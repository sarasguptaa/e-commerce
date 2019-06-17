import Vue from 'vue'
import Resource from 'vue-resource'

Vue.use(Resource)

const urlsaras="172.16.29.8:8082";
const urlaman="172.16.29.20:8081";
const urlniket="172.16.28.215:8080";
const commonApi = {
    userAuthApi (data, path, cb, errorHandler) {
        let headerObject = {
            'Access-Control-Allow-Credentials':'true',
            'Access-Control-Allow-Methods': 'POST, GET, PUT, OPTIONS, DELETE',
            'Access-Control-Allow-Headers': 'Access-Control-Allow-Methods, Access-Control-Allow-Origin, Origin, Accept, Content-Type',
            'Content-Type': 'application/json',
            'Accept': 'application/json'
        }
        Vue.http.post('http://'+urlaman+'/' + path, data, {headers: headerObject}).then((res) => {
            cb(res)
        }, (error) => {
            errorHandler(error)
        })
    },
    getSearchResultApi (data, cb, errorHandler) {
        let headerObject = {
            'Access-Control-Allow-Origin': '*',
            'Access-Control-Allow-Methods': 'POST, GET, PUT, OPTIONS, DELETE',
            'Access-Control-Allow-Headers': 'Access-Control-Allow-Methods, Access-Control-Allow-Origin, Origin, Accept, Content-Type',
            'Content-Type': 'application/json',
            'Accept': 'application/json'
        }
        Vue.http.get('http://'+urlniket+'/search/'+data, {headers: headerObject}).then((res) => {
            cb(res)
        }, (error) => {
            errorHandler(error)
        })
    },
    getOneFromAll(cb, errorHandler) {
        let headerObject = {
            'Access-Control-Allow-Origin': '*',
            'Access-Control-Allow-Methods': 'POST, GET, PUT, OPTIONS, DELETE',
            'Access-Control-Allow-Headers': 'Access-Control-Allow-Methods, Access-Control-Allow-Origin, Origin, Accept, Content-Type',
            'Content-Type': 'application/json',
            'Accept': 'application/json'
        }
        Vue.http.get('http://'+urlsaras+'/getAllSubcat/', {headers: headerObject}).then((res) => {
            cb(res)
        }, (error) => {
            errorHandler(error)
        })
    },
    getFromSubcid(path, cb, errorHandler) {
        let headerObject = {
            'Access-Control-Allow-Origin': '*',
            'Access-Control-Allow-Methods': 'POST, GET, PUT, OPTIONS, DELETE',
            'Access-Control-Allow-Headers': 'Access-Control-Allow-Methods, Access-Control-Allow-Origin, Origin, Accept, Content-Type',
            'Content-Type': 'application/json',
            'Accept': 'application/json'
        }
        Vue.http.get('http://'+urlsaras+'/getOneSubcatDet/'+path, {headers: headerObject}).then((res) => {
            cb(res)
        }, (error) => {
            errorHandler(error)
        })
    },
    getFromPid(path, cb, errorHandler) {
        let headerObject = {
            'Access-Control-Allow-Origin': '*',
            'Access-Control-Allow-Methods': 'POST, GET, PUT, OPTIONS, DELETE',
            'Access-Control-Allow-Headers': 'Access-Control-Allow-Methods, Access-Control-Allow-Origin, Origin, Accept, Content-Type',
            'Content-Type': 'application/json',
            'Accept': 'application/json'
        }
        Vue.http.get('http://'+urlsaras+'/getOneProdDet/'+path, {headers: headerObject}).then((res) => {
            cb(res)
        }, (error) => {
            errorHandler(error)
        })
    },
    getAllCat(cb, errorHandler) {
        let headerObject = {
            'Access-Control-Allow-Origin': '*',
            'Access-Control-Allow-Methods': 'POST, GET, PUT, OPTIONS, DELETE',
            'Access-Control-Allow-Headers': 'Access-Control-Allow-Methods, Access-Control-Allow-Origin, Origin, Accept, Content-Type',
            'Content-Type': 'application/json',
            'Accept': 'application/json'
        }
        Vue.http.get('http://'+urlsaras+'/getAllCat/', {headers: headerObject}).then((res) => {
            cb(res)
        }, (error) => {
            errorHandler(error)
        })
    },
    getAllSubcat(cb, errorHandler) {
        let headerObject = {
            'Access-Control-Allow-Origin': '*',
            'Access-Control-Allow-Methods': 'POST, GET, PUT, OPTIONS, DELETE',
            'Access-Control-Allow-Headers': 'Access-Control-Allow-Methods, Access-Control-Allow-Origin, Origin, Accept, Content-Type',
            'Content-Type': 'application/json',
            'Accept': 'application/json'
        }
        Vue.http.get('http://'+urlsaras+'/getAllSubcat/', {headers: headerObject}).then((res) => {
            cb(res)
        }, (error) => {
            errorHandler(error)
        })
    },
    getRandomProd(cb, errorHandler) {
        let headerObject = {
            'Access-Control-Allow-Origin': '*',
            'Access-Control-Allow-Methods': 'POST, GET, PUT, OPTIONS, DELETE',
            'Access-Control-Allow-Headers': 'Access-Control-Allow-Methods, Access-Control-Allow-Origin, Origin, Accept, Content-Type',
            'Content-Type': 'application/json',
            'Accept': 'application/json'
        }
        Vue.http.get('http://'+urlsaras+'/getAllProd/', {headers: headerObject}).then((res) => {
            cb(res)
        }, (error) => {
            errorHandler(error)
        })
    },
    getAllProdWithSamePid(data, cb, errorhandler) {
        let headerObject = {
            'Access-Control-Allow-Origin': '*',
            'Access-Control-Allow-Methods': 'POST, GET, PUT, OPTIONS, DELETE',
            'Access-Control-Allow-Headers': 'Access-Control-Allow-Methods, Access-Control-Allow-Origin, Origin, Accept, Content-Type',
            'Content-Type': 'application/json',
            'Accept': 'application/json'
        }
        Vue.http.get('http://'+urlsaras+'/getAllProdWithSamePid/'+data, {headers: headerObject}).then((res) => {
            cb(res)
        }, (error) => {
            errorhandler(error)
        })
    },
    getCartDetails(data, cb, errorhandler) {
        debugger
        let headerObject = {
            'Access-Control-Allow-Origin': '*',
            'Access-Control-Allow-Methods': 'POST, GET, PUT, OPTIONS, DELETE',
            'Access-Control-Allow-Headers': 'Access-Control-Allow-Methods, Access-Control-Allow-Origin, Origin, Accept, Content-Type',
            'Content-Type': 'application/json',
            'Accept': 'application/json'
        }
        Vue.http.get('http://'+urlsaras+'/getCartWithId/'+data, {headers: headerObject}).then((res) => {
            cb(res)
        }, (error) => {
            errorhandler(error)
        })
    },
}

export default commonApi