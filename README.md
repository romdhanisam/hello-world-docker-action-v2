[![Awesome](https://cdn.rawgit.com/sindresorhus/awesome/d7305f38d29fed78fa85652e3a63e154dd8e8829/media/badge.svg)](https://github.com/romdhanisam/hello-world-docker-action-v2/tree/develop)
[![javadoc](https://javadoc.io/badge2/org.springframework/spring-core/javadoc.svg)](https://romdhanisam.github.io/hello-world-docker-action-v2/)

# Hello world Github action
## Github release usage

### Add tag
> > git tag -a -m "Prepare release" v17
>
> > git push --follow-tags

## Sign usage MAC

### List of keys
> gpg --list-secret-keys --keyid-format=long
-------------------------
### Generate key  

> gpg --full-generate-key
-------------------------
### Delete key
> gpg --delete-secret-key EB2A1CE10DE3E599**
-------------------------
### Set default secret

> Recommended
> > git config --global user.signingkey CD0C7DB15E9DD359**
>
>OR
> > gpg -s --default-key CD0C7DB15E9DD359** input > output
>
> > gpg -d < input.gpg | head -1
>
> OR
> > gpg -s --default-key CD0C7DB15E9DD35**

### Set default secret
https://github.com/settings/keys
#### Add GPG key
> gpg --armor --export CD0C7DB15E9DD35**

#### Config auto sign commit with github action
```shell
gpg --list-secret-keys 
```
```shell
# macOS
gpg --armor --export-secret-key joe@foo.bar | pbcopy

# Ubuntu (assuming GNU base64)
gpg --armor --export-secret-key joe@foo.bar -w0 | xclip

# Arch
gpg --armor --export-secret-key joe@foo.bar | xclip -selection clipboard -i

# FreeBSD (assuming BSD base64)
gpg --armor --export-secret-key joe@foo.bar | xclip
```
Setting GPG as secret repository
```yaml
- name: Import GPG key
  id: import_gpg
  uses: crazy-max/ghaction-import-gpg@v5
  with:
    gpg_private_key: ${{ secrets.GPG_PRIVATE_KEY_ROBOT }}
    git_user_signingkey: true
    git_commit_gpgsign: true
```
-----------------------------
#### Fix
error: gpg failed to sign the data

fatal: failed to write commit object

> export GPG_TTY=$(tty)

[comment]: <> (#### Microsoft Teams Notification)

[comment]: <> (![Microsoft Teams Notification]&#40;https://raw.githubusercontent.com/romdhanisam/hello-world-docker-action-v2/main/assets/Screenshot%202022-02-21%20at%2001.21.25.png?raw=true&#41;)


## Stargazers over time

[![Stargazers over time](https://starchart.cc/romdhanisam/hello-world-docker-action-v2.svg)](https://starchart.cc/romdhanisam/hello-world-docker-action-v2)
