#!/usr/bin/env bash
# Copyright 2017 The Kubernetes Authors.
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#     http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.

# This script takes an argument: the tag name ("v1.2.3") to release from.

# Exit on error.
set -e

function release-java-doc {
  if [ -n "$(git status --porcelain)" ]; then
    echo "Git working tree not clean, aborting."
    exit 1
  fi
  echo "Generating Helm Chart package for new version."
  echo "Please note that your gh-pages branch, if it locally exists, should be up-to-date."
  git checkout gh-pages
  mvn clean javadoc:javadoc
  rm -Rf docs/apidocs
  mv target/site/apidocs docs
  echo "Commit new package and index."
  git add -A && git commit -m "Update Javadoc from CI"
  echo "If you are happy with the changes, please manually push to the gh-pages branch. No force should be needed."
  echo "Assuming upstream is your remote, please run: git push upstream gh-pages."
}

# Execute script.
release-java-doc
