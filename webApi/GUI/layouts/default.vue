<template>
  <div class="uk-container-expand">
    <nav class="uk-navbar uk-background-muted uk-margin-large-bottom uk-margin-remove-bottom" >
      <div class="uk-navbar-center ">
          <ul class="uk-navbar-nav uk-margin-xlarge-left">
            <li><nuxt-link :to="'/'">Search Person</nuxt-link> </li>
            <li><nuxt-link :to="'/addPerson'">Add Person</nuxt-link> </li>
          </ul>
        </div>
    </nav>

    <nuxt/>
  </div>
</template>
<style>
html

.uk-active{
  background-color: #FAFAD2;
}
 .uk-navbar-nav li a  {
  font-weight: bold;
  font-family: Century Gothic;
  color: #191970;
}

.uk-navbar{
  margin-bottom: 10px !important;
  border-bottom: 0.1px solid;
  border-bottom-color: #F1F1F1;
}


</style>
