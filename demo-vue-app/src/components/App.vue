<template>
  <!-- ============ Marquee ============ -->
  <div class="marquee w-full h-12 overflow-hidden position-relative">
    <ul class="marquee-content h-full flex" ref="mq">
      <!-- main -->
      <!-- 1 -->
      <li
        class="flex justify-center items-center flex-shrink-0 text-white transform scale-75 lg:scale-100"
        v-for="coin in tenCoins" :key="coin.name"
      >
        <div class="flex justify-between w-3/4">
          <!-- ticker -->
          <div class="flex items-center">
            <img
              :src="coin.image"
              alt="coin logo"
              class="w-4 h-4 lg:w-6 lg:h-6 rounded-full mr-4 object-cover"
            />
            <div class="hidden lg:block">
              <p class="font-bold">{{coin.name}}</p>
              <p class="text-xs uppercase tracking-widest ">
                {{coin.symbol}}
              </p>
            </div>
          </div>
          <!-- price -->
          <div>
            <p class="font-bold text-xs lg:text-base flex justify-end ">
              {{ $filters.comma_separator(coin.currentPrice) }}
            </p>
            <!-- percent red -->
            <p
              class="font-bold text-xs text-red-400 flex justify-end items-center "
              v-if="$filters.price_negative(coin.priceChangePercentage24h)"
            >
              <fa icon="caret-down" class="mr-1" />
              {{ $filters.string_trunc(coin.priceChangePercentage24h, 5) }}%
            </p>
            <!-- percent green -->
            <p
              v-else
              class="font-bold text-xs text-green-400 flex justify-end items-center "
            >
              <fa icon="caret-up" class="mr-1" />
              {{$filters.string_trunc(coin.priceChangePercentage24h, 5) }}%
            </p>
          </div>
        </div>
      </li>
      
      <!-- clones -->
      <!-- 1 -->
      <li
        class="flex justify-center items-center flex-shrink-0 text-white transform scale-75 lg:scale-100"
        v-for="coin in cloneCoins" :key="coin.name"
      >
        <div class="flex justify-between w-3/4">
          <!-- ticker -->
          <div class="flex items-center">
            <img
              :src="coin.image"
              alt="coin logo"
              class="w-4 h-4 lg:w-6 lg:h-6 rounded-full mr-4 "
            />
            <div class="hidden lg:block">
              <p class="font-bold">{{coin.name}}</p>
              <p class="text-xs uppercase tracking-widest">
                {{coin.symbol}}
              </p>
            </div>
          </div>
          <!-- price -->
          <div>
            <p class="font-bold flex justify-end text-xs lg:text-base">
              {{ $filters.comma_separator(coin.currentPrice) }}
            </p>
            <!-- percent red -->
            <p
              class="font-bold text-xs text-red-400 flex justify-end items-center "
              v-if="$filters.price_negative(coin.priceChangePercentage24h)"
            >
              <fa icon="caret-down" class="mr-1" />
              {{ $filters.string_trunc(coin.priceChangePercentage24h, 5) }}%
            </p>
            <!-- percent green -->
            <p
              v-else
              class="font-bold text-xs text-green-400 flex justify-end items-center "
            >
              <fa icon="caret-up" class="mr-1" />
              {{ $filters.string_trunc(coin.priceChangePercentage24h, 5) }}%
            </p>
          </div>
        </div>
      </li>
    </ul>
  </div>
  <!-- ============ Table ============ -->
  <div class="container mx-auto pt-18 px-2">
    
    <!-- table -->
    <table class="table-fixed cursor-pointer" >
      <caption class="table-title font-bold text-gray-700  pb-2">Cryptocurrency Exchange - Top 20 (Market Cap)</caption>
      <!-- head -->
      <thead>
        <tr class="relative text-left text-gray-600 text-sm" >
          <td class="p-2"> 
            Search: 
            <input type="text" placeholder="Coin Name ..." class="border border-gray-500 rounded p-2"
              v-model="search"
            />
          </td>          
        </tr>
        <tr class="text-left bg-gray-100 text-gray-600 text-sm">
          <th class="w-1/4 p-1">#</th> <!-- # -->
          <th class="w-1/4 p-4">Coin Name</th>
          <th class="w-1/4">Market Price(Real Time)</th>
          <th class="w-1/4">Change%(24 Hours)</th>
          <th class="w-1/4 hidden sm:table-cell">Trading Volume</th>
          <th class="w-1/4 hidden sm:table-cell">Market Capitalization</th>
        </tr>
      </thead>
      
      <!-- body -->
      <tbody class="divide-y">
        <!-- 1 -->
        <tr class="text-sm hover:bg-gray-100 transition duration-300"
          v-for="coin in matchedNames" :key="coin.name"
        >
          <td>${index + 1}</td> <!-- # -->
          <td class="p-4 flex items-center">
            <p class="mr-2">{{coin.marketCapRank}}</p>
            <img
              :src="coin.image"
              alt="coin logo"
              class="w-7 h-7 rounded-full mr-1"
              onclick="window.location='https://api.coingecko.com/api/v3/coins/bitcoin/ohlc?vs_currency=usd&days=1&x-cg-pro-api-key=CG-h5drP3fPRQVmBJNmoTuRwyXv';"
            />  <!-- link website -->
            <p class="font-bold p-1 mr-1">{{coin.name}}</p>
            <p class="uppercase text-gray-500 hidden sm:table-cell">
              {{coin.symbol}}
            </p>
          </td>
          <td class="font-bold text-gray-600">
            ${{ $filters.comma_separator(coin.currentPrice) }}
          </td>
          <td class=" font-bold">
            <div class="text-red-500" v-if="$filters.price_negative(coin.priceChangePercentage24h)">
              <fa icon="caret-down" class="mr-1" />{{coin.priceChangePercentage24h}}%
            </div>
            <div v-else class="text-green-500" >
              <fa icon="caret-up" class="mr-1" />{{coin.priceChangePercentage24h}}%
            </div>
          </td>
          <td class="hidden sm:table-cell">
            <p style="color:rgb(245, 85, 170)">{{ $filters.comma_separator(coin.totalVolume) }} </p>
          </td>
          <td class="pr-10 hidden sm:table-cell">
            <p style="color:rgb(245, 85, 170)">${{ $filters.comma_separator(coin.marketCap) }} </p>
          </td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import "./assets/tailwind.css";
import { computed, ref, watchEffect } from "vue";

import axios from 'axios'
export default {
  name: "App",
  setup() { //JS 會call 既method
    const coins = ref([]);
    const cloneCoins = ref([]); //for走馬燈
    const search = ref('')
    // api call
    const retrieveCoins = async () => {
      try {
        const response = await axios.get(
          "http://localhost:8088/crypto/api/v1/coin/market"
        );
        coins.value = response.data;
      } catch (err) {
        console.log(err);
      }
    };
    // fetch timer, invoke backend service in every 30 seconds 
    setInterval(() => {
      retrieveCoins();
    }, 60000); //太密了了30000
    // 10 items for marquee
    const tenCoins = computed(() => {
      return coins.value.slice(0, 10);  //limited 10 times
    });
    // cloneCoins
    watchEffect(()=>{
      const dup = coins.value.slice(0, 5); //slice是契合的script
      cloneCoins.value = dup;
    });
    // search
    const matchedNames = computed(()=> {
      return coins.value.filter((coin) => coin.id.includes(search.value)); //similar to landa
    });
    return { tenCoins, cloneCoins, matchedNames, search };
  },
};
</script>

<style>
#app {
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
}
.marquee-content {
  animation: scrolling 25s linear infinite;
}
.marquee-content li {
  width: 19%;
}
.table-title {
  font-size : 30px;
  bottom: 30;
  height: 1.5em;
}
.marquee:before,
.marquee:after {
  position: absolute;
  top: 0;
  width: 10rem;
  height: 3em;
  content: "";
  z-index: 1;
}
.marquee {
  background: rgb(59, 191, 189);
}
.marquee:before {
  left: 0;
  background: linear-gradient(to right, rgb(238, 172, 221) 0%, transparent 70%);
}
.marquee:after {
  right: 0;
  background: linear-gradient(to left, rgb(176, 227, 239) 0%, transparent 70%);
}
@keyframes scrolling {
  0% {
    transform: translateX(0);
  }
  100% {
    transform: translateX(-100%);
  }
}
</style>
