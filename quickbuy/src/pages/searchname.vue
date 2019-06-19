<template>
    <div class="searchname">
        <div v-if="!getSearchData.response" >No Search Query</div>
        <div v-if="getSearchData.response" style="margin-bottom: 15px; text-align: left;width: 100%" class="card">
            <b-container>
                <b-row align-v="center">
                    <b-col cols="10">
                        <p style="margin: 10px 0 10px 0px; font-size: 14px;display: inl">1-{{getSearchData.response.length}} of over {{getSearchData.response.length}} results for '{{searchvar}}'</p>
                    </b-col>
                    <b-col>
                    <b-form-select style="height:30px;font-size:14px;padding-top: 3px">
                        <option value="a">Best Rating</option>
                        <option value="b">Cheapest</option>
                    </b-form-select>
                    </b-col>
                </b-row>
            
            </b-container>
        </div>
        <b-container v-if="getSearchData.response">
            <b-row class="merchantRow" v-for="(ele, index) in getSearchData.response" :key="index">
                <b-col cols="4" class="cardMerchant">
                    <img :src="require('../'+ele.imgurl)" style="cursor: pointer" class="img-responsive imgMerchant" :alt="ele.pname" id="displayImg" @click="clickFunction(ele.pid)">
                </b-col>
                <b-col cols="8" style="text-align: left" class="cardMerchant">
                    <div class="myHeader" style="cursor: pointer" @click="clickFunction(ele.pid)">
                        <h3>{{ele.pname}}</h3>
                        <div class="star-ratings-sprite" ><span :style="'width:'+ ele.rating*20+'%'" class="star-ratings-sprite-rating"></span></div>
                        <!--p style="padding:10px 0 0 0; margin:0">by: {{ele.merchantName}}</p-->
                        <p style="padding:10px 0 0 0; margin:0">₹{{ele.price}}</p>
                    </div>
                </b-col>
            </b-row>
        </b-container>
    </div>
</template>

<script>
import {mapActions} from 'vuex'
import {mapGetters} from 'vuex'
import router from '../router'
export default {
    name: 'searchname',
    props:{
        searchvar: ''
    },
    methods:{
        ...mapActions(['callSearchResult']),
        searchSuccess(){

        },
        searchFailure(){

        },
        clickFunction(pid){
            router.push({ path: '/products/'+pid+'/1'})
        }
    },
    computed:{
        ...mapGetters(['getSearchData'])
    }
}
</script>

<style scoped>
.imgMerchant{
    height: 100%;
}
.card{
    border: none;
    border-radius: 0;
    box-shadow: 0 1px 2px 0 rgba(0,0,0,0.1);
    height: auto;
}
.cardMerchant{
    border: none;
    border-radius: 0;
    box-shadow: 0 1px 2px 0 rgba(0,0,0,0.1);
    height: auto;
    background-color: white;
    height: 200px;
}
.myHeader{
    padding: 10px;
}
.star-ratings-sprite {
    
    background: url("https://s3-us-west-2.amazonaws.com/s.cdpn.io/2605/star-rating-sprite.png") repeat-x;
    font-size: 0;
    height: 21px;
    line-height: 0;
    overflow: hidden;
    text-indent: -999em;
    width: 110px;
    margin: 0 0 0 0;
}
.star-ratings-sprite-rating {
    background: url("https://s3-us-west-2.amazonaws.com/s.cdpn.io/2605/star-rating-sprite.png") repeat-x;
    background-position: 0 100%;
    float: left;
    height: 21px;
    display:block;
    text-align: left;
}
.merchantRow{
    margin-bottom: 20px;
}
</style>
