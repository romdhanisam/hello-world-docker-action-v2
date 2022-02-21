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


-----------------------------
#### Fix 
error: gpg failed to sign the data

fatal: failed to write commit object

> export GPG_TTY=$(tty)

