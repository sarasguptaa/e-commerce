<template>
    <div class="displaycat">
        <b-container v-if="getCatdisplayData">
            <b-row class="merchantRow" v-for="(ele, index) in getCatdisplayData" :key="index">
                <b-col cols="4" class="cardMerchant">
                    <img :src="require('@/'+ele.body.imgurl)" style="cursor: pointer" class="img-responsive imgMerchant" :alt="ele.body.pname" id="displayImg" @click="clickFunction(ele.body.pid)">
                </b-col>
                <b-col cols="8" style="text-align: left" class="cardMerchant">
                    <div class="myHeader" style="cursor: pointer" @click="clickFunction(ele.body.pid)">
                        <h3>{{ele.body.pname}}</h3>
                        <div class="star-ratings-sprite" ><span :style="'width:'+ ele.body.rating*20+'%'" class="star-ratings-sprite-rating"></span></div>
                        <!--p style="padding:10px 0 0 0; margin:0">by: {{ele.merchantName}}</p-->
                        <p style="padding:10px 0 0 0; margin:0">₹{{ele.body.price}}</p>
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
    name: 'displaycat',
    props:['subcidvar', 'subname', 'cname'],
    methods:{
        ...mapActions(['getAllSubcategoryProducts']),
        searchSubSuccess(){

        },
        searchSubFailure(){

        },
        clickFunction(pid){
            router.push({ path: '/products/'+pid})
        }
    },
    computed:{
        ...mapGetters(['getCatdisplayData']),
        abc(){
            this.$forceUpdate()
        }
    },
    created() {
        this.$store.dispatch('getAllSubcategoryProducts', {
            data: this.subcidvar,
            success: this.searchSubSuccess,
            failure: this.searchSubFailure
        })
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
