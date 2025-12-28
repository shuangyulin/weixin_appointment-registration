<template>
	<div :style='{"width":"calc(100% - 40px)","padding":"20px 30px","margin":"20px 0 0 auto","fontSize":"16px","borderRadius":"10px","background":"#fff"}'>
		<el-form
			:style='{"padding":"20px 20% 0 5%","borderColor":"#eee","borderStyle":"solid","borderWidth":"0px 0 0"}'
			class="add-update-preview"
			ref="ruleForm"
			:model="ruleForm"
			label-width="180px"
		>
				<el-form-item :style='{"border":"0px solid #eee","width":"100%","padding":"0","margin":"0 0 26px 0","display":"inline-block"}'   v-if="flag=='yonghu'"  label="账号" prop="zhanghao">
					<el-input v-model="ruleForm.zhanghao" readonly placeholder="账号" clearable></el-input>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","width":"100%","padding":"0","margin":"0 0 26px 0","display":"inline-block"}' v-if="flag=='yonghu'" label="头像" prop="touxiang">
					<file-upload
						tip="点击上传头像"
						action="file/upload"
						:limit="3"
						:multiple="true"
						:fileUrls="ruleForm.touxiang?ruleForm.touxiang:''"
						@change="yonghutouxiangUploadChange"
					></file-upload>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","width":"100%","padding":"0","margin":"0 0 26px 0","display":"inline-block"}'   v-if="flag=='yonghu'"  label="姓名" prop="xingming">
					<el-input v-model="ruleForm.xingming"  placeholder="姓名" clearable></el-input>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","width":"100%","padding":"0","margin":"0 0 26px 0","display":"inline-block"}' v-if="flag=='yonghu'"  label="性别" prop="xingbie">
					<el-select v-model="ruleForm.xingbie"  placeholder="请选择性别">
						<el-option
							v-for="(item,index) in yonghuxingbieOptions"
							v-bind:key="index"
							:label="item"
							:value="item">
						</el-option>
					</el-select>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","width":"100%","padding":"0","margin":"0 0 26px 0","display":"inline-block"}'   v-if="flag=='yonghu'"  label="电话" prop="dianhua">
					<el-input v-model="ruleForm.dianhua"  placeholder="电话" clearable></el-input>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","width":"100%","padding":"0","margin":"0 0 26px 0","display":"inline-block"}'   v-if="flag=='yonghu'"  label="年龄" prop="nianling">
					<el-input v-model="ruleForm.nianling"  placeholder="年龄" clearable></el-input>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","width":"100%","padding":"0","margin":"0 0 26px 0","display":"inline-block"}'   v-if="flag=='yonghu'"  label="身份证号" prop="shenfenzhenghao">
					<el-input v-model="ruleForm.shenfenzhenghao"  placeholder="身份证号" clearable></el-input>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","width":"100%","padding":"0","margin":"0 0 26px 0","display":"inline-block"}'   v-if="flag=='yisheng'"  label="医生账号" prop="yishengzhanghao">
					<el-input v-model="ruleForm.yishengzhanghao" readonly placeholder="医生账号" clearable></el-input>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","width":"100%","padding":"0","margin":"0 0 26px 0","display":"inline-block"}' v-if="flag=='yisheng'"  label="性别" prop="xingbie">
					<el-select v-model="ruleForm.xingbie"  placeholder="请选择性别">
						<el-option
							v-for="(item,index) in yishengxingbieOptions"
							v-bind:key="index"
							:label="item"
							:value="item">
						</el-option>
					</el-select>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","width":"100%","padding":"0","margin":"0 0 26px 0","display":"inline-block"}'   v-if="flag=='yisheng'"  label="医生姓名" prop="yishengxingming">
					<el-input v-model="ruleForm.yishengxingming"  placeholder="医生姓名" clearable></el-input>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","width":"100%","padding":"0","margin":"0 0 26px 0","display":"inline-block"}'   v-if="flag=='yisheng'"  label="联系电话" prop="lianxidianhua">
					<el-input v-model="ruleForm.lianxidianhua"  placeholder="联系电话" clearable></el-input>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","width":"100%","padding":"0","margin":"0 0 26px 0","display":"inline-block"}' v-if="flag=='yisheng'" label="头像" prop="touxiang">
					<file-upload
						tip="点击上传头像"
						action="file/upload"
						:limit="3"
						:multiple="true"
						:fileUrls="ruleForm.touxiang?ruleForm.touxiang:''"
						@change="yishengtouxiangUploadChange"
					></file-upload>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","width":"100%","padding":"0","margin":"0 0 26px 0","display":"inline-block"}'   v-if="flag=='yisheng'"  label="专业特长" prop="zhuanyetezhang">
					<el-input v-model="ruleForm.zhuanyetezhang"  placeholder="专业特长" clearable></el-input>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","width":"100%","padding":"0","margin":"0 0 26px 0","display":"inline-block"}'   v-if="flag=='yisheng'"  label="职称" prop="zhicheng">
					<el-input v-model="ruleForm.zhicheng"  placeholder="职称" clearable></el-input>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","width":"100%","padding":"0","margin":"0 0 26px 0","display":"inline-block"}' v-if="flag=='users'" label="用户名" prop="username">
					<el-input v-model="ruleForm.username" placeholder="用户名"></el-input>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","width":"100%","padding":"0","margin":"0 0 26px 0","display":"inline-block"}' v-if="flag=='users'" label="头像" prop="image">
					<file-upload
						tip="点击上传头像"
						action="file/upload"
						:limit="1"
						:multiple="false"
						:fileUrls="ruleForm.image?ruleForm.image:''"
						@change="usersimageUploadChange"
					></file-upload>
				</el-form-item>
				<el-form-item :style='{"padding":"0","margin":"20px 0 0"}'>
					<el-button class="btn3" :style='{"border":"0px solid #ccc","cursor":"pointer","padding":"0 10px","margin":"0 10px 0 0","color":"#fff","borderRadius":"30px","background":"#437BC7","width":"auto","fontSize":"16px","minWidth":"120px","height":"40px"}' type="primary" @click="onUpdateHandler">
						<span class="icon iconfont icon-tijiao04" :style='{"margin":"0 2px","fontSize":"16px","color":"#fff","height":"40px"}'></span>
						保存
					</el-button>
				</el-form-item>
		</el-form>
	</div>
</template>
<script>
// 校验引入
import { 
	isIntNumer,
	isMobile,
	checkIdCard,
} from "@/utils/validate";

export default {
	data() {
		return {
			ruleForm: {},
			flag: '',
			usersFlag: false,
			yonghuxingbieOptions: [],
			yishengxingbieOptions: [],
			};
		},
		mounted() {
			var table = this.$storage.get("sessionTable");
			this.flag = table;
			this.$http({
				url: `${this.$storage.get("sessionTable")}/session`,
				method: "get"
			}).then(({ data }) => {
				if (data && data.code === 0) {

					this.ruleForm = data.data;
				} else {
					this.$message.error(data.msg);
				}
			});
			this.yonghuxingbieOptions = "男,女".split(',')
			this.yishengxingbieOptions = "男,女".split(',')
		},
		methods: {
		yonghutouxiangUploadChange(fileUrls) {
			this.ruleForm.touxiang = fileUrls;
		},
		yishengtouxiangUploadChange(fileUrls) {
			this.ruleForm.touxiang = fileUrls;
		},
		usersimageUploadChange(fileUrls) {
			this.ruleForm.image = fileUrls;
		},
		onUpdateHandler() {
			if((!this.ruleForm.zhanghao)&& 'yonghu'==this.flag){
				this.$message.error('账号不能为空');
				return
			}


			if((!this.ruleForm.mima)&& 'yonghu'==this.flag){
				this.$message.error('密码不能为空');
				return
			}

			if((!this.ruleForm.touxiang)&& 'yonghu'==this.flag){
				this.$message.error('头像不能为空');
				return
			}


			if(this.ruleForm.touxiang!=null) {
				this.ruleForm.touxiang = this.ruleForm.touxiang.replace(new RegExp(this.$base.url,"g"),"");
			}
			if((!this.ruleForm.xingming)&& 'yonghu'==this.flag){
				this.$message.error('姓名不能为空');
				return
			}






			if( 'yonghu' ==this.flag && this.ruleForm.dianhua&&(!isMobile(this.ruleForm.dianhua))){
				this.$message.error(`电话应输入手机格式`);
				return
			}


			if( 'yonghu' ==this.flag && this.ruleForm.nianling&&(!isIntNumer(this.ruleForm.nianling))){
				this.$message.error(`年龄应输入整数`);
				return
			}
			if((!this.ruleForm.shenfenzhenghao)&& 'yonghu'==this.flag){
				this.$message.error('身份证号不能为空');
				return
			}


			if( 'yonghu' ==this.flag && this.ruleForm.shenfenzhenghao&&(!checkIdCard(this.ruleForm.shenfenzhenghao))){
				this.$message.error(`身份证号应输入身份证格式`);
				return
			}
			if((!this.ruleForm.yishengzhanghao)&& 'yisheng'==this.flag){
				this.$message.error('医生账号不能为空');
				return
			}


			if((!this.ruleForm.mima)&& 'yisheng'==this.flag){
				this.$message.error('密码不能为空');
				return
			}



			if((!this.ruleForm.yishengxingming)&& 'yisheng'==this.flag){
				this.$message.error('医生姓名不能为空');
				return
			}




			if( 'yisheng' ==this.flag && this.ruleForm.lianxidianhua&&(!isMobile(this.ruleForm.lianxidianhua))){
				this.$message.error(`联系电话应输入手机格式`);
				return
			}


			if(this.ruleForm.touxiang!=null) {
				this.ruleForm.touxiang = this.ruleForm.touxiang.replace(new RegExp(this.$base.url,"g"),"");
			}
			if((!this.ruleForm.zhuanyetezhang)&& 'yisheng'==this.flag){
				this.$message.error('专业特长不能为空');
				return
			}


			if((!this.ruleForm.zhicheng)&& 'yisheng'==this.flag){
				this.$message.error('职称不能为空');
				return
			}






			if('users'==this.flag && this.ruleForm.username.trim().length<1) {
				this.$message.error(`用户名不能为空`);
				return	
			}
			if(this.flag=='users'){
				this.ruleForm.image = this.ruleForm.image.replace(new RegExp(this.$base.url,"g"),"")
			}
			this.$http({
				url: `${this.$storage.get("sessionTable")}/update`,
				method: "post",
				data: this.ruleForm
			}).then(({ data }) => {
				if (data && data.code === 0) {
					if(this.flag=='users'){
						this.$storage.set('headportrait',this.ruleForm.image)
					}
					this.$message({
						message: "修改信息成功",
						type: "success",
						duration: 1500,
						onClose: () => {
							window.location.reload();
						}
					});
				} else {
					this.$message.error(data.msg);
				}
			});
		}
	}
};
</script>
<style lang="scss" scoped>
	.el-date-editor.el-input {
		width: auto;
	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__label {
				padding: 0 10px 0 0;
				color: #666;
				font-weight: 600;
				width: 180px;
				font-size: 16px;
				line-height: 40px;
				text-align: right;
			}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__content {
		margin-left: 180px;
	}
	
	.add-update-preview .el-input /deep/ .el-input__inner {
				border: 1px solid #E8E8E8;
				border-radius: 0px;
				padding: 0 12px;
				color: #666;
				width: 100%;
				font-size: 16px;
				min-width: 50%;
				height: 40px;
			}
	
	.add-update-preview .el-select /deep/ .el-input__inner {
				border: 1px solid #E8E8E8;
				border-radius: 0px;
				padding: 0 10px;
				color: #666;
				width: 100%;
				font-size: 16px;
				height: 40px;
			}
	
	.add-update-preview .el-date-editor /deep/ .el-input__inner {
				border: 1px solid #E8E8E8;
				border-radius: 0px;
				padding: 0 10px 0 30px;
				color: #666;
				background: #fff;
				width: 100%;
				font-size: 16px;
				height: 40px;
			}
	
	.add-update-preview /deep/ .el-upload--picture-card {
		background: transparent;
		border: 0;
		border-radius: 0;
		width: auto;
		height: auto;
		line-height: initial;
		vertical-align: middle;
	}
	
	.add-update-preview /deep/ .el-upload-list .el-upload-list__item {
				border: 1px dashed #E8E8E8;
				cursor: pointer;
				border-radius: 0px;
				color: #666;
				background: #fff;
				width: 200px;
				font-size: 24px;
				line-height: 90px;
				text-align: center;
				height: 90px;
			}
	
	.add-update-preview /deep/ .el-upload .el-icon-plus {
				border: 1px dashed #E8E8E8;
				cursor: pointer;
				border-radius: 0px;
				color: #666;
				background: #fff;
				width: 200px;
				font-size: 24px;
				line-height: 90px;
				text-align: center;
				height: 90px;
			}
	
	.add-update-preview .el-textarea /deep/ .el-textarea__inner {
				border: 1px solid #E8E8E8;
				border-radius: 0px;
				padding: 12px;
				color: #666;
				background: #fff;
				width: 100%;
				font-size: 14px;
				height: 120px;
			}
	
	.add-update-preview .btn3 {
				border: 0px solid #ccc;
				cursor: pointer;
				border-radius: 30px;
				padding: 0 10px;
				margin: 0 10px 0 0;
				color: #fff;
				background: #437BC7;
				width: auto;
				font-size: 16px;
				min-width: 120px;
				height: 40px;
			}
	
	.add-update-preview .btn3:hover {
				opacity: 0.8;
			}
	
	.editor>.avatar-uploader {
		line-height: 0;
		height: 0;
	}
</style>
