import { computed, ref, watchEffect } from "vue";

import axios from "axios";
export default {
  name: "App",
  setup() {
    const coins = ref([]);
    const cloneCoins = ref([]);
    const search = ref("");
    // Define the API Call
    const retrieveCoins = async () => {
      try {
        const response = await axios.get(
          // "http://localhost:8088/crypto/api/v1/coin/market"
          "https://api.coingecko.com/api/v3/coins/markets?vs_currency=usd"
        );
        coins.value = response.data;
      } catch (err) {
        console.log(err);
      }
    };
    // fetch timer, invoke backend service in every 30 seconds
    setInterval(() => {
      retrieveCoins();
    }, 30000);

    // inital run
    retrieveCoins();

    // 10 items for marquee
    const tenCoins = computed(() => {
      return coins.value.slice(0, 10);
    });
    // cloneCoins
    watchEffect(() => {
      const dup = coins.value.slice(0, 5);
      cloneCoins.value = dup;
    });
    // search
    const matchedNames = computed(() => {
      return coins.value.filter((coin) => coin.id.includes(search.value));
    });
    return { tenCoins, cloneCoins, matchedNames, search };
  },
};