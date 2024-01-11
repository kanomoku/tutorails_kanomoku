function install_tree() {
  set +e
  tree_version="tree-1.8.0"
  tree_install_count=$(rpm -qa | grep -i ${tree_version} | wc -l) # 查看已经安装 tree-1.8.0 版本的数量
  if [ "${tree_install_count}" == "0" ]; then                     # 表示此版本未安装
    origin_version=$(rpm -qa | grep -i tree)                      # 查询 tree 当前已经安装的版本
    echo "tree is ${origin_version}"
    if [ -n "${origin_version}" ]; then # 表示查询到某个版本
      echo "delete is ${origin_version}"
      rpm -e tree # 卸载当前安装的 tree
    fi

    echo "begin install tree"
    x86="x86_64"
    aarch64="aarch64"
    cpu_type=$(lscput | grep 'Architecture') # 查询CPU类型
    if [[ "${cpu_type}" =~ ${x86} ]]; then
      echo "cpu is x86"
      sudo wget --no-check-certificate -O /tmp/bigTree.rpm http://mama.indstate.edu/users/ice/tree/tree-1.8.0-1.x86_64.rpm # 下载
      sudo rpm -ivh /tmp/bigTree.rpm                                                                                       # 安装
    fi

    if [[ "${cpu_type}" =~ ${aarch64} ]]; then
      echo "cpu is aarch64"
      sudo wget --no-check-certificate -O /tmp/bigTree.rpm http://mama.indstate.edu/users/ice/tree/tree-1.8.0-1.aarch64.rpm # 下载
      sudo rpm -ivh /tmp/bigTree.rpm                                                                                        # 安装
    fi
    echo "end install tree"
  else
    echo "tree already installed"
  fi
  set -e
}

# 安装tree
install_tree
