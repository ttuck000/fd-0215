<template>

    <v-data-table
        :headers="headers"
        :items="reviewSearch"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'ReviewSearchView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
                { text: "reviewId", value: "reviewId" },
                { text: "contents", value: "contents" },
                { text: "customerId", value: "customerId" },
            ],
            reviewSearch : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/reviewSearches'))

            temp.data._embedded.reviewSearches.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.reviewSearch = temp.data._embedded.reviewSearches;
        },
        methods: {
        }
    }
</script>

