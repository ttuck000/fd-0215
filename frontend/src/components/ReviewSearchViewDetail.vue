<template>

    <v-card outlined>
        <v-card-title>
            ReviewSearch # {{$route.params.id }}
        </v-card-title>

        <v-card-text>
            <div>
                <String label="ReviewId" v-model="item.reviewId" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="Contents" v-model="item.contents" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="CustomerId" v-model="item.customerId" :editMode="editMode" @change="change" />
            </div>
        </v-card-text>
    </v-card>

</template>

<script>
  const axios = require('axios').default;

  export default {
    name: 'ReviewSearchViewDetail',
    props: {
      value: Object,
    },
    data: () => ({
        item : [],
    }),
    async created() {
      var params = this.$route.params;
      var temp = await axios.get(axios.fixUrl('/reviewSearches/' + params.id))

      this.item = temp.data;

    },
    methods: {
    }
  }
</script>

