#!/bin/bash

# 创建目标目录
mkdir -p ../bitoj-jar/gateway
mkdir -p ../bitoj-jar/system
mkdir -p ../bitoj-jar/friend
mkdir -p ../bitoj-jar/job
mkdir -p ../bitoj-jar/judge

# 复制 jar 包
cp ../../../oj-gateway/target/oj-gateway-1.0-SNAPSHOT.jar ../bitoj-jar/gateway/oj-gateway.jar
cp ../../../oj-modules/oj-system/target/oj-system-1.0-SNAPSHOT.jar ../bitoj-jar/system/oj-system.jar
cp ../../../oj-modules/oj-friend/target/oj-friend-1.0-SNAPSHOT.jar ../bitoj-jar/friend/oj-friend.jar
cp ../../../oj-modules/oj-job/target/oj-job-1.0-SNAPSHOT.jar ../bitoj-jar/job/oj-job.jar
cp ../../../oj-modules/oj-judge/target/oj-judge-1.0-SNAPSHOT.jar ../bitoj-jar/judge/oj-judge.jar 