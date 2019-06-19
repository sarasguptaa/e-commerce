<template>
    <div class="orderhistorypage">

        <b-container>
            <b-row style="text-align:left;">
                <b-col cols="12" class="card" style="padding: 15px 0 5px 40px"><h2>Order History</h2></b-col>
            </b-row>
            <hr>
            <b-row v-for="(element, ind) in getOrderhistoryData" :key="ind" class="card" style="padding: 10px; margin-bottom:10px">
                <b-container><b-row align-h="center"><h2 style="margin-bottom: 0px">Order: {{ind+1}}</h2></b-row></b-container>
                <hr>
                <div  v-for="(ele, index) in element.productClassList" :key="index">
                    <b-row  class="merchantRow">
                        <b-col cols="2">
                            <img :src="require('../'+ele.imgurl)" class="img-responsive imgMain" id="displayImg">
                        </b-col>
                        <b-col cols="8" style="text-align: left">
                            <div class="myHeader">
                                <h3 style="font-size: 100%">{{ele.pname}}</h3>
                                <p style="padding:10px 0 0 0; margin:0;font-size: 100%">by: {{ele.merchantName}}</p>
                                <p style="padding:10px 0 0 0; margin:0;font-size: 100%">Quantity: {{ele.quantity}}</p>
                            </div>
                        </b-col>
                        <b-col cols="2">
                            <h2 style="padding:10px 0 0 0; margin:0;font-size: 100%">₹{{ele.price}} x {{ele.quantity}}</h2>
                        </b-col>
                    </b-row>
                <hr>
            
                </div>
            </b-row>
            <hr>
        </b-container>
    </div>
</template>

<script>
import {mapGetters, mapActions} from 'vuex';
export default {
    name: 'orderhistorypage',
    methods: {
        ...mapActions(['orderHistory'])
    },
    computed:{
        ...mapGetters(['getOrderhistoryData','getLoginData'])
    },
    created(){
        this.$store.dispatch('orderHistory', {
            data: this.getLoginData.userId,
            success: () => {},
            failure: () => {}
        });
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
    height: 100px;
    max-width: 100%;
}
.myHeader{
    padding: 10px;
}
.merchantRow{
    height: 100px
}
</style>
