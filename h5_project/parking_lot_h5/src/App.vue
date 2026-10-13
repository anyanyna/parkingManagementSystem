<script>
	export default {
		onLaunch: function() {
			console.log('App Launch')
		},
		onShow: function() {
			console.log('App Show')
		},
		onHide: function() {
			console.log('App Hide')
		}
	}
</script>

<style lang="scss">
	/*每个页面公共css */
	@import "@/uni_modules/uview-ui/index.scss";
	*,view{
		box-sizing: border-box;
	}
	page {
	  width: 100%;
	  height: 100%;
	  background-color: #F0F2F2;
		
	}
</style>
