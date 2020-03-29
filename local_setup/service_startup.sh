#!/bin/bash


echo "$BASE"

echo "[Start] Setting env vars... "
export MYSQL_DB=db
export MYSQL_USER=user
export MYSQL_PASS=password
export MYSQL_ROOT_PASS=password
echo "[Done] Setting env vars..."

echo "[Start] Running docker-compose..."
docker-compose -f docker-compose.yml up -d
