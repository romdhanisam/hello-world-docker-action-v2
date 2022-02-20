#!/bin/sh -l

echo "HI $1"
time=$(date)
echo "::set-output name=time::$time"
