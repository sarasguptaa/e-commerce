<template>
    <div class="cartpage">
        <b-container>
            <b-row>
                <b-col cols="10" class="card" style="padding: 15px 0 5px 10px"><h2>Other Merchants</h2></b-col>
            </b-row><br>
            <b-row class="merchantRow">
                <b-col cols="4" class="cardMerchant">
                    <img src="@/img/iphone.jpg" class="img-responsive imgMerchant" alt="iphone" id="displayImg">
                </b-col>
                <b-col cols="6" style="text-align: left" class="cardMerchant">
                    <div class="myHeader">
                        <h3>Apple iPhone 7 Plus (32GB) Silver</h3>
                        <p style="padding:10px 0 0 0; margin:0">by: ABCD</p>
                    </div>
                </b-col>
                <b-col cols="2">
                    <button>Check Out</button><br><br>
                    <button>Buy Now</button>
                </b-col>
            </b-row>
        </b-container>
    </div>
</template>

<script>
import {mapActions} from 'vuex'
import {mapGetters} from 'vuex'
export default {
    name: 'cartpage',
    methods:{
        ...mapActions([''])
    },
    computed:{
        ...mapGetters([''])
    }
}
</script>

<style scoped>
.card{
    border: none;
    border-radius: 0;
    box-shadow: 0 1px 2px 0 rgba(0,0,0,0.1);
    height: auto;
}
.merchantRow{
    margin-bottom: 20px;
}
.cardMerchant{
    border: none;
    border-radius: 0;
    box-shadow: 0 1px 2px 0 rgba(0,0,0,0.1);
    height: auto;
    background-color: white;
    height: 200px;
}
.imgMerchant{
    height: 100%;
}
</style>
