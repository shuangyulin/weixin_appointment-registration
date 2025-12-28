const base = {
    get() {
        return {
            url : "http://localhost:8080/springbootub8qq51t/",
            name: "springbootub8qq51t",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/springbootub8qq51t/front/h5/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "在线预约挂号系统"
        } 
    }
}
export default base
