<template>
  <section>
     <div class="uk-flex uk-flex-center uk-margin-xlarge-left">
        <form class="uk-search uk-search-navbar uk-background-muted">
          <a class=" uk-form-icon uk-search-icon-flip" uk-search-icon v-on:click.prevent="submit"></a>
          <input class="uk-search-input uk-padding-small" v-on:keydown.enter.prevent="submit" placeholder="search" v-model="searchString" name="">
        </form>
    </div>
  </section>
</template>
<script>


export default {
  props:['submit', 'searchString'],
  data:function(){
    return{
        mutableList: this.searchString
    }
  
  }
}
</script>
<style scoped>
  .uk-search{
  margin-bottom: 10px !important;
  border-bottom: 1px solid;
  border-bottom-color: #F1F1F1;
}
</style>
