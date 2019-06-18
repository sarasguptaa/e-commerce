import Vue from 'vue'
import Vuex from 'vuex'
import commonApi from '@/api/index.js'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    loginData: {},
    searchData: {
      response: null
    },
    homeData: {},
    sub1Data: {},
    sub2Data: {},
    catData: {},
    subcatData: {},
    randomData: {},
    allPidProdData: {},
    bestProdData: {},
    cartData: {
      "userId": "57339e44-c65a-4464-a81a-8434107d52d7",
      "productClassList": []
    }
  },
  mutations: {
    login_data: (state, logData) => {
      state.loginData = logData;
    },
    search_data: (state, sData2) => {
      state.searchData.response = sData2;
    },
    home_data: (state, hData) => {
      state.homeData = hData;
    },
    sub1_data: (state, hData) => {
      state.sub1Data = hData;
    },
    sub2_data: (state, hData) => {
      state.sub2Data = hData;
    },
    cat_data: (state, hData) => {
      state.catData = hData;
    },
    subcat_data: (state, hData) => {
      state.subcatData = hData;
    },
    random_data: (state, hData) => {
      state.randomData = hData;
    },
    all_pid_prod_data: (state, hData) => {
      state.allPidProdData = hData;
    },
    best_prod_data: (state, hData) => {
      state.bestProdData = hData;
    },
    cart_data: (state, hData) => {
      state.cartData = hData;
    },
    cart_data_push: (state, hData) => {
      state.cartData.productClassList.push(hData);
    },
    cart_data_pop: (state, hData) => {
      state.cartData.productClassList.splice(hData,1);
    },
    cart_data_add_quantity: (state, hData) => {
      state.cartData.productClassList[hData].quantity="" + (parseInt(state.cartData.productClassList[hData].quantity)+1);
    },
    cart_data_remove_quantity: (state, hData) => {
      state.cartData.productClassList[hData].quantity="" + (parseInt(state.cartData.productClassList[hData].quantity)-1);
      if(state.cartData.productClassList[hData].quantity=="0")
        state.cartData.productClassList.splice(hData, 1)
    }
  },
  actions: {
    setSignupData: ({commit}, {data, success, failure}) => {
      commonApi.userAuthApi(data, 'signup', (response) => {
        success()
      },
      (error) => {
        failure(error.body.message)
      });
    },
    setLoginData: ({commit}, {data, success, failure}) => {
      commonApi.userAuthApi(data, 'login', (response) => {
        commit('login_data', response.body);
        success();
      },
      (error) => {
        failure(error.body.message)
      });
    },
    callSearchResult: ({commit}, {searchvar, success, failure}) => {
      commonApi.getSearchResultApi(searchvar, (response)=>{
        commit('search_data', response.body);
        success();
      },
      (error) => {
        failure(error.body.message)
      });
    },
    homeDisplayProd: ({commit}, {success, failure}) => {
      commonApi.getOneFromAll((response)=>{
        commit('home_data', response.body);
        success();
      },
      (error) => {
        failure(error.body.message)
      });
    },
    homeDisplaySubProd1: ({commit}, {success, failure}) => {
      commonApi.getFromSubcid('1',(response)=>{
        var a=[];
        response.body.pid.forEach(element => {
          commonApi.getFromPid(element, (response2)=>{a.push(response2)},(error2)=>{})
        });
        commit('sub1_data', a);
        success();
      },
      (error) => {
        failure(error.body.message)
      });
    },
    homeDisplaySubProd2: ({commit}, {success, failure}) => {
      commonApi.getFromSubcid('2',(response)=>{
        var a=[];
        response.body.pid.forEach(element => {
          commonApi.getFromPid(element, (response2)=>{a.push(response2)},(error2)=>{})
        });
        commit('sub2_data', a);
        success();
      },
      (error) => {
        failure(error.body.message)
      });
    },
    getAllCategories: ({commit}, {success, failure}) => {
      commonApi.getAllCat((response)=>{
        commit('cat_data', response.body);
        success();
      },
      (error) => {
        failure(error.body.message)
      });
    },
    getAllSubcategories: ({commit}, {success, failure}) => {
      commonApi.getAllSubcat((response)=>{
        commit('subcat_data', response.body);
        success();
      },
      (error) => {
        failure(error.body.message)
      });
    },
    getRandomProd: ({commit}, {success, failure}) => {
      commonApi.getRandomProd((response)=>{
        commit('random_data', response.body);
        //console.log(response.body);
        success();
      },
      (error) => {
        failure(error.body.message)
      });
    },
    getAllProdWithSamePid: ({commit}, {data, success, failure}) => {
      commonApi.getAllProdWithSamePid(data, (response)=>{
        commit('all_pid_prod_data', response.body);
        //console.log(response.body);
        success();
      },
      (error) => {
        failure(error.body.message)
      });
    },
    getBestProdPid: ({commit}, {data, success, failure}) => {
      commonApi.getFromPid(data, (response)=>{
        commit('best_prod_data', response.body);
        //console.log(response.body);
        success();
      },
      (error) => {
        failure(error.body.message)
      });
    },
    addToCart: ({commit, state}, {data, success, failure}) => {
      let ind=-1;
      state.cartData.productClassList.forEach((ele, index)=>{
        if(ele.pid==data.pid && ele.mid==data.mid){
          ind = index;
        }
      })
      if(ind==-1){
        data["quantity"] = "1";
        commit('cart_data_push', data);
      }
      else
        commit('cart_data_add_quantity', ind)
      data = state.cartData;
      commonApi.addToCart(data, ()=>{
        //console.log(response.body);
        success();
      },
      (error) => {
        failure(error.body.message)
      });
    },
    removeFromCart: ({commit, state}, {data, success, failure}) => {
      let ind=-1;
      state.cartData.productClassList.forEach((ele, index)=>{
        if(ele.pid==data.pid && ele.mid==data.mid){
          ind = index;
        }
      })
      if(ind!=-1){
        commit('cart_data_remove_quantity', ind)
      }
      data = state.cartData;
      commonApi.addToCart(data, ()=>{
        //console.log(response.body);
        success();
      },
      (error) => {
        failure(error.body.message)
      });
    },
    getCart: ({commit}, {data, success, failure}) => {
      commonApi.getCartDetails(data, (response)=>{
        delete response.body.teamId;
        commit('cart_data', response.body)
        //console.log(response.body);
        success();
      },
      (error) => {
        failure(error.body.message)
      });
    }
  },
  getters: {
    getLoginData: state => {
      return state.loginData;
    },
    getSearchData: state => {
      return state.searchData;
    },
    getHomeData: state => {
      return state.homeData;
    },
    getSub1Data: state => {
      return state.sub1Data;
    },
    getSub2Data: state => {
      return state.sub2Data;
    },
    getCatData: state => {
      return state.catData;
    },
    getSubcatData: state => {
      return state.subcatData;
    },
    getRandomData: state => {
      return state.randomData;
    },
    getAllPidProdData: state => {
      return state.allPidProdData;
    },
    getBestProdData: state => {
      return state.bestProdData;
    },
    getCartData: state => {
      return state.cartData;
    }
  }
})
