#!/usr/bin/env bash
set -e
cmd="$@"

status=$(nc -z localhost 9042; echo $?)
echo $status

while [ $status != 0 ]
do
  sleep 3s
  status=$(nc -z localhost 9042; echo $?)
  echo "cassandra status $status"
done

exec $cmd
