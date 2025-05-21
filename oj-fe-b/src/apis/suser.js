import service from '@/utils/request'

//127.0.0.1:19090/system/sysUser/login
export function loginService(userAccount, password) {
  return service({
    url:"/sysUser/login",
    method: "post",
    data: {userAccount, password}
  })
}

export function getUserInfoService() {
  return service({
    url: "/sysUser/info",
    method: "get",
  });
}


export function logoutService() {
  return service({
    url: "/sysUser/logout",
    method: "delete",
  });
}