# Hello world docker action

This action prints "Hello World" or "Hello" + the name of a person to greet to the log.

## Inputs

## `who-to-greet`

**Required** The name of the person to greet. Default `"World"`.

## Outputs

## `time`

The time we greeted you.

## Example usage

uses: actions/hello-world-docker-action@v1
with:
  who-to-greet: 'Mona the Octocat'# hello-world-docker-action

# Github release usage

## add tag
> > git tag -a -m "Prepare release" v17
>
> > git push --follow-tags

# Sign usage

## list of keys
> gpg --list-secret-keys --keyid-format=long
-------------------------
## generate key

> gpg --full-generate-key
-------------------------
## delete key
> gpg --delete-secret-key EB2A1CE10DE3E599**
-------------------------
## Set default secret
> git config --global user.signingkey CD0C7DB15E9DD359**
-------------------------
> > gpg -s --default-key CD0C7DB15E9DD359** input > output
> 
> > gpg -d < input.gpg | head -1
-------------------------
> gpg -s --default-key CD0C7DB15E9DD35**