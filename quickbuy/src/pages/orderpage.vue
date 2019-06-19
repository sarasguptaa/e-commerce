<template>
    <div class="orderpage">
        <b-container>
            <b-row style="text-align:left;">
                <b-col cols="12" class="card" style="padding: 15px 0 5px 40px"><h2>Order Page</h2></b-col>
            </b-row>
            <hr>
            <div class="card" style="padding: 10px">
                <div  v-for="(ele, index) in getCartData.productClassList" :key="index">
                    <b-row  class="merchantRow">
                        <b-col cols="2">
                            <img :src="require('../'+ele.imgurl)" class="img-responsive imgMain" id="displayImg">
                        </b-col>
                        <b-col cols="8" style="text-align: left">
                            <div class="myHeader">
                                {{ele.pid}}
                                {{ele.mid}}
                                <h3 style="font-size: 100%">{{ele.pname}}</h3>
                                <p style="padding:10px 0 0 0; margin:0">by: {{ele.merchantName}}</p>
                                <p style="padding:10px 0 0 0; margin:0">Quantity: {{ele.quantity}}</p>
                            </div>
                        </b-col>
                        <b-col cols="2">
                            <h2 style="padding:10px 0 0 0; margin:0">₹{{ele.price}} x {{ele.quantity}}</h2>
                        </b-col>
                    </b-row>
                <hr>
            
                </div>

                <b-row style="text-align: right">
                    <b-col cols="8"></b-col>
                    <b-col cols="4" ><h2>Total: {{totalVar}}</h2></b-col>
                </b-row>
            </div>
            <hr>
            <div class="card">
                <b-row>
                    <b-col cols="12" style="padding: 15px 0 0px 40px"><h3 style="margin: 1px 0px 0px 0px">Delivery Address</h3></b-col>
                </b-row>
                <center><hr style="width: 96%"></center>
                <div>
                    <b-form-textarea
                        id="textarea"
                        v-model="addressVar"
                        placeholder="Enter Address..."
                        rows="3"
                        max-rows="6"
                        style="margin: 0px 0px 0px 20px; width: 95%"
                    ></b-form-textarea>
                    <center><hr style="width: 96%"></center>
                </div>
                <b-row>
                    <b-col cols="12">
                        <button @click="confirmFunction()">Confirm Order</button>
                    </b-col>
                </b-row>
            </div>
            <hr>
        </b-container>
    </div>
</template>

<script>
import {mapGetters, mapActions} from 'vuex';
import commonApi from '@/api/index.js';
import router from "../router"
export default {
    name: 'orderpage',
    computed:{
        ...mapGetters(['getCartData'])
    },
    data(){
        return{
            totalVar: 0,
            addressVar: ''
        }
    },
    created(){
        this.getCartData.productClassList.forEach(element => {
            this.totalVar += parseInt(element.price)*parseInt(element.quantity)
        });
    },
    methods:{
        ...mapActions(['updateCart']),
        confirmFunction(){
            if(this.addressVar!=''){
                let data = this.getCartData;
                data["address"] = this.addressVar;
                commonApi.confirmOrder(data, (response)=>{
                    this.$store.dispatch('updateCart', response.body.productClassList)
                    console.log(response)
                    if(response.body.productClassList.length===0){
                        this.$bvToast.toast("Order Placed!!",{
                            title: "Success Message",
                            toaster: "b-toaster-top-center",
                            solid: true
                        })
                        router.push({path: "/"})
                    }
                    else{
                        this.$bvToast.toast("Order not placed!! Please check the cart!!",{
                            title: "Failure Message",
                            toaster: "b-toaster-top-center",
                            solid: true
                        })
                        router.push({path: "/cart"})
                    }
                },(error)=>{
                    this.$bvToast.toast(msg,{
                        title: "Error Message",
                        toaster: "b-toaster-top-center",
                        solid: true
                    })
                });
            }
            else{
                this.$bvToast.toast("Enter an Address!!",{
                    title: "Warning!!",
                    toaster: "b-toaster-top-center",
                    solid: true
                })
            }
        }
    }
}
</script>

<style scoped>
.card{
    border: none;
    border-radius: 0;
    box-shadow: 0 4px 16px 0 rgba(0,0,0,0.1);
    height: auto;
}
.imgMain{
    height: 150px;
    max-width: 100%;
}
.myHeader{
    padding: 10px;
}
.merchantRow{
    height: 150px
}
button {
  background-color: #ffffff; /* Green */
  border: none;
  color: #232f3e;
  padding: 15px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  box-shadow: 0 2px 4px 0 rgba(0,0,0,0.2);
  margin-bottom: 16px;
  border: 1px solid;
  border-color: #232f3e;
  font-weight: bold
}
button:hover{
    color: #ffffff;
    background-color: #232f3e;
    border: 1px solid;
    border-color: #232f3e;
}
</style>
