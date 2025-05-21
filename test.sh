#!/bin/bash

# 1. 移除子模块缓存（索引里的记录）
git rm --cached bite-oj
git rm --cached oj-fe-b
git rm --cached oj-fe-c

# 2. 删除子模块中的 .git 文件夹（不再当成子仓库）
rm -rf bite-oj/.git
rm -rf oj-fe-b/.git
rm -rf oj-fe-c/.git

# 3. 添加回这些文件夹作为普通目录
git add .

# 4. 提交
git commit -m "add subfolders as normal directories"

# 5. 推送到远程 main 分支
git push -u origin main
