<template>

    <v-data-table
        :headers="headers"
        :items="kakaotalk"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'KakaotalkView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
                { text: "orderStatus", value: "orderStatus" },
                { text: "phoneNumber", value: "phoneNumber" },
                { text: "userId", value: "userId" },
            ],
            kakaotalk : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/kakaotalks'))

            temp.data._embedded.kakaotalks.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.kakaotalk = temp.data._embedded.kakaotalks;
        },
        methods: {
        }
    }
</script>

