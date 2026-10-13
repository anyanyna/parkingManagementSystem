
<template>
            <yt-grid width="1700" height="925" background="#F0F2F5">
                
            <yt-grid-item fixedSize='width' comWidth='58.00px' id="yt-s9rsnm17gsfmu" gridColumnStart="20" gridColumnEnd="78" gridRowStart="16" gridRowEnd="36" zIndex="1" previewType="FixedWH">
                <span ref='ref1' class='webVueAntYtSpan webVueAntYtSpanStyle-mvkcn40  webVueAntYtSpanStyle-mv webVueAntYtSpanStyle null-mv null'>
                            <span v-html='"车场配置"'>
                            
                        </span>
                        </span>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' id="yt-oheiom17gsfn7" gridColumnStart="20" gridColumnEnd="1680" gridRowStart="47" gridRowEnd="167" zIndex="2" previewType="FixedWH">
                <div ref='ref2' class='webVueAntYtRectangle webVueAntYtRectangleStyle-mv3qkzi webVueAntYtRectangleStyle-mv webVueAntYtRectangleStyle'>
                            
                        </div>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' id="yt-bcnmvm17gsfnd" gridColumnStart="40" gridColumnEnd="370" gridRowStart="67" gridRowEnd="99" zIndex="3" previewType="FixedWH">
                <a-form-item ref='ref3' class='webVueAntInputFormItem webVueAntYtInputFormItem-mv1ygk3  webVueAntYtInputFormItem-mv webVueAntYtInputFormItem show-label-mv show-label' name='Nameofyardvalue1' :colon='false'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"车场名称："'>
                            
                        </span>
                        </div>
                        </template>
<a-input data-event class='webVueAntinput webVueAntYtInputStyle-mvpakf4 webVueAntYtInputStyle-mv webVueAntYtInputStyle' v-model:value='Nameofyardvalue1' :maxLength='100' :placeholder='"请输入"'>
                            
                        </a-input>
                        </a-form-item>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' id="yt-pav9fm17gsfsd" gridColumnStart="1330" gridColumnEnd="1660" gridRowStart="67" gridRowEnd="99" zIndex="4" previewType="FixedWH">
                <a-form-item ref='ref9367' class='webVueSelectFormItem webVueAntYtSelectFormItem-mv5wgh9  webVueAntYtSelectFormItem-mv webVueAntYtSelectFormItem show-label-mv show-label' name='Categoryofyardvalue1' :colon='false'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"车场类别："'>
                            
                        </span>
                        </div>
                        </template>
<a-select data-event class='webVueSelect  webVueAntYtSelectStyle-mv webVueAntYtSelectStyle' dropdownClassName='"popup_yt-pav9fm17gsfsd" "popupKeyId"' :showArrow='true' v-model:value='Categoryofyardvalue1' :allowClear='true' :placeholder='"请输入"' :mode='"multiple"' :options='optionsParkingLotCategory' :showSearch='true'>
<!-- <a-select data-event class='webVueSelect  webVueAntYtSelectStyle-mv webVueAntYtSelectStyle' dropdownClassName='"popup_yt-pav9fm17gsfsd" "popupKeyId"' :showArrow='true' v-model:value='Categoryofyardvalue1' :allowClear='true' :placeholder='"请输入"' :mode='"multiple"' :options='[{"label":"商场","value":"商场","disabled":false,"select":false},{"label":"停车楼","value":"停车楼","disabled":false,"select":false},{"value":"交通枢纽","label":"交通枢纽","disabled":false,"select":false},{"value":"医院","label":"医院","disabled":false,"select":false},{"value":"住宅社区","label":"住宅社区","disabled":false,"select":false},{"value":"商业园区","label":"商业园区","disabled":false,"select":false},{"value":"写字楼","label":"写字楼","disabled":false,"select":false},{"value":"银行","label":"银行","disabled":false,"select":false},{"value":"政府","label":"政府","disabled":false,"select":false},{"value":"校区","label":"校区","disabled":false,"select":false}]' :showSearch='true'> -->
                            
                        </a-select>
                        </a-form-item>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' id="yt-hfisim18o2h3o" gridColumnStart="1520" gridColumnEnd="1584" gridRowStart="115" gridRowEnd="147" zIndex="5" previewType="FixedWH">
                <a-button ref='ref11' @click="()=> { handleSearchYards('search'); }" class='webVueAntButton webVueAntYtButtonStyle-mvj97ih  webVueAntYtButtonStyle-mv webVueAntYtButtonStyle center-mv center' :loading='Checkloading1'>
                            <span class='yt-button-content ' v-html='"查询"'>
                            
                        </span>
                        </a-button>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' id="yt-o4q99m18o2h3y" gridColumnStart="1596" gridColumnEnd="1660" gridRowStart="115" gridRowEnd="147" zIndex="6" previewType="FixedWH">
                <a-button ref='ref12' @click="()=> { handleResetFilters(); }" class='webVueAntButton webVueAntYtButtonStyle-mvnwml7  webVueAntYtButtonStyle-mv webVueAntYtButtonStyle center-mv center' :loading='Reset1loading1'>
                            <span class='yt-button-content ' v-html='"重置"'>
                            
                        </span>
                        </a-button>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' id="yt-sgoe7m18o4yw6" gridColumnStart="20" gridColumnEnd="1680" gridRowStart="188" gridRowEnd="996" zIndex="7" previewType="FixedWH">
                <div ref='ref13' class='webVueAntYtRectangle webVueAntYtRectangleStyle-mv5e698 webVueAntYtRectangleStyle-mv webVueAntYtRectangleStyle'>
                            
                        </div>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' id="yt-dkj1zm18o4ywb" gridColumnStart="40" gridColumnEnd="104" gridRowStart="204" gridRowEnd="236" zIndex="8" previewType="FixedWH">
                <a-button ref='ref14' @click="()=> { showNewYardModal(); }" class='webVueAntButton webVueAntYtButtonStyle-mvx33n5  webVueAntYtButtonStyle-mv webVueAntYtButtonStyle center-mv center' :loading='Newloading1'>
                            <span class='yt-button-content ' v-html='"新建"'>
                            
                        </span>
                        </a-button>
            </yt-grid-item>
        
            <!-- 启用-批量操作 -->
            <yt-grid-item fixedSize='selfAdaption' id="yt-kk72lm18o4ywl" gridColumnStart="116" gridColumnEnd="180" gridRowStart="204" gridRowEnd="236" zIndex="9" previewType="FixedWH">
                <a-button ref='ref15' @click="()=> { handleDeactivateEnableSelectedYards(); }" class='webVueAntButton webVueAntYtButtonStyle-mvx33n5  webVueAntYtButtonStyle-mv webVueAntYtButtonStyle center-mv center' :loading='Deactivation1loading3'>
                            <span class='yt-button-content ' v-html='"启用"'>
                            
                        </span>
                        </a-button>
            </yt-grid-item>

             <!-- 停用-批量操作 -->
             <yt-grid-item fixedSize='selfAdaption' id="yt-kk72lm18o4ywl" gridColumnStart="196" gridColumnEnd="265" gridRowStart="204" gridRowEnd="236" zIndex="9" previewType="FixedWH">
                <a-button ref='ref15' @click="()=> { handleDeactivateSelectedYards(); }" class='webVueAntButton webVueAntYtButtonStyle-mvmfn7t  webVueAntYtButtonStyle-mv webVueAntYtButtonStyle center-mv center' :loading='Deactivation1loading3'>
                            <span class='yt-button-content ' v-html='"停用"'>
                            
                        </span>
                        </a-button>
            </yt-grid-item>
        
            <!-- 车场配置-列表 -->
            <yt-grid-item fixedSize='selfAdaption' :isShow='YardListisShow1' id="yt-g8j26m18o4yx8" gridColumnStart="40" gridColumnEnd="1660" gridRowStart="251" gridRowEnd="855" zIndex="10" previewType="FixedWH">
            <!-- <yt-grid-item fixedSize='selfAdaption' :isShow='YardListisShow1' id="yt-g8j26m18o4yx8" gridColumnStart="40" gridColumnEnd="1660" gridRowStart="251" gridRowEnd="855" zIndex="10" previewType="FixedWH"> -->
                <!-- <yt-table ref='ref9368' @onTableChange="(pagination)=> { fetchPaginatedParkingLotData(pagination); }" @onRowClick="(record)=> { showParkingLotDetails(record); }" class='webVueAntYtTable webVueAntYtTableStyle-mvm9sfd webVueAntYtTableStyle-mv webVueAntYtTableStyle' :selectType='"checkbox"' v-model:selectedRows='YardListselectedRows1' v-model:total='YardListtotal1' v-model:current='YardListcurrent2' v-model:pageSize='YardListpageSize1' :columns='YardListdata1.columns' :showSizeChanger='true' :showQuickJumper='true' :dataSource='YardListdata1.dataSource' :scroll='{y:491.9999578285365}'> -->
                <yt-table ref='ref9368' @onTableChange="(pagination)=> { fetchPaginatedParkingLotData(pagination); }" @onRowClick="(record)=> { showParkingLotDetails(record); }" class='webVueAntYtTable webVueAntYtTableStyle-mvm9sfd webVueAntYtTableStyle-mv webVueAntYtTableStyle' :selectType='"checkbox"' v-model:selectedRows='YardListselectedRows1' v-model:total='YardListtotal1' v-model:current='YardListcurrent2' v-model:pageSize='YardListpageSize1' :columns='YardListdata1.columns' :showSizeChanger='true' :showQuickJumper='true' :dataSource='YardListdata1.dataSource'>
                            <template #cell='{ column, record }'>
                            <template v-if='column.dataIndex === "operation1"' :forKey='"operation1"'>
                            
            <yt-grid  previewType="AdaptiveWH" width="100%" height="100%">
                
            <!-- <yt-grid-item fixedSize='selfAdaption' top="0.30000%" left="1.30000%" bottom="0.30000%" right="1.70000%" gridColumnStart="9" gridColumnEnd="44" gridRowStart="16" gridRowEnd="86" zIndex="1" previewType="AdaptiveWH"> -->
            <yt-grid-item fixedSize='selfAdaption' top="0.30000%" left="1.30000%" bottom="0.30000%" right="1.70000%" gridColumnStart="9" gridColumnEnd="33" gridRowStart="16" gridRowEnd="86" zIndex="1" previewType="AdaptiveWH">
                <a-button ref='ref31' @click="(event)=> { event.stopPropagation(); handleEditYard(record); }" class='webVueAntButton webVueAntYtButtonStyle-mvy8s4x  webVueAntYtButtonStyle-mv webVueAntYtButtonStyle center-mv center' :loading='Editloading1'>
                            <span class='yt-button-content ' v-html='"编辑"'>
                            
                        </span>
                        </a-button>
            </yt-grid-item>

            <!-- 二维码-列表操作 -->
            <!-- <yt-grid-item fixedSize='selfAdaption' top="0.30000%" left="0.20000%" bottom="0.30000%" right="0.00000%" gridColumnStart="36" gridColumnEnd="50" gridRowStart="16" gridRowEnd="86" zIndex="2" previewType="AdaptiveWH"> -->
            <yt-grid-item fixedSize='selfAdaption' top="0.30000%" left="0.20000%" bottom="0.30000%" right="0.00000%" gridColumnStart="50" gridColumnEnd="50" gridRowStart="16" gridRowEnd="86" zIndex="2" previewType="AdaptiveWH">
                <a-button ref='ref32' @click="(event)=> { event.stopPropagation(); handleGenerateQRCode(record); }" class='webVueAntButton webVueAntYtButtonStyle-mvy8s4x  webVueAntYtButtonStyle-mv webVueAntYtButtonStyle center-mv center' :loading='Deactivation1loading1'>
                            <span class='yt-button-content ' v-html='"二维码"'>
                            
                        </span>
                        </a-button>
            </yt-grid-item>
        
            <!-- 停用-列表操作 -->
            <!-- <yt-grid-item fixedSize='selfAdaption' top="0.30000%" left="0.20000%" bottom="0.30000%" right="0.00000%" gridColumnStart="56" gridColumnEnd="90" gridRowStart="16" gridRowEnd="86" zIndex="2" previewType="AdaptiveWH"> -->
            <yt-grid-item v-if="record.statusoftheyard != '已停用'" fixedSize='selfAdaption' top="0.30000%" left="0.20000%" bottom="0.30000%" right="0.00000%" gridColumnStart="88" gridColumnEnd="72" gridRowStart="16" gridRowEnd="86" zIndex="2" previewType="AdaptiveWH">
                <a-button ref='ref32' @click="(event)=> { event.stopPropagation(); handleDeactivateYard(record); }" class='webVueAntButton webVueAntYtButtonStyle-mvlwfr3  webVueAntYtButtonStyle-mv webVueAntYtButtonStyle center-mv center' :loading='Deactivation1loading1'>
                            <span class='yt-button-content ' v-html='"停用"'>
                            
                        </span>
                        </a-button>
            </yt-grid-item>

            <!-- 启用-列表操作 -->
            <!-- <yt-grid-item fixedSize='selfAdaption' top="0.30000%" left="0.20000%" bottom="0.30000%" right="0.00000%" gridColumnStart="156" gridColumnEnd="80" gridRowStart="16" gridRowEnd="86" zIndex="2" previewType="AdaptiveWH"> -->
            <!-- <yt-grid-item fixedSize='selfAdaption' top="0.30000%" left="0.20000%" bottom="0.30000%" right="0.00000%" gridColumnStart="75" gridColumnEnd="95" gridRowStart="16" gridRowEnd="86" zIndex="2" previewType="AdaptiveWH"> -->
            <yt-grid-item v-if="record.statusoftheyard == '已停用'" fixedSize='selfAdaption' top="0.30000%" left="0.20000%" bottom="0.30000%" right="0.00000%" gridColumnStart="88" gridColumnEnd="72" gridRowStart="16" gridRowEnd="86" zIndex="2" previewType="AdaptiveWH">
                <a-button ref='ref32' @click="(event)=> { event.stopPropagation(); handleDeactivateEnableYard(record); }" class='webVueAntButton webVueAntYtButtonStyle-mvy8s4x  webVueAntYtButtonStyle-mv webVueAntYtButtonStyle center-mv center' :loading='Deactivation1loading1'>
                            <span class='yt-button-content ' v-html='"启用"'>
                            
                        </span>
                        </a-button>
            </yt-grid-item>
        
            </yt-grid>
            
                        </template>
                        </template>
                        </yt-table>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' id="yt-kb1uym18phh7i" gridColumnStart="470" gridColumnEnd="800" gridRowStart="67" gridRowEnd="99" zIndex="11" previewType="FixedWH">
                <a-form-item ref='ref20' class='webVueAntYtCascaderFormItem webVueAntYtCascaderFormItem-mv5j4kp  webVueAntYtCascaderFormItem-mv webVueAntYtCascaderFormItem show-label-mv show-label' name='Areavalue1' :colon='false'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"所属区域："'>
                            
                        </span>
                        </div>
                        </template>
<!-- <a-cascader data-event class='webVueAntYtCascader webVueAntYtCascaderStyle-mvbipu6 webVueAntYtCascaderStyle-mv webVueAntYtCascaderStyle' dropdownClassName='"popupKey" "popupKeyId"' change-on-select :showArrow='true' :placeholder='"请输入"' :multiple='true' :options='[{"value":"李沧区","label":"李沧区","disabled":false,"select":false,"children":[{"value":"XX街道","label":"XX街道","disabled":false,"select":false,"children":[{"value":"中心","label":"中心","disabled":false,"select":false}]}]}]' v-model:value='Areavalue1' :showSearch='true' :showCheckedStrategy='"SHOW_CHILD"'> -->
<a-cascader data-event class='webVueAntYtCascader webVueAntYtCascaderStyle-mvbipu6 webVueAntYtCascaderStyle-mv webVueAntYtCascaderStyle' dropdownClassName='"popupKey" "popupKeyId"' change-on-select :showArrow='true' :placeholder='"请输入"' :multiple='true' :options='optionsArea' v-model:value='Areavalue1' :showSearch='true' :showCheckedStrategy='"SHOW_CHILD"'>
                            
                        </a-cascader>
                        </a-form-item>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' id="yt-sf0b7m18pwssb" gridColumnStart="900" gridColumnEnd="1230" gridRowStart="67" gridRowEnd="99" zIndex="12" previewType="FixedWH">
                <a-form-item ref='ref9369' class='webVueSelectFormItem webVueAntYtSelectFormItem-mv248cx  webVueAntYtSelectFormItem-mv webVueAntYtSelectFormItem show-label-mv show-label' name='Typeofyardvalue1' :colon='false'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"车场类型："'>
                            
                        </span>
                        </div>
                        </template>
<a-select data-event class='webVueSelect  webVueAntYtSelectStyle-mv webVueAntYtSelectStyle' dropdownClassName='"popup_yt-pav9fm17gsfsd" "popupKeyId"' :showArrow='true' v-model:value='Typeofyardvalue1' :allowClear='true' :placeholder='"请输入"' :mode='"multiple"' :options='optionsParkingLotType' :showSearch='true'>
<!-- <a-select data-event class='webVueSelect  webVueAntYtSelectStyle-mv webVueAntYtSelectStyle' dropdownClassName='"popup_yt-pav9fm17gsfsd" "popupKeyId"' :showArrow='true' v-model:value='Typeofyardvalue1' :allowClear='true' :placeholder='"请输入"' :mode='"multiple"' :options='[{"label":"自营","value":"自营","disabled":false,"select":false},{"label":"托管（接入）","value":"托管（接入）","disabled":false,"select":false},{"value":"托管（未接）","label":"托管（未接）","disabled":false,"select":false}]' :showSearch='true'> -->
                            
                        </a-select>
                        </a-form-item>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' id="yt-r7pj6m18qdrbb" gridColumnStart="40" gridColumnEnd="370" gridRowStart="115" gridRowEnd="147" zIndex="13" previewType="FixedWH">
                <a-form-item ref='ref9370' class='webVueSelectFormItem webVueAntYtSelectFormItem-mv4859g  webVueAntYtSelectFormItem-mv webVueAntYtSelectFormItem show-label-mv show-label' name='Platevalue1' :colon='false'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"所属板块："'>
                            
                        </span>
                        </div>
                        </template>
<a-select data-event class='webVueSelect  webVueAntYtSelectStyle-mv webVueAntYtSelectStyle' dropdownClassName='"popup_yt-pav9fm17gsfsd" "popupKeyId"' :showArrow='true' v-model:value='Platevalue1' :allowClear='true' :placeholder='"请输入"' :mode='"multiple"' :options='optionsPlate' :showSearch='true'>
<!-- <a-select data-event class='webVueSelect  webVueAntYtSelectStyle-mv webVueAntYtSelectStyle' dropdownClassName='"popup_yt-pav9fm17gsfsd" "popupKeyId"' :showArrow='true' v-model:value='Platevalue1' :allowClear='true' :placeholder='"请输入"' :mode='"multiple"' :options='[{"label":"板块1","value":"板块1","disabled":false,"select":false},{"label":"板块2","value":"板块2","disabled":false,"select":false}]' :showSearch='true'> -->
                            
                        </a-select>
                        </a-form-item>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' id="yt-m5dwhm18qjlt5" gridColumnStart="470" gridColumnEnd="800" gridRowStart="115" gridRowEnd="147" zIndex="14" previewType="FixedWH">
                <a-form-item ref='ref9371' class='webVueSelectFormItem webVueAntYtSelectFormItem-mvx6e6v  webVueAntYtSelectFormItem-mv webVueAntYtSelectFormItem show-label-mv show-label' name='Statusoftheyardvalue1' :colon='false'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"车场状态："'>
                            
                        </span>
                        </div>
                        </template>
<a-select data-event class='webVueSelect  webVueAntYtSelectStyle-mv webVueAntYtSelectStyle' dropdownClassName='"popup_yt-pav9fm17gsfsd" "popupKeyId"' :showArrow='true' v-model:value='Statusoftheyardvalue1' :allowClear='true' :placeholder='"请输入"' :mode='"multiple"' :options='optionsParkingLotStatus' :showSearch='true'>
<!-- <a-select data-event class='webVueSelect  webVueAntYtSelectStyle-mv webVueAntYtSelectStyle' dropdownClassName='"popup_yt-pav9fm17gsfsd" "popupKeyId"' :showArrow='true' v-model:value='Statusoftheyardvalue1' :allowClear='true' :placeholder='"请输入"' :mode='"multiple"' :options='[{"label":"使用中","value":"使用中","disabled":false,"select":false},{"label":"试运行","value":"试运行","disabled":false,"select":false},{"value":"建设中","label":"建设中","disabled":false,"select":false},{"value":"已停用","label":"已停用","disabled":false,"select":false}]' :showSearch='true'> -->
                            
                        </a-select>
                        </a-form-item>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' id="yt-6bv4tm18qk464" gridColumnStart="900" gridColumnEnd="1230" gridRowStart="115" gridRowEnd="147" zIndex="15" previewType="FixedWH">
                <a-form-item ref='ref29' class='webVueAntInputFormItem webVueAntYtInputFormItem-mv8rrxx  webVueAntYtInputFormItem-mv webVueAntYtInputFormItem show-label-mv show-label' name='OperatingCompanyvalue1' :colon='false'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"运营公司："'>
                            
                        </span>
                        </div>
                        </template>
<a-input data-event class='webVueAntinput webVueAntYtInputStyle-mvdodth webVueAntYtInputStyle-mv webVueAntYtInputStyle' v-model:value='OperatingCompanyvalue1' :maxLength='100' :allowClear='true' :placeholder='"请输入"'>
                            
                        </a-input>
                        </a-form-item>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' :isShow='DepotDetailsisShow1' id="yt-lcqvgm19868ag" gridColumnStart="370" gridColumnEnd="1330" gridRowStart="122" gridRowEnd="886" zIndex="16" previewType="FixedWH">
                <yt-custom-modal ref='ref33' class='webVueAntYtModal webVueAntYtModalStyle-mv3k259 webVueAntYtModalStyle-mv webVueAntYtModalStyle' v-model:isShow='DepotDetailsisShow1' :title='"车场详情"' :showFooter='false' :maskClosable='true'>
                            <template #content>
                            <a-form class='webVueAntForm ' :model='DepotDetailsform1' ref='ref33_form'>
                            
            <div style="display:grid;width:100%;height:100%;grid-template-columns: repeat(auto-fill, 1%);grid-template-rows: repeat(auto-fill, 1%);position: relative;">
            
            <yt-grid-item fixedSize='selfAdaption' :isShow='DepotDetailsMenuisShow1' marginLeft='-13px' top="0.00000%" left="0.00000%" bottom="0.00000%" right="5.80000%" gridColumnStart="1" gridColumnEnd="15" gridRowStart="1" gridRowEnd="101" zIndex="1" previewType="FitScreen">
                <yt-vertical-menu-menu ref='ref37' @click_to_jump="()=> { handleYardDetailMenuSelection(); }" class='webVueAntYtVerticleMenu webVueAntYtVerticleMenuStyle-mvtbah7 webVueAntYtVerticleMenuStyle-mv webVueAntYtVerticleMenuStyle' v-model:openKeys='DepotDetailsMenuopenKeys1' v-model:selectedKeys='DepotDetailsMenuselectedKeys1' :items='DepotDetailsMenuoptions1.dataSource'>
                            
                        </yt-vertical-menu-menu>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="0.00000%" left="0.20000%" bottom="0.00000%" right="0.00000%" gridColumnStart="14" gridColumnEnd="101" gridRowStart="1" gridRowEnd="101" zIndex="2" previewType="FitScreen">
                <yt-dynamic-panel ref='ref38' class='webVueAntYtDynamicPanel ' mutileStyle='[{"statusId":"1","info":{}},{"statusId":"2","info":{}},{"statusId":"3","info":{}},{"statusId":"4","info":{}},{"statusId":"5","info":{}},{"statusId":"6","info":{}},{"statusId":"7","info":{}}]'>
                            
            <yt-grid  previewType="AdaptiveWH" width="100%" height="100%">
                
            <!-- 基础信息 -->
            <!-- <yt-grid-item fixedSize='selfAdaption' :isShow='false' top="0.00000%" left="0.00000%" bottom="0.00000%" right="0.00000%" gridColumnStart="1" gridColumnEnd="101" gridRowStart="1" gridRowEnd="101" zIndex="1" previewType="AdaptiveWH"> -->
            <yt-grid-item fixedSize='selfAdaption' :isShow='DepotDetailsDynamicPanelselectKey1 == "1"' top="0.00000%" left="0.00000%" bottom="0.00000%" right="0.00000%" gridColumnStart="1" gridColumnEnd="101" gridRowStart="1" gridRowEnd="101" zIndex="1" previewType="AdaptiveWH">
                <a-form ref='ref110' :model='Basicinformationform1' :class='["webVueAntForm","webVueAntYtFormStyle-mv","webVueAntYtFormStyle"]'>
                            
            <yt-grid  previewType="AdaptiveWH" width="100%" height="154.71167369901545%">
                
            <yt-grid-item fixedSize='selfAdaption' top="18.10000%" left="0.30000%" bottom="9.00000%" right="1.50000%" gridColumnStart="9" gridColumnEnd="46" gridRowStart="5" gridRowEnd="9" zIndex="1" previewType="AdaptiveWH">
                <a-form-item ref='ref111' class='webVueAntInputFormItem webVueAntYtInputFormItem-mvpuck0  webVueAntYtInputFormItem-mv webVueAntYtInputFormItem show-label-mv show-label' name='yardnumbervalue1' :colon='false' :rules='[]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"车场编号："'>
                            
                        </span>
                        </div>
                        </template>
<a-input data-event class='webVueAntinput webVueAntYtInputStyle-mvdkdf2 webVueAntYtInputStyle-mv webVueAntYtInputStyle' v-model:value='Basicinformationform1.yardnumbervalue1' :disabled='true' :maxLength='100' :placeholder='"请输入"'>
                            
                        </a-input>
                        </a-form-item>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="15.90000%" left="0.30000%" bottom="11.30000%" right="1.80000%" gridColumnStart="58" gridColumnEnd="97" gridRowStart="5" gridRowEnd="9" zIndex="2" previewType="AdaptiveWH">
                <a-form-item ref='ref112' class='webVueAntInputFormItem webVueAntYtInputFormItem-mv8s0vx  webVueAntYtInputFormItem-mv webVueAntYtInputFormItem show-label-mv show-label' name='Nameofyard1value1' :colon='false' :rules='[{"required":true,"message":"必填"}]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"车场名称："'>
                            
                        </span>
                        </div>
                        </template>
<a-input data-event class='webVueAntinput webVueAntYtInputStyle-mvfi2pe webVueAntYtInputStyle-mv webVueAntYtInputStyle' v-model:value='Basicinformationform1.Nameofyard1value1' :disabled='true' :maxLength='100' :placeholder='"请输入"'>
                            
                        </a-input>
                        </a-form-item>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="11.30000%" left="2.50000%" bottom="15.90000%" right="1.80000%" gridColumnStart="59" gridColumnEnd="97" gridRowStart="10" gridRowEnd="14" zIndex="3" previewType="AdaptiveWH">
                <a-form-item ref='ref114' class='webVueAntInputFormItem webVueAntYtInputFormItem-mvpbz2u  webVueAntYtInputFormItem-mv webVueAntYtInputFormItem show-label-mv show-label' name='Yardabbreviationvalue1' :colon='false' :rules='[]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"车场简称："'>
                            
                        </span>
                        </div>
                        </template>
<a-input data-event class='webVueAntinput webVueAntYtInputStyle-mvsjuug webVueAntYtInputStyle-mv webVueAntYtInputStyle' v-model:value='Basicinformationform1.Yardabbreviationvalue1' :disabled='true' :maxLength='100' :placeholder='"请输入"'>
                            
                        </a-input>
                        </a-form-item>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="18.10000%" left="1.30000%" bottom="9.00000%" right="1.70000%" gridColumnStart="7" gridColumnEnd="46" gridRowStart="27" gridRowEnd="31" zIndex="4" previewType="AdaptiveWH">
                <a-form-item ref='ref118' class='webVueAntInputFormItem webVueAntYtInputFormItem-mvwxgc4  webVueAntYtInputFormItem-mv webVueAntYtInputFormItem show-label-mv show-label' name='Numberofparkingvalue1' :colon='false' :rules='[{"required":true,"message":"必填"}]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"泊车数量："'>
                            
                        </span>
                        </div>
                        </template>
<a-input data-event class='webVueAntinput webVueAntYtInputStyle-mvs3dkq webVueAntYtInputStyle-mv webVueAntYtInputStyle' v-model:value='Basicinformationform1.Numberofparkingvalue1' :disabled='true' :maxLength='100' :placeholder='"请输入"'>
                            
                        </a-input>
                        </a-form-item>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="4.50000%" left="0.50000%" bottom="22.70000%" right="1.20000%" gridColumnStart="60" gridColumnEnd="97" gridRowStart="37" gridRowEnd="41" zIndex="5" previewType="AdaptiveWH">
                <a-form-item ref='ref119' class='webVueAntInputFormItem webVueAntYtInputFormItem-mvxhjfq  webVueAntYtInputFormItem-mv webVueAntYtInputFormItem show-label-mv show-label' name='Longtermrentalparkingspacesvalue1' :colon='false' :rules='[]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"长租车位："'>
                            
                        </span>
                        </div>
                        </template>
<a-input data-event class='webVueAntinput webVueAntYtInputStyle-mv56efh webVueAntYtInputStyle-mv webVueAntYtInputStyle' v-model:value='Basicinformationform1.Longtermrentalparkingspacesvalue1' :disabled='true' :maxLength='100' :placeholder='"自动同步"'>
                            
                        </a-input>
                        </a-form-item>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="4.50000%" left="2.60000%" bottom="22.70000%" right="1.80000%" gridColumnStart="8" gridColumnEnd="46" gridRowStart="37" gridRowEnd="41" zIndex="6" previewType="AdaptiveWH">
                <a-form-item ref='ref120' class='webVueAntInputFormItem webVueAntYtInputFormItem-mvuumku  webVueAntYtInputFormItem-mv webVueAntYtInputFormItem show-label-mv show-label' name='Reservationofparkingspacevalue1' :colon='false' :rules='[]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"预约车位："'>
                            
                        </span>
                        </div>
                        </template>
<a-input data-event class='webVueAntinput webVueAntYtInputStyle-mvlbaqg webVueAntYtInputStyle-mv webVueAntYtInputStyle' v-model:value='Basicinformationform1.Reservationofparkingspacevalue1' :disabled='true' :maxLength='100' :placeholder='"自动同步"'>
                            
                        </a-input>
                        </a-form-item>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="18.10000%" left="0.80000%" bottom="9.00000%" right="0.90000%" gridColumnStart="60" gridColumnEnd="97" gridRowStart="27" gridRowEnd="31" zIndex="7" previewType="AdaptiveWH">
                <a-form-item ref='ref121' class='webVueAntInputFormItem webVueAntYtInputFormItem-mvjn1mn  webVueAntYtInputFormItem-mv webVueAntYtInputFormItem show-label-mv show-label' name='VIPParkingvalue1' :colon='false' :rules='[]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"贵宾车位："'>
                            
                        </span>
                        </div>
                        </template>
<a-input data-event class='webVueAntinput webVueAntYtInputStyle-mv2mqra webVueAntYtInputStyle-mv webVueAntYtInputStyle' v-model:value='Basicinformationform1.VIPParkingvalue1' :disabled='true' :maxLength='100' :placeholder='"请输入"'>
                            
                        </a-input>
                        </a-form-item>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="11.30000%" left="0.20000%" bottom="15.90000%" right="1.60000%" gridColumnStart="60" gridColumnEnd="97" gridRowStart="32" gridRowEnd="36" zIndex="8" previewType="AdaptiveWH">
                <a-form-item ref='ref123' class='webVueAntInputFormItem webVueAntYtInputFormItem-mvoees1  webVueAntYtInputFormItem-mv webVueAntYtInputFormItem show-label-mv show-label' name='Numberofchargingpilesvalue1' :colon='false' :rules='[]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"充电桩数："'>
                            
                        </span>
                        </div>
                        </template>
<a-input data-event class='webVueAntinput webVueAntYtInputStyle-mvww6pf webVueAntYtInputStyle-mv webVueAntYtInputStyle' v-model:value='Basicinformationform1.Numberofchargingpilesvalue1' :disabled='true' :maxLength='100' :placeholder='"请输入"'>
                            
                        </a-input>
                        </a-form-item>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="27.20000%" left="45.20000%" bottom="30.30000%" right="36.50000%" gridColumnStart="3" gridColumnEnd="5" gridRowStart="2" gridRowEnd="5" zIndex="9" previewType="AdaptiveWH">
                <div ref='ref126' class='webVueAntYtRectangle webVueAntYtRectangleStyle-mvbi05d webVueAntYtRectangleStyle-mv webVueAntYtRectangleStyle'>
                            
                        </div>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='width' comWidth='58.00px' top="21.20000%" left="10.50000%" bottom="18.10000%" right="1.60000%" gridColumnStart="5" gridColumnEnd="13" gridRowStart="2" gridRowEnd="5" zIndex="10" previewType="AdaptiveWH">
                <span ref='ref127' class='webVueAntYtSpan webVueAntYtSpanStyle-mvn0u3r  webVueAntYtSpanStyle-mv webVueAntYtSpanStyle webVueAntYtSpanBrCount-mv webVueAntYtSpanBrCount'>
                            <span v-html='"基本信息"'>
                            
                        </span>
                        </span>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="18.10000%" left="45.20000%" bottom="18.10000%" right="36.50000%" gridColumnStart="3" gridColumnEnd="5" gridRowStart="24" gridRowEnd="26" zIndex="11" previewType="AdaptiveWH">
                <div ref='ref128' class='webVueAntYtRectangle webVueAntYtRectangleStyle-mv2tcbb webVueAntYtRectangleStyle-mv webVueAntYtRectangleStyle'>
                            
                        </div>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='width' comWidth='57.00px' top="12.10000%" left="10.50000%" bottom="27.20000%" right="3.20000%" gridColumnStart="5" gridColumnEnd="13" gridRowStart="24" gridRowEnd="27" zIndex="12" previewType="AdaptiveWH">
                <span ref='ref129' class='webVueAntYtSpan webVueAntYtSpanStyle-mvzllom  webVueAntYtSpanStyle-mv webVueAntYtSpanStyle webVueAntYtSpanBrCount-mv webVueAntYtSpanBrCount'>
                            <span v-html='"车位信息"'>
                            
                        </span>
                        </span>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="0.00000%" left="14.70000%" bottom="36.30000%" right="48.90000%" gridColumnStart="4" gridColumnEnd="5" gridRowStart="42" gridRowEnd="44" zIndex="13" previewType="AdaptiveWH">
                <div ref='ref130' class='webVueAntYtRectangle webVueAntYtRectangleStyle-mvr9ni5 webVueAntYtRectangleStyle-mv webVueAntYtRectangleStyle'>
                            
                        </div>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='width' comWidth='57.00px' top="24.20000%" left="1.20000%" bottom="15.10000%" right="0.20000%" gridColumnStart="6" gridColumnEnd="13" gridRowStart="41" gridRowEnd="44" zIndex="14" previewType="AdaptiveWH">
                <span ref='ref131' class='webVueAntYtSpan webVueAntYtSpanStyle-mvma1jw  webVueAntYtSpanStyle-mv webVueAntYtSpanStyle webVueAntYtSpanBrCount-mv webVueAntYtSpanBrCount'>
                            <span v-html='"运营信息"'>
                            
                        </span>
                        </span>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="11.30000%" left="2.30000%" bottom="15.90000%" right="0.80000%" gridColumnStart="7" gridColumnEnd="46" gridRowStart="45" gridRowEnd="49" zIndex="15" previewType="AdaptiveWH">
                <a-form-item ref='ref146' class='webVueAntInputFormItem webVueAntYtInputFormItem-mv3gl9k  webVueAntYtInputFormItem-mv webVueAntYtInputFormItem show-label-mv show-label' name='OperatingCompany1value1' :colon='false' :rules='[{"required":true,"message":"必填"}]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"运营公司："'>
                            
                        </span>
                        </div>
                        </template>
<a-input data-event class='webVueAntinput webVueAntYtInputStyle-mv2bvli webVueAntYtInputStyle-mv webVueAntYtInputStyle' v-model:value='Basicinformationform1.OperatingCompany1value1' :disabled='true' :maxLength='100' :placeholder='"请输入"'>
                            
                        </a-input>
                        </a-form-item>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="6.80000%" left="1.20000%" bottom="20.40000%" right="1.20000%" gridColumnStart="9" gridColumnEnd="46" gridRowStart="50" gridRowEnd="54" zIndex="16" previewType="AdaptiveWH">
                <a-form-item ref='ref148' class='webVueAntInputFormItem webVueAntYtInputFormItem-mvhzizl  webVueAntYtInputFormItem-mv webVueAntYtInputFormItem show-label-mv show-label' name='Personinchargevalue1' :colon='false' :rules='[{"required":true,"message":"必填"}]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"负责人："'>
                            
                        </span>
                        </div>
                        </template>
<a-input data-event class='webVueAntinput webVueAntYtInputStyle-mvma3t1 webVueAntYtInputStyle-mv webVueAntYtInputStyle' v-model:value='Basicinformationform1.Personinchargevalue1' :disabled='true' :maxLength='100' :placeholder='"请输入"'>
                            
                        </a-input>
                        </a-form-item>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="6.80000%" left="2.20000%" bottom="20.40000%" right="0.90000%" gridColumnStart="58" gridColumnEnd="97" gridRowStart="50" gridRowEnd="54" zIndex="17" previewType="AdaptiveWH">
                <a-form-item ref='ref149' class='webVueAntInputFormItem webVueAntYtInputFormItem-mvep1mf  webVueAntYtInputFormItem-mv webVueAntYtInputFormItem show-label-mv show-label' name='ContactPhonevalue1' :colon='false' :rules='[{"required":true,"message":"必填"}]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"联系电话："'>
                            
                        </span>
                        </div>
                        </template>
<a-input data-event class='webVueAntinput webVueAntYtInputStyle-mvykn6c webVueAntYtInputStyle-mv webVueAntYtInputStyle' v-model:value='Basicinformationform1.ContactPhonevalue1' :disabled='true' :maxLength='100' :placeholder='"请输入"'>
                            
                        </a-input>
                        </a-form-item>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="3.00000%" left="1.10000%" bottom="0.00000%" right="0.40000%" gridColumnStart="8" gridColumnEnd="97" gridRowStart="55" gridRowEnd="58" zIndex="18" previewType="AdaptiveWH">
                <a-form-item ref='ref150' class='webVueAntInputFormItem webVueAntYtInputFormItem-mv2ncsp  webVueAntYtInputFormItem-mv webVueAntYtInputFormItem show-label-mv show-label' name='latitudeandlongitudevalue1' :colon='false' :rules='[{"required":true,"message":"必填"}]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"经纬度："'>
                            
                        </span>
                        </div>
                        </template>
<a-input data-event class='webVueAntinput webVueAntYtInputStyle-mvnx2rb webVueAntYtInputStyle-mv webVueAntYtInputStyle' v-model:value='Basicinformationform1.latitudeandlongitudevalue1' :disabled='true' :maxLength='100' :placeholder='"请输入"'>
                            
                        </a-input>
                        </a-form-item>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="18.10000%" left="0.90000%" bottom="9.00000%" right="0.40000%" gridColumnStart="8" gridColumnEnd="97" gridRowStart="59" gridRowEnd="63" zIndex="19" previewType="AdaptiveWH">
                <a-form-item ref='ref151' class='webVueAntInputFormItem webVueAntYtInputFormItem-mvpy6vq  webVueAntYtInputFormItem-mv webVueAntYtInputFormItem show-label-mv show-label' name='Detailedaddressvalue1' :colon='false' :rules='[]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"详细地址："'>
                            
                        </span>
                        </div>
                        </template>
<a-input data-event class='webVueAntinput webVueAntYtInputStyle-mvl2pbf webVueAntYtInputStyle-mv webVueAntYtInputStyle' v-model:value='Basicinformationform1.Detailedaddressvalue1' :disabled='true' :maxLength='100' :placeholder='"请输入"'>
                            
                        </a-input>
                        </a-form-item>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="6.40000%" left="1.10000%" bottom="10.30000%" right="0.50000%" gridColumnStart="8" gridColumnEnd="97" gridRowStart="64" gridRowEnd="71" zIndex="20" previewType="AdaptiveWH">
                <a-form-item ref='ref152' class='webVueAntInputFormItem webVueAntYtInputFormItem-mvoippu  webVueAntYtInputFormItem-mv webVueAntYtInputFormItem show-label-mv show-label' name='YardDescriptionvalue1' :colon='false' :rules='[]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"车场描述："'>
                            
                        </span>
                        </div>
                        </template>
<a-input data-event class='webVueAntinput webVueAntYtInputStyle-mvloji9 webVueAntYtInputStyle-mv webVueAntYtInputStyle' v-model:value='Basicinformationform1.YardDescriptionvalue1' :disabled='true' :maxLength='100' :placeholder='"请输入"'>
                            
                        </a-input>
                        </a-form-item>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="9.00000%" left="2.60000%" bottom="27.20000%" right="61.00000%" gridColumnStart="4" gridColumnEnd="5" gridRowStart="72" gridRowEnd="74" zIndex="21" previewType="AdaptiveWH">
                <div ref='ref153' class='webVueAntYtRectangle webVueAntYtRectangleStyle-mvh3of7 webVueAntYtRectangleStyle-mv webVueAntYtRectangleStyle'>
                            
                        </div>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='width' comWidth='57.00px' top="30.30000%" left="12.00000%" bottom="9.00000%" right="1.60000%" gridColumnStart="5" gridColumnEnd="13" gridRowStart="71" gridRowEnd="74" zIndex="22" previewType="AdaptiveWH">
                <span ref='ref154' class='webVueAntYtSpan webVueAntYtSpanStyle-mvqq9z9  webVueAntYtSpanStyle-mv webVueAntYtSpanStyle webVueAntYtSpanBrCount-mv webVueAntYtSpanBrCount'>
                            <span v-html='"其他信息"'>
                            
                        </span>
                        </span>
            </yt-grid-item>
        

            <!-- <yt-grid-item fixedSize='width' comWidth='85.00px' top="12.10000%" left="2.60000%" bottom="27.20000%" right="3.70000%" gridColumnStart="7" gridColumnEnd="18" gridRowStart="80" gridRowEnd="83" zIndex="23" previewType="AdaptiveWH">
                <span ref='ref163' class='webVueAntYtSpan webVueAntYtSpanStyle-mvbmxa9  webVueAntYtSpanStyle-mv webVueAntYtSpanStyle webVueAntYtSpanBrCount-mv webVueAntYtSpanBrCount'>
                            <span v-html='"车场二维码："'>
                            
                        </span>
                        </span>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="4.50000%" left="5.00000%" bottom="4.50000%" right="6.90000%" gridColumnStart="18" gridColumnEnd="29" gridRowStart="80" gridRowEnd="88" zIndex="24" previewType="AdaptiveWH">
                <div ref='ref165' class='webVueAntYtPicture webVueAntYtPictureStyle-mvwhdhb webVueAntYtPictureStyle-mv webVueAntYtPictureStyle'>
                            <a-image :src='"./staticResource/public/yt-picture.png"' :preview='false' :style='{
        transform:"scaleX(1) scaleY(1)",
        objectFit:"contain"
      }'>
                            
                        </a-image>
                        </div>
            </yt-grid-item> -->
        

            <yt-grid-item fixedSize='width' comWidth='71.00px' top="4.50000%" left="7.40000%" bottom="4.50000%" right="6.50000%" gridColumnStart="8" gridColumnEnd="18" gridRowStart="75" gridRowEnd="92" zIndex="25" previewType="AdaptiveWH">
                <span ref='ref167' class='webVueAntYtSpan webVueAntYtSpanStyle-mvkj0hv  webVueAntYtSpanStyle-mv webVueAntYtSpanStyle webVueAntYtSpanBrCount-mv webVueAntYtSpanBrCount'>
                            <span v-html='"车场照片："'>
                            
                        </span>
                        </span>
            </yt-grid-item>
        
            <!-- 车场照片 附件 -->
            <yt-grid-item fixedSize='selfAdaption' top="1.10000%" left="3.90000%" bottom="7.90000%" right="8.00000%" gridColumnStart="18" gridColumnEnd="29" gridRowStart="82" gridRowEnd="98" zIndex="26" previewType="AdaptiveWH">
              <!-- <a-upload action="http://127.0.0.1:9001/api/resource/fileUpload/a09fe71ca88f44a085076b47be78ecfe/0" -->
              <a-upload action="/api/common/uploadFile"
                  :multiple="true"
                  :max-count="10"
                  disabled
                  :file-list="Basicinformationform1.YardPhotosfileList3"
                >
                <a-button>
                  <!-- <upload-outlined></upload-outlined> -->
                  照片
                </a-button>
              </a-upload>
                <!-- <div ref='ref168' class='webVueAntYtPicture webVueAntYtPictureStyle-mvs43ok webVueAntYtPictureStyle-mv webVueAntYtPictureStyle'>
                            <a-image :src='"./staticResource/public/yt-picture.png"' :preview='false' :style='{
        transform:"scaleX(1) scaleY(1)",
        objectFit:"contain"
      }'>
                            
                        </a-image>
                        </div> -->
            </yt-grid-item>
        

            <!-- <yt-grid-item fixedSize='selfAdaption' top="1.10000%" left="3.80000%" bottom="7.90000%" right="8.10000%" gridColumnStart="30" gridColumnEnd="41" gridRowStart="90" gridRowEnd="98" zIndex="27" previewType="AdaptiveWH">
                <div ref='ref169' class='webVueAntYtPicture webVueAntYtPictureStyle-mvvynkh webVueAntYtPictureStyle-mv webVueAntYtPictureStyle'>
                            <a-image :src='"./staticResource/public/yt-picture.png"' :preview='false' :style='{
        transform:"scaleX(1) scaleY(1)",
        objectFit:"contain"
      }'>
                            
                        </a-image>
                        </div>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="1.10000%" left="3.60000%" bottom="7.90000%" right="8.20000%" gridColumnStart="42" gridColumnEnd="53" gridRowStart="90" gridRowEnd="98" zIndex="29" previewType="AdaptiveWH">
                <div ref='ref172' class='webVueAntYtPicture webVueAntYtPictureStyle-mvlelgq webVueAntYtPictureStyle-mv webVueAntYtPictureStyle'>
                            <a-image :src='"./staticResource/public/yt-picture.png"' :preview='false' :style='{
        transform:"scaleX(1) scaleY(1)",
        objectFit:"contain"
      }'>
                            
                        </a-image>
                        </div>
            </yt-grid-item> -->
        

            <yt-grid-item fixedSize='selfAdaption' top="9.00000%" left="1.90000%" bottom="18.10000%" right="1.10000%" gridColumnStart="7" gridColumnEnd="46" gridRowStart="10" gridRowEnd="14" zIndex="33" previewType="AdaptiveWH">
                <a-form-item ref='ref173' class='webVueSelectFormItem webVueAntYtSelectFormItem-mv3zwbf  webVueAntYtSelectFormItem-mv webVueAntYtSelectFormItem show-label-mv show-label' name='yardstatus1value1' :colon='false' :rules='[{"required":true,"message":"必填"}]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"车场状态："'>
                            
                        </span>
                        </div>
                        </template>
<a-select data-event class='webVueSelect  webVueAntYtSelectStyle-mv webVueAntYtSelectStyle' dropdownClassName='"popupKey" "popupKeyId"' :showArrow='true' :disabled='true' v-model:value='Basicinformationform1.yardstatus1value1' :placeholder='"请输入"' :mode='"single"' :options='optionsParkingLotStatus' :showSearch='true'>
<!-- <a-select data-event class='webVueSelect  webVueAntYtSelectStyle-mv webVueAntYtSelectStyle' dropdownClassName='"popupKey" "popupKeyId"' :showArrow='true' :disabled='true' v-model:value='Basicinformationform1.yardstatus1value1' :placeholder='"请输入"' :mode='"single"' :options='[{"label":"使用中","value":"使用中","disabled":false,"select":false},{"label":"试运行","value":"试运行","disabled":false,"select":false},{"value":"建设中","label":"建设中","disabled":false,"select":false},{"value":"已停用","label":"已停用","disabled":false,"select":false}]' :showSearch='true'> -->
                            
                        </a-select>
                        </a-form-item>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="22.70000%" left="2.30000%" bottom="4.50000%" right="1.10000%" gridColumnStart="7" gridColumnEnd="46" gridRowStart="19" gridRowEnd="23" zIndex="34" previewType="AdaptiveWH">
                <a-form-item ref='ref174' class='webVueSelectFormItem webVueAntYtSelectFormItem-mvfrwmp  webVueAntYtSelectFormItem-mv webVueAntYtSelectFormItem show-label-mv show-label' name='Typeofyard1value1' :colon='false' :rules='[{"required":true,"message":"必填"}]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"车场类型："'>
                            
                        </span>
                        </div>
                        </template>
<a-select data-event class='webVueSelect  webVueAntYtSelectStyle-mv webVueAntYtSelectStyle' dropdownClassName='"popupKey" "popupKeyId"' :showArrow='true' :disabled='true' v-model:value='Basicinformationform1.Typeofyard1value1' :placeholder='"请输入"' :mode='"single"' :options='optionsParkingLotType' :showSearch='true'>
<!-- <a-select data-event class='webVueSelect  webVueAntYtSelectStyle-mv webVueAntYtSelectStyle' dropdownClassName='"popupKey" "popupKeyId"' :showArrow='true' :disabled='true' v-model:value='Basicinformationform1.Typeofyard1value1' :placeholder='"请输入"' :mode='"single"' :options='[{"label":"自营","value":"自营","disabled":false,"select":false},{"label":"托管（接入）","value":"托管（接入）","disabled":false,"select":false},{"value":"托管（未接）","label":"托管（未接）","disabled":false,"select":false}]' :showSearch='true'> -->
                            
                        </a-select>
                        </a-form-item>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="4.50000%" left="0.30000%" bottom="22.70000%" right="1.50000%" gridColumnStart="9" gridColumnEnd="46" gridRowStart="15" gridRowEnd="19" zIndex="35" previewType="AdaptiveWH">
                <a-form-item ref='ref2707' class='webVueSelectFormItem webVueAntYtSelectFormItem-mverfpf  webVueAntYtSelectFormItem-mv webVueAntYtSelectFormItem show-label-mv show-label' name='Area1value1' :colon='false' :rules='[]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"所属区域："'>
                            
                        </span>
                        </div>
                        </template>
                        <!-- <a-cascader data-event class='webVueAntYtCascader webVueAntYtCascaderStyle-mvbipu6 webVueAntYtCascaderStyle-mv webVueAntYtCascaderStyle' dropdownClassName='"popupKey" "popupKeyId"' change-on-select :disabled='true' :showArrow='true' :placeholder='"请输入"' :multiple='true' :options='[{"value":"李沧区","label":"李沧区","disabled":false,"select":false,"children":[{"value":"XX街道","label":"XX街道","disabled":false,"select":false,"children":[{"value":"中心","label":"中心","disabled":false,"select":false}]}]}]' v-model:value='Basicinformationform1.Area1value1' :showSearch='true' :showCheckedStrategy='"SHOW_CHILD"'> -->
                        <a-cascader data-event class='webVueAntYtCascader webVueAntYtCascaderStyle-mvbipu6 webVueAntYtCascaderStyle-mv webVueAntYtCascaderStyle' dropdownClassName='"popupKey" "popupKeyId"' change-on-select :disabled='true' :showArrow='true' :placeholder='"请输入"' :multiple='false' :options='optionsArea' v-model:value='Basicinformationform1.Area1value1' :showSearch='true' :showCheckedStrategy='"SHOW_CHILD"'>
                            
                          </a-cascader>
<!-- <a-select data-event class='webVueSelect  webVueAntYtSelectStyle-mv webVueAntYtSelectStyle' dropdownClassName='"popupKey" "popupKeyId"' :showArrow='true' :disabled='true' v-model:value='Basicinformationform1.Area1value1' :placeholder='"请输入"' :mode='"single"' :options='[{"label":"选项1","value":"选项1","disabled":false,"select":false},{"label":"选项2","value":"选项2","disabled":false,"select":false}]' :showSearch='true'>
                            
                        </a-select> -->
                        </a-form-item>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="22.70000%" left="2.50000%" bottom="4.50000%" right="1.80000%" gridColumnStart="59" gridColumnEnd="97" gridRowStart="19" gridRowEnd="23" zIndex="28" previewType="AdaptiveWH">
                <a-form-item ref='ref2708' class='webVueSelectFormItem webVueAntYtSelectFormItem-mvp8rja  webVueAntYtSelectFormItem-mv webVueAntYtSelectFormItem show-label-mv show-label' name='YardCategory1value1' :colon='false' :rules='[]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"车场类别："'>
                            
                        </span>
                        </div>
                        </template>
<a-select data-event class='webVueSelect  webVueAntYtSelectStyle-mv webVueAntYtSelectStyle' dropdownClassName='"popupKey" "popupKeyId"' :showArrow='true' :disabled='true' v-model:value='Basicinformationform1.YardCategory1value1' :placeholder='"请输入"' :mode='"single"' :options='optionsParkingLotCategory' :showSearch='true'>
<!-- <a-select data-event class='webVueSelect  webVueAntYtSelectStyle-mv webVueAntYtSelectStyle' dropdownClassName='"popupKey" "popupKeyId"' :showArrow='true' :disabled='true' v-model:value='Basicinformationform1.YardCategory1value1' :placeholder='"请输入"' :mode='"single"' :options='[{"label":"商场","value":"商场","disabled":false,"select":false},{"label":"停车楼","value":"停车楼","disabled":false,"select":false},{"value":"交通枢纽","label":"交通枢纽","disabled":false,"select":false},{"value":"医院","label":"医院","disabled":false,"select":false},{"value":"住宅社区","label":"住宅社区","disabled":false,"select":false},{"value":"商业园区","label":"商业园区","disabled":false,"select":false},{"value":"写字楼","label":"写字楼","disabled":false,"select":false},{"value":"银行","label":"银行","disabled":false,"select":false},{"value":"政府","label":"政府","disabled":false,"select":false},{"value":"校区","label":"校区","disabled":false,"select":false}]' :showSearch='true'> -->
                            
                        </a-select>
                        </a-form-item>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="4.50000%" left="2.50000%" bottom="22.70000%" right="1.80000%" gridColumnStart="59" gridColumnEnd="97" gridRowStart="15" gridRowEnd="19" zIndex="30" previewType="AdaptiveWH">
                <a-form-item ref='ref2709' class='webVueSelectFormItem webVueAntYtSelectFormItem-mvvbi94  webVueAntYtSelectFormItem-mv webVueAntYtSelectFormItem show-label-mv show-label' name='Plate1value1' :colon='false' :rules='[]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"所属板块："'>
                            
                        </span>
                        </div>
                        </template>
<a-select data-event class='webVueSelect  webVueAntYtSelectStyle-mv webVueAntYtSelectStyle' dropdownClassName='"popupKey" "popupKeyId"' :showArrow='true' :disabled='true' v-model:value='Basicinformationform1.Plate1value1' :placeholder='"请输入"' :mode='"single"' :options='optionsPlate' :showSearch='true'>
<!-- <a-select data-event class='webVueSelect  webVueAntYtSelectStyle-mv webVueAntYtSelectStyle' dropdownClassName='"popupKey" "popupKeyId"' :showArrow='true' :disabled='true' v-model:value='Basicinformationform1.Plate1value1' :placeholder='"请输入"' :mode='"single"' :options='[{"label":"板块1","value":"板块1","disabled":false,"select":false},{"label":"板块2","value":"板块2","disabled":false,"select":false}]' :showSearch='true'> -->
                            
                        </a-select>
                        </a-form-item>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="11.30000%" left="2.60000%" bottom="15.90000%" right="1.80000%" gridColumnStart="8" gridColumnEnd="46" gridRowStart="32" gridRowEnd="36" zIndex="31" previewType="AdaptiveWH">
                <a-form-item ref='ref9372' class='webVueSelectFormItem webVueAntYtSelectFormItem-mv8buay  webVueAntYtSelectFormItem-mv webVueAntYtSelectFormItem show-label-mv show-label' name='Chargingservicevalue1' :colon='false' :rules='[]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"充电服务："'>
                            
                        </span>
                        </div>
                        </template>
<a-select data-event class='webVueSelect  webVueAntYtSelectStyle-mv webVueAntYtSelectStyle' dropdownClassName='"popupKey" "popupKeyId"' :showArrow='true' :disabled='true' v-model:value='Basicinformationform1.Chargingservicevalue1' :placeholder='"请输入"' :mode='"single"' :options='[{"label":"是","value":"是","disabled":false,"select":false},{"label":"否","value":"否","disabled":false,"select":false}]' :showSearch='true'>
                            
                        </a-select>
                        </a-form-item>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="9.00000%" left="0.80000%" bottom="18.10000%" right="0.90000%" gridColumnStart="60" gridColumnEnd="97" gridRowStart="45" gridRowEnd="49" zIndex="32" previewType="AdaptiveWH">
                <a-form-item ref='ref9373' class='webVueSelectFormItem webVueAntYtSelectFormItem-mv0qxhj  webVueAntYtSelectFormItem-mv webVueAntYtSelectFormItem show-label-mv show-label' name='AdditionalServicesvalue1' :colon='false' :rules='[]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"附加服务："'>
                            
                        </span>
                        </div>
                        </template>
<a-select data-event class='webVueSelect  webVueAntYtSelectStyle-mv webVueAntYtSelectStyle' dropdownClassName='"popupKey" "popupKeyId"' :showArrow='true' :disabled='true' v-model:value='Basicinformationform1.AdditionalServicesvalue1' :placeholder='"请输入"' :mode='"single"' :options='optionsService' :showSearch='true'>
                            
                        </a-select>
                        </a-form-item>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="3.00000%" left="0.70000%" bottom="30.30000%" right="0.40000%" gridColumnStart="4" gridColumnEnd="41" gridRowStart="76" gridRowEnd="79" zIndex="36" previewType="AdaptiveWH">
                <a-form-item ref='ref2754' class='webVueAntRadioFormItem webVueAntYtRadioFormItem-mvceqc5  webVueAntYtRadioFormItem-mv webVueAntYtRadioFormItem show-label-mv show-label' name='Whetherthelargescreenisvisiblevalue1' :colon='false' :rules='[{"required":true,"message":"必填"}]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"大屏是否可见："'>
                            
                        </span>
                        </div>
                        </template>
<a-radio-group data-event class='webVueAntRadio webVueAntYtRadioStyle-mv6ea0m webVueAntYtRadioStyle-mv webVueAntYtRadioStyle' v-model:value='Basicinformationform1.Whetherthelargescreenisvisiblevalue1' :disabled='true' :options='[{"label":"是","value":"是","disabled":false,"select":true},{"label":"否","value":"否","disabled":false,"select":false}]'>
                            
                        </a-radio-group>
                        </a-form-item>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='width' comWidth='72.00px' top="9.00000%" left="2.20000%" bottom="27.20000%" right="0.90000%" gridColumnStart="60" gridColumnEnd="69" gridRowStart="76" gridRowEnd="79" zIndex="37" previewType="AdaptiveWH">
                <span ref='ref3607' class='webVueAntYtSpan webVueAntYtSpanStyle-mvcvfmk  webVueAntYtSpanStyle-mv webVueAntYtSpanStyle webVueAntYtSpanBrCount-mv webVueAntYtSpanBrCount'>
                            <span v-html='"车场图标："'>
                            
                        </span>
                        </span>
            </yt-grid-item>
        
            <!-- 车场图标 附件 -->
            <yt-grid-item fixedSize='selfAdaption' top="3.40000%" left="0.00000%" bottom="5.60000%" right="3.00000%" gridColumnStart="70" gridColumnEnd="80" gridRowStart="76" gridRowEnd="76" zIndex="38" previewType="AdaptiveWH">
               <a-upload action="/api/common/uploadFile"
                  :multiple="false"
                  :max-count="1"
                  :disabled="true"
                  :file-list="Basicinformationform1.YardIconfileList3"
                >
                <a-button>
                  <!-- <upload-outlined></upload-outlined> -->
                  图标
                </a-button>
              </a-upload>
                <!-- <div ref='ref3608' class='webVueAntYtPicture webVueAntYtPictureStyle-mv1vbg6 webVueAntYtPictureStyle-mv webVueAntYtPictureStyle'>
                            <a-image :src='"./staticResource/public/yt-picture.png"' :preview='false' :style='{
        transform:"scaleX(1) scaleY(1)",
        objectFit:"contain"
      }'>
                            
                        </a-image>
                        </div> -->
            </yt-grid-item>
        
            </yt-grid>
            
                        </a-form>
            </yt-grid-item>
        
            <!-- 平台信息 -->
            <yt-grid-item fixedSize='selfAdaption' :isShow='DepotDetailsDynamicPanelselectKey1 == "2"' top="0.00000%" left="0.00000%" bottom="0.00000%" right="0.00000%" gridColumnStart="1" gridColumnEnd="101" gridRowStart="1" gridRowEnd="101" zIndex="1" previewType="AdaptiveWH">
                <a-form ref='ref180' :model='PlatformInformationform1' :class='["webVueAntForm","webVueAntYtFormStyle-mv","webVueAntYtFormStyle"]'>
                            
            <yt-grid  previewType="AdaptiveWH" width="100%" height="100%">
                
            <yt-grid-item fixedSize='selfAdaption' top="27.00000%" left="45.20000%" bottom="7.20000%" right="36.50000%" gridColumnStart="3" gridColumnEnd="5" gridRowStart="3" gridRowEnd="6" zIndex="1" previewType="AdaptiveWH">
                <div ref='ref189' class='webVueAntYtRectangle webVueAntYtRectangleStyle-mvkgk4l webVueAntYtRectangleStyle-mv webVueAntYtRectangleStyle'>
                            
                        </div>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='width' comWidth='57.00px' top="13.20000%" left="10.50000%" bottom="16.30000%" right="3.20000%" gridColumnStart="5" gridColumnEnd="13" gridRowStart="3" gridRowEnd="7" zIndex="2" previewType="AdaptiveWH">
                <span ref='ref190' class='webVueAntYtSpan webVueAntYtSpanStyle-mvvorrz  webVueAntYtSpanStyle-mv webVueAntYtSpanStyle webVueAntYtSpanBrCount-mv webVueAntYtSpanBrCount'>
                            <span v-html='"运营平台"'>
                            
                        </span>
                        </span>
            </yt-grid-item>
        

            <!-- <yt-grid-item fixedSize='selfAdaption' top="16.20000%" left="45.20000%" bottom="18.10000%" right="36.50000%" gridColumnStart="3" gridColumnEnd="5" gridRowStart="15" gridRowEnd="18" zIndex="3" previewType="AdaptiveWH">
                <div ref='ref191' class='webVueAntYtRectangle webVueAntYtRectangleStyle-mvrqe5p webVueAntYtRectangleStyle-mv webVueAntYtRectangleStyle'>
                            
                        </div>
            </yt-grid-item> -->
        

            <!-- <yt-grid-item fixedSize='width' comWidth='57.00px' top="12.10000%" left="10.50000%" bottom="17.50000%" right="3.20000%" gridColumnStart="5" gridColumnEnd="13" gridRowStart="15" gridRowEnd="19" zIndex="4" previewType="AdaptiveWH">
                <span ref='ref192' class='webVueAntYtSpan webVueAntYtSpanStyle-mvykzy0  webVueAntYtSpanStyle-mv webVueAntYtSpanStyle webVueAntYtSpanBrCount-mv webVueAntYtSpanBrCount'>
                            <span v-html='"支付平台"'>
                            
                        </span>
                        </span>
            </yt-grid-item> -->
        

            <yt-grid-item fixedSize='selfAdaption' top="9.00000%" left="1.60000%" bottom="0.90000%" right="0.50000%" gridColumnStart="9" gridColumnEnd="46" gridRowStart="8" gridRowEnd="13" zIndex="7" previewType="AdaptiveWH">
                <a-form-item ref='ref214' class='webVueSelectFormItem webVueAntYtSelectFormItem-mvdnk3l  webVueAntYtSelectFormItem-mv webVueAntYtSelectFormItem show-label-mv show-label' name='Operationmodevalue1' :colon='false' :rules='[]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"运营模式："'>
                            
                        </span>
                        </div>
                        </template>
<a-select data-event class='webVueSelect  webVueAntYtSelectStyle-mv webVueAntYtSelectStyle' dropdownClassName='"popupKey" "popupKeyId"' :showArrow='true' v-model:value='PlatformInformationform1.Operationmodevalue1' :disabled='true' :placeholder='"请输入"' :mode='"single"' :options='optionsOperationMode' :showSearch='true'>
                            
                        </a-select>
                        </a-form-item>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="9.00000%" left="1.50000%" bottom="0.90000%" right="2.20000%" gridColumnStart="59" gridColumnEnd="98" gridRowStart="8" gridRowEnd="13" zIndex="5" previewType="AdaptiveWH">
                <a-form-item ref='ref216' class='webVueSelectFormItem webVueAntYtSelectFormItem-mv9adbi  webVueAntYtSelectFormItem-mv webVueAntYtSelectFormItem show-label-mv show-label' name='OperatingCompanyvalue2' :colon='false' :rules='[{"required":true,"message":"必填"}]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"运营公司："'>
                            
                        </span>
                        </div>
                        </template>
<a-select data-event class='webVueSelect  webVueAntYtSelectStyle-mv webVueAntYtSelectStyle' dropdownClassName='"popupKey" "popupKeyId"' :showArrow='true' :disabled='true' v-model:value='PlatformInformationform1.OperatingCompanyvalue2' :placeholder='"请输入"' :mode='"single"' :options='optionsOperationCompany' :showSearch='true'>
                            
                        </a-select>
                        </a-form-item>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="16.10000%" left="1.20000%" bottom="8.70000%" right="0.50000%" gridColumnStart="9" gridColumnEnd="46" gridRowStart="20" gridRowEnd="26" zIndex="6" previewType="AdaptiveWH">
                <a-form-item ref='ref218' class='webVueSelectFormItem webVueAntYtSelectFormItem-mvmqd1q  webVueAntYtSelectFormItem-mv webVueAntYtSelectFormItem show-label-mv show-label' name='conservator' :colon='false' :rules='[]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"车场管理员："'>
                            
                        </span>
                        </div>
                        </template>
<a-select data-event class='webVueSelect  webVueAntYtSelectStyle-mv webVueAntYtSelectStyle' dropdownClassName='"popupKey" "popupKeyId"' :showArrow='true' :disabled='true' v-model:value='PlatformInformationform1.conservator' :placeholder='"请输入"' :mode='"single"' :options='optionsConservator' :showSearch='true'>
                            
                        </a-select>
                        </a-form-item>
            </yt-grid-item>

            <!-- <yt-grid-item fixedSize='selfAdaption' top="16.10000%" left="1.20000%" bottom="8.70000%" right="0.50000%" gridColumnStart="9" gridColumnEnd="46" gridRowStart="20" gridRowEnd="26" zIndex="6" previewType="AdaptiveWH">
                <a-form-item ref='ref218' class='webVueSelectFormItem webVueAntYtSelectFormItem-mvmqd1q  webVueAntYtSelectFormItem-mv webVueAntYtSelectFormItem show-label-mv show-label' name='dockingplatformvalue1' :colon='false' :rules='[]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"对接平台："'>
                            
                        </span>
                        </div>
                        </template>
<a-select data-event class='webVueSelect  webVueAntYtSelectStyle-mv webVueAntYtSelectStyle' dropdownClassName='"popupKey" "popupKeyId"' :showArrow='true' :disabled='true' v-model:value='PlatformInformationform1.dockingplatformvalue1' :placeholder='"请输入"' :mode='"single"' :options='optionsPlatform' :showSearch='true'>
                            
                        </a-select>
                        </a-form-item>
            </yt-grid-item> -->
        
            </yt-grid>
            
                        </a-form>
            </yt-grid-item>
        
            <!-- 运营规则 详情弹窗 -->
            <yt-grid-item fixedSize='selfAdaption' :isShow='DepotDetailsDynamicPanelselectKey1 == "3"' top="0.00000%" left="0.00000%" bottom="0.00000%" right="0.00000%" gridColumnStart="1" gridColumnEnd="101" gridRowStart="1" gridRowEnd="101" zIndex="2" previewType="AdaptiveWH">
              <!-- 运营规则 详情弹窗 form 新 -->
              <a-form :class='["webVueAntForm","webVueAntYtFormStyle-mv","webVueAntYtFormStyle","webVueAntForm-yy","webVueAntForm-un"]' v-bind="formItemLayout" ref='ref254' :model='OperatingRulesform1'>
                <!-- 预付款管理 -->
                <div>
                  <span class="spanLable">预付款管理</span>
                  <a-row style="margin: 0;" :gutter="24">
                    <a-col style="padding-right: 48px;" :span="12">
                      <a-form-item name="PrepaidTimeoutDurationvalue1" label="预付超时时长：">
                        <a-input class='webVueAntYtInputStyle-mv2mqra' data-event v-model:value='OperatingRulesform1.PrepaidTimeoutDurationvalue1' :maxLength='100' :placeholder='"请输入"' :disabled='true'>
                        </a-input>
                      </a-form-item>
                    </a-col>
                    <a-col style="padding-right: 48px;" :span="12">
                      <a-form-item name="Timeoutdoesnotleaveprocessingvalue1" label="超时未离开处理：">
                      <a-select class='webVueAntYtSelectStyle-mv' data-event  dropdownClassName='"popupKey" "popupKeyId"' :showArrow='true' v-model:value='OperatingRulesform1.Timeoutdoesnotleaveprocessingvalue1' :placeholder='"请输入"' :disabled='true' :mode='"single"' :options='[{"label":"重新计费","value":"重新计费","disabled":false,"select":false},{"label":"暂不处理","value":"暂不处理","disabled":false,"select":false}]' :showSearch='true'>
                      </a-select>
                      </a-form-item>
                    </a-col>
                  </a-row>
                  <a-row style="margin: 0;" :gutter="24">
                    <a-col style="padding-right: 48px;" :span="12">
                      <a-form-item name="Notifyvalue1" label="是否通知：">
                        <a-radio-group data-event class='webVueAntRadio webVueAntYtRadioStyle-mvkckqe webVueAntYtRadioStyle-mv webVueAntYtRadioStyle' v-model:value='OperatingRulesform1.Notifyvalue1' :disabled='true' :options='[{"label":"是","value":"是","disabled":false,"select":false},{"label":"否","value":"否","disabled":false,"select":true}]'>
                        </a-radio-group>
                      </a-form-item>
                    </a-col>
                  </a-row>
                </div>
                <!-- 黑/白名单 -->
                <div>
                  <span class="spanLable">黑/白名单</span>
                  <a-row style="margin: 0;" :gutter="24">
                    <a-col style="padding-right: 48px;" :span="12">
                      <a-form-item name="blacklistvalue1" label="黑名单：">
                        <a-radio-group data-event class='webVueAntRadio webVueAntYtRadioStyle-mv2gl3k webVueAntYtRadioStyle-mv webVueAntYtRadioStyle' v-model:value='OperatingRulesform1.blacklistvalue1' :disabled='true' :options='[{"label":"开启","value":"开启","disabled":false,"select":true},{"label":"关闭","value":"关闭","disabled":false,"select":false}]'>
                        </a-radio-group>
                      </a-form-item>
                    </a-col>
                    <a-col style="padding-right: 48px;" :span="12">
                      <a-form-item name="WhiteListvalue1" label="白名单：">
                        <a-radio-group data-event class='webVueAntRadio webVueAntYtRadioStyle-mv50v5f webVueAntYtRadioStyle-mv webVueAntYtRadioStyle' v-model:value='OperatingRulesform1.WhiteListvalue1' :disabled='true' :options='[{"label":"开启","value":"开启","disabled":false,"select":true},{"label":"关闭","value":"关闭","disabled":false,"select":false}]'>
                        </a-radio-group>
                      </a-form-item>
                    </a-col>
                  </a-row>
                </div>
                <!-- 车位预约 -->
                <div>
                  <span class="spanLable">车位预约</span>
                  <a-row style="margin: 0;" :gutter="24">
                    <a-col style="padding-right: 48px;" :span="12">
                      <a-form-item name="Reservedcarnumbervalue1" label="预约车位数：">
                        <a-input-number class='webVueAntYtInputStyle-mv2mqra' data-event v-model:value='OperatingRulesform1.Reservedcarnumbervalue1' :placeholder='"请输入"' :disabled='true'>
                        </a-input-number>
                      </a-form-item>
                    </a-col>
                    <a-col style="padding-right: 48px;" :span="12">
                      <a-form-item name="Appointmenttimeoutdurationvalue1" label="预约超时时长：">
                        <a-input data-event v-model:value='OperatingRulesform1.Appointmenttimeoutdurationvalue1' :maxLength='100' :placeholder='"请输入"' :disabled='true'>
                        </a-input>
                      </a-form-item>
                    </a-col>
                  </a-row>
                  <a-row style="margin: 0;" :gutter="24">
                    <a-col style="padding-right: 48px;" :span="12">
                      <a-form-item name="Notifyvalue3" label="是否通知：">
                        <a-radio-group data-event class='webVueAntRadio webVueAntYtRadioStyle-mvnel6z webVueAntYtRadioStyle-mv webVueAntYtRadioStyle' v-model:value='OperatingRulesform1.Notifyvalue3' :disabled='true' :options='[{"label":"是","value":"是","disabled":false,"select":false},{"label":"否","value":"否","disabled":false,"select":true}]'>
                        </a-radio-group>
                      </a-form-item>
                    </a-col>
                  </a-row>
                </div>
                <!-- 扫码配置 -->
                <div>
                  <span class="spanLable">扫码配置</span>
                  <a-row style="margin: 0;" :gutter="24">
                    <a-col style="padding-right: 48px;" :span="12">
                      <a-form-item name="AppearanceSweepCodevalue1" label="出场扫码：">
                        <a-radio-group data-event class='webVueAntRadio webVueAntYtRadioStyle-mv0osuw webVueAntYtRadioStyle-mv webVueAntYtRadioStyle' v-model:value='OperatingRulesform1.AppearanceSweepCodevalue1' :disabled='true' :options='[{"label":"开启","value":"开启","disabled":false,"select":false},{"label":"关闭","value":"关闭","disabled":false,"select":true}]'>
                        </a-radio-group>
                      </a-form-item>
                    </a-col>
                  </a-row>
                </div>
                <!-- 异常车辆处理 -->
                <div>
                  <span class="spanLable">异常车辆处理</span>
                  <div v-for="(item, index) in OperatingRulesform1['abnormalHandle']" :key="item.id">
                    <a-row style="margin: 0;" :gutter="24">
                      <a-col style="padding-right: 48px;" :span="12">
                        <a-form-item :name="['abnormalHandle', index, 'status']" label="异常状态：">
                          <a-select class='webVueAntYtSelectStyle-mv' data-event dropdownClassName='"popupKey" "popupKeyId"' :showArrow='true' v-model:value="item['status']" :placeholder='"请输入"' :disabled='true' :mode='"single"' :options='[{"label":"重复入场","value":"重复入场","disabled":false,"select":false},{"label":"无驶入车","value":"无驶入车","disabled":false,"select":false},{"value":"强制抬杆","label":"强制抬杆","disabled":false,"select":false},{"value":"其他","label":"其他","disabled":false,"select":false}]' :showSearch='true'>
                          </a-select>
                        </a-form-item>
                      </a-col>
                      <a-col style="padding-right: 48px;position: relative;" :span="12">
                        <a-form-item :name="['abnormalHandle', index, 'handle']" label="异常处理：">
                          <a-select class='webVueAntYtSelectStyle-mv' data-event dropdownClassName='"popupKey" "popupKeyId"' :showArrow='true' v-model:value="item['handle']" :placeholder='"请输入"' :disabled='true' :mode='"single"' :options='[{"label":"禁止通行","value":"禁止通行","disabled":false,"select":false},{"label":"车辆放行","value":"车辆放行","disabled":false,"select":false},{"value":"放行拉黑","label":"放行拉黑","disabled":false,"select":false},{"value":"其他","label":"其他","disabled":false,"select":false}]' :showSearch='true'>
                          </a-select>
                        </a-form-item>
                      </a-col>
                    </a-row>
                    <a-row style="margin: 0;" :gutter="24">
                      <a-col style="padding-right: 48px;" :span="12">
                        <a-form-item :name="['abnormalHandle', index, 'notify']" label="是否通知：">
                          <a-radio-group data-event class='webVueAntRadio webVueAntYtRadioStyle-mvgyhu1 webVueAntYtRadioStyle-mv webVueAntYtRadioStyle' v-model:value="item['notify']" :disabled='true' :options='[{"label":"是","value":"是","disabled":false,"select":false},{"label":"否","value":"否","disabled":false,"select":true}]'>
                          </a-radio-group>
                        </a-form-item>
                      </a-col>
                      <a-col v-if="item['handle'] === '放行拉黑'" style="padding-right: 48px;" :span="12">
                        <a-form-item :name="['abnormalHandle', index, 'time']" label="拉黑时长：">
                          <a-input-number class='webVueAntYtInputStyle-mv2mqra' data-event v-model:value="item['time']" :placeholder='"请输入"' :disabled='true' addon-after="天">
                          </a-input-number>
                        </a-form-item>
                      </a-col>
                    </a-row>
                  </div>
                </div>
              </a-form>

                <!-- 运营规则 详情弹窗 form 旧 -->
                <!-- <a-form ref='ref254' :model='OperatingRulesform1' :class='["webVueAntForm","webVueAntYtFormStyle-mv","webVueAntYtFormStyle"]'>
                            
            <yt-grid  previewType="AdaptiveWH" width="100%" height="100%">
                
            <yt-grid-item fixedSize='selfAdaption' top="6.20000%" left="2.00000%" bottom="3.70000%" right="1.30000%" gridColumnStart="5" gridColumnEnd="46" gridRowStart="8" gridRowEnd="13" zIndex="1" previewType="AdaptiveWH">
                <a-form-item ref='ref255' class='webVueAntInputFormItem webVueAntYtInputFormItem-mvn7ype  webVueAntYtInputFormItem-mv webVueAntYtInputFormItem show-label-mv show-label' name='PrepaidTimeoutDurationvalue1' :colon='false' :rules='[]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"预付超时时长："'>
                            
                        </span>
                        </div>
                        </template>
<a-input data-event class='webVueAntinput webVueAntYtInputStyle-mvqg28l webVueAntYtInputStyle-mv webVueAntYtInputStyle' v-model:value='OperatingRulesform1.PrepaidTimeoutDurationvalue1' :disabled='true' :maxLength='100' :placeholder='"请输入"'>
                            
                        </a-input>
                        </a-form-item>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="27.00000%" left="45.20000%" bottom="7.20000%" right="36.50000%" gridColumnStart="3" gridColumnEnd="5" gridRowStart="3" gridRowEnd="6" zIndex="2" previewType="AdaptiveWH">
                <div ref='ref263' class='webVueAntYtRectangle webVueAntYtRectangleStyle-mv3pbka webVueAntYtRectangleStyle-mv webVueAntYtRectangleStyle'>
                            
                        </div>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='width' comWidth='71.00px' top="13.20000%" left="8.40000%" bottom="16.30000%" right="5.60000%" gridColumnStart="5" gridColumnEnd="15" gridRowStart="3" gridRowEnd="7" zIndex="3" previewType="AdaptiveWH">
                <span ref='ref264' class='webVueAntYtSpan webVueAntYtSpanStyle-mvjkax4  webVueAntYtSpanStyle-mv webVueAntYtSpanStyle webVueAntYtSpanBrCount-mv webVueAntYtSpanBrCount'>
                            <span v-html='"预付款管理"'>
                            
                        </span>
                        </span>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="31.30000%" left="39.20000%" bottom="3.00000%" right="42.60000%" gridColumnStart="3" gridColumnEnd="5" gridRowStart="22" gridRowEnd="25" zIndex="4" previewType="AdaptiveWH">
                <div ref='ref265' class='webVueAntYtRectangle webVueAntYtRectangleStyle-mvehdkp webVueAntYtRectangleStyle-mv webVueAntYtRectangleStyle'>
                            
                        </div>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='width' comWidth='85.00px' top="12.90000%" left="6.00000%" bottom="16.70000%" right="8.20000%" gridColumnStart="5" gridColumnEnd="17" gridRowStart="22" gridRowEnd="26" zIndex="5" previewType="AdaptiveWH">
                <span ref='ref266' class='webVueAntYtSpan webVueAntYtSpanStyle-mvgkra0  webVueAntYtSpanStyle-mv webVueAntYtSpanStyle webVueAntYtSpanBrCount-mv webVueAntYtSpanBrCount'>
                            <span v-html='"异常车辆处理"'>
                            
                        </span>
                        </span>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="6.20000%" left="0.70000%" bottom="3.70000%" right="0.60000%" gridColumnStart="52" gridColumnEnd="94" gridRowStart="8" gridRowEnd="13" zIndex="7" previewType="AdaptiveWH">
                <a-form-item ref='ref2187' class='webVueSelectFormItem webVueAntYtSelectFormItem-mv1nhn6  webVueAntYtSelectFormItem-mv webVueAntYtSelectFormItem show-label-mv show-label' name='Timeoutdoesnotleaveprocessingvalue1' :colon='false' :rules='[]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"超时未离开处理："'>
                            
                        </span>
                        </div>
                        </template>
<a-select data-event class='webVueSelect  webVueAntYtSelectStyle-mv webVueAntYtSelectStyle' dropdownClassName='"popupKey" "popupKeyId"' :showArrow='true' :disabled='true' v-model:value='OperatingRulesform1.Timeoutdoesnotleaveprocessingvalue1' :placeholder='"请输入"' :mode='"single"' :options='[{"label":"选项1","value":"选项1","disabled":false,"select":false},{"label":"选项2","value":"选项2","disabled":false,"select":false}]' :showSearch='true'>
                            
                        </a-select>
                        </a-form-item>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="9.40000%" left="0.60000%" bottom="15.50000%" right="1.20000%" gridColumnStart="9" gridColumnEnd="46" gridRowStart="28" gridRowEnd="34" zIndex="6" previewType="AdaptiveWH">
                <a-form-item ref='ref2192' class='webVueSelectFormItem webVueAntYtSelectFormItem-mv8t8m6  webVueAntYtSelectFormItem-mv webVueAntYtSelectFormItem show-label-mv show-label' name='Abnormalstatevalue1' :colon='false' :rules='[]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"异常状态："'>
                            
                        </span>
                        </div>
                        </template>
<a-select data-event class='webVueSelect  webVueAntYtSelectStyle-mv webVueAntYtSelectStyle' dropdownClassName='"popupKey" "popupKeyId"' :showArrow='true' :disabled='true' v-model:value='OperatingRulesform1.Abnormalstatevalue1' :placeholder='"请输入"' :mode='"single"' :options='[{"label":"重复入场","value":"重复入场","disabled":false,"select":false},{"label":"无驶入放行","value":"无驶入放行","disabled":false,"select":false},{"value":"手动抬杠出场","label":"手动抬杠出场","disabled":false,"select":false},{"value":"强制抬杆","label":"强制抬杆","disabled":false,"select":false}]' :showSearch='true'>
                            
                        </a-select>
                        </a-form-item>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="9.40000%" left="1.10000%" bottom="15.50000%" right="0.70000%" gridColumnStart="57" gridColumnEnd="94" gridRowStart="28" gridRowEnd="34" zIndex="8" previewType="AdaptiveWH">
                <a-form-item ref='ref2233' class='webVueSelectFormItem webVueAntYtSelectFormItem-mvxm3kt  webVueAntYtSelectFormItem-mv webVueAntYtSelectFormItem show-label-mv show-label' name='ExceptionHandlingvalue1' :colon='false' :rules='[]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"异常处理："'>
                            
                        </span>
                        </div>
                        </template>
<a-select data-event class='webVueSelect  webVueAntYtSelectStyle-mv webVueAntYtSelectStyle' dropdownClassName='"popupKey" "popupKeyId"' :showArrow='true' :disabled='true' v-model:value='OperatingRulesform1.ExceptionHandlingvalue1' :placeholder='"请输入"' :mode='"single"' :options='[{"label":"重复入场","value":"重复入场","disabled":false,"select":false},{"label":"无驶入放行","value":"无驶入放行","disabled":false,"select":false},{"value":"手动抬杠出场","label":"手动抬杠出场","disabled":false,"select":false},{"value":"强制抬杆","label":"强制抬杆","disabled":false,"select":false}]' :showSearch='true'>
                            
                        </a-select>
                        </a-form-item>
            </yt-grid-item>
        
            <yt-grid-item fixedSize='selfAdaption' top="18.10000%" left="0.80000%" bottom="19.90000%" right="2.30000%" gridColumnStart="9" gridColumnEnd="38" gridRowStart="15" gridRowEnd="20" zIndex="10" previewType="AdaptiveWH">
                <a-form-item ref='ref2235' class='webVueAntRadioFormItem webVueAntYtRadioFormItem-mvjnpt1  webVueAntYtRadioFormItem-mv webVueAntYtRadioFormItem show-label-mv show-label' name='Notifyvalue1' :colon='false' :rules='[]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"是否通知："'>
                            
                        </span>
                        </div>
                        </template>
<a-radio-group data-event class='webVueAntRadio webVueAntYtRadioStyle-mvictr6 webVueAntYtRadioStyle-mv webVueAntYtRadioStyle' v-model:value='OperatingRulesform1.Notifyvalue1' :disabled='true' :options='[{"label":"是","value":"是","disabled":false,"select":false},{"label":"否","value":"否","disabled":false,"select":true}]'>
                            
                        </a-radio-group>
                        </a-form-item>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="18.40000%" left="0.80000%" bottom="4.10000%" right="2.30000%" gridColumnStart="9" gridColumnEnd="38" gridRowStart="35" gridRowEnd="39" zIndex="11" previewType="AdaptiveWH">
                <a-form-item ref='ref2236' class='webVueAntRadioFormItem webVueAntYtRadioFormItem-mvaytlt  webVueAntYtRadioFormItem-mv webVueAntYtRadioFormItem show-label-mv show-label' name='Notifyvalue2' :colon='false' :rules='[]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"是否通知："'>
                            
                        </span>
                        </div>
                        </template>
<a-radio-group data-event class='webVueAntRadio webVueAntYtRadioStyle-mvq9qs5 webVueAntYtRadioStyle-mv webVueAntYtRadioStyle' v-model:value='OperatingRulesform1.Notifyvalue2' :disabled='true' :options='[{"label":"是","value":"是","disabled":false,"select":false},{"label":"否","value":"否","disabled":false,"select":true}]'>
                            
                        </a-radio-group>
                        </a-form-item>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="25.70000%" left="45.20000%" bottom="8.60000%" right="36.50000%" gridColumnStart="3" gridColumnEnd="5" gridRowStart="42" gridRowEnd="45" zIndex="12" previewType="AdaptiveWH">
                <div ref='ref2319' class='webVueAntYtRectangle webVueAntYtRectangleStyle-mvj4cqv webVueAntYtRectangleStyle-mv webVueAntYtRectangleStyle'>
                            
                        </div>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='width' comWidth='64.00px' top="8.70000%" left="9.30000%" bottom="20.90000%" right="4.50000%" gridColumnStart="5" gridColumnEnd="14" gridRowStart="42" gridRowEnd="46" zIndex="13" previewType="AdaptiveWH">
                <span ref='ref2320' class='webVueAntYtSpan webVueAntYtSpanStyle-mvi8o7j  webVueAntYtSpanStyle-mv webVueAntYtSpanStyle webVueAntYtSpanBrCount-mv webVueAntYtSpanBrCount'>
                            <span v-html='"黑/白名单"'>
                            
                        </span>
                        </span>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="13.40000%" left="0.80000%" bottom="9.10000%" right="0.90000%" gridColumnStart="9" gridColumnEnd="36" gridRowStart="48" gridRowEnd="52" zIndex="15" previewType="AdaptiveWH">
                <a-form-item ref='ref2322' class='webVueAntRadioFormItem webVueAntYtRadioFormItem-mvogf4h  webVueAntYtRadioFormItem-mv webVueAntYtRadioFormItem show-label-mv show-label' name='blacklistvalue1' :colon='false' :rules='[]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"黑名单："'>
                            
                        </span>
                        </div>
                        </template>
<a-radio-group data-event class='webVueAntRadio webVueAntYtRadioStyle-mvwuy6q webVueAntYtRadioStyle-mv webVueAntYtRadioStyle' v-model:value='OperatingRulesform1.blacklistvalue1' :disabled='true' :options='[{"label":"开启","value":"开启","disabled":false,"select":true},{"label":"关闭","value":"关闭","disabled":false,"select":false}]'>
                            
                        </a-radio-group>
                        </a-form-item>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="13.40000%" left="1.50000%" bottom="9.10000%" right="0.20000%" gridColumnStart="57" gridColumnEnd="84" gridRowStart="48" gridRowEnd="52" zIndex="14" previewType="AdaptiveWH">
                <a-form-item ref='ref2323' class='webVueAntRadioFormItem webVueAntYtRadioFormItem-mvg80mt  webVueAntYtRadioFormItem-mv webVueAntYtRadioFormItem show-label-mv show-label' name='WhiteListvalue1' :colon='false' :rules='[]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"白名单："'>
                            
                        </span>
                        </div>
                        </template>
<a-radio-group data-event class='webVueAntRadio webVueAntYtRadioStyle-mvfeujg webVueAntYtRadioStyle-mv webVueAntYtRadioStyle' v-model:value='OperatingRulesform1.WhiteListvalue1' :disabled='true' :options='[{"label":"开启","value":"开启","disabled":false,"select":true},{"label":"关闭","value":"关闭","disabled":false,"select":false}]'>
                            
                        </a-radio-group>
                        </a-form-item>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="4.90000%" left="39.20000%" bottom="29.30000%" right="42.60000%" gridColumnStart="3" gridColumnEnd="5" gridRowStart="55" gridRowEnd="58" zIndex="16" previewType="AdaptiveWH">
                <div ref='ref2324' class='webVueAntYtRectangle webVueAntYtRectangleStyle-mvp1mig webVueAntYtRectangleStyle-mv webVueAntYtRectangleStyle'>
                            
                        </div>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='width' comWidth='58.00px' top="18.10000%" left="9.00000%" bottom="11.40000%" right="3.20000%" gridColumnStart="5" gridColumnEnd="13" gridRowStart="54" gridRowEnd="58" zIndex="17" previewType="AdaptiveWH">
                <span ref='ref2325' class='webVueAntYtSpan webVueAntYtSpanStyle-mvqlj8c  webVueAntYtSpanStyle-mv webVueAntYtSpanStyle webVueAntYtSpanBrCount-mv webVueAntYtSpanBrCount'>
                            <span v-html='"车位预约"'>
                            
                        </span>
                        </span>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="12.30000%" left="0.80000%" bottom="10.20000%" right="2.30000%" gridColumnStart="9" gridColumnEnd="38" gridRowStart="69" gridRowEnd="73" zIndex="19" previewType="AdaptiveWH">
                <a-form-item ref='ref2329' class='webVueAntRadioFormItem webVueAntYtRadioFormItem-mvry68l  webVueAntYtRadioFormItem-mv webVueAntYtRadioFormItem show-label-mv show-label' name='Notifyvalue3' :colon='false' :rules='[]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"是否通知："'>
                            
                        </span>
                        </div>
                        </template>
<a-radio-group data-event class='webVueAntRadio webVueAntYtRadioStyle-mvbaqy1 webVueAntYtRadioStyle-mv webVueAntYtRadioStyle' v-model:value='OperatingRulesform1.Notifyvalue3' :disabled='true' :options='[{"label":"是","value":"是","disabled":false,"select":false},{"label":"否","value":"否","disabled":false,"select":true}]'>
                            
                        </a-radio-group>
                        </a-form-item>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="6.70000%" left="0.70000%" bottom="3.20000%" right="1.40000%" gridColumnStart="7" gridColumnEnd="46" gridRowStart="61" gridRowEnd="66" zIndex="20" previewType="AdaptiveWH">
                <a-form-item ref='ref2331' class='webVueAntInputNumberFormItem webVueAntYtInputNumberFormItem-mvxr7a6  webVueAntYtInputNumberFormItem-mv webVueAntYtInputNumberFormItem show-label-mv show-label' name='Reservedcarnumbervalue1' :colon='false' :rules='[]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"预约车位数："'>
                            
                        </span>
                        </div>
                        </template>
<a-input-number data-event class='webVueAntInputNumber webVueAntYtInputNumberStyle-mvvulay webVueAntYtInputNumberStyle-mv webVueAntYtInputNumberStyle' v-model:value='OperatingRulesform1.Reservedcarnumbervalue1' :disabled='true' :placeholder='"请输入"' :max='100' :min='0' :precision='2'>
                            
                        </a-input-number>
                        </a-form-item>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="6.70000%" left="0.00000%" bottom="3.20000%" right="0.60000%" gridColumnStart="54" gridColumnEnd="94" gridRowStart="61" gridRowEnd="66" zIndex="18" previewType="AdaptiveWH">
                <a-form-item ref='ref2332' class='webVueAntInputNumberFormItem webVueAntYtInputNumberFormItem-mvkbj57  webVueAntYtInputNumberFormItem-mv webVueAntYtInputNumberFormItem show-label-mv show-label' name='Appointmenttimeoutdurationvalue1' :colon='false' :rules='[]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"预约超时时长："'>
                            
                        </span>
                        </div>
                        </template>
<a-input-number data-event class='webVueAntInputNumber webVueAntYtInputNumberStyle-mvmr09b webVueAntYtInputNumberStyle-mv webVueAntYtInputNumberStyle' v-model:value='OperatingRulesform1.Appointmenttimeoutdurationvalue1' :disabled='true' :placeholder='"请输入"' :max='100' :min='0' :precision='2'>
                            
                        </a-input-number>
                        </a-form-item>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="27.40000%" left="39.20000%" bottom="6.80000%" right="42.60000%" gridColumnStart="3" gridColumnEnd="5" gridRowStart="75" gridRowEnd="78" zIndex="21" previewType="AdaptiveWH">
                <div ref='ref2786' class='webVueAntYtRectangle webVueAntYtRectangleStyle-mvefkch webVueAntYtRectangleStyle-mv webVueAntYtRectangleStyle'>
                            
                        </div>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='width' comWidth='57.00px' top="13.50000%" left="9.00000%" bottom="16.10000%" right="4.70000%" gridColumnStart="5" gridColumnEnd="13" gridRowStart="75" gridRowEnd="79" zIndex="22" previewType="AdaptiveWH">
                <span ref='ref2787' class='webVueAntYtSpan webVueAntYtSpanStyle-mvv0bdi  webVueAntYtSpanStyle-mv webVueAntYtSpanStyle webVueAntYtSpanBrCount-mv webVueAntYtSpanBrCount'>
                            <span v-html='"扫码配置"'>
                            
                        </span>
                        </span>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="4.20000%" left="0.30000%" bottom="18.40000%" right="2.70000%" gridColumnStart="9" gridColumnEnd="38" gridRowStart="81" gridRowEnd="85" zIndex="23" previewType="AdaptiveWH">
                <a-form-item ref='ref2788' class='webVueAntRadioFormItem webVueAntYtRadioFormItem-mvqr9c2  webVueAntYtRadioFormItem-mv webVueAntYtRadioFormItem show-label-mv show-label' name='AppearanceSweepCodevalue1' :colon='false' :rules='[]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"出场扫码："'>
                            
                        </span>
                        </div>
                        </template>
<a-radio-group data-event class='webVueAntRadio webVueAntYtRadioStyle-mvd32wz webVueAntYtRadioStyle-mv webVueAntYtRadioStyle' v-model:value='OperatingRulesform1.AppearanceSweepCodevalue1' :disabled='true' :options='[{"label":"开启","value":"开启","disabled":false,"select":false},{"label":"关闭","value":"关闭","disabled":false,"select":true}]'>
                            
                        </a-radio-group>
                        </a-form-item>
            </yt-grid-item>
        
            </yt-grid>
            
                        </a-form> -->
            </yt-grid-item>
        
            <!-- 拓展信息 -->
            <yt-grid-item fixedSize='selfAdaption' :isShow='DepotDetailsDynamicPanelselectKey1 == "6"' top="0.00000%" left="0.00000%" bottom="0.00000%" right="0.00000%" gridColumnStart="1" gridColumnEnd="101" gridRowStart="1" gridRowEnd="101" zIndex="1" previewType="AdaptiveWH">
                <a-form ref='ref374' :model='Expandinformationform1' :class='["webVueAntForm","webVueAntYtFormStyle-mv","webVueAntYtFormStyle"]'>
                            
            <yt-grid  previewType="AdaptiveWH" width="100%" height="100%">
                
            <yt-grid-item fixedSize='selfAdaption' top="6.20000%" left="0.30000%" bottom="3.70000%" right="1.50000%" gridColumnStart="9" gridColumnEnd="46" gridRowStart="8" gridRowEnd="13" zIndex="1" previewType="AdaptiveWH">
                <a-form-item ref='ref375' class='webVueAntInputFormItem webVueAntYtInputFormItem-mvj685v  webVueAntYtInputFormItem-mv webVueAntYtInputFormItem show-label-mv show-label' name='PropertyUnitvalue1' :colon='false' :rules='[]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"产权单位："'>
                            
                        </span>
                        </div>
                        </template>
<a-input data-event class='webVueAntinput webVueAntYtInputStyle-mvzs58z webVueAntYtInputStyle-mv webVueAntYtInputStyle' v-model:value='Expandinformationform1.PropertyUnitvalue1' :disabled='true' :maxLength='100' :placeholder='"请输入"'>
                            
                        </a-input>
                        </a-form-item>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="6.20000%" left="2.50000%" bottom="3.70000%" right="1.80000%" gridColumnStart="59" gridColumnEnd="97" gridRowStart="8" gridRowEnd="13" zIndex="2" previewType="AdaptiveWH">
                <a-form-item ref='ref376' class='webVueAntInputFormItem webVueAntYtInputFormItem-mv8e6ly  webVueAntYtInputFormItem-mv webVueAntYtInputFormItem show-label-mv show-label' name='BuildingPropertiesvalue1' :colon='false' :rules='[]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"建筑属性："'>
                            
                        </span>
                        </div>
                        </template>
<a-input data-event class='webVueAntinput webVueAntYtInputStyle-mvlbfo1 webVueAntYtInputStyle-mv webVueAntYtInputStyle' v-model:value='Expandinformationform1.BuildingPropertiesvalue1' :disabled='true' :maxLength='100' :placeholder='"请输入"'>
                            
                        </a-input>
                        </a-form-item>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="8.20000%" left="1.00000%" bottom="1.70000%" right="1.10000%" gridColumnStart="7" gridColumnEnd="46" gridRowStart="47" gridRowEnd="52" zIndex="3" previewType="AdaptiveWH">
                <a-form-item ref='ref378' class='webVueAntInputFormItem webVueAntYtInputFormItem-mvxto16  webVueAntYtInputFormItem-mv webVueAntYtInputFormItem show-label-mv show-label' name='LicenseNumbervalue1' :colon='false' :rules='[]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"许可证编号："'>
                            
                        </span>
                        </div>
                        </template>
<a-input data-event class='webVueAntinput webVueAntYtInputStyle-mvogfzb webVueAntYtInputStyle-mv webVueAntYtInputStyle' v-model:value='Expandinformationform1.LicenseNumbervalue1' :disabled='true' :maxLength='100' :placeholder='"请输入"'>
                            
                        </a-input>
                        </a-form-item>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="9.70000%" left="0.30000%" bottom="15.20000%" right="1.50000%" gridColumnStart="9" gridColumnEnd="46" gridRowStart="54" gridRowEnd="60" zIndex="4" previewType="AdaptiveWH">
                <a-form-item ref='ref380' class='webVueAntInputFormItem webVueAntYtInputFormItem-mvsrs55  webVueAntYtInputFormItem-mv webVueAntYtInputFormItem show-label-mv show-label' name='BusinessScopevalue1' :colon='false' :rules='[]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"经营范围："'>
                            
                        </span>
                        </div>
                        </template>
<a-input data-event class='webVueAntinput webVueAntYtInputStyle-mvadubv webVueAntYtInputStyle-mv webVueAntYtInputStyle' v-model:value='Expandinformationform1.BusinessScopevalue1' :disabled='true' :maxLength='100' :placeholder='"请输入"'>
                            
                        </a-input>
                        </a-form-item>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="27.00000%" left="45.20000%" bottom="7.20000%" right="36.50000%" gridColumnStart="3" gridColumnEnd="5" gridRowStart="3" gridRowEnd="6" zIndex="5" previewType="AdaptiveWH">
                <div ref='ref383' class='webVueAntYtRectangle webVueAntYtRectangleStyle-mvxvyjj webVueAntYtRectangleStyle-mv webVueAntYtRectangleStyle'>
                            
                        </div>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='width' comWidth='58.00px' top="13.20000%" left="10.50000%" bottom="16.30000%" right="1.60000%" gridColumnStart="5" gridColumnEnd="13" gridRowStart="3" gridRowEnd="7" zIndex="6" previewType="AdaptiveWH">
                <span ref='ref384' class='webVueAntYtSpan webVueAntYtSpanStyle-mvbp6u1  webVueAntYtSpanStyle-mv webVueAntYtSpanStyle webVueAntYtSpanBrCount-mv webVueAntYtSpanBrCount'>
                            <span v-html='"基本信息"'>
                            
                        </span>
                        </span>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="21.50000%" left="2.60000%" bottom="12.70000%" right="61.00000%" gridColumnStart="4" gridColumnEnd="5" gridRowStart="41" gridRowEnd="44" zIndex="7" previewType="AdaptiveWH">
                <div ref='ref385' class='webVueAntYtRectangle webVueAntYtRectangleStyle-mvqmbat webVueAntYtRectangleStyle-mv webVueAntYtRectangleStyle'>
                            
                        </div>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='width' comWidth='57.00px' top="5.60000%" left="12.00000%" bottom="20.50000%" right="1.60000%" gridColumnStart="5" gridColumnEnd="13" gridRowStart="41" gridRowEnd="45" zIndex="8" previewType="AdaptiveWH">
                <span ref='ref386' class='webVueAntYtSpan webVueAntYtSpanStyle-mvl2eya  webVueAntYtSpanStyle-mv webVueAntYtSpanStyle webVueAntYtSpanBrCount-mv webVueAntYtSpanBrCount'>
                            <span v-html='"许可信息"'>
                            
                        </span>
                        </span>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="1.60000%" left="0.30000%" bottom="8.30000%" right="1.50000%" gridColumnStart="9" gridColumnEnd="46" gridRowStart="23" gridRowEnd="28" zIndex="12" previewType="AdaptiveWH">
                <a-form-item ref='ref456' class='webVueAntInputFormItem webVueAntYtInputFormItem-mvvpgya  webVueAntYtInputFormItem-mv webVueAntYtInputFormItem show-label-mv show-label' name='Contactvalue1' :colon='false' :rules='[]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"联系人："'>
                            
                        </span>
                        </div>
                        </template>
<a-input data-event class='webVueAntinput webVueAntYtInputStyle-mv405o8 webVueAntYtInputStyle-mv webVueAntYtInputStyle' v-model:value='Expandinformationform1.Contactvalue1' :disabled='true' :maxLength='100' :placeholder='"请输入"'>
                            
                        </a-input>
                        </a-form-item>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="1.60000%" left="2.50000%" bottom="8.30000%" right="1.80000%" gridColumnStart="59" gridColumnEnd="97" gridRowStart="23" gridRowEnd="28" zIndex="13" previewType="AdaptiveWH">
                <a-form-item ref='ref457' class='webVueAntInputFormItem webVueAntYtInputFormItem-mvxybzj  webVueAntYtInputFormItem-mv webVueAntYtInputFormItem show-label-mv show-label' name='ContactPhonevalue5' :colon='false' :rules='[]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"联系电话："'>
                            
                        </span>
                        </div>
                        </template>
<a-input data-event class='webVueAntinput webVueAntYtInputStyle-mvhvrg4 webVueAntYtInputStyle-mv webVueAntYtInputStyle' v-model:value='Expandinformationform1.ContactPhonevalue5' :disabled='true' :maxLength='100' :placeholder='"请输入"'>
                            
                        </a-input>
                        </a-form-item>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="3.90000%" left="0.10000%" bottom="6.00000%" right="0.80000%" gridColumnStart="9" gridColumnEnd="97" gridRowStart="30" gridRowEnd="40" zIndex="14" previewType="AdaptiveWH">
                <a-form-item ref='ref459' class='webVueAntInputFormItem webVueAntYtInputFormItem-mvefpqg  webVueAntYtInputFormItem-mv webVueAntYtInputFormItem show-label-mv show-label' name='Expandinformationvalue1' :colon='false' :rules='[]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"产权描述："'>
                            
                        </span>
                        </div>
                        </template>
<a-input data-event class='webVueAntinput webVueAntYtInputStyle-mv5nqeu webVueAntYtInputStyle-mv webVueAntYtInputStyle' v-model:value='Expandinformationform1.Expandinformationvalue1' :disabled='true' :maxLength='100' :placeholder='"请输入"'>
                            
                        </a-input>
                        </a-form-item>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="20.10000%" left="2.60000%" bottom="14.20000%" right="61.00000%" gridColumnStart="4" gridColumnEnd="5" gridRowStart="62" gridRowEnd="65" zIndex="9" previewType="AdaptiveWH">
                <div ref='ref460' class='webVueAntYtRectangle webVueAntYtRectangleStyle-mvmpn3y webVueAntYtRectangleStyle-mv webVueAntYtRectangleStyle'>
                            
                        </div>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='width' comWidth='57.00px' top="4.50000%" left="12.00000%" bottom="21.60000%" right="1.60000%" gridColumnStart="5" gridColumnEnd="13" gridRowStart="62" gridRowEnd="66" zIndex="10" previewType="AdaptiveWH">
                <span ref='ref461' class='webVueAntYtSpan webVueAntYtSpanStyle-mv0dqvs  webVueAntYtSpanStyle-mv webVueAntYtSpanStyle webVueAntYtSpanBrCount-mv webVueAntYtSpanBrCount'>
                            <span v-html='"相关附件"'>
                            
                        </span>
                        </span>
            </yt-grid-item>

            <!-- 详情-附件上传 -->
            <!-- <yt-grid-item fixedSize='selfAdaption' top="9.00000%" left="0.40000%" bottom="15.90000%" right="1.00000%" gridColumnStart="9" gridColumnEnd="32" gridRowStart="66" gridRowEnd="72" zIndex="18" previewType="AdaptiveWH"> -->
            <yt-grid-item fixedSize='selfAdaption' top="9.00000%" left="0.40000%" bottom="15.90000%" right="1.00000%" gridColumnStart="1" gridColumnEnd="21" gridRowStart="66" gridRowEnd="72" zIndex="18" previewType="AdaptiveWH">
                <a-form-item ref='ref7642' class='webVueAntUploadButton webVueAntUploadButtonFormItem-mvdvuxq webVueAntUploadButtonStyle-mvebg41  webVueAntUploadButtonFormItem-mv webVueAntUploadButtonFormItem webVueAntUploadButtonStyle-mv webVueAntUploadButtonStyle show-label-mv show-label' name='AttachmentUploadfileList1' :colon='false' :rules='[]'>
                            <template #label>
                            <div class='label-content '>
                            <!-- <span class='ant-form-item-content ' v-html='"附件上传："'>
                            
                        </span> -->
                        </div>
                        </template>

                         <a-upload action="/api/common/uploadFile"
                          :multiple="true"
                          :max-count="10"
                          disabled
                          :file-list="Expandinformationform1.AttachmentUploadfileList3"
                        >
                        <a-button>
                          <!-- <upload-outlined></upload-outlined> -->
                          附件文件
                        </a-button>
                      </a-upload>
<!-- <yt-upload-button-inner data-event v-model:fileList='Expandinformationform2.AttachmentUploadfileList2' :showUploadList='true' :accept='"image/*"' :maxCount='9'>
                            
                        </yt-upload-button-inner> -->
                        </a-form-item>
            </yt-grid-item>
        

            <!-- <yt-grid-item fixedSize='selfAdaption' :isShow='FileAttachmentListisShow1' top="0.90000%" left="0.90000%" bottom="1.60000%" right="0.20000%" gridColumnStart="3" gridColumnEnd="98" gridRowStart="67" gridRowEnd="94" zIndex="11" previewType="AdaptiveWH">
                <yt-table ref='ref462' @onTableChange="(pagination)=> { handleFileAttachmentListPagination(pagination); }" class='webVueAntYtTable webVueAntYtTableStyle-mvmm00u webVueAntYtTableStyle-mv webVueAntYtTableStyle' :canSelect='false' v-model:selectedRows='FileAttachmentListselectedRows1' v-model:total='FileAttachmentListtotal1' v-model:current='FileAttachmentListcurrent2' v-model:pageSize='FileAttachmentListpageSize1' :columns='FileAttachmentListdata1.columns' :dataSource='FileAttachmentListdata1.dataSource' :scroll='{y:115}'>
                            <template #cell='{ column, record }'>
                            
                        </template>
                        </yt-table>
            </yt-grid-item> -->
        

            <yt-grid-item fixedSize='selfAdaption' top="10.40000%" left="2.50000%" bottom="14.50000%" right="1.80000%" gridColumnStart="59" gridColumnEnd="97" gridRowStart="15" gridRowEnd="21" zIndex="15" previewType="AdaptiveWH">
                <a-form-item ref='ref466' class='webVueAntInputFormItem webVueAntYtInputFormItem-mv6cqqo  webVueAntYtInputFormItem-mv webVueAntYtInputFormItem show-label-mv show-label' name='Servicelifevalue1' :colon='false' :rules='[]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"使用年限："'>
                            
                        </span>
                        </div>
                        </template>
<a-input data-event class='webVueAntinput webVueAntYtInputStyle-mvyx9po webVueAntYtInputStyle-mv webVueAntYtInputStyle' v-model:value='Expandinformationform1.Servicelifevalue1' :disabled='true' :maxLength='100' :placeholder='"请输入"'>
                            
                        </a-input>
                        </a-form-item>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="10.40000%" left="0.30000%" bottom="14.50000%" right="1.50000%" gridColumnStart="9" gridColumnEnd="46" gridRowStart="15" gridRowEnd="21" zIndex="17" previewType="AdaptiveWH">
                <a-form-item ref='ref468' class='webVueAntDatePickerFormItem webVueAntYtDatePickerFormItem-mvkjazx  webVueAntYtDatePickerFormItem-mv webVueAntYtDatePickerFormItem show-label-mv show-label' name='Constructiontimevalue1' :colon='false' :rules='[]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"建设时间："'>
                            
                        </span>
                        </div>
                        </template>
<yt-custom-date-piker data-event class='webVueAntYtDatePickerStyle-mvjj33p webVueAntYtDatePickerStyle-mv webVueAntYtDatePickerStyle' popupKey='"popupKey" "popupKeyId"' v-model:value='Expandinformationform1.Constructiontimevalue1' :disabled='true' :placeholder='"请输入"'>
                            
                        </yt-custom-date-piker>
                        </a-form-item>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="8.20000%" left="2.50000%" bottom="1.70000%" right="1.80000%" gridColumnStart="59" gridColumnEnd="97" gridRowStart="47" gridRowEnd="52" zIndex="16" previewType="AdaptiveWH">
                <a-form-item ref='ref469' class='webVueAntRangePickerFormItem webVueAntYtRangePickerFormItem-mvf96yg  webVueAntYtRangePickerFormItem-mv webVueAntYtRangePickerFormItem show-label-mv show-label' name='ValidityPeriodvalue1' :colon='false' :rules='[]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"有效期："'>
                            
                        </span>
                        </div>
                        </template>
<yt-custom-range-picker data-event class='webVueAntYtRangePicker webVueAntYtRangePickerStyle-mvgphyx webVueAntYtRangePickerStyle-mv webVueAntYtRangePickerStyle' popupKey='"popupKey" "popupKeyId"' v-model:value='Expandinformationform1.ValidityPeriodvalue1' :disabled='true'>
                            
                        </yt-custom-range-picker>
                        </a-form-item>
            </yt-grid-item>
        
            </yt-grid>
            
                        </a-form>
            </yt-grid-item>
        
            <!-- 操作记录 -->
            <yt-grid-item fixedSize='selfAdaption' :isShow='DepotDetailsDynamicPanelselectKey1 == "7"' top="0.00000%" left="0.00000%" bottom="0.00000%" right="0.00000%" gridColumnStart="1" gridColumnEnd="101" gridRowStart="1" gridRowEnd="101" zIndex="1" previewType="AdaptiveWH">
                <a-form ref='ref414' :model='Operationrecordform1' :class='["webVueAntForm","webVueAntYtFormStyle-mv","webVueAntYtFormStyle"]'>
                            
            <yt-grid  previewType="AdaptiveWH" width="100%" height="100%">
                
            <yt-grid-item fixedSize='selfAdaption' top="27.00000%" left="45.20000%" bottom="7.20000%" right="36.50000%" gridColumnStart="3" gridColumnEnd="5" gridRowStart="3" gridRowEnd="6" zIndex="2" previewType="AdaptiveWH">
                <div ref='ref423' class='webVueAntYtRectangle webVueAntYtRectangleStyle-mv5ba7m webVueAntYtRectangleStyle-mv webVueAntYtRectangleStyle'>
                            
                        </div>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='width' comWidth='57.00px' top="13.20000%" left="10.50000%" bottom="16.30000%" right="3.20000%" gridColumnStart="5" gridColumnEnd="13" gridRowStart="3" gridRowEnd="7" zIndex="3" previewType="AdaptiveWH">
                <span ref='ref424' class='webVueAntYtSpan webVueAntYtSpanStyle-mvfw1kx  webVueAntYtSpanStyle-mv webVueAntYtSpanStyle webVueAntYtSpanBrCount-mv webVueAntYtSpanBrCount'>
                            <span v-html='"操作记录"'>
                            
                        </span>
                        </span>
            </yt-grid-item>
        
            <yt-grid-item fixedSize='selfAdaption' :isShow='OperationrecordoftheyardisShow1' top="0.30000%" left="0.90000%" bottom="0.40000%" right="0.80000%" gridColumnStart="3" gridColumnEnd="99" gridRowStart="8" gridRowEnd="98" zIndex="1" previewType="AdaptiveWH">
                <yt-table ref='ref454' class='webVueAntYtTable webVueAntYtTableStyle-mvd9omn webVueAntYtTableStyle-mv webVueAntYtTableStyle' :canSelect='false' v-model:selectedRows='OperationrecordoftheyardselectedRows1' v-model:total='Operationrecordoftheyardtotal1' v-model:current='Operationrecordoftheyardcurrent2' v-model:pageSize='OperationrecordoftheyardpageSize1' :columns='Operationrecordoftheyarddata1.columns' :showQuickJumper='true' :dataSource='Operationrecordoftheyarddata1.dataSource' :scroll='{y:563}'>
                            <template #cell='{ column, record }'>
                            
                        </template>
                        </yt-table>
            </yt-grid-item>
        
            </yt-grid>
            
                        </a-form>
            </yt-grid-item>
        
            <!-- 岗亭管理 -->
            <yt-grid-item fixedSize='selfAdaption' :isShow='DepotDetailsDynamicPanelselectKey1 == "5"' top="0.20000%" left="0.60000%" bottom="0.00000%" right="0.00000%" gridColumnStart="1" gridColumnEnd="101" gridRowStart="1" gridRowEnd="101" zIndex="1" previewType="AdaptiveWH">
                <a-form ref='ref3756' :model='PostManagementViewform1' :class='["webVueAntForm","webVueAntYtFormStyle-mv","webVueAntYtFormStyle"]'>
                            
            <yt-grid  previewType="AdaptiveWH" width="100%" height="100%">
                
            <yt-grid-item fixedSize='selfAdaption' :isShow='ListofPostPersonnelisShow1' top="1.00000%" left="0.90000%" bottom="0.30000%" right="0.70000%" gridColumnStart="3" gridColumnEnd="100" gridRowStart="8" gridRowEnd="91" zIndex="1" previewType="AdaptiveWH">
                <yt-table ref='ref3757' @onTableChange="(pagination)=> { fetchPaginatedPostPersonnelData(pagination); }" class='webVueAntYtTable webVueAntYtTableStyle-mv1y6vv webVueAntYtTableStyle-mv webVueAntYtTableStyle' :canSelect='false' v-model:selectedRows='ListofPostPersonnelselectedRows1' v-model:total='ListofPostPersonneltotal1' v-model:current='ListofPostPersonnelcurrent2' v-model:pageSize='ListofPostPersonnelpageSize1' :columns='ListofPostPersonneldata1.columns' :dataSource='ListofPostPersonneldata1.dataSource' :scroll='{y:508}'>
                            <template #cell='{ column, record }'>
                            
                        </template>
                        </yt-table>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="3.40000%" left="45.60000%" bottom="30.70000%" right="36.10000%" gridColumnStart="3" gridColumnEnd="5" gridRowStart="4" gridRowEnd="7" zIndex="2" previewType="AdaptiveWH">
                <div ref='ref3759' class='webVueAntYtRectangle webVueAntYtRectangleStyle-mvfgaem webVueAntYtRectangleStyle-mv webVueAntYtRectangleStyle'>
                            
                        </div>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='width' comWidth='57.00px' top="20.50000%" left="10.60000%" bottom="8.90000%" right="2.80000%" gridColumnStart="5" gridColumnEnd="13" gridRowStart="3" gridRowEnd="7" zIndex="3" previewType="AdaptiveWH">
                <span ref='ref3760' class='webVueAntYtSpan webVueAntYtSpanStyle-mvzk4vq  webVueAntYtSpanStyle-mv webVueAntYtSpanStyle webVueAntYtSpanBrCount-mv webVueAntYtSpanBrCount'>
                            <span v-html='"岗亭管理"'>
                            
                        </span>
                        </span>
            </yt-grid-item>
        
            </yt-grid>
            
                        </a-form>
            </yt-grid-item>
        
            <!-- 计费规则 详情 -->
            <yt-grid-item fixedSize='selfAdaption' :isShow='DepotDetailsDynamicPanelselectKey1 == "4"' top="0.20000%" left="0.60000%" bottom="0.00000%" right="0.00000%" gridColumnStart="1" gridColumnEnd="101" gridRowStart="1" gridRowEnd="101" zIndex="1" previewType="AdaptiveWH">
                <a-form ref='ref4216' :model='BillingRulesViewform1' :class='["webVueAntForm","webVueAntYtFormStyle-mv","webVueAntYtFormStyle"]'>
                            
            <yt-grid  previewType="AdaptiveWH" width="100%" height="100%">
            <!-- 计费规则 列表 详情 -->
            <yt-grid-item fixedSize='selfAdaption' :isShow='yardbillingrulesisShow1' top="1.00000%" left="0.00000%" bottom="0.30000%" right="0.60000%" gridColumnStart="4" gridColumnEnd="99" gridRowStart="8" gridRowEnd="90" zIndex="1" previewType="AdaptiveWH">
                <yt-table ref='ref4217' @onTableChange="(pagination)=> { fetchDetailYardBillingRulesData(pagination); }" class='webVueAntYtTable webVueAntYtTableStyle-mvb40wp webVueAntYtTableStyle-mv webVueAntYtTableStyle' :canSelect='false' v-model:selectedRows='yardbillingrulesselectedRows1' v-model:total='yardbillingrulestotal1' v-model:current='yardbillingrulescurrent2' v-model:pageSize='yardbillingrulespageSize1' :columns='yardbillingrulesdata1.columns' :showQuickJumper='true' :dataSource='yardbillingrulesdata1.dataSource' :scroll='{y:503}'>
                <!-- <yt-table ref='ref4217' @onTableChange="(pagination)=> { fetchDetailYardBillingRulesData(pagination); }" @click="()=> { initYardBillingRules(); }" class='webVueAntYtTable webVueAntYtTableStyle-mvb40wp webVueAntYtTableStyle-mv webVueAntYtTableStyle' :canSelect='false' v-model:selectedRows='yardbillingrulesselectedRows1' v-model:total='yardbillingrulestotal1' v-model:current='yardbillingrulescurrent2' v-model:pageSize='yardbillingrulespageSize1' :columns='yardbillingrulesdata1.columns' :showQuickJumper='true' :dataSource='yardbillingrulesdata1.dataSource' :scroll='{y:503}'> -->
                            <template #cell='{ column, record }'>
                            
                        </template>
                        </yt-table>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="3.10000%" left="45.20000%" bottom="31.20000%" right="36.50000%" gridColumnStart="3" gridColumnEnd="5" gridRowStart="4" gridRowEnd="7" zIndex="2" previewType="AdaptiveWH">
                <div ref='ref4218' class='webVueAntYtRectangle webVueAntYtRectangleStyle-mvg6v14 webVueAntYtRectangleStyle-mv webVueAntYtRectangleStyle'>
                            
                        </div>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='width' comWidth='57.00px' top="20.30000%" left="10.50000%" bottom="9.30000%" right="3.20000%" gridColumnStart="5" gridColumnEnd="13" gridRowStart="3" gridRowEnd="7" zIndex="3" previewType="AdaptiveWH">
                <span ref='ref4219' class='webVueAntYtSpan webVueAntYtSpanStyle-mvtdbow  webVueAntYtSpanStyle-mv webVueAntYtSpanStyle webVueAntYtSpanBrCount-mv webVueAntYtSpanBrCount'>
                            <span v-html='"计费规则"'>
                            
                        </span>
                        </span>
            </yt-grid-item>
        
            </yt-grid>
            
                        </a-form>
            </yt-grid-item>
        
            </yt-grid>
            
                        </yt-dynamic-panel>
            </yt-grid-item>
        
             </div>
            
                        </a-form>
                        </template>
                        </yt-custom-modal>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' :isShow='NewdepotisShow1' id="yt-mgsbpm244iq7p" gridColumnStart="370" gridColumnEnd="1330" gridRowStart="98" gridRowEnd="919" zIndex="17" previewType="FixedWH">
                <yt-custom-modal ref='ref4351' @ok="()=> { handleConfirmNewYard(); }" @cancel="()=> { handleCancelNewYard(); }" class='webVueAntYtModal webVueAntYtModalStyle-mvyoel3 webVueAntYtModalStyle-mv webVueAntYtModalStyle' v-model:isShow='NewdepotisShow1' :title='"新增车场"' :maskClosable='true'>
                            <template #content>
                            <a-form class='webVueAntForm ' :model='Newdepotform1' ref='ref4351_form'>
                            
            <div style="display:grid;width:100%;height:100%;grid-template-columns: repeat(auto-fill, 1%);grid-template-rows: repeat(auto-fill, 1%);position: relative;">
            
            <yt-grid-item fixedSize='selfAdaption' :isShow='NewYardMenuisShow1' marginLeft='-13px' top="0.00000%" left="0.00000%" bottom="0.00000%" right="5.80000%" gridColumnStart="1" gridColumnEnd="15" gridRowStart="1" gridRowEnd="101" zIndex="1" previewType="FitScreen">
                <yt-vertical-menu-menu ref='ref4352' @click_to_jump="()=> { handleNewYardMenuSelection(); }" class='webVueAntYtVerticleMenu webVueAntYtVerticleMenuStyle-mv84nse webVueAntYtVerticleMenuStyle-mv webVueAntYtVerticleMenuStyle' v-model:openKeys='NewYardMenuopenKeys1' v-model:selectedKeys='NewYardMenuselectedKeys1' :items='NewYardMenuoptions1.dataSource'>
                            
                        </yt-vertical-menu-menu>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="0.00000%" left="0.20000%" bottom="0.00000%" right="0.00000%" gridColumnStart="14" gridColumnEnd="101" gridRowStart="1" gridRowEnd="101" zIndex="2" previewType="FitScreen">
                <yt-dynamic-panel ref='ref4353' class='webVueAntYtDynamicPanel ' mutileStyle='[{"statusId":"1","info":{}},{"statusId":"2","info":{}},{"statusId":"3","info":{}},{"statusId":"4","info":{}},{"statusId":"5","info":{}},{"statusId":"6","info":{}}]'>
                            
            <yt-grid  previewType="AdaptiveWH" width="100%" height="100%">
              <!-- 基础信息 -->
            <!-- <yt-grid-item fixedSize='selfAdaption' :isShow='true' top="0.00000%" left="0.00000%" bottom="0.00000%" right="0.00000%" gridColumnStart="1" gridColumnEnd="101" gridRowStart="1" gridRowEnd="101" zIndex="1" previewType="AdaptiveWH"> -->
            <!-- <yt-grid-item fixedSize='selfAdaption' :isShow='NewYardDynamicPanelselectKey1 == "1"' top="0.00000%" left="0.00000%" bottom="0.00000%" right="0.00000%" gridColumnStart="1" gridColumnEnd="101" gridRowStart="1" gridRowEnd="101" zIndex="1" previewType="AdaptiveWH"> -->
            <yt-grid-item fixedSize='selfAdaption' v-show='NewYardDynamicPanelselectKey1 == "1"' top="0.00000%" left="0.00000%" bottom="0.00000%" right="0.00000%" gridColumnStart="1" gridColumnEnd="101" gridRowStart="1" gridRowEnd="101" zIndex="1" previewType="AdaptiveWH">
                <a-form ref='ref4354' :model='Basicinformationform2' :class='["webVueAntForm","webVueAntYtFormStyle-mv","webVueAntYtFormStyle"]'>
                            
            <yt-grid  previewType="AdaptiveWH" width="100%" height="154.71167369901545%">
                
            <yt-grid-item fixedSize='selfAdaption' top="18.10000%" left="0.30000%" bottom="9.00000%" right="1.50000%" gridColumnStart="9" gridColumnEnd="46" gridRowStart="5" gridRowEnd="9" zIndex="1" previewType="AdaptiveWH">
                <a-form-item ref='ref4355' class='webVueAntInputFormItem webVueAntYtInputFormItem-mv2ma06  webVueAntYtInputFormItem-mv webVueAntYtInputFormItem show-label-mv show-label' name='yardnumbervalue2' :colon='false' :rules='[]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"车场编号："'>
                            
                        </span>
                        </div>
                        </template>
<a-input data-event class='webVueAntinput webVueAntYtInputStyle-mvnplft webVueAntYtInputStyle-mv webVueAntYtInputStyle' v-model:value='Basicinformationform2.yardnumbervalue2' :disabled='true' :maxLength='100' :placeholder='"请输入"'>
                            
                        </a-input>
                        </a-form-item>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="15.90000%" left="0.30000%" bottom="11.30000%" right="1.80000%" gridColumnStart="58" gridColumnEnd="97" gridRowStart="5" gridRowEnd="9" zIndex="2" previewType="AdaptiveWH">
                <a-form-item ref='ref4356' class='webVueAntInputFormItem webVueAntYtInputFormItem-mvsy9gz  webVueAntYtInputFormItem-mv webVueAntYtInputFormItem show-label-mv show-label' name='Nameofyard1value2' :colon='false' :rules='[{"required":true,"message":"必填"}]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"车场名称："'>
                            
                        </span>
                        </div>
                        </template>
<a-input data-event class='webVueAntinput webVueAntYtInputStyle-mvoe0lk webVueAntYtInputStyle-mv webVueAntYtInputStyle' v-model:value='Basicinformationform2.Nameofyard1value2' :disabled='false' :maxLength='100' :placeholder='"请输入"'>
                            
                        </a-input>
                        </a-form-item>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="11.30000%" left="2.50000%" bottom="15.90000%" right="1.80000%" gridColumnStart="59" gridColumnEnd="97" gridRowStart="10" gridRowEnd="14" zIndex="3" previewType="AdaptiveWH">
                <a-form-item ref='ref4357' class='webVueAntInputFormItem webVueAntYtInputFormItem-mv0r9yr  webVueAntYtInputFormItem-mv webVueAntYtInputFormItem show-label-mv show-label' name='Yardabbreviationvalue2' :colon='false' :rules='[]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"车场简称："'>
                            
                        </span>
                        </div>
                        </template>
<a-input data-event class='webVueAntinput webVueAntYtInputStyle-mvb6mmw webVueAntYtInputStyle-mv webVueAntYtInputStyle' v-model:value='Basicinformationform2.Yardabbreviationvalue2' :disabled='false' :maxLength='100' :placeholder='"请输入"'>
                            
                        </a-input>
                        </a-form-item>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="18.10000%" left="1.30000%" bottom="9.00000%" right="1.70000%" gridColumnStart="7" gridColumnEnd="46" gridRowStart="27" gridRowEnd="31" zIndex="4" previewType="AdaptiveWH">
                <a-form-item ref='ref4358' class='webVueAntInputFormItem webVueAntYtInputFormItem-mvy550t  webVueAntYtInputFormItem-mv webVueAntYtInputFormItem show-label-mv show-label' name='Numberofparkingvalue2' :colon='false' :rules='[{"required":true,"message":"必填"}]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"泊车数量："'>
                            
                        </span>
                        </div>
                        </template>
<a-input data-event class='webVueAntinput webVueAntYtInputStyle-mv6rhd7 webVueAntYtInputStyle-mv webVueAntYtInputStyle' v-model:value='Basicinformationform2.Numberofparkingvalue2' :maxLength='100' :placeholder='"请输入"'>
                            
                        </a-input>
                        </a-form-item>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="4.50000%" left="0.50000%" bottom="22.70000%" right="1.20000%" gridColumnStart="60" gridColumnEnd="97" gridRowStart="37" gridRowEnd="41" zIndex="5" previewType="AdaptiveWH">
                <a-form-item ref='ref4359' class='webVueAntInputFormItem webVueAntYtInputFormItem-mvxowcy  webVueAntYtInputFormItem-mv webVueAntYtInputFormItem show-label-mv show-label' name='Longtermrentalparkingspacesvalue2' :colon='false' :rules='[]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"长租车位："'>
                            
                        </span>
                        </div>
                        </template>
<a-input data-event class='webVueAntinput webVueAntYtInputStyle-mv2ztuz webVueAntYtInputStyle-mv webVueAntYtInputStyle' v-model:value='Basicinformationform2.Longtermrentalparkingspacesvalue2' :disabled='true' :maxLength='100' :placeholder='"自动同步"'>
                            
                        </a-input>
                        </a-form-item>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="4.50000%" left="2.60000%" bottom="22.70000%" right="1.80000%" gridColumnStart="8" gridColumnEnd="46" gridRowStart="37" gridRowEnd="41" zIndex="6" previewType="AdaptiveWH">
                <a-form-item ref='ref4360' class='webVueAntInputFormItem webVueAntYtInputFormItem-mv2zvj2  webVueAntYtInputFormItem-mv webVueAntYtInputFormItem show-label-mv show-label' name='Reservationofparkingspacevalue2' :colon='false' :rules='[]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"预约车位："'>
                            
                        </span>
                        </div>
                        </template>
<a-input data-event class='webVueAntinput webVueAntYtInputStyle-mv35dpq webVueAntYtInputStyle-mv webVueAntYtInputStyle' v-model:value='Basicinformationform2.Reservationofparkingspacevalue2' :disabled='true' :maxLength='100' :placeholder='"自动同步"'>
                            
                        </a-input>
                        </a-form-item>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="18.10000%" left="0.80000%" bottom="9.00000%" right="0.90000%" gridColumnStart="60" gridColumnEnd="97" gridRowStart="27" gridRowEnd="31" zIndex="7" previewType="AdaptiveWH">
                <a-form-item ref='ref4361' class='webVueAntInputFormItem webVueAntYtInputFormItem-mvtyrtn  webVueAntYtInputFormItem-mv webVueAntYtInputFormItem show-label-mv show-label' name='VIPParkingvalue2' :colon='false' :rules='[]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"贵宾车位："'>
                            
                        </span>
                        </div>
                        </template>
<a-input data-event class='webVueAntinput webVueAntYtInputStyle-mvy1l3b webVueAntYtInputStyle-mv webVueAntYtInputStyle' v-model:value='Basicinformationform2.VIPParkingvalue2' :maxLength='100' :placeholder='"请输入"'>
                            
                        </a-input>
                        </a-form-item>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="11.30000%" left="0.20000%" bottom="15.90000%" right="1.60000%" gridColumnStart="60" gridColumnEnd="97" gridRowStart="32" gridRowEnd="36" zIndex="8" previewType="AdaptiveWH">
                <a-form-item ref='ref4362' class='webVueAntInputFormItem webVueAntYtInputFormItem-mvfpgv0  webVueAntYtInputFormItem-mv webVueAntYtInputFormItem show-label-mv show-label' name='Numberofchargingpilesvalue2' :colon='false' :rules='[]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"充电桩数："'>
                            
                        </span>
                        </div>
                        </template>
<a-input data-event class='webVueAntinput webVueAntYtInputStyle-mvdheq3 webVueAntYtInputStyle-mv webVueAntYtInputStyle' v-model:value='Basicinformationform2.Numberofchargingpilesvalue2' :maxLength='100' :placeholder='"请输入"'>
                            
                        </a-input>
                        </a-form-item>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="27.20000%" left="45.20000%" bottom="30.30000%" right="36.50000%" gridColumnStart="3" gridColumnEnd="5" gridRowStart="2" gridRowEnd="5" zIndex="9" previewType="AdaptiveWH">
                <div ref='ref4363' class='webVueAntYtRectangle webVueAntYtRectangleStyle-mvlkd8d webVueAntYtRectangleStyle-mv webVueAntYtRectangleStyle'>
                            
                        </div>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='width' comWidth='58.00px' top="21.20000%" left="10.50000%" bottom="18.10000%" right="1.60000%" gridColumnStart="5" gridColumnEnd="13" gridRowStart="2" gridRowEnd="5" zIndex="10" previewType="AdaptiveWH">
                <span ref='ref4364' class='webVueAntYtSpan webVueAntYtSpanStyle-mv1sma7  webVueAntYtSpanStyle-mv webVueAntYtSpanStyle webVueAntYtSpanBrCount-mv webVueAntYtSpanBrCount'>
                            <span v-html='"基本信息"'>
                            
                        </span>
                        </span>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="18.10000%" left="45.20000%" bottom="18.10000%" right="36.50000%" gridColumnStart="3" gridColumnEnd="5" gridRowStart="24" gridRowEnd="26" zIndex="11" previewType="AdaptiveWH">
                <div ref='ref4365' class='webVueAntYtRectangle webVueAntYtRectangleStyle-mvugyfw webVueAntYtRectangleStyle-mv webVueAntYtRectangleStyle'>
                            
                        </div>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='width' comWidth='57.00px' top="12.10000%" left="10.50000%" bottom="27.20000%" right="3.20000%" gridColumnStart="5" gridColumnEnd="13" gridRowStart="24" gridRowEnd="27" zIndex="12" previewType="AdaptiveWH">
                <span ref='ref4366' class='webVueAntYtSpan webVueAntYtSpanStyle-mv19svx  webVueAntYtSpanStyle-mv webVueAntYtSpanStyle webVueAntYtSpanBrCount-mv webVueAntYtSpanBrCount'>
                            <span v-html='"车位信息"'>
                            
                        </span>
                        </span>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="0.00000%" left="14.70000%" bottom="36.30000%" right="48.90000%" gridColumnStart="4" gridColumnEnd="5" gridRowStart="42" gridRowEnd="44" zIndex="13" previewType="AdaptiveWH">
                <div ref='ref4367' class='webVueAntYtRectangle webVueAntYtRectangleStyle-mvc20ji webVueAntYtRectangleStyle-mv webVueAntYtRectangleStyle'>
                            
                        </div>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='width' comWidth='57.00px' top="24.20000%" left="1.20000%" bottom="15.10000%" right="0.20000%" gridColumnStart="6" gridColumnEnd="13" gridRowStart="41" gridRowEnd="44" zIndex="14" previewType="AdaptiveWH">
                <span ref='ref4368' class='webVueAntYtSpan webVueAntYtSpanStyle-mv7ha9p  webVueAntYtSpanStyle-mv webVueAntYtSpanStyle webVueAntYtSpanBrCount-mv webVueAntYtSpanBrCount'>
                            <span v-html='"运营信息"'>
                            
                        </span>
                        </span>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="11.30000%" left="2.30000%" bottom="15.90000%" right="0.80000%" gridColumnStart="7" gridColumnEnd="46" gridRowStart="45" gridRowEnd="49" zIndex="15" previewType="AdaptiveWH">
                <a-form-item ref='ref4369' class='webVueAntInputFormItem webVueAntYtInputFormItem-mvn07uz  webVueAntYtInputFormItem-mv webVueAntYtInputFormItem show-label-mv show-label' name='OperatingCompany1value2' :colon='false' :rules='[{"required":true,"message":"必填"}]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"运营公司："'>
                            
                        </span>
                        </div>
                        </template>
<a-input data-event class='webVueAntinput webVueAntYtInputStyle-mvm38hf webVueAntYtInputStyle-mv webVueAntYtInputStyle' v-model:value='Basicinformationform2.OperatingCompany1value2' :disabled='false' :maxLength='100' :placeholder='"请输入"'>
                            
                        </a-input>
                        </a-form-item>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="6.80000%" left="1.20000%" bottom="20.40000%" right="1.20000%" gridColumnStart="9" gridColumnEnd="46" gridRowStart="50" gridRowEnd="54" zIndex="16" previewType="AdaptiveWH">
                <a-form-item ref='ref4370' class='webVueAntInputFormItem webVueAntYtInputFormItem-mv73r7u  webVueAntYtInputFormItem-mv webVueAntYtInputFormItem show-label-mv show-label' name='Personinchargevalue2' :colon='false' :rules='[{"required":true,"message":"必填"}]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"负责人："'>
                            
                        </span>
                        </div>
                        </template>
<a-input data-event class='webVueAntinput webVueAntYtInputStyle-mvlp3dl webVueAntYtInputStyle-mv webVueAntYtInputStyle' v-model:value='Basicinformationform2.Personinchargevalue2' :disabled='false' :maxLength='100' :placeholder='"请输入"'>
                            
                        </a-input>
                        </a-form-item>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="6.80000%" left="2.20000%" bottom="20.40000%" right="0.90000%" gridColumnStart="58" gridColumnEnd="97" gridRowStart="50" gridRowEnd="54" zIndex="17" previewType="AdaptiveWH">
                <a-form-item ref='ref4371' class='webVueAntInputFormItem webVueAntYtInputFormItem-mv54hos  webVueAntYtInputFormItem-mv webVueAntYtInputFormItem show-label-mv show-label' name='ContactPhonevalue2' :colon='false' :rules='[{"required":true,"message":"必填"}]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"联系电话："'>
                            
                        </span>
                        </div>
                        </template>
<a-input data-event class='webVueAntinput webVueAntYtInputStyle-mvgr7qh webVueAntYtInputStyle-mv webVueAntYtInputStyle' v-model:value='Basicinformationform2.ContactPhonevalue2' :disabled='false' :maxLength='100' :placeholder='"请输入"'>
                            
                        </a-input>
                        </a-form-item>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="3.00000%" left="1.10000%" bottom="0.00000%" right="0.40000%" gridColumnStart="8" gridColumnEnd="97" gridRowStart="55" gridRowEnd="58" zIndex="18" previewType="AdaptiveWH">
                <a-form-item ref='ref4372' class='webVueAntInputFormItem webVueAntYtInputFormItem-mvwvesy  webVueAntYtInputFormItem-mv webVueAntYtInputFormItem show-label-mv show-label' name='latitudeandlongitudevalue2' :colon='false' :rules='[{"required":true,"message":"必填"}]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"经纬度："'>
                            
                        </span>
                        </div>
                        </template>
<a-input data-event class='webVueAntinput webVueAntYtInputStyle-mveug0w webVueAntYtInputStyle-mv webVueAntYtInputStyle' v-model:value='Basicinformationform2.latitudeandlongitudevalue2' :disabled='false' :maxLength='100' :placeholder='"请输入"' @click="() => handleModalMap('add')">
                            
                        </a-input>
                        </a-form-item>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="18.10000%" left="0.90000%" bottom="9.00000%" right="0.40000%" gridColumnStart="8" gridColumnEnd="97" gridRowStart="59" gridRowEnd="63" zIndex="19" previewType="AdaptiveWH">
                <a-form-item ref='ref4373' class='webVueAntInputFormItem webVueAntYtInputFormItem-mvgsdjk  webVueAntYtInputFormItem-mv webVueAntYtInputFormItem show-label-mv show-label' name='Detailedaddressvalue2' :colon='false' :rules='[]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"详细地址："'>
                            
                        </span>
                        </div>
                        </template>
<a-input data-event class='webVueAntinput webVueAntYtInputStyle-mvk1588 webVueAntYtInputStyle-mv webVueAntYtInputStyle' v-model:value='Basicinformationform2.Detailedaddressvalue2' :disabled='false' :maxLength='100' :placeholder='"请输入"'>
                            
                        </a-input>
                        </a-form-item>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="6.40000%" left="1.10000%" bottom="10.30000%" right="0.50000%" gridColumnStart="8" gridColumnEnd="97" gridRowStart="64" gridRowEnd="71" zIndex="20" previewType="AdaptiveWH">
                <a-form-item ref='ref4374' class='webVueAntInputFormItem webVueAntYtInputFormItem-mvqj8p5  webVueAntYtInputFormItem-mv webVueAntYtInputFormItem show-label-mv show-label' name='YardDescriptionvalue2' :colon='false' :rules='[]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"车场描述："'>
                            
                        </span>
                        </div>
                        </template>
<a-input data-event class='webVueAntinput webVueAntYtInputStyle-mv2mayo webVueAntYtInputStyle-mv webVueAntYtInputStyle' v-model:value='Basicinformationform2.YardDescriptionvalue2' :disabled='false' :maxLength='100' :placeholder='"请输入"'>
                            
                        </a-input>
                        </a-form-item>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="9.00000%" left="2.60000%" bottom="27.20000%" right="61.00000%" gridColumnStart="4" gridColumnEnd="5" gridRowStart="72" gridRowEnd="74" zIndex="21" previewType="AdaptiveWH">
                <div ref='ref4375' class='webVueAntYtRectangle webVueAntYtRectangleStyle-mvbfozs webVueAntYtRectangleStyle-mv webVueAntYtRectangleStyle'>
                            
                        </div>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='width' comWidth='57.00px' top="30.30000%" left="12.00000%" bottom="9.00000%" right="1.60000%" gridColumnStart="5" gridColumnEnd="13" gridRowStart="71" gridRowEnd="74" zIndex="22" previewType="AdaptiveWH">
                <span ref='ref4376' class='webVueAntYtSpan webVueAntYtSpanStyle-mvhvqpm  webVueAntYtSpanStyle-mv webVueAntYtSpanStyle webVueAntYtSpanBrCount-mv webVueAntYtSpanBrCount'>
                            <span v-html='"其他信息"'>
                            
                        </span>
                        </span>
            </yt-grid-item>
        

            <!-- <yt-grid-item fixedSize='width' comWidth='85.00px' top="12.10000%" left="2.60000%" bottom="27.20000%" right="3.70000%" gridColumnStart="7" gridColumnEnd="18" gridRowStart="80" gridRowEnd="83" zIndex="23" previewType="AdaptiveWH">
                <span ref='ref4377' class='webVueAntYtSpan webVueAntYtSpanStyle-mv6j4vi  webVueAntYtSpanStyle-mv webVueAntYtSpanStyle webVueAntYtSpanBrCount-mv webVueAntYtSpanBrCount'>
                            <span v-html='"车场二维码："'>
                            
                        </span>
                        </span>
            </yt-grid-item> -->
        

            <yt-grid-item fixedSize='selfAdaption' top="9.00000%" left="1.90000%" bottom="18.10000%" right="1.10000%" gridColumnStart="7" gridColumnEnd="46" gridRowStart="10" gridRowEnd="14" zIndex="29" previewType="AdaptiveWH">
                <a-form-item ref='ref9374' class='webVueSelectFormItem webVueAntYtSelectFormItem-mvg60cy  webVueAntYtSelectFormItem-mv webVueAntYtSelectFormItem show-label-mv show-label' name='yardstatus1value2' :colon='false' :rules='[{"required":true,"message":"必填"}]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"车场状态："'>
                            
                        </span>
                        </div>
                        </template>
<a-select data-event class='webVueSelect  webVueAntYtSelectStyle-mv webVueAntYtSelectStyle' dropdownClassName='"popupKey" "popupKeyId"' :showArrow='true' v-model:value='Basicinformationform2.yardstatus1value2' :placeholder='"请输入"' :mode='"single"' :options='optionsParkingLotStatus' :showSearch='true'>
<!-- <a-select data-event class='webVueSelect  webVueAntYtSelectStyle-mv webVueAntYtSelectStyle' dropdownClassName='"popupKey" "popupKeyId"' :showArrow='true' v-model:value='Basicinformationform2.yardstatus1value2' :placeholder='"请输入"' :mode='"single"' :options='[{"label":"使用中","value":"使用中","disabled":false,"select":false},{"label":"试运行","value":"试运行","disabled":false,"select":false},{"value":"建设中","label":"建设中","disabled":false,"select":false},{"value":"已停用","label":"已停用","disabled":false,"select":false}]' :showSearch='true'> -->
                            
                        </a-select>
                        </a-form-item>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="22.70000%" left="2.30000%" bottom="4.50000%" right="1.10000%" gridColumnStart="7" gridColumnEnd="46" gridRowStart="19" gridRowEnd="23" zIndex="30" previewType="AdaptiveWH">
                <a-form-item ref='ref9375' class='webVueSelectFormItem webVueAntYtSelectFormItem-mv0apnx  webVueAntYtSelectFormItem-mv webVueAntYtSelectFormItem show-label-mv show-label' name='Typeofyard1value2' :colon='false' :rules='[{"required":true,"message":"必填"}]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"车场类型："'>
                            
                        </span>
                        </div>
                        </template>
<a-select data-event class='webVueSelect  webVueAntYtSelectStyle-mv webVueAntYtSelectStyle' dropdownClassName='"popupKey" "popupKeyId"' :showArrow='true' v-model:value='Basicinformationform2.Typeofyard1value2' :placeholder='"请输入"' :mode='"single"' :options='optionsParkingLotType' :showSearch='true'>
<!-- <a-select data-event class='webVueSelect  webVueAntYtSelectStyle-mv webVueAntYtSelectStyle' dropdownClassName='"popupKey" "popupKeyId"' :showArrow='true' v-model:value='Basicinformationform2.Typeofyard1value2' :placeholder='"请输入"' :mode='"single"' :options='[{"label":"自营","value":"自营","disabled":false,"select":false},{"label":"托管（接入）","value":"托管（接入）","disabled":false,"select":false},{"value":"托管（未接）","label":"托管（未接）","disabled":false,"select":false}]' :showSearch='true'> -->
                            
                        </a-select>
                        </a-form-item>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="4.50000%" left="0.30000%" bottom="22.70000%" right="1.50000%" gridColumnStart="9" gridColumnEnd="46" gridRowStart="15" gridRowEnd="19" zIndex="31" previewType="AdaptiveWH">
                <a-form-item ref='ref9376' class='webVueSelectFormItem webVueAntYtSelectFormItem-mvgrijz  webVueAntYtSelectFormItem-mv webVueAntYtSelectFormItem show-label-mv show-label' name='Area1value2' :colon='false' :rules='[]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"所属区域："'>
                            
                        </span>
                        </div>
                        </template>

                        <!-- <a-cascader data-event class='webVueAntYtCascader webVueAntYtCascaderStyle-mvbipu6 webVueAntYtCascaderStyle-mv webVueAntYtCascaderStyle' dropdownClassName='"popupKey" "popupKeyId"' change-on-select :showArrow='true' :placeholder='"请输入"' :multiple='true' :options='[{"value":"李沧区","label":"李沧区","disabled":false,"select":false,"children":[{"value":"XX街道","label":"XX街道","disabled":false,"select":false,"children":[{"value":"中心","label":"中心","disabled":false,"select":false}]}]}]' v-model:value='Basicinformationform2.Area1value2' :showSearch='true' :showCheckedStrategy='"SHOW_CHILD"'> -->
                        <a-cascader data-event class='webVueAntYtCascader webVueAntYtCascaderStyle-mvbipu6 webVueAntYtCascaderStyle-mv webVueAntYtCascaderStyle' dropdownClassName='"popupKey" "popupKeyId"' change-on-select :showArrow='true' :placeholder='"请输入"' :multiple='false' :options='optionsArea' v-model:value='Basicinformationform2.Area1value2' :showSearch='true' :showCheckedStrategy='"SHOW_CHILD"'>
                            
                          </a-cascader>
<!-- <a-select data-event class='webVueSelect  webVueAntYtSelectStyle-mv webVueAntYtSelectStyle' dropdownClassName='"popupKey" "popupKeyId"' :showArrow='true' v-model:value='Basicinformationform2.Area1value2' :placeholder='"请输入"' :mode='"single"' :options='[{"label":"选项1","value":"选项1","disabled":false,"select":false},{"label":"选项2","value":"选项2","disabled":false,"select":false}]' :showSearch='true'>
                            
                        </a-select> -->
                        </a-form-item>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="22.70000%" left="2.50000%" bottom="4.50000%" right="1.80000%" gridColumnStart="59" gridColumnEnd="97" gridRowStart="19" gridRowEnd="23" zIndex="25" previewType="AdaptiveWH">
                <a-form-item ref='ref9377' class='webVueSelectFormItem webVueAntYtSelectFormItem-mv0at2w  webVueAntYtSelectFormItem-mv webVueAntYtSelectFormItem show-label-mv show-label' name='YardCategory1value2' :colon='false' :rules='[]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"车场类别："'>
                            
                        </span>
                        </div>
                        </template>
<a-select data-event class='webVueSelect  webVueAntYtSelectStyle-mv webVueAntYtSelectStyle' dropdownClassName='"popupKey" "popupKeyId"' :showArrow='true' v-model:value='Basicinformationform2.YardCategory1value2' :placeholder='"请输入"' :mode='"single"' :options='optionsParkingLotCategory' :showSearch='true'>
<!-- <a-select data-event class='webVueSelect  webVueAntYtSelectStyle-mv webVueAntYtSelectStyle' dropdownClassName='"popupKey" "popupKeyId"' :showArrow='true' v-model:value='Basicinformationform2.YardCategory1value2' :placeholder='"请输入"' :mode='"single"' :options='[{"label":"商场","value":"商场","disabled":false,"select":false},{"label":"停车楼","value":"停车楼","disabled":false,"select":false},{"value":"交通枢纽","label":"交通枢纽","disabled":false,"select":false},{"value":"医院","label":"医院","disabled":false,"select":false},{"value":"住宅社区","label":"住宅社区","disabled":false,"select":false},{"value":"商业园区","label":"商业园区","disabled":false,"select":false},{"value":"写字楼","label":"写字楼","disabled":false,"select":false},{"value":"银行","label":"银行","disabled":false,"select":false},{"value":"政府","label":"政府","disabled":false,"select":false},{"value":"校区","label":"校区","disabled":false,"select":false}]' :showSearch='true'> -->
                            
                        </a-select>
                        </a-form-item>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="4.50000%" left="2.50000%" bottom="22.70000%" right="1.80000%" gridColumnStart="59" gridColumnEnd="97" gridRowStart="15" gridRowEnd="19" zIndex="26" previewType="AdaptiveWH">
                <a-form-item ref='ref9378' class='webVueSelectFormItem webVueAntYtSelectFormItem-mve08cv  webVueAntYtSelectFormItem-mv webVueAntYtSelectFormItem show-label-mv show-label' name='Plate1value2' :colon='false' :rules='[]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"所属板块："'>
                            
                        </span>
                        </div>
                        </template>
<a-select data-event class='webVueSelect  webVueAntYtSelectStyle-mv webVueAntYtSelectStyle' dropdownClassName='"popupKey" "popupKeyId"' :showArrow='true' v-model:value='Basicinformationform2.Plate1value2' :placeholder='"请输入"' :mode='"single"' :options='optionsPlate' :showSearch='true'>
<!-- <a-select data-event class='webVueSelect  webVueAntYtSelectStyle-mv webVueAntYtSelectStyle' dropdownClassName='"popupKey" "popupKeyId"' :showArrow='true' v-model:value='Basicinformationform2.Plate1value2' :placeholder='"请输入"' :mode='"single"' :options='[{"label":"板块1","value":"板块1","disabled":false,"select":false},{"label":"板块2","value":"板块2","disabled":false,"select":false}]' :showSearch='true'> -->
                            
                        </a-select>
                        </a-form-item>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="11.30000%" left="2.60000%" bottom="15.90000%" right="1.80000%" gridColumnStart="8" gridColumnEnd="46" gridRowStart="32" gridRowEnd="36" zIndex="27" previewType="AdaptiveWH">
                <a-form-item ref='ref9379' class='webVueSelectFormItem webVueAntYtSelectFormItem-mvi4mjx  webVueAntYtSelectFormItem-mv webVueAntYtSelectFormItem show-label-mv show-label' name='Chargingservicevalue2' :colon='false' :rules='[]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"充电服务："'>
                            
                        </span>
                        </div>
                        </template>
<a-select data-event class='webVueSelect  webVueAntYtSelectStyle-mv webVueAntYtSelectStyle' dropdownClassName='"popupKey" "popupKeyId"' :showArrow='true' v-model:value='Basicinformationform2.Chargingservicevalue2' :placeholder='"请输入"' :mode='"single"' :options='[{"label":"是","value":"是","disabled":false,"select":false},{"label":"否","value":"否","disabled":false,"select":false}]' :showSearch='true'>
                            
                        </a-select>
                        </a-form-item>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="9.00000%" left="0.80000%" bottom="18.10000%" right="0.90000%" gridColumnStart="60" gridColumnEnd="97" gridRowStart="45" gridRowEnd="49" zIndex="28" previewType="AdaptiveWH">
                <a-form-item ref='ref9380' class='webVueSelectFormItem webVueAntYtSelectFormItem-mvtk6cr  webVueAntYtSelectFormItem-mv webVueAntYtSelectFormItem show-label-mv show-label' name='AdditionalServicesvalue2' :colon='false' :rules='[]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"附加服务："'>
                            
                        </span>
                        </div>
                        </template>
<a-select data-event class='webVueSelect  webVueAntYtSelectStyle-mv webVueAntYtSelectStyle' dropdownClassName='"popupKey" "popupKeyId"' :showArrow='true' v-model:value='Basicinformationform2.AdditionalServicesvalue2' :placeholder='"请输入"' :mode='"single"' :options='optionsService' :showSearch='true'>
                            
                        </a-select>
                        </a-form-item>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="3.00000%" left="0.70000%" bottom="30.30000%" right="0.40000%" gridColumnStart="4" gridColumnEnd="41" gridRowStart="76" gridRowEnd="79" zIndex="32" previewType="AdaptiveWH">
                <a-form-item ref='ref4390' class='webVueAntRadioFormItem webVueAntYtRadioFormItem-mvzvezs  webVueAntYtRadioFormItem-mv webVueAntYtRadioFormItem show-label-mv show-label' name='Whetherthelargescreenisvisiblevalue2' :colon='false' :rules='[{"required":true,"message":"必填"}]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"大屏是否可见："'>
                            
                        </span>
                        </div>
                        </template>
<a-radio-group data-event class='webVueAntRadio webVueAntYtRadioStyle-mvcp436 webVueAntYtRadioStyle-mv webVueAntYtRadioStyle' v-model:value='Basicinformationform2.Whetherthelargescreenisvisiblevalue2' :options='[{"label":"是","value":"是","disabled":false,"select":true},{"label":"否","value":"否","disabled":false,"select":false}]'>
                            
                        </a-radio-group>
                        </a-form-item>
            </yt-grid-item>

            <!-- 新增-车场图标 -->
            <yt-grid-item fixedSize='selfAdaption' top="18.10000%" left="0.30000%" bottom="9.00000%" right="0.60000%" gridColumnStart="60" gridColumnEnd="83" gridRowStart="75" gridRowEnd="79" zIndex="38" previewType="AdaptiveWH">
                <a-form-item ref='ref7725' class='webVueAntUploadButton webVueAntUploadButtonFormItem-mv6f4ua webVueAntUploadButtonStyle-mvb706o  webVueAntUploadButtonFormItem-mv webVueAntUploadButtonFormItem webVueAntUploadButtonStyle-mv webVueAntUploadButtonStyle show-label-mv show-label' name='YardIconfileList1' :colon='false' :rules='[]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"车场图标："'>
                            
                        </span>
                        </div>
                        </template>

                          <a-upload action="/api/common/uploadFile"
                          :multiple="false"
                          :max-count="1"
                          :file-list="Basicinformationform2.YardIconfileList2"
                          @change="handleChangeYardIconfileList2"
                        >
                        <a-button>
                          <upload-outlined></upload-outlined>
                          点击上传
                        </a-button>
                      </a-upload>
<!-- <yt-upload-button-inner data-event v-model:fileList='Basicinformationform2.YardIconfileList2' :showUploadList='true' :accept='"image/*"' :maxCount='1' :preview='true'>
                            
                        </yt-upload-button-inner> -->
                        </a-form-item>
            </yt-grid-item>
        

            <!-- <yt-grid-item fixedSize='width' comWidth='72.00px' top="9.00000%" left="2.20000%" bottom="27.20000%" right="0.90000%" gridColumnStart="60" gridColumnEnd="69" gridRowStart="76" gridRowEnd="79" zIndex="33" previewType="AdaptiveWH">
                <span ref='ref4391' class='webVueAntYtSpan webVueAntYtSpanStyle-mv0x0s7  webVueAntYtSpanStyle-mv webVueAntYtSpanStyle webVueAntYtSpanBrCount-mv webVueAntYtSpanBrCount'>
                            <span v-html='"车场图标："'>
                            
                        </span>
                        </span>
            </yt-grid-item> -->
        

            <!-- <yt-grid-item fixedSize='selfAdaption' top="20.40000%" left="3.90000%" bottom="6.80000%" right="8.00000%" gridColumnStart="18" gridColumnEnd="29" gridRowStart="79" gridRowEnd="83" zIndex="34" previewType="AdaptiveWH">
                <a-button ref='ref7477' class='webVueAntButton webVueAntYtButtonStyle-mv0i720  webVueAntYtButtonStyle-mv webVueAntYtButtonStyle center-mv center' :loading='Generatetwodimensionalcodeloading1'>
                            <span class='yt-button-content ' v-html='"生成二维码"'>
                            
                        </span>
                        </a-button>
            </yt-grid-item> -->
        
            <!-- 新增-车场照片 -->
            <yt-grid-item fixedSize='selfAdaption' top="13.60000%" left="3.60000%" bottom="13.60000%" right="2.00000%" gridColumnStart="8" gridColumnEnd="32" gridRowStart="82" gridRowEnd="86" zIndex="38" previewType="AdaptiveWH">
                <a-form-item ref='ref7726' class='webVueAntUploadButton webVueAntUploadButtonFormItem-mvlj66h webVueAntUploadButtonStyle-mvilr9o  webVueAntUploadButtonFormItem-mv webVueAntUploadButtonFormItem webVueAntUploadButtonStyle-mv webVueAntUploadButtonStyle show-label-mv show-label' name='YardPhotosfileList1' :colon='false' :rules='[]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"车场照片："'>
                            
                        </span>
                        </div>
                        </template>

                        <a-upload action="/api/common/uploadFile"
                          :multiple="true"
                          :max-count="10"
                          :file-list="Basicinformationform2.YardPhotosfileList2"
                          @change="handleChangeYardPhotosfileList2"
                        >
                        <a-button>
                          <upload-outlined></upload-outlined>
                          点击上传
                        </a-button>
                      </a-upload>

<!-- <yt-upload-button-inner data-event v-model:fileList='Basicinformationform2.YardPhotosfileList2' :showUploadList='true' :accept='"image/*"' :maxCount='1' :preview='true'>
                            
                        </yt-upload-button-inner> -->
                        </a-form-item>
            </yt-grid-item>

            <!-- <yt-grid-item fixedSize='width' :isShow='"_$isShow$_"' comWidth='71.00px' top="15.10000%" left="9.90000%" bottom="24.20000%" right="4.10000%" gridColumnStart="8" gridColumnEnd="18" gridRowStart="84" gridRowEnd="87" zIndex="24" previewType="AdaptiveWH"> -->
            <!-- <yt-grid-item fixedSize='width' :isShow='"_$isShow$_"' comWidth='71.00px' top="15.10000%" left="9.90000%" bottom="24.20000%" right="4.10000%" gridColumnStart="8" gridColumnEnd="18" gridRowStart="78" gridRowEnd="87" zIndex="24" previewType="AdaptiveWH">
                <span ref='ref4379' class='webVueAntYtSpan webVueAntYtSpanStyle-mv0e6ah  webVueAntYtSpanStyle-mv webVueAntYtSpanStyle webVueAntYtSpanBrCount-mv webVueAntYtSpanBrCount'>
                            <span v-html='"车场照片："'>
                            
                        </span>
                        </span>
            </yt-grid-item> -->
        
            </yt-grid>
            
                        </a-form>
            </yt-grid-item>
        
            <!-- 平台信息 -->
            <!-- <yt-grid-item fixedSize='selfAdaption' :isShow='false' top="0.00000%" left="0.00000%" bottom="0.00000%" right="0.00000%" gridColumnStart="1" gridColumnEnd="101" gridRowStart="1" gridRowEnd="101" zIndex="2" previewType="AdaptiveWH"> -->
            <!-- <yt-grid-item fixedSize='selfAdaption' :isShow='NewYardDynamicPanelselectKey1 == "2"' top="0.00000%" left="0.00000%" bottom="0.00000%" right="0.00000%" gridColumnStart="1" gridColumnEnd="101" gridRowStart="1" gridRowEnd="101" zIndex="2" previewType="AdaptiveWH"> -->
            <yt-grid-item fixedSize='selfAdaption' v-show='NewYardDynamicPanelselectKey1 == "2"' top="0.00000%" left="0.00000%" bottom="0.00000%" right="0.00000%" gridColumnStart="1" gridColumnEnd="101" gridRowStart="1" gridRowEnd="101" zIndex="2" previewType="AdaptiveWH">
                <a-form ref='ref4393' :model='PlatformInformationform2' :class='["webVueAntForm","webVueAntYtFormStyle-mv","webVueAntYtFormStyle"]'>
                            
            <yt-grid  previewType="AdaptiveWH" width="100%" height="100%">
                
            <yt-grid-item fixedSize='selfAdaption' top="27.00000%" left="45.20000%" bottom="7.20000%" right="36.50000%" gridColumnStart="3" gridColumnEnd="5" gridRowStart="3" gridRowEnd="6" zIndex="1" previewType="AdaptiveWH">
                <div ref='ref4394' class='webVueAntYtRectangle webVueAntYtRectangleStyle-mv74sab webVueAntYtRectangleStyle-mv webVueAntYtRectangleStyle'>
                            
                        </div>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='width' comWidth='57.00px' top="13.20000%" left="10.50000%" bottom="16.30000%" right="3.20000%" gridColumnStart="5" gridColumnEnd="13" gridRowStart="3" gridRowEnd="7" zIndex="2" previewType="AdaptiveWH">
                <span ref='ref4395' class='webVueAntYtSpan webVueAntYtSpanStyle-mv138es  webVueAntYtSpanStyle-mv webVueAntYtSpanStyle webVueAntYtSpanBrCount-mv webVueAntYtSpanBrCount'>
                            <span v-html='"运营平台"'>
                            
                        </span>
                        </span>
            </yt-grid-item>
        

            <!-- <yt-grid-item fixedSize='selfAdaption' top="16.20000%" left="45.20000%" bottom="18.10000%" right="36.50000%" gridColumnStart="3" gridColumnEnd="5" gridRowStart="15" gridRowEnd="18" zIndex="3" previewType="AdaptiveWH">
                <div ref='ref4396' class='webVueAntYtRectangle webVueAntYtRectangleStyle-mvqe248 webVueAntYtRectangleStyle-mv webVueAntYtRectangleStyle'>
                            
                        </div>
            </yt-grid-item> -->
        

            <!-- <yt-grid-item fixedSize='width' comWidth='57.00px' top="12.10000%" left="10.50000%" bottom="17.50000%" right="3.20000%" gridColumnStart="5" gridColumnEnd="13" gridRowStart="15" gridRowEnd="19" zIndex="4" previewType="AdaptiveWH">
                <span ref='ref4397' class='webVueAntYtSpan webVueAntYtSpanStyle-mv1pqck  webVueAntYtSpanStyle-mv webVueAntYtSpanStyle webVueAntYtSpanBrCount-mv webVueAntYtSpanBrCount'>
                            <span v-html='"支付平台"'>
                            
                        </span>
                        </span>
            </yt-grid-item> -->
        

            <yt-grid-item fixedSize='selfAdaption' top="9.00000%" left="1.60000%" bottom="0.90000%" right="0.50000%" gridColumnStart="9" gridColumnEnd="46" gridRowStart="8" gridRowEnd="13" zIndex="7" previewType="AdaptiveWH">
                <a-form-item ref='ref9381' class='webVueSelectFormItem webVueAntYtSelectFormItem-mvaoi0m  webVueAntYtSelectFormItem-mv webVueAntYtSelectFormItem show-label-mv show-label' name='Operationmodevalue2' :colon='false' :rules='[]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"运营模式："'>
                            
                        </span>
                        </div>
                        </template>
<a-select data-event class='webVueSelect  webVueAntYtSelectStyle-mv webVueAntYtSelectStyle' dropdownClassName='"popupKey" "popupKeyId"' :showArrow='true' v-model:value='PlatformInformationform2.Operationmodevalue2' :disabled='false' :placeholder='"请输入"' :mode='"single"' :options='optionsOperationMode' :showSearch='true'>
                            
                        </a-select>
                        </a-form-item>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="9.00000%" left="1.50000%" bottom="0.90000%" right="2.20000%" gridColumnStart="59" gridColumnEnd="98" gridRowStart="8" gridRowEnd="13" zIndex="5" previewType="AdaptiveWH">
                <a-form-item ref='ref9382' class='webVueSelectFormItem webVueAntYtSelectFormItem-mvpjhp1  webVueAntYtSelectFormItem-mv webVueAntYtSelectFormItem show-label-mv show-label' name='OperatingCompanyvalue3' :colon='false' :rules='[{"required":true,"message":"必填"}]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"运营公司："'>
                            
                        </span>
                        </div>
                        </template>
<a-select data-event class='webVueSelect  webVueAntYtSelectStyle-mv webVueAntYtSelectStyle' dropdownClassName='"popupKey" "popupKeyId"' :showArrow='true' v-model:value='PlatformInformationform2.OperatingCompanyvalue3' :placeholder='"请输入"' :mode='"single"' :options='optionsOperationCompany' :showSearch='true'>
                            
                        </a-select>
                        </a-form-item>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="16.10000%" left="1.20000%" bottom="8.70000%" right="0.50000%" gridColumnStart="9" gridColumnEnd="46" gridRowStart="20" gridRowEnd="26" zIndex="6" previewType="AdaptiveWH">
                <a-form-item ref='ref9383' class='webVueSelectFormItem webVueAntYtSelectFormItem-mv409yg  webVueAntYtSelectFormItem-mv webVueAntYtSelectFormItem show-label-mv show-label' name='conservator' :colon='false' :rules='[]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"车场管理员："'>
                            
                        </span>
                        </div>
                        </template>
<a-select data-event class='webVueSelect  webVueAntYtSelectStyle-mv webVueAntYtSelectStyle' dropdownClassName='"popupKey" "popupKeyId"' :showArrow='true' v-model:value='PlatformInformationform2.conservator' :placeholder='"请输入"' :mode='"single"' :options='optionsConservator' :showSearch='true'>
                            
                        </a-select>
                        </a-form-item>
            </yt-grid-item>

            <!-- <yt-grid-item fixedSize='selfAdaption' top="16.10000%" left="1.20000%" bottom="8.70000%" right="0.50000%" gridColumnStart="9" gridColumnEnd="46" gridRowStart="20" gridRowEnd="26" zIndex="6" previewType="AdaptiveWH">
                <a-form-item ref='ref9383' class='webVueSelectFormItem webVueAntYtSelectFormItem-mv409yg  webVueAntYtSelectFormItem-mv webVueAntYtSelectFormItem show-label-mv show-label' name='dockingplatformvalue2' :colon='false' :rules='[]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"对接平台："'>
                            
                        </span>
                        </div>
                        </template>
<a-select data-event class='webVueSelect  webVueAntYtSelectStyle-mv webVueAntYtSelectStyle' dropdownClassName='"popupKey" "popupKeyId"' :showArrow='true' v-model:value='PlatformInformationform2.dockingplatformvalue2' :placeholder='"请输入"' :mode='"single"' :options='optionsPlatform' :showSearch='true'>
                            
                        </a-select>
                        </a-form-item>
            </yt-grid-item> -->
        
            </yt-grid>
            
                        </a-form>
            </yt-grid-item>
        
            <!-- 运营规则 新增弹窗 -->
            <!-- <yt-grid-item fixedSize='selfAdaption' :isShow='false' top="0.00000%" left="0.00000%" bottom="0.00000%" right="0.00000%" gridColumnStart="1" gridColumnEnd="101" gridRowStart="1" gridRowEnd="101" zIndex="6" previewType="AdaptiveWH"> -->
            <yt-grid-item fixedSize='selfAdaption' :isShow='NewYardDynamicPanelselectKey1 == "3"' top="0.00000%" left="0.00000%" bottom="0.00000%" right="0.00000%" gridColumnStart="1" gridColumnEnd="101" gridRowStart="1" gridRowEnd="101" zIndex="6" previewType="AdaptiveWH">
              <!-- 运营规则 新增弹窗 form 新 -->
              <a-form :class='["webVueAntForm","webVueAntYtFormStyle-mv","webVueAntYtFormStyle","webVueAntForm-yy"]' v-bind="formItemLayout" ref='ref4401' :model='OperatingRulesform2'>
                <!-- 预付款管理 -->
                <div>
                  <span class="spanLable">预付款管理</span>
                  <a-row style="margin: 0;" :gutter="24">
                    <a-col style="padding-right: 48px;" :span="12">
                      <a-form-item name="PrepaidTimeoutDurationvalue2" label="预付超时时长：" class="minute">
                        <a-input data-event v-model:value='OperatingRulesform2.PrepaidTimeoutDurationvalue2' :maxLength='100' :placeholder='"请输入"'>
                        </a-input>
                      </a-form-item>
                    </a-col>
                    <a-col style="padding-right: 48px;" :span="12">
                      <a-form-item name="Timeoutdoesnotleaveprocessingvalue2" label="超时未离开处理：">
                      <a-select data-event  dropdownClassName='"popupKey" "popupKeyId"' :showArrow='true' v-model:value='OperatingRulesform2.Timeoutdoesnotleaveprocessingvalue2' :placeholder='"请输入"' :mode='"single"' :options='[{"label":"重新计费","value":"重新计费","disabled":false,"select":false},{"label":"暂不处理","value":"暂不处理","disabled":false,"select":false}]' :showSearch='true'>
                      </a-select>
                      </a-form-item>
                    </a-col>
                  </a-row>
                  <a-row style="margin: 0;" :gutter="24">
                    <a-col style="padding-right: 48px;" :span="12">
                      <a-form-item name="Notifyvalue4" label="是否通知：" class="minute">
                        <a-radio-group data-event class='webVueAntRadio webVueAntYtRadioStyle-mvkckqe webVueAntYtRadioStyle-mv webVueAntYtRadioStyle' v-model:value='OperatingRulesform2.Notifyvalue4' :options='[{"label":"是","value":"是","disabled":false,"select":false},{"label":"否","value":"否","disabled":false,"select":true}]'>
                        </a-radio-group>
                      </a-form-item>
                    </a-col>
                  </a-row>
                </div>
                <!-- 黑/白名单 -->
                <div>
                  <span class="spanLable">黑/白名单</span>
                  <a-row style="margin: 0;" :gutter="24">
                    <a-col style="padding-right: 48px;" :span="12">
                      <a-form-item name="blacklistvalue2" label="黑名单：">
                        <a-radio-group data-event class='webVueAntRadio webVueAntYtRadioStyle-mv2gl3k webVueAntYtRadioStyle-mv webVueAntYtRadioStyle' v-model:value='OperatingRulesform2.blacklistvalue2' :options='[{"label":"开启","value":"开启","disabled":false,"select":true},{"label":"关闭","value":"关闭","disabled":false,"select":false}]'>
                        </a-radio-group>
                      </a-form-item>
                    </a-col>
                    <a-col style="padding-right: 48px;" :span="12">
                      <a-form-item name="WhiteListvalue2" label="白名单：">
                        <a-radio-group data-event class='webVueAntRadio webVueAntYtRadioStyle-mv50v5f webVueAntYtRadioStyle-mv webVueAntYtRadioStyle' v-model:value='OperatingRulesform2.WhiteListvalue2' :options='[{"label":"开启","value":"开启","disabled":false,"select":true},{"label":"关闭","value":"关闭","disabled":false,"select":false}]'>
                        </a-radio-group>
                      </a-form-item>
                    </a-col>
                  </a-row>
                </div>
                <!-- 车位预约 -->
                <div>
                  <span class="spanLable">车位预约</span>
                  <a-row style="margin: 0;" :gutter="24">
                    <a-col style="padding-right: 48px;" :span="12">
                      <a-form-item name="Reservedcarnumbervalue2" label="预约车位数：" class="minute">
                        <a-input-number data-event v-model:value='OperatingRulesform2.Reservedcarnumbervalue2' :placeholder='"请输入"'>
                        </a-input-number>
                      </a-form-item>
                    </a-col>
                    <a-col style="padding-right: 48px;" :span="12">
                      <a-form-item name="Appointmenttimeoutdurationvalue2" label="预约超时时长：">
                        <a-input data-event v-model:value='OperatingRulesform2.Appointmenttimeoutdurationvalue2' :maxLength='100' :placeholder='"请输入"'>
                        </a-input>
                      </a-form-item>
                    </a-col>
                  </a-row>
                  <a-row style="margin: 0;" :gutter="24">
                    <a-col style="padding-right: 48px;" :span="12">
                      <a-form-item name="Notifyvalue6" label="是否通知：" class="minute">
                        <a-radio-group data-event class='webVueAntRadio webVueAntYtRadioStyle-mvnel6z webVueAntYtRadioStyle-mv webVueAntYtRadioStyle' v-model:value='OperatingRulesform2.Notifyvalue6' :options='[{"label":"是","value":"是","disabled":false,"select":false},{"label":"否","value":"否","disabled":false,"select":true}]'>
                        </a-radio-group>
                      </a-form-item>
                    </a-col>
                  </a-row>
                </div>
                <!-- 扫码配置 -->
                <div>
                  <span class="spanLable">扫码配置</span>
                  <a-row style="margin: 0;" :gutter="24">
                    <a-col style="padding-right: 48px;" :span="12">
                      <a-form-item name="AppearanceSweepCodevalue2" label="出场扫码：">
                        <a-radio-group data-event class='webVueAntRadio webVueAntYtRadioStyle-mv0osuw webVueAntYtRadioStyle-mv webVueAntYtRadioStyle' v-model:value='OperatingRulesform2.AppearanceSweepCodevalue2' :options='[{"label":"开启","value":"开启","disabled":false,"select":false},{"label":"关闭","value":"关闭","disabled":false,"select":true}]'>
                        </a-radio-group>
                      </a-form-item>
                    </a-col>
                  </a-row>
                </div>
                <!-- 异常车辆处理 -->
                <div>
                  <span class="spanLable">异常车辆处理</span>
                  <div v-for="(item, index) in OperatingRulesform2['abnormalHandle']" :key="item.id">
                    <a-row style="margin: 0;" :gutter="24">
                      <a-col style="padding-right: 48px;" :span="12">
                        <a-form-item :name="['abnormalHandle', index, 'status']" label="异常状态：">
                          <a-select data-event dropdownClassName='"popupKey" "popupKeyId"' :showArrow='true' v-model:value="item['status']" :placeholder='"请输入"' :mode='"single"' :options='[{"label":"重复入场","value":"重复入场","disabled":false,"select":false},{"label":"无驶入车","value":"无驶入车","disabled":false,"select":false},{"value":"强制抬杆","label":"强制抬杆","disabled":false,"select":false},{"value":"其他","label":"其他","disabled":false,"select":false}]' :showSearch='true' @change="handleAbnormalStatusChange(item)">
                          </a-select>
                        </a-form-item>
                      </a-col>
                      <a-col style="padding-right: 48px;position: relative;" :span="12">
                        <a-form-item :name="['abnormalHandle', index, 'handle']" label="异常处理：">
                          <a-select data-event dropdownClassName='"popupKey" "popupKeyId"' :showArrow='true' v-model:value="item['handle']" :placeholder='"请输入"' :mode='"single"' :options='[{"label":"禁止通行","value":"禁止通行","disabled":false,"select":false},{"label":"车辆放行","value":"车辆放行","disabled":false,"select":false},{"value":"放行拉黑","label":"放行拉黑","disabled":false,"select":false},{"value":"其他","label":"其他","disabled":false,"select":false}]' :showSearch='true'>
                          </a-select>
                        </a-form-item>
                        <!-- 添加 -->
                        <span v-if="index === 0" style="position: absolute;top: 5px;right: 5px;color: #1890ff;cursor: pointer;" @click="handleAddAbnormal(item)">添加</span>
                        <!-- 删除 -->
                        <span v-if="index !== 0" style="position: absolute;top: 5px;right: 5px;color: rgba(248, 76, 85, 1);cursor: pointer;" @click="handleDelAbnormal(item)">删除</span>
                      </a-col>
                    </a-row>
                    <a-row style="margin: 0;" :gutter="24">
                      <a-col style="padding-right: 48px;" :span="12">
                        <a-form-item :name="['abnormalHandle', index, 'notify']" label="是否通知：">
                          <a-radio-group data-event class='webVueAntRadio webVueAntYtRadioStyle-mvgyhu1 webVueAntYtRadioStyle-mv webVueAntYtRadioStyle' v-model:value="item['notify']" :options='[{"label":"是","value":"是","disabled":false,"select":false},{"label":"否","value":"否","disabled":false,"select":true}]'>
                          </a-radio-group>
                        </a-form-item>
                      </a-col>
                      <a-col v-if="item['handle'] === '放行拉黑'" style="padding-right: 48px;" :span="12">
                        <a-form-item :name="['abnormalHandle', index, 'time']" label="拉黑时长：">
                          <a-input-number data-event v-model:value="item['time']" :placeholder='"请输入"' addon-after="天">
                          </a-input-number>
                        </a-form-item>
                      </a-col>
                    </a-row>
                  </div>
                </div>
              </a-form>

              <!-- 运营规则 新增弹窗 form 旧 -->
                <!-- <a-form ref='ref4401' :model='OperatingRulesform2' :class='["webVueAntForm","webVueAntYtFormStyle-mv","webVueAntYtFormStyle"]'>
                            
            <yt-grid  previewType="AdaptiveWH" width="100%" height="100%">
                
            <yt-grid-item fixedSize='selfAdaption' top="6.20000%" left="2.00000%" bottom="3.70000%" right="1.30000%" gridColumnStart="5" gridColumnEnd="46" gridRowStart="8" gridRowEnd="13" zIndex="1" previewType="AdaptiveWH">
                <a-form-item ref='ref4402' class='webVueAntInputFormItem webVueAntYtInputFormItem-mvv3f2d  webVueAntYtInputFormItem-mv webVueAntYtInputFormItem show-label-mv show-label' name='PrepaidTimeoutDurationvalue2' :colon='false' :rules='[]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"预付超时时长："'>
                            
                        </span>
                        </div>
                        </template>
<a-input data-event class='webVueAntinput webVueAntYtInputStyle-mvekypo webVueAntYtInputStyle-mv webVueAntYtInputStyle' v-model:value='OperatingRulesform2.PrepaidTimeoutDurationvalue2' :maxLength='100' :placeholder='"请输入"'>
                            
                        </a-input>
                        </a-form-item>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="27.00000%" left="45.20000%" bottom="7.20000%" right="36.50000%" gridColumnStart="3" gridColumnEnd="5" gridRowStart="3" gridRowEnd="6" zIndex="2" previewType="AdaptiveWH">
                <div ref='ref4403' class='webVueAntYtRectangle webVueAntYtRectangleStyle-mvo3o3w webVueAntYtRectangleStyle-mv webVueAntYtRectangleStyle'>
                            
                        </div>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='width' comWidth='71.00px' top="13.20000%" left="8.40000%" bottom="16.30000%" right="5.60000%" gridColumnStart="5" gridColumnEnd="15" gridRowStart="3" gridRowEnd="7" zIndex="3" previewType="AdaptiveWH">
                <span ref='ref4404' class='webVueAntYtSpan webVueAntYtSpanStyle-mvga247  webVueAntYtSpanStyle-mv webVueAntYtSpanStyle webVueAntYtSpanBrCount-mv webVueAntYtSpanBrCount'>
                            <span v-html='"预付款管理"'>
                            
                        </span>
                        </span>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="31.30000%" left="39.20000%" bottom="3.00000%" right="42.60000%" gridColumnStart="3" gridColumnEnd="5" gridRowStart="22" gridRowEnd="25" zIndex="4" previewType="AdaptiveWH">
                <div ref='ref4405' class='webVueAntYtRectangle webVueAntYtRectangleStyle-mvh8ot7 webVueAntYtRectangleStyle-mv webVueAntYtRectangleStyle'>
                            
                        </div>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='width' comWidth='85.00px' top="12.90000%" left="6.00000%" bottom="16.70000%" right="8.20000%" gridColumnStart="5" gridColumnEnd="17" gridRowStart="22" gridRowEnd="26" zIndex="5" previewType="AdaptiveWH">
                <span ref='ref4406' class='webVueAntYtSpan webVueAntYtSpanStyle-mvgqgxc  webVueAntYtSpanStyle-mv webVueAntYtSpanStyle webVueAntYtSpanBrCount-mv webVueAntYtSpanBrCount'>
                            <span v-html='"异常车辆处理"'>
                            
                        </span>
                        </span>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="6.20000%" left="0.70000%" bottom="3.70000%" right="0.60000%" gridColumnStart="52" gridColumnEnd="94" gridRowStart="8" gridRowEnd="13" zIndex="7" previewType="AdaptiveWH">
                <a-form-item ref='ref9384' class='webVueSelectFormItem webVueAntYtSelectFormItem-mvtpuy7  webVueAntYtSelectFormItem-mv webVueAntYtSelectFormItem show-label-mv show-label' name='Timeoutdoesnotleaveprocessingvalue2' :colon='false' :rules='[]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"超时未离开处理："'>
                            
                        </span>
                        </div>
                        </template>
<a-select data-event class='webVueSelect  webVueAntYtSelectStyle-mv webVueAntYtSelectStyle' dropdownClassName='"popupKey" "popupKeyId"' :showArrow='true' v-model:value='OperatingRulesform2.Timeoutdoesnotleaveprocessingvalue2' :placeholder='"请输入"' :mode='"single"' :options='[{"label":"选项1","value":"选项1","disabled":false,"select":false},{"label":"选项2","value":"选项2","disabled":false,"select":false}]' :showSearch='true'>
                            
                        </a-select>
                        </a-form-item>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="9.40000%" left="0.60000%" bottom="15.50000%" right="1.20000%" gridColumnStart="9" gridColumnEnd="46" gridRowStart="28" gridRowEnd="34" zIndex="6" previewType="AdaptiveWH">
                <a-form-item ref='ref9385' class='webVueSelectFormItem webVueAntYtSelectFormItem-mva52sf  webVueAntYtSelectFormItem-mv webVueAntYtSelectFormItem show-label-mv show-label' name='Abnormalstatevalue2' :colon='false' :rules='[]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"异常状态："'>
                            
                        </span>
                        </div>
                        </template>
<a-select data-event class='webVueSelect  webVueAntYtSelectStyle-mv webVueAntYtSelectStyle' dropdownClassName='"popupKey" "popupKeyId"' :showArrow='true' v-model:value='OperatingRulesform2.Abnormalstatevalue2' :placeholder='"请输入"' :mode='"single"' :options='[{"label":"重复入场","value":"重复入场","disabled":false,"select":false},{"label":"无驶入放行","value":"无驶入放行","disabled":false,"select":false},{"value":"手动抬杠出场","label":"手动抬杠出场","disabled":false,"select":false},{"value":"强制抬杆","label":"强制抬杆","disabled":false,"select":false}]' :showSearch='true'>
                            
                        </a-select>
                        </a-form-item>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="9.40000%" left="1.10000%" bottom="15.50000%" right="0.70000%" gridColumnStart="57" gridColumnEnd="94" gridRowStart="28" gridRowEnd="34" zIndex="8" previewType="AdaptiveWH">
                <a-form-item ref='ref9386' class='webVueSelectFormItem webVueAntYtSelectFormItem-mv3fc06  webVueAntYtSelectFormItem-mv webVueAntYtSelectFormItem show-label-mv show-label' name='ExceptionHandlingvalue2' :colon='false' :rules='[]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"异常处理："'>
                            
                        </span>
                        </div>
                        </template>
<a-select data-event class='webVueSelect  webVueAntYtSelectStyle-mv webVueAntYtSelectStyle' dropdownClassName='"popupKey" "popupKeyId"' :showArrow='true' v-model:value='OperatingRulesform2.ExceptionHandlingvalue2' :placeholder='"请输入"' :mode='"single"' :options='[{"label":"重复入场","value":"重复入场","disabled":false,"select":false},{"label":"无驶入放行","value":"无驶入放行","disabled":false,"select":false},{"value":"手动抬杠出场","label":"手动抬杠出场","disabled":false,"select":false},{"value":"强制抬杆","label":"强制抬杆","disabled":false,"select":false}]' :showSearch='true'>
                            
                        </a-select>
                        </a-form-item>
            </yt-grid-item>
        
            <yt-grid-item fixedSize='selfAdaption' top="18.10000%" left="0.80000%" bottom="19.90000%" right="2.30000%" gridColumnStart="9" gridColumnEnd="38" gridRowStart="15" gridRowEnd="20" zIndex="10" previewType="AdaptiveWH">
                <a-form-item ref='ref4411' class='webVueAntRadioFormItem webVueAntYtRadioFormItem-mvucfio  webVueAntYtRadioFormItem-mv webVueAntYtRadioFormItem show-label-mv show-label' name='Notifyvalue4' :colon='false' :rules='[]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"是否通知："'>
                            
                        </span>
                        </div>
                        </template>
<a-radio-group data-event class='webVueAntRadio webVueAntYtRadioStyle-mvkckqe webVueAntYtRadioStyle-mv webVueAntYtRadioStyle' v-model:value='OperatingRulesform2.Notifyvalue4' :options='[{"label":"是","value":"是","disabled":false,"select":false},{"label":"否","value":"否","disabled":false,"select":true}]'>
                            
                        </a-radio-group>
                        </a-form-item>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="18.40000%" left="0.80000%" bottom="4.10000%" right="2.30000%" gridColumnStart="9" gridColumnEnd="38" gridRowStart="35" gridRowEnd="39" zIndex="11" previewType="AdaptiveWH">
                <a-form-item ref='ref4412' class='webVueAntRadioFormItem webVueAntYtRadioFormItem-mv2eiyt  webVueAntYtRadioFormItem-mv webVueAntYtRadioFormItem show-label-mv show-label' name='Notifyvalue5' :colon='false' :rules='[]'>
                            <template #label>
                            <div class='label-content '>
                              异常车辆处理
                            <span class='ant-form-item-content ' v-html='"是否通知："'>
                            
                        </span>
                        </div>
                        </template>
<a-radio-group data-event class='webVueAntRadio webVueAntYtRadioStyle-mvgyhu1 webVueAntYtRadioStyle-mv webVueAntYtRadioStyle' v-model:value='OperatingRulesform2.Notifyvalue5' :options='[{"label":"是","value":"是","disabled":false,"select":false},{"label":"否","value":"否","disabled":false,"select":true}]'>
                            
                        </a-radio-group>
                        </a-form-item>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="25.70000%" left="45.20000%" bottom="8.60000%" right="36.50000%" gridColumnStart="3" gridColumnEnd="5" gridRowStart="42" gridRowEnd="45" zIndex="12" previewType="AdaptiveWH">
                <div ref='ref4413' class='webVueAntYtRectangle webVueAntYtRectangleStyle-mvk530g webVueAntYtRectangleStyle-mv webVueAntYtRectangleStyle'>
                            
                        </div>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='width' comWidth='64.00px' top="8.70000%" left="9.30000%" bottom="20.90000%" right="4.50000%" gridColumnStart="5" gridColumnEnd="14" gridRowStart="42" gridRowEnd="46" zIndex="13" previewType="AdaptiveWH">
                <span ref='ref4414' class='webVueAntYtSpan webVueAntYtSpanStyle-mvs7yxc  webVueAntYtSpanStyle-mv webVueAntYtSpanStyle webVueAntYtSpanBrCount-mv webVueAntYtSpanBrCount'>
                            <span v-html='"黑/白名单"'>
                            
                        </span>
                        </span>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="13.40000%" left="0.80000%" bottom="9.10000%" right="0.90000%" gridColumnStart="9" gridColumnEnd="36" gridRowStart="48" gridRowEnd="52" zIndex="15" previewType="AdaptiveWH">
                <a-form-item ref='ref4415' class='webVueAntRadioFormItem webVueAntYtRadioFormItem-mvg2qjo  webVueAntYtRadioFormItem-mv webVueAntYtRadioFormItem show-label-mv show-label' name='blacklistvalue2' :colon='false' :rules='[]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"黑名单："'>
                            
                        </span>
                        </div>
                        </template>
<a-radio-group data-event class='webVueAntRadio webVueAntYtRadioStyle-mv2gl3k webVueAntYtRadioStyle-mv webVueAntYtRadioStyle' v-model:value='OperatingRulesform2.blacklistvalue2' :options='[{"label":"开启","value":"开启","disabled":false,"select":true},{"label":"关闭","value":"关闭","disabled":false,"select":false}]'>
                            
                        </a-radio-group>
                        </a-form-item>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="13.40000%" left="1.50000%" bottom="9.10000%" right="0.20000%" gridColumnStart="57" gridColumnEnd="84" gridRowStart="48" gridRowEnd="52" zIndex="14" previewType="AdaptiveWH">
                <a-form-item ref='ref4416' class='webVueAntRadioFormItem webVueAntYtRadioFormItem-mvkweoy  webVueAntYtRadioFormItem-mv webVueAntYtRadioFormItem show-label-mv show-label' name='WhiteListvalue2' :colon='false' :rules='[]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"白名单："'>
                            
                        </span>
                        </div>
                        </template>
<a-radio-group data-event class='webVueAntRadio webVueAntYtRadioStyle-mv50v5f webVueAntYtRadioStyle-mv webVueAntYtRadioStyle' v-model:value='OperatingRulesform2.WhiteListvalue2' :options='[{"label":"开启","value":"开启","disabled":false,"select":true},{"label":"关闭","value":"关闭","disabled":false,"select":false}]'>
                            
                        </a-radio-group>
                        </a-form-item>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="4.90000%" left="39.20000%" bottom="29.30000%" right="42.60000%" gridColumnStart="3" gridColumnEnd="5" gridRowStart="55" gridRowEnd="58" zIndex="16" previewType="AdaptiveWH">
                <div ref='ref4417' class='webVueAntYtRectangle webVueAntYtRectangleStyle-mv9n9k7 webVueAntYtRectangleStyle-mv webVueAntYtRectangleStyle'>
                            
                        </div>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='width' comWidth='58.00px' top="18.10000%" left="9.00000%" bottom="11.40000%" right="3.20000%" gridColumnStart="5" gridColumnEnd="13" gridRowStart="54" gridRowEnd="58" zIndex="17" previewType="AdaptiveWH">
                <span ref='ref4418' class='webVueAntYtSpan webVueAntYtSpanStyle-mv4jkk3  webVueAntYtSpanStyle-mv webVueAntYtSpanStyle webVueAntYtSpanBrCount-mv webVueAntYtSpanBrCount'>
                            <span v-html='"车位预约"'>
                            
                        </span>
                        </span>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="12.30000%" left="0.80000%" bottom="10.20000%" right="2.30000%" gridColumnStart="9" gridColumnEnd="38" gridRowStart="69" gridRowEnd="73" zIndex="19" previewType="AdaptiveWH">
                <a-form-item ref='ref4419' class='webVueAntRadioFormItem webVueAntYtRadioFormItem-mvjq4ft  webVueAntYtRadioFormItem-mv webVueAntYtRadioFormItem show-label-mv show-label' name='Notifyvalue6' :colon='false' :rules='[]'>
                            <template #label>
                            <div class='label-content '>
                             车位预约
                            <span class='ant-form-item-content ' v-html='"是否通知："'>
                            
                        </span>
                        </div>
                        </template>
<a-radio-group data-event class='webVueAntRadio webVueAntYtRadioStyle-mvnel6z webVueAntYtRadioStyle-mv webVueAntYtRadioStyle' v-model:value='OperatingRulesform2.Notifyvalue6' :options='[{"label":"是","value":"是","disabled":false,"select":false},{"label":"否","value":"否","disabled":false,"select":true}]'>
                            
                        </a-radio-group>
                        </a-form-item>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="6.70000%" left="0.70000%" bottom="3.20000%" right="1.40000%" gridColumnStart="7" gridColumnEnd="46" gridRowStart="61" gridRowEnd="66" zIndex="20" previewType="AdaptiveWH">
                <a-form-item ref='ref4420' class='webVueAntInputNumberFormItem webVueAntYtInputNumberFormItem-mvxt2iz  webVueAntYtInputNumberFormItem-mv webVueAntYtInputNumberFormItem show-label-mv show-label' name='Reservedcarnumbervalue2' :colon='false' :rules='[]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"预约车位数："'>
                            
                        </span>
                        </div>
                        </template>
<a-input-number data-event class='webVueAntInputNumber webVueAntYtInputNumberStyle-mv8cyir webVueAntYtInputNumberStyle-mv webVueAntYtInputNumberStyle' v-model:value='OperatingRulesform2.Reservedcarnumbervalue2' :placeholder='"请输入"' :max='100' :min='0' :precision='2'>
                            
                        </a-input-number>
                        </a-form-item>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="6.70000%" left="0.00000%" bottom="3.20000%" right="0.60000%" gridColumnStart="54" gridColumnEnd="94" gridRowStart="61" gridRowEnd="66" zIndex="18" previewType="AdaptiveWH">
                <a-form-item ref='ref4421' class='webVueAntInputNumberFormItem webVueAntYtInputNumberFormItem-mvernqg  webVueAntYtInputNumberFormItem-mv webVueAntYtInputNumberFormItem show-label-mv show-label' name='Appointmenttimeoutdurationvalue2' :colon='false' :rules='[]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"预约超时时长："'>
                            
                        </span>
                        </div>
                        </template>
<a-input-number data-event class='webVueAntInputNumber webVueAntYtInputNumberStyle-mvgnkv1 webVueAntYtInputNumberStyle-mv webVueAntYtInputNumberStyle' v-model:value='OperatingRulesform2.Appointmenttimeoutdurationvalue2' :placeholder='"请输入"' :max='100' :min='0' :precision='2'>
                            
                        </a-input-number>
                        </a-form-item>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="27.40000%" left="39.20000%" bottom="6.80000%" right="42.60000%" gridColumnStart="3" gridColumnEnd="5" gridRowStart="75" gridRowEnd="78" zIndex="21" previewType="AdaptiveWH">
                <div ref='ref4422' class='webVueAntYtRectangle webVueAntYtRectangleStyle-mvsv6ey webVueAntYtRectangleStyle-mv webVueAntYtRectangleStyle'>
                            
                        </div>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='width' comWidth='57.00px' top="13.50000%" left="9.00000%" bottom="16.10000%" right="4.70000%" gridColumnStart="5" gridColumnEnd="13" gridRowStart="75" gridRowEnd="79" zIndex="22" previewType="AdaptiveWH">
                <span ref='ref4423' class='webVueAntYtSpan webVueAntYtSpanStyle-mvxv9q3  webVueAntYtSpanStyle-mv webVueAntYtSpanStyle webVueAntYtSpanBrCount-mv webVueAntYtSpanBrCount'>
                            <span v-html='"扫码配置"'>
                            
                        </span>
                        </span>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="4.20000%" left="0.30000%" bottom="18.40000%" right="2.70000%" gridColumnStart="9" gridColumnEnd="38" gridRowStart="81" gridRowEnd="85" zIndex="23" previewType="AdaptiveWH">
                <a-form-item ref='ref4424' class='webVueAntRadioFormItem webVueAntYtRadioFormItem-mv0zurl  webVueAntYtRadioFormItem-mv webVueAntYtRadioFormItem show-label-mv show-label' name='AppearanceSweepCodevalue2' :colon='false' :rules='[]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"出场扫码："'>
                            
                        </span>
                        </div>
                        </template>
<a-radio-group data-event class='webVueAntRadio webVueAntYtRadioStyle-mv0osuw webVueAntYtRadioStyle-mv webVueAntYtRadioStyle' v-model:value='OperatingRulesform2.AppearanceSweepCodevalue2' :options='[{"label":"开启","value":"开启","disabled":false,"select":false},{"label":"关闭","value":"关闭","disabled":false,"select":true}]'>
                            
                        </a-radio-group>
                        </a-form-item>
            </yt-grid-item>
        
            </yt-grid>
            
                        </a-form> -->
            </yt-grid-item>
        
            <!-- 拓展信息 -->
            <!-- <yt-grid-item fixedSize='selfAdaption' :isShow='false' top="0.00000%" left="0.00000%" bottom="0.00000%" right="0.00000%" gridColumnStart="1" gridColumnEnd="101" gridRowStart="1" gridRowEnd="101" zIndex="3" previewType="AdaptiveWH"> -->
            <yt-grid-item fixedSize='selfAdaption' :isShow='NewYardDynamicPanelselectKey1 == "6"' top="0.00000%" left="0.00000%" bottom="0.00000%" right="0.00000%" gridColumnStart="1" gridColumnEnd="101" gridRowStart="1" gridRowEnd="101" zIndex="3" previewType="AdaptiveWH">
                <a-form ref='ref4425' :model='Expandinformationform2' :class='["webVueAntForm","webVueAntYtFormStyle-mv","webVueAntYtFormStyle"]'>
                            
            <yt-grid  previewType="AdaptiveWH" width="100%" height="100%">
                
            <yt-grid-item fixedSize='selfAdaption' top="6.20000%" left="0.30000%" bottom="3.70000%" right="1.50000%" gridColumnStart="9" gridColumnEnd="46" gridRowStart="8" gridRowEnd="13" zIndex="1" previewType="AdaptiveWH">
                <a-form-item ref='ref4426' class='webVueAntInputFormItem webVueAntYtInputFormItem-mvij4r9  webVueAntYtInputFormItem-mv webVueAntYtInputFormItem show-label-mv show-label' name='PropertyUnitvalue2' :colon='false' :rules='[]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"产权单位："'>
                            
                        </span>
                        </div>
                        </template>
<a-input data-event class='webVueAntinput webVueAntYtInputStyle-mvi4n4s webVueAntYtInputStyle-mv webVueAntYtInputStyle' v-model:value='Expandinformationform2.PropertyUnitvalue2' :maxLength='100' :placeholder='"请输入"'>
                            
                        </a-input>
                        </a-form-item>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="6.20000%" left="2.50000%" bottom="3.70000%" right="1.80000%" gridColumnStart="59" gridColumnEnd="97" gridRowStart="8" gridRowEnd="13" zIndex="2" previewType="AdaptiveWH">
                <a-form-item ref='ref4427' class='webVueAntInputFormItem webVueAntYtInputFormItem-mv5h4tl  webVueAntYtInputFormItem-mv webVueAntYtInputFormItem show-label-mv show-label' name='BuildingPropertiesvalue2' :colon='false' :rules='[]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"建筑属性："'>
                            
                        </span>
                        </div>
                        </template>
<a-input data-event class='webVueAntinput webVueAntYtInputStyle-mvn9x27 webVueAntYtInputStyle-mv webVueAntYtInputStyle' v-model:value='Expandinformationform2.BuildingPropertiesvalue2' :maxLength='100' :placeholder='"请输入"'>
                            
                        </a-input>
                        </a-form-item>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="8.20000%" left="1.00000%" bottom="1.70000%" right="1.10000%" gridColumnStart="7" gridColumnEnd="46" gridRowStart="47" gridRowEnd="52" zIndex="3" previewType="AdaptiveWH">
                <a-form-item ref='ref4428' class='webVueAntInputFormItem webVueAntYtInputFormItem-mvcg82r  webVueAntYtInputFormItem-mv webVueAntYtInputFormItem show-label-mv show-label' name='LicenseNumbervalue2' :colon='false' :rules='[]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"许可证编号："'>
                            
                        </span>
                        </div>
                        </template>
<a-input data-event class='webVueAntinput webVueAntYtInputStyle-mvq204k webVueAntYtInputStyle-mv webVueAntYtInputStyle' v-model:value='Expandinformationform2.LicenseNumbervalue2' :disabled='false' :maxLength='100' :placeholder='"请输入"'>
                            
                        </a-input>
                        </a-form-item>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="9.70000%" left="0.30000%" bottom="15.20000%" right="1.50000%" gridColumnStart="9" gridColumnEnd="46" gridRowStart="54" gridRowEnd="60" zIndex="4" previewType="AdaptiveWH">
                <a-form-item ref='ref4429' class='webVueAntInputFormItem webVueAntYtInputFormItem-mv4z5g0  webVueAntYtInputFormItem-mv webVueAntYtInputFormItem show-label-mv show-label' name='BusinessScopevalue2' :colon='false' :rules='[]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"经营范围："'>
                            
                        </span>
                        </div>
                        </template>
<a-input data-event class='webVueAntinput webVueAntYtInputStyle-mvfqagi webVueAntYtInputStyle-mv webVueAntYtInputStyle' v-model:value='Expandinformationform2.BusinessScopevalue2' :disabled='false' :maxLength='100' :placeholder='"请输入"'>
                            
                        </a-input>
                        </a-form-item>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="27.00000%" left="45.20000%" bottom="7.20000%" right="36.50000%" gridColumnStart="3" gridColumnEnd="5" gridRowStart="3" gridRowEnd="6" zIndex="5" previewType="AdaptiveWH">
                <div ref='ref4430' class='webVueAntYtRectangle webVueAntYtRectangleStyle-mvlhfaq webVueAntYtRectangleStyle-mv webVueAntYtRectangleStyle'>
                            
                        </div>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='width' comWidth='58.00px' top="13.20000%" left="10.50000%" bottom="16.30000%" right="1.60000%" gridColumnStart="5" gridColumnEnd="13" gridRowStart="3" gridRowEnd="7" zIndex="6" previewType="AdaptiveWH">
                <span ref='ref4431' class='webVueAntYtSpan webVueAntYtSpanStyle-mv0fm0l  webVueAntYtSpanStyle-mv webVueAntYtSpanStyle webVueAntYtSpanBrCount-mv webVueAntYtSpanBrCount'>
                            <span v-html='"基本信息"'>
                            
                        </span>
                        </span>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="21.50000%" left="2.60000%" bottom="12.70000%" right="61.00000%" gridColumnStart="4" gridColumnEnd="5" gridRowStart="41" gridRowEnd="44" zIndex="7" previewType="AdaptiveWH">
                <div ref='ref4432' class='webVueAntYtRectangle webVueAntYtRectangleStyle-mvxke9f webVueAntYtRectangleStyle-mv webVueAntYtRectangleStyle'>
                            
                        </div>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='width' comWidth='57.00px' top="5.60000%" left="12.00000%" bottom="20.50000%" right="1.60000%" gridColumnStart="5" gridColumnEnd="13" gridRowStart="41" gridRowEnd="45" zIndex="8" previewType="AdaptiveWH">
                <span ref='ref4433' class='webVueAntYtSpan webVueAntYtSpanStyle-mvamlte  webVueAntYtSpanStyle-mv webVueAntYtSpanStyle webVueAntYtSpanBrCount-mv webVueAntYtSpanBrCount'>
                            <span v-html='"许可信息"'>
                            
                        </span>
                        </span>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="1.60000%" left="0.30000%" bottom="8.30000%" right="1.50000%" gridColumnStart="9" gridColumnEnd="46" gridRowStart="23" gridRowEnd="28" zIndex="12" previewType="AdaptiveWH">
                <a-form-item ref='ref4434' class='webVueAntInputFormItem webVueAntYtInputFormItem-mvtz6ok  webVueAntYtInputFormItem-mv webVueAntYtInputFormItem show-label-mv show-label' name='Contactvalue2' :colon='false' :rules='[]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"联系人："'>
                            
                        </span>
                        </div>
                        </template>
<a-input data-event class='webVueAntinput webVueAntYtInputStyle-mvz6sb6 webVueAntYtInputStyle-mv webVueAntYtInputStyle' v-model:value='Expandinformationform2.Contactvalue2' :maxLength='100' :placeholder='"请输入"'>
                            
                        </a-input>
                        </a-form-item>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="1.60000%" left="2.50000%" bottom="8.30000%" right="1.80000%" gridColumnStart="59" gridColumnEnd="97" gridRowStart="23" gridRowEnd="28" zIndex="13" previewType="AdaptiveWH">
                <a-form-item ref='ref4435' class='webVueAntInputFormItem webVueAntYtInputFormItem-mv76kuz  webVueAntYtInputFormItem-mv webVueAntYtInputFormItem show-label-mv show-label' name='ContactPhonevalue3' :colon='false' :rules='[]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"联系电话："'>
                            
                        </span>
                        </div>
                        </template>
<a-input data-event class='webVueAntinput webVueAntYtInputStyle-mv51hwv webVueAntYtInputStyle-mv webVueAntYtInputStyle' v-model:value='Expandinformationform2.ContactPhonevalue3' :maxLength='100' :placeholder='"请输入"'>
                            
                        </a-input>
                        </a-form-item>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="3.90000%" left="0.10000%" bottom="6.00000%" right="0.80000%" gridColumnStart="9" gridColumnEnd="97" gridRowStart="30" gridRowEnd="40" zIndex="14" previewType="AdaptiveWH">
                <a-form-item ref='ref4436' class='webVueAntInputFormItem webVueAntYtInputFormItem-mvvkzjr  webVueAntYtInputFormItem-mv webVueAntYtInputFormItem show-label-mv show-label' name='Expandinformationvalue2' :colon='false' :rules='[]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"产权描述："'>
                            
                        </span>
                        </div>
                        </template>
<a-input data-event class='webVueAntinput webVueAntYtInputStyle-mvmq92x webVueAntYtInputStyle-mv webVueAntYtInputStyle' v-model:value='Expandinformationform2.Expandinformationvalue2' :maxLength='100' :placeholder='"请输入"'>
                            
                        </a-input>
                        </a-form-item>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="20.10000%" left="2.60000%" bottom="14.20000%" right="61.00000%" gridColumnStart="4" gridColumnEnd="5" gridRowStart="62" gridRowEnd="65" zIndex="9" previewType="AdaptiveWH">
                <div ref='ref4437' class='webVueAntYtRectangle webVueAntYtRectangleStyle-mv130mh webVueAntYtRectangleStyle-mv webVueAntYtRectangleStyle'>
                            
                        </div>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='width' comWidth='57.00px' top="4.50000%" left="12.00000%" bottom="21.60000%" right="1.60000%" gridColumnStart="5" gridColumnEnd="13" gridRowStart="62" gridRowEnd="66" zIndex="10" previewType="AdaptiveWH">
                <span ref='ref4438' class='webVueAntYtSpan webVueAntYtSpanStyle-mv71u15  webVueAntYtSpanStyle-mv webVueAntYtSpanStyle webVueAntYtSpanBrCount-mv webVueAntYtSpanBrCount'>
                            <span v-html='"相关附件"'>
                            
                        </span>
                        </span>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="10.40000%" left="2.50000%" bottom="14.50000%" right="1.80000%" gridColumnStart="59" gridColumnEnd="97" gridRowStart="15" gridRowEnd="21" zIndex="15" previewType="AdaptiveWH">
                <a-form-item ref='ref4440' class='webVueAntInputFormItem webVueAntYtInputFormItem-mvqr9y5  webVueAntYtInputFormItem-mv webVueAntYtInputFormItem show-label-mv show-label' name='Servicelifevalue2' :colon='false' :rules='[]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"使用年限："'>
                            
                        </span>
                        </div>
                        </template>
<a-input data-event class='webVueAntinput webVueAntYtInputStyle-mv42nla webVueAntYtInputStyle-mv webVueAntYtInputStyle' v-model:value='Expandinformationform2.Servicelifevalue2' :maxLength='100' :placeholder='"请输入"'>
                            
                        </a-input>
                        </a-form-item>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="10.40000%" left="0.30000%" bottom="14.50000%" right="1.50000%" gridColumnStart="9" gridColumnEnd="46" gridRowStart="15" gridRowEnd="21" zIndex="17" previewType="AdaptiveWH">
                <a-form-item ref='ref9387' class='webVueAntDatePickerFormItem webVueAntYtDatePickerFormItem-mvmixhr  webVueAntYtDatePickerFormItem-mv webVueAntYtDatePickerFormItem show-label-mv show-label' name='Constructiontimevalue2' :colon='false' :rules='[]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"建设时间："'>
                            
                        </span>
                        </div>
                        </template>
<yt-custom-date-piker data-event class='webVueAntYtDatePickerStyle-mv1t9l5 webVueAntYtDatePickerStyle-mv webVueAntYtDatePickerStyle' popupKey='"popupKey" "popupKeyId"' v-model:value='Expandinformationform2.Constructiontimevalue2' :placeholder='"请输入"'>
                            
                        </yt-custom-date-piker>
                        </a-form-item>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="8.20000%" left="2.50000%" bottom="1.70000%" right="1.80000%" gridColumnStart="59" gridColumnEnd="97" gridRowStart="47" gridRowEnd="52" zIndex="16" previewType="AdaptiveWH">
                <a-form-item ref='ref9388' class='webVueAntRangePickerFormItem webVueAntYtRangePickerFormItem-mvxwat0  webVueAntYtRangePickerFormItem-mv webVueAntYtRangePickerFormItem show-label-mv show-label' name='ValidityPeriodvalue2' :colon='false' :rules='[]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"有效期："'>
                            
                        </span>
                        </div>
                        </template>
<yt-custom-range-picker data-event class='webVueAntYtRangePicker webVueAntYtRangePickerStyle-mvkvyfu webVueAntYtRangePickerStyle-mv webVueAntYtRangePickerStyle' popupKey='"popupKey" "popupKeyId"' v-model:value='Expandinformationform2.ValidityPeriodvalue2'>
                            
                        </yt-custom-range-picker>
                        </a-form-item>
            </yt-grid-item>

            <!-- 新增-附件上传 -->
            <yt-grid-item fixedSize='selfAdaption' top="9.00000%" left="0.40000%" bottom="15.90000%" right="1.00000%" gridColumnStart="9" gridColumnEnd="32" gridRowStart="66" gridRowEnd="72" zIndex="18" previewType="AdaptiveWH">
                <a-form-item ref='ref7642' class='webVueAntUploadButton webVueAntUploadButtonFormItem-mvdvuxq webVueAntUploadButtonStyle-mvebg41  webVueAntUploadButtonFormItem-mv webVueAntUploadButtonFormItem webVueAntUploadButtonStyle-mv webVueAntUploadButtonStyle show-label-mv show-label' name='AttachmentUploadfileList1' :colon='false' :rules='[]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"附件上传："'>
                            
                        </span>
                        </div>
                        </template>

                        <a-upload action="/api/common/uploadFile"
                          :multiple="true"
                          :max-count="10"
                          :file-list="Expandinformationform2.AttachmentUploadfileList2"
                          @change="handleChangeAttachmentUploadfileList2"
                        >
                        <a-button>
                          <upload-outlined></upload-outlined>
                          点击上传
                        </a-button>
                      </a-upload>
<!-- <yt-upload-button-inner data-event v-model:fileList='Expandinformationform2.AttachmentUploadfileList2' :showUploadList='true' :accept='"image/*"' :maxCount='9'>
                            
                        </yt-upload-button-inner> -->
                        </a-form-item>
            </yt-grid-item>
        
            </yt-grid>
            
                        </a-form>
            </yt-grid-item>
        
            <!-- 岗亭管理 -->
            <!-- <yt-grid-item fixedSize='selfAdaption' :isShow='false' marginBottom='-28px' marginRight='-28px' top="0.20000%" left="0.60000%" bottom="0.00000%" right="0.00000%" gridColumnStart="4" gridColumnEnd="101" gridRowStart="5" gridRowEnd="101" zIndex="4" previewType="AdaptiveWH"> -->
            <yt-grid-item fixedSize='selfAdaption' :isShow='NewYardDynamicPanelselectKey1 == "5"' top="0.20000%" left="0.60000%" bottom="0.00000%" right="0.00000%" gridColumnStart="1" gridColumnEnd="101" gridRowStart="1" gridRowEnd="101" zIndex="4" previewType="AdaptiveWH">
                <a-form ref='ref4447' :model='PostManagementNewform1' :class='["webVueAntForm","webVueAntYtFormStyle-mv","webVueAntYtFormStyle"]'>
                            
            <yt-grid  previewType="AdaptiveWH" width="100%" height="100%">
                
            <yt-grid-item fixedSize='selfAdaption' top="3.40000%" left="45.60000%" bottom="30.70000%" right="36.10000%" gridColumnStart="3" gridColumnEnd="5" gridRowStart="4" gridRowEnd="7" zIndex="1" previewType="AdaptiveWH">
                <div ref='ref4449' class='webVueAntYtRectangle webVueAntYtRectangleStyle-mv6rc1k webVueAntYtRectangleStyle-mv webVueAntYtRectangleStyle'>
                            
                        </div>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='width' comWidth='57.00px' top="20.50000%" left="10.60000%" bottom="8.90000%" right="2.80000%" gridColumnStart="5" gridColumnEnd="13" gridRowStart="3" gridRowEnd="7" zIndex="2" previewType="AdaptiveWH">
                <span ref='ref4450' class='webVueAntYtSpan webVueAntYtSpanStyle-mvutvff  webVueAntYtSpanStyle-mv webVueAntYtSpanStyle webVueAntYtSpanBrCount-mv webVueAntYtSpanBrCount'>
                            <span v-html='"岗亭管理"'>
                            
                        </span>
                        </span>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="12.20000%" left="2.10000%" bottom="12.50000%" right="1.60000%" gridColumnStart="5" gridColumnEnd="45" gridRowStart="10" gridRowEnd="16" zIndex="3" previewType="AdaptiveWH">
                <a-form-item ref='ref5240' class='webVueAntInputFormItem webVueAntYtInputFormItem-mv8lagz  webVueAntYtInputFormItem-mv webVueAntYtInputFormItem show-label-mv show-label' name='Namevalue1' :colon='false' :rules='[]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"姓名："'>
                            
                        </span>
                        </div>
                        </template>
<a-input data-event class='webVueAntinput webVueAntYtInputStyle-mve95nu webVueAntYtInputStyle-mv webVueAntYtInputStyle' v-model:value='PostManagementNewform1.Namevalue1' :maxLength='100' :placeholder='"请输入"'>
                            
                        </a-input>
                        </a-form-item>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="12.20000%" left="1.60000%" bottom="12.50000%" right="0.60000%" gridColumnStart="57" gridColumnEnd="98" gridRowStart="10" gridRowEnd="16" zIndex="4" previewType="AdaptiveWH">
                <a-form-item ref='ref5241' class='webVueAntInputFormItem webVueAntYtInputFormItem-mve38v3  webVueAntYtInputFormItem-mv webVueAntYtInputFormItem show-label-mv show-label' name='Mobilephonenumbervalue1' :colon='false' :rules='[]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"手机号："'>
                            
                        </span>
                        </div>
                        </template>
<a-input data-event class='webVueAntinput webVueAntYtInputStyle-mv7r26c webVueAntYtInputStyle-mv webVueAntYtInputStyle' v-model:value='PostManagementNewform1.Mobilephonenumbervalue1' :maxLength='100' :placeholder='"请输入"'>
                            
                        </a-input>
                        </a-form-item>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="8.10000%" left="0.60000%" bottom="16.60000%" right="1.60000%" gridColumnStart="4" gridColumnEnd="45" gridRowStart="18" gridRowEnd="24" zIndex="5" previewType="AdaptiveWH">
                <a-form-item ref='ref5242' class='webVueAntInputFormItem webVueAntYtInputFormItem-mve57mk  webVueAntYtInputFormItem-mv webVueAntYtInputFormItem show-label-mv show-label' name='IdentityCardvalue1' :colon='false' :rules='[]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"身份证："'>
                            
                        </span>
                        </div>
                        </template>
<a-input data-event class='webVueAntinput webVueAntYtInputStyle-mv8thsr webVueAntYtInputStyle-mv webVueAntYtInputStyle' v-model:value='PostManagementNewform1.IdentityCardvalue1' :maxLength='100' :placeholder='"请输入"'>
                            
                        </a-input>
                        </a-form-item>
            </yt-grid-item>
        
            </yt-grid>
            
                        </a-form>
            </yt-grid-item>
        
            <!-- 计费规则 -->
            <!-- <yt-grid-item fixedSize='selfAdaption' :isShow='false' marginBottom='-28px' marginRight='-28px' top="0.20000%" left="0.60000%" bottom="0.00000%" right="0.00000%" gridColumnStart="4" gridColumnEnd="101" gridRowStart="5" gridRowEnd="101" zIndex="5" previewType="AdaptiveWH"> -->
            <!-- <yt-grid-item fixedSize='selfAdaption' :isShow='NewYardDynamicPanelselectKey1 == "4"' top="0.20000%" left="0.60000%" bottom="0.00000%" right="0.00000%" gridColumnStart="4" gridColumnEnd="101" gridRowStart="5" gridRowEnd="101" zIndex="5" previewType="AdaptiveWH"> -->
            <yt-grid-item fixedSize='selfAdaption' :isShow='NewYardDynamicPanelselectKey1 == "4"' top="0.20000%" left="0.60000%" bottom="0.00000%" right="0.00000%" gridColumnStart="1" gridColumnEnd="101" gridRowStart="1" gridRowEnd="101" zIndex="5" previewType="AdaptiveWH">
                <a-form ref='ref4451' :model='BillingRulesNewform1' :class='["webVueAntForm","webVueAntYtFormStyle-mv","webVueAntYtFormStyle"]'>
                            
            <yt-grid  previewType="AdaptiveWH" width="100%" height="100%">
                
            <yt-grid-item fixedSize='selfAdaption' top="3.10000%" left="45.20000%" bottom="31.20000%" right="36.50000%" gridColumnStart="3" gridColumnEnd="5" gridRowStart="4" gridRowEnd="7" zIndex="1" previewType="AdaptiveWH">
                <div ref='ref4453' class='webVueAntYtRectangle webVueAntYtRectangleStyle-mvo8rle webVueAntYtRectangleStyle-mv webVueAntYtRectangleStyle'>
                            
                        </div>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='width' comWidth='57.00px' top="20.30000%" left="10.50000%" bottom="9.30000%" right="3.20000%" gridColumnStart="5" gridColumnEnd="13" gridRowStart="3" gridRowEnd="7" zIndex="2" previewType="AdaptiveWH">
                <span ref='ref4454' class='webVueAntYtSpan webVueAntYtSpanStyle-mvdqafj  webVueAntYtSpanStyle-mv webVueAntYtSpanStyle webVueAntYtSpanBrCount-mv webVueAntYtSpanBrCount'>
                            <span v-html='"计费规则"'>
                            
                        </span>
                        </span>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' :isShow='RuleNameisShow1' top="14.60000%" left="0.00000%" bottom="10.30000%" right="0.00000%" gridColumnStart="4" gridColumnEnd="44" gridRowStart="8" gridRowEnd="14" zIndex="3" previewType="AdaptiveWH">
                <a-form-item ref='ref9389' class='webVueSelectFormItem webVueAntYtSelectFormItem-mvvoo80  webVueAntYtSelectFormItem-mv webVueAntYtSelectFormItem show-label-mv show-label' name='RuleNamevalue1' :colon='false' :rules='[]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"规则名称："'>
                            
                        </span>
                        </div>
                        </template>
<a-select data-event class='webVueSelect  webVueAntYtSelectStyle-mv webVueAntYtSelectStyle' dropdownClassName='"popupKey" "popupKeyId"' :showArrow='true' v-model:value='BillingRulesNewform1.RuleNamevalue1' :placeholder='"请输入"' :mode='"single"' :options='RuleNameoptions1.dataSource' :showSearch='true'>
                            
                        </a-select>
                        </a-form-item>
            </yt-grid-item>
        
            </yt-grid>
            
                        </a-form>
            </yt-grid-item>
        
            </yt-grid>
            
                        </yt-dynamic-panel>
            </yt-grid-item>
        
             </div>
            
                        </a-form>
                        </template>
                        </yt-custom-modal>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' :isShow='yardeditorisShow1' id="yt-4wmcem244irou" gridColumnStart="370" gridColumnEnd="1330" gridRowStart="98" gridRowEnd="919" zIndex="18" previewType="FixedWH">
                <yt-custom-modal ref='ref4455' @ok="()=> { handleSaveYardEdit(); }" @cancel="()=> { handleCancelYardEdit(); }" class='webVueAntYtModal webVueAntYtModalStyle-mvlhsvc webVueAntYtModalStyle-mv webVueAntYtModalStyle' v-model:isShow='yardeditorisShow1' :title='"车场编辑"' :okText='"保存"' :maskClosable='true'>
                            <template #content>
                            <a-form class='webVueAntForm ' :model='yardeditorform1' ref='ref4455_form'>
                            
            <div style="display:grid;width:100%;height:100%;grid-template-columns: repeat(auto-fill, 1%);grid-template-rows: repeat(auto-fill, 1%);position: relative;">
            
            <yt-grid-item fixedSize='selfAdaption' :isShow='YardEditMenuisShow1' marginLeft='-13px' top="0.00000%" left="0.00000%" bottom="0.00000%" right="5.80000%" gridColumnStart="1" gridColumnEnd="15" gridRowStart="1" gridRowEnd="101" zIndex="1" previewType="FitScreen">
                <yt-vertical-menu-menu ref='ref4456' @click_to_jump="()=> { handleYardEditMenuSelection(); }" class='webVueAntYtVerticleMenu webVueAntYtVerticleMenuStyle-mvcr8o0 webVueAntYtVerticleMenuStyle-mv webVueAntYtVerticleMenuStyle' v-model:openKeys='YardEditMenuopenKeys1' v-model:selectedKeys='YardEditMenuselectedKeys1' :items='YardEditMenuoptions1.dataSource'>
                            
                        </yt-vertical-menu-menu>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="0.00000%" left="0.20000%" bottom="0.00000%" right="0.00000%" gridColumnStart="14" gridColumnEnd="101" gridRowStart="1" gridRowEnd="101" zIndex="2" previewType="FitScreen">
                <yt-dynamic-panel ref='ref4457' class='webVueAntYtDynamicPanel ' mutileStyle='[{"statusId":"1","info":{}},{"statusId":"2","info":{}},{"statusId":"3","info":{}},{"statusId":"4","info":{}},{"statusId":"5","info":{}},{"statusId":"6","info":{}}]'>
                            
            <yt-grid  previewType="AdaptiveWH" width="100%" height="100%">
                
            <!-- 基础信息 -->
            <!-- <yt-grid-item fixedSize='selfAdaption' :isShow='false' top="0.00000%" left="0.00000%" bottom="0.00000%" right="0.00000%" gridColumnStart="1" gridColumnEnd="101" gridRowStart="1" gridRowEnd="101" zIndex="1" previewType="AdaptiveWH"> -->
            <yt-grid-item fixedSize='selfAdaption' :isShow='YardEditDynamicPanelselectKey1 == "1"' top="0.00000%" left="0.00000%" bottom="0.00000%" right="0.00000%" gridColumnStart="1" gridColumnEnd="101" gridRowStart="1" gridRowEnd="101" zIndex="1" previewType="AdaptiveWH">
                <a-form ref='ref4458' :model='Basicinformationform3' :class='["webVueAntForm","webVueAntYtFormStyle-mv","webVueAntYtFormStyle"]'>
                            
            <yt-grid  previewType="AdaptiveWH" width="100%" height="154.71167369901545%">
                
            <yt-grid-item fixedSize='selfAdaption' top="18.10000%" left="0.30000%" bottom="9.00000%" right="1.50000%" gridColumnStart="9" gridColumnEnd="46" gridRowStart="5" gridRowEnd="9" zIndex="1" previewType="AdaptiveWH">
                <a-form-item ref='ref4459' class='webVueAntInputFormItem webVueAntYtInputFormItem-mvl57fx  webVueAntYtInputFormItem-mv webVueAntYtInputFormItem show-label-mv show-label' name='yardnumbervalue3' :colon='false' :rules='[]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"车场编号："'>
                            
                        </span>
                        </div>
                        </template>
<a-input data-event class='webVueAntinput webVueAntYtInputStyle-mvexthv webVueAntYtInputStyle-mv webVueAntYtInputStyle' v-model:value='Basicinformationform3.yardnumbervalue3' :disabled='true' :maxLength='100' :placeholder='"请输入"'>
                            
                        </a-input>
                        </a-form-item>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="15.90000%" left="0.30000%" bottom="11.30000%" right="1.80000%" gridColumnStart="58" gridColumnEnd="97" gridRowStart="5" gridRowEnd="9" zIndex="2" previewType="AdaptiveWH">
                <a-form-item ref='ref4460' class='webVueAntInputFormItem webVueAntYtInputFormItem-mvwhold  webVueAntYtInputFormItem-mv webVueAntYtInputFormItem show-label-mv show-label' name='Nameofyard1value3' :colon='false' :rules='[{"required":true,"message":"必填"}]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"车场名称："'>
                            
                        </span>
                        </div>
                        </template>
<a-input data-event class='webVueAntinput webVueAntYtInputStyle-mvgeipk webVueAntYtInputStyle-mv webVueAntYtInputStyle' v-model:value='Basicinformationform3.Nameofyard1value3' :disabled='false' :maxLength='100' :placeholder='"请输入"'>
                            
                        </a-input>
                        </a-form-item>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="11.30000%" left="2.50000%" bottom="15.90000%" right="1.80000%" gridColumnStart="59" gridColumnEnd="97" gridRowStart="10" gridRowEnd="14" zIndex="3" previewType="AdaptiveWH">
                <a-form-item ref='ref4461' class='webVueAntInputFormItem webVueAntYtInputFormItem-mvk3kzp  webVueAntYtInputFormItem-mv webVueAntYtInputFormItem show-label-mv show-label' name='Yardabbreviationvalue3' :colon='false' :rules='[]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"车场简称："'>
                            
                        </span>
                        </div>
                        </template>
<a-input data-event class='webVueAntinput webVueAntYtInputStyle-mv4ptis webVueAntYtInputStyle-mv webVueAntYtInputStyle' v-model:value='Basicinformationform3.Yardabbreviationvalue3' :disabled='false' :maxLength='100' :placeholder='"请输入"'>
                            
                        </a-input>
                        </a-form-item>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="18.10000%" left="1.30000%" bottom="9.00000%" right="1.70000%" gridColumnStart="7" gridColumnEnd="46" gridRowStart="27" gridRowEnd="31" zIndex="4" previewType="AdaptiveWH">
                <a-form-item ref='ref4462' class='webVueAntInputFormItem webVueAntYtInputFormItem-mvym2xi  webVueAntYtInputFormItem-mv webVueAntYtInputFormItem show-label-mv show-label' name='Numberofparkingvalue3' :colon='false' :rules='[{"required":true,"message":"必填"}]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"泊车数量："'>
                            
                        </span>
                        </div>
                        </template>
<a-input data-event class='webVueAntinput webVueAntYtInputStyle-mvb32jn webVueAntYtInputStyle-mv webVueAntYtInputStyle' v-model:value='Basicinformationform3.Numberofparkingvalue3' :maxLength='100' :placeholder='"请输入"'>
                            
                        </a-input>
                        </a-form-item>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="4.50000%" left="0.50000%" bottom="22.70000%" right="1.20000%" gridColumnStart="60" gridColumnEnd="97" gridRowStart="37" gridRowEnd="41" zIndex="5" previewType="AdaptiveWH">
                <a-form-item ref='ref4463' class='webVueAntInputFormItem webVueAntYtInputFormItem-mvc75fw  webVueAntYtInputFormItem-mv webVueAntYtInputFormItem show-label-mv show-label' name='Longtermrentalparkingspacesvalue3' :colon='false' :rules='[]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"长租车位："'>
                            
                        </span>
                        </div>
                        </template>
<a-input data-event class='webVueAntinput webVueAntYtInputStyle-mvdub0v webVueAntYtInputStyle-mv webVueAntYtInputStyle' v-model:value='Basicinformationform3.Longtermrentalparkingspacesvalue3' :disabled='true' :maxLength='100' :placeholder='"自动同步"'>
                            
                        </a-input>
                        </a-form-item>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="4.50000%" left="2.60000%" bottom="22.70000%" right="1.80000%" gridColumnStart="8" gridColumnEnd="46" gridRowStart="37" gridRowEnd="41" zIndex="6" previewType="AdaptiveWH">
                <a-form-item ref='ref4464' class='webVueAntInputFormItem webVueAntYtInputFormItem-mvcsnl8  webVueAntYtInputFormItem-mv webVueAntYtInputFormItem show-label-mv show-label' name='Reservationofparkingspacevalue3' :colon='false' :rules='[]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"预约车位："'>
                            
                        </span>
                        </div>
                        </template>
<a-input data-event class='webVueAntinput webVueAntYtInputStyle-mvxbpi0 webVueAntYtInputStyle-mv webVueAntYtInputStyle' v-model:value='Basicinformationform3.Reservationofparkingspacevalue3' :disabled='true' :maxLength='100' :placeholder='"自动同步"'>
                            
                        </a-input>
                        </a-form-item>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="18.10000%" left="0.80000%" bottom="9.00000%" right="0.90000%" gridColumnStart="60" gridColumnEnd="97" gridRowStart="27" gridRowEnd="31" zIndex="7" previewType="AdaptiveWH">
                <a-form-item ref='ref4465' class='webVueAntInputFormItem webVueAntYtInputFormItem-mvq6zes  webVueAntYtInputFormItem-mv webVueAntYtInputFormItem show-label-mv show-label' name='VIPParkingvalue3' :colon='false' :rules='[]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"贵宾车位："'>
                            
                        </span>
                        </div>
                        </template>
<a-input data-event class='webVueAntinput webVueAntYtInputStyle-mvj81s5 webVueAntYtInputStyle-mv webVueAntYtInputStyle' v-model:value='Basicinformationform3.VIPParkingvalue3' :maxLength='100' :placeholder='"请输入"'>
                            
                        </a-input>
                        </a-form-item>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="11.30000%" left="0.20000%" bottom="15.90000%" right="1.60000%" gridColumnStart="60" gridColumnEnd="97" gridRowStart="32" gridRowEnd="36" zIndex="8" previewType="AdaptiveWH">
                <a-form-item ref='ref4466' class='webVueAntInputFormItem webVueAntYtInputFormItem-mvnmq28  webVueAntYtInputFormItem-mv webVueAntYtInputFormItem show-label-mv show-label' name='Numberofchargingpilesvalue3' :colon='false' :rules='[]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"充电桩数："'>
                            
                        </span>
                        </div>
                        </template>
<a-input data-event class='webVueAntinput webVueAntYtInputStyle-mvsbr1z webVueAntYtInputStyle-mv webVueAntYtInputStyle' v-model:value='Basicinformationform3.Numberofchargingpilesvalue3' :maxLength='100' :placeholder='"请输入"'>
                            
                        </a-input>
                        </a-form-item>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="27.20000%" left="45.20000%" bottom="30.30000%" right="36.50000%" gridColumnStart="3" gridColumnEnd="5" gridRowStart="2" gridRowEnd="5" zIndex="9" previewType="AdaptiveWH">
                <div ref='ref4467' class='webVueAntYtRectangle webVueAntYtRectangleStyle-mvvpq1s webVueAntYtRectangleStyle-mv webVueAntYtRectangleStyle'>
                            
                        </div>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='width' comWidth='58.00px' top="21.20000%" left="10.50000%" bottom="18.10000%" right="1.60000%" gridColumnStart="5" gridColumnEnd="13" gridRowStart="2" gridRowEnd="5" zIndex="10" previewType="AdaptiveWH">
                <span ref='ref4468' class='webVueAntYtSpan webVueAntYtSpanStyle-mvkahsb  webVueAntYtSpanStyle-mv webVueAntYtSpanStyle webVueAntYtSpanBrCount-mv webVueAntYtSpanBrCount'>
                            <span v-html='"基本信息"'>
                            
                        </span>
                        </span>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="18.10000%" left="45.20000%" bottom="18.10000%" right="36.50000%" gridColumnStart="3" gridColumnEnd="5" gridRowStart="24" gridRowEnd="26" zIndex="11" previewType="AdaptiveWH">
                <div ref='ref4469' class='webVueAntYtRectangle webVueAntYtRectangleStyle-mvzepms webVueAntYtRectangleStyle-mv webVueAntYtRectangleStyle'>
                            
                        </div>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='width' comWidth='57.00px' top="12.10000%" left="10.50000%" bottom="27.20000%" right="3.20000%" gridColumnStart="5" gridColumnEnd="13" gridRowStart="24" gridRowEnd="27" zIndex="12" previewType="AdaptiveWH">
                <span ref='ref4470' class='webVueAntYtSpan webVueAntYtSpanStyle-mvs012l  webVueAntYtSpanStyle-mv webVueAntYtSpanStyle webVueAntYtSpanBrCount-mv webVueAntYtSpanBrCount'>
                            <span v-html='"车位信息"'>
                            
                        </span>
                        </span>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="0.00000%" left="14.70000%" bottom="36.30000%" right="48.90000%" gridColumnStart="4" gridColumnEnd="5" gridRowStart="42" gridRowEnd="44" zIndex="13" previewType="AdaptiveWH">
                <div ref='ref4471' class='webVueAntYtRectangle webVueAntYtRectangleStyle-mva5nzl webVueAntYtRectangleStyle-mv webVueAntYtRectangleStyle'>
                            
                        </div>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='width' comWidth='57.00px' top="24.20000%" left="1.20000%" bottom="15.10000%" right="0.20000%" gridColumnStart="6" gridColumnEnd="13" gridRowStart="41" gridRowEnd="44" zIndex="14" previewType="AdaptiveWH">
                <span ref='ref4472' class='webVueAntYtSpan webVueAntYtSpanStyle-mv2027u  webVueAntYtSpanStyle-mv webVueAntYtSpanStyle webVueAntYtSpanBrCount-mv webVueAntYtSpanBrCount'>
                            <span v-html='"运营信息"'>
                            
                        </span>
                        </span>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="11.30000%" left="2.30000%" bottom="15.90000%" right="0.80000%" gridColumnStart="7" gridColumnEnd="46" gridRowStart="45" gridRowEnd="49" zIndex="15" previewType="AdaptiveWH">
                <a-form-item ref='ref4473' class='webVueAntInputFormItem webVueAntYtInputFormItem-mvn4zrd  webVueAntYtInputFormItem-mv webVueAntYtInputFormItem show-label-mv show-label' name='OperatingCompany1value3' :colon='false' :rules='[{"required":true,"message":"必填"}]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"运营公司："'>
                            
                        </span>
                        </div>
                        </template>
<a-input data-event class='webVueAntinput webVueAntYtInputStyle-mvax7i5 webVueAntYtInputStyle-mv webVueAntYtInputStyle' v-model:value='Basicinformationform3.OperatingCompany1value3' :disabled='false' :maxLength='100' :placeholder='"请输入"'>
                            
                        </a-input>
                        </a-form-item>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="6.80000%" left="1.20000%" bottom="20.40000%" right="1.20000%" gridColumnStart="9" gridColumnEnd="46" gridRowStart="50" gridRowEnd="54" zIndex="16" previewType="AdaptiveWH">
                <a-form-item ref='ref4474' class='webVueAntInputFormItem webVueAntYtInputFormItem-mviqrt7  webVueAntYtInputFormItem-mv webVueAntYtInputFormItem show-label-mv show-label' name='Personinchargevalue3' :colon='false' :rules='[{"required":true,"message":"必填"}]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"负责人："'>
                            
                        </span>
                        </div>
                        </template>
<a-input data-event class='webVueAntinput webVueAntYtInputStyle-mvw31cz webVueAntYtInputStyle-mv webVueAntYtInputStyle' v-model:value='Basicinformationform3.Personinchargevalue3' :disabled='false' :maxLength='100' :placeholder='"请输入"'>
                            
                        </a-input>
                        </a-form-item>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="6.80000%" left="2.20000%" bottom="20.40000%" right="0.90000%" gridColumnStart="58" gridColumnEnd="97" gridRowStart="50" gridRowEnd="54" zIndex="17" previewType="AdaptiveWH">
                <a-form-item ref='ref4475' class='webVueAntInputFormItem webVueAntYtInputFormItem-mvawtyn  webVueAntYtInputFormItem-mv webVueAntYtInputFormItem show-label-mv show-label' name='ContactPhonevalue4' :colon='false' :rules='[{"required":true,"message":"必填"}]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"联系电话："'>
                            
                        </span>
                        </div>
                        </template>
<a-input data-event class='webVueAntinput webVueAntYtInputStyle-mvqp5py webVueAntYtInputStyle-mv webVueAntYtInputStyle' v-model:value='Basicinformationform3.ContactPhonevalue4' :disabled='false' :maxLength='100' :placeholder='"请输入"'>
                            
                        </a-input>
                        </a-form-item>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="3.00000%" left="1.10000%" bottom="0.00000%" right="0.40000%" gridColumnStart="8" gridColumnEnd="97" gridRowStart="55" gridRowEnd="58" zIndex="18" previewType="AdaptiveWH">
                <a-form-item ref='ref4476' class='webVueAntInputFormItem webVueAntYtInputFormItem-mvt1as6  webVueAntYtInputFormItem-mv webVueAntYtInputFormItem show-label-mv show-label' name='latitudeandlongitudevalue3' :colon='false' :rules='[{"required":true,"message":"必填"}]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"经纬度："'>
                            
                        </span>
                        </div>
                        </template>
<a-input data-event class='webVueAntinput webVueAntYtInputStyle-mvk06aa webVueAntYtInputStyle-mv webVueAntYtInputStyle' v-model:value='Basicinformationform3.latitudeandlongitudevalue3' :disabled='false' :maxLength='100' :placeholder='"请输入"' @click="() => handleModalMap('edit')">
                            
                        </a-input>
                        </a-form-item>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="18.10000%" left="0.90000%" bottom="9.00000%" right="0.40000%" gridColumnStart="8" gridColumnEnd="97" gridRowStart="59" gridRowEnd="63" zIndex="19" previewType="AdaptiveWH">
                <a-form-item ref='ref4477' class='webVueAntInputFormItem webVueAntYtInputFormItem-mvxrtyr  webVueAntYtInputFormItem-mv webVueAntYtInputFormItem show-label-mv show-label' name='Detailedaddressvalue3' :colon='false' :rules='[]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"详细地址："'>
                            
                        </span>
                        </div>
                        </template>
<a-input data-event class='webVueAntinput webVueAntYtInputStyle-mvt5ef9 webVueAntYtInputStyle-mv webVueAntYtInputStyle' v-model:value='Basicinformationform3.Detailedaddressvalue3' :disabled='false' :maxLength='100' :placeholder='"请输入"'>
                            
                        </a-input>
                        </a-form-item>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="6.40000%" left="1.10000%" bottom="10.30000%" right="0.50000%" gridColumnStart="8" gridColumnEnd="97" gridRowStart="64" gridRowEnd="71" zIndex="20" previewType="AdaptiveWH">
                <a-form-item ref='ref4478' class='webVueAntInputFormItem webVueAntYtInputFormItem-mv7d20g  webVueAntYtInputFormItem-mv webVueAntYtInputFormItem show-label-mv show-label' name='YardDescriptionvalue3' :colon='false' :rules='[]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"车场描述："'>
                            
                        </span>
                        </div>
                        </template>
<a-input data-event class='webVueAntinput webVueAntYtInputStyle-mv3enng webVueAntYtInputStyle-mv webVueAntYtInputStyle' v-model:value='Basicinformationform3.YardDescriptionvalue3' :disabled='false' :maxLength='100' :placeholder='"请输入"'>
                            
                        </a-input>
                        </a-form-item>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="9.00000%" left="2.60000%" bottom="27.20000%" right="61.00000%" gridColumnStart="4" gridColumnEnd="5" gridRowStart="72" gridRowEnd="74" zIndex="21" previewType="AdaptiveWH">
                <div ref='ref4479' class='webVueAntYtRectangle webVueAntYtRectangleStyle-mvaiklg webVueAntYtRectangleStyle-mv webVueAntYtRectangleStyle'>
                            
                        </div>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='width' comWidth='57.00px' top="30.30000%" left="12.00000%" bottom="9.00000%" right="1.60000%" gridColumnStart="5" gridColumnEnd="13" gridRowStart="71" gridRowEnd="74" zIndex="22" previewType="AdaptiveWH">
                <span ref='ref4480' class='webVueAntYtSpan webVueAntYtSpanStyle-mv0t9ig  webVueAntYtSpanStyle-mv webVueAntYtSpanStyle webVueAntYtSpanBrCount-mv webVueAntYtSpanBrCount'>
                            <span v-html='"其他信息"'>
                            
                        </span>
                        </span>
            </yt-grid-item>
        

            <!-- <yt-grid-item fixedSize='width' comWidth='85.00px' top="12.10000%" left="2.60000%" bottom="27.20000%" right="3.70000%" gridColumnStart="7" gridColumnEnd="18" gridRowStart="80" gridRowEnd="83" zIndex="23" previewType="AdaptiveWH">
                <span ref='ref4481' class='webVueAntYtSpan webVueAntYtSpanStyle-mvaf3ga  webVueAntYtSpanStyle-mv webVueAntYtSpanStyle webVueAntYtSpanBrCount-mv webVueAntYtSpanBrCount'>
                            <span v-html='"车场二维码："'>
                            
                        </span>
                        </span>
            </yt-grid-item> -->
        

            <!-- <yt-grid-item fixedSize='selfAdaption' top="4.50000%" left="5.00000%" bottom="4.50000%" right="6.90000%" gridColumnStart="18" gridColumnEnd="29" gridRowStart="80" gridRowEnd="88" zIndex="24" previewType="AdaptiveWH">
                <div ref='ref4482' class='webVueAntYtPicture webVueAntYtPictureStyle-mvnstv1 webVueAntYtPictureStyle-mv webVueAntYtPictureStyle'>
                            <a-image :src='"./staticResource/public/yt-picture.png"' :preview='false' :style='{
        transform:"scaleX(1) scaleY(1)",
        objectFit:"contain"
      }'>
                            
                        </a-image>
                        </div>
            </yt-grid-item> -->
        

            <yt-grid-item fixedSize='selfAdaption' top="9.00000%" left="1.90000%" bottom="18.10000%" right="1.10000%" gridColumnStart="7" gridColumnEnd="46" gridRowStart="10" gridRowEnd="14" zIndex="33" previewType="AdaptiveWH">
                <a-form-item ref='ref9390' class='webVueSelectFormItem webVueAntYtSelectFormItem-mvp13q8  webVueAntYtSelectFormItem-mv webVueAntYtSelectFormItem show-label-mv show-label' name='yardstatus1value3' :colon='false' :rules='[{"required":true,"message":"必填"}]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"车场状态："'>
                            
                        </span>
                        </div>
                        </template>
<a-select data-event class='webVueSelect  webVueAntYtSelectStyle-mv webVueAntYtSelectStyle' dropdownClassName='"popupKey" "popupKeyId"' :showArrow='true' v-model:value='Basicinformationform3.yardstatus1value3' :placeholder='"请输入"' :mode='"single"' :options='optionsParkingLotStatus' :showSearch='true'>
<!-- <a-select data-event class='webVueSelect  webVueAntYtSelectStyle-mv webVueAntYtSelectStyle' dropdownClassName='"popupKey" "popupKeyId"' :showArrow='true' v-model:value='Basicinformationform3.yardstatus1value3' :placeholder='"请输入"' :mode='"single"' :options='[{"label":"使用中","value":"使用中","disabled":false,"select":false},{"label":"试运行","value":"试运行","disabled":false,"select":false},{"value":"建设中","label":"建设中","disabled":false,"select":false},{"value":"已停用","label":"已停用","disabled":false,"select":false}]' :showSearch='true'> -->
                            
                        </a-select>
                        </a-form-item>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="22.70000%" left="2.30000%" bottom="4.50000%" right="1.10000%" gridColumnStart="7" gridColumnEnd="46" gridRowStart="19" gridRowEnd="23" zIndex="34" previewType="AdaptiveWH">
                <a-form-item ref='ref9391' class='webVueSelectFormItem webVueAntYtSelectFormItem-mvwp8us  webVueAntYtSelectFormItem-mv webVueAntYtSelectFormItem show-label-mv show-label' name='Typeofyard1value3' :colon='false' :rules='[{"required":true,"message":"必填"}]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"车场类型："'>
                            
                        </span>
                        </div>
                        </template>
<a-select data-event class='webVueSelect  webVueAntYtSelectStyle-mv webVueAntYtSelectStyle' dropdownClassName='"popupKey" "popupKeyId"' :showArrow='true' v-model:value='Basicinformationform3.Typeofyard1value3' :placeholder='"请输入"' :mode='"single"' :options='optionsParkingLotType' :showSearch='true'>
<!-- <a-select data-event class='webVueSelect  webVueAntYtSelectStyle-mv webVueAntYtSelectStyle' dropdownClassName='"popupKey" "popupKeyId"' :showArrow='true' v-model:value='Basicinformationform3.Typeofyard1value3' :placeholder='"请输入"' :mode='"single"' :options='[{"label":"自营","value":"自营","disabled":false,"select":false},{"label":"托管（接入）","value":"托管（接入）","disabled":false,"select":false},{"value":"托管（未接）","label":"托管（未接）","disabled":false,"select":false}]' :showSearch='true'> -->
                            
                        </a-select>
                        </a-form-item>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="4.50000%" left="0.30000%" bottom="22.70000%" right="1.50000%" gridColumnStart="9" gridColumnEnd="46" gridRowStart="15" gridRowEnd="19" zIndex="35" previewType="AdaptiveWH">
                <a-form-item ref='ref9392' class='webVueSelectFormItem webVueAntYtSelectFormItem-mv9opql  webVueAntYtSelectFormItem-mv webVueAntYtSelectFormItem show-label-mv show-label' name='Area1value3' :colon='false' :rules='[]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"所属区域："'>
                            
                        </span>
                        </div>
                        </template>
                        <!-- <a-cascader data-event class='webVueAntYtCascader webVueAntYtCascaderStyle-mvbipu6 webVueAntYtCascaderStyle-mv webVueAntYtCascaderStyle' dropdownClassName='"popupKey" "popupKeyId"' change-on-select :showArrow='true' :placeholder='"请输入"' :multiple='true' :options='[{"value":"李沧区","label":"李沧区","disabled":false,"select":false,"children":[{"value":"XX街道","label":"XX街道","disabled":false,"select":false,"children":[{"value":"中心","label":"中心","disabled":false,"select":false}]}]}]' v-model:value='Basicinformationform3.Area1value3' :showSearch='true' :showCheckedStrategy='"SHOW_CHILD"'> -->
                        <a-cascader data-event class='webVueAntYtCascader webVueAntYtCascaderStyle-mvbipu6 webVueAntYtCascaderStyle-mv webVueAntYtCascaderStyle' dropdownClassName='"popupKey" "popupKeyId"' change-on-select :showArrow='true' :placeholder='"请输入"' :multiple='false' :options='optionsArea' v-model:value='Basicinformationform3.Area1value3' :showSearch='true' :showCheckedStrategy='"SHOW_CHILD"'>
                            
                          </a-cascader>
<!-- <a-select data-event class='webVueSelect  webVueAntYtSelectStyle-mv webVueAntYtSelectStyle' dropdownClassName='"popupKey" "popupKeyId"' :showArrow='true' v-model:value='Basicinformationform3.Area1value3' :placeholder='"请输入"' :mode='"single"' :options='[{"label":"选项1","value":"选项1","disabled":false,"select":false},{"label":"选项2","value":"选项2","disabled":false,"select":false}]' :showSearch='true'>
                            
                        </a-select> -->
                        </a-form-item>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="22.70000%" left="2.50000%" bottom="4.50000%" right="1.80000%" gridColumnStart="59" gridColumnEnd="97" gridRowStart="19" gridRowEnd="23" zIndex="28" previewType="AdaptiveWH">
                <a-form-item ref='ref9393' class='webVueSelectFormItem webVueAntYtSelectFormItem-mvxi0ub  webVueAntYtSelectFormItem-mv webVueAntYtSelectFormItem show-label-mv show-label' name='YardCategory1value3' :colon='false' :rules='[]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"车场类别："'>
                            
                        </span>
                        </div>
                        </template>
<a-select data-event class='webVueSelect  webVueAntYtSelectStyle-mv webVueAntYtSelectStyle' dropdownClassName='"popupKey" "popupKeyId"' :showArrow='true' v-model:value='Basicinformationform3.YardCategory1value3' :placeholder='"请输入"' :mode='"single"' :options='optionsParkingLotCategory' :showSearch='true'>
<!-- <a-select data-event class='webVueSelect  webVueAntYtSelectStyle-mv webVueAntYtSelectStyle' dropdownClassName='"popupKey" "popupKeyId"' :showArrow='true' v-model:value='Basicinformationform3.YardCategory1value3' :placeholder='"请输入"' :mode='"single"' :options='[{"label":"商场","value":"商场","disabled":false,"select":false},{"label":"停车楼","value":"停车楼","disabled":false,"select":false},{"value":"交通枢纽","label":"交通枢纽","disabled":false,"select":false},{"value":"医院","label":"医院","disabled":false,"select":false},{"value":"住宅社区","label":"住宅社区","disabled":false,"select":false},{"value":"商业园区","label":"商业园区","disabled":false,"select":false},{"value":"写字楼","label":"写字楼","disabled":false,"select":false},{"value":"银行","label":"银行","disabled":false,"select":false},{"value":"政府","label":"政府","disabled":false,"select":false},{"value":"校区","label":"校区","disabled":false,"select":false}]' :showSearch='true'> -->
                            
                        </a-select>
                        </a-form-item>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="4.50000%" left="2.50000%" bottom="22.70000%" right="1.80000%" gridColumnStart="59" gridColumnEnd="97" gridRowStart="15" gridRowEnd="19" zIndex="30" previewType="AdaptiveWH">
                <a-form-item ref='ref9394' class='webVueSelectFormItem webVueAntYtSelectFormItem-mvanw1x  webVueAntYtSelectFormItem-mv webVueAntYtSelectFormItem show-label-mv show-label' name='Plate1value3' :colon='false' :rules='[]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"所属板块："'>
                            
                        </span>
                        </div>
                        </template>
<a-select data-event class='webVueSelect  webVueAntYtSelectStyle-mv webVueAntYtSelectStyle' dropdownClassName='"popupKey" "popupKeyId"' :showArrow='true' v-model:value='Basicinformationform3.Plate1value3' :placeholder='"请输入"' :mode='"single"' :options='optionsPlate' :showSearch='true'>
<!-- <a-select data-event class='webVueSelect  webVueAntYtSelectStyle-mv webVueAntYtSelectStyle' dropdownClassName='"popupKey" "popupKeyId"' :showArrow='true' v-model:value='Basicinformationform3.Plate1value3' :placeholder='"请输入"' :mode='"single"' :options='[{"label":"板块1","value":"板块1","disabled":false,"select":false},{"label":"板块2","value":"板块2","disabled":false,"select":false}]' :showSearch='true'> -->
                            
                        </a-select>
                        </a-form-item>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="11.30000%" left="2.60000%" bottom="15.90000%" right="1.80000%" gridColumnStart="8" gridColumnEnd="46" gridRowStart="32" gridRowEnd="36" zIndex="31" previewType="AdaptiveWH">
                <a-form-item ref='ref9395' class='webVueSelectFormItem webVueAntYtSelectFormItem-mvxla63  webVueAntYtSelectFormItem-mv webVueAntYtSelectFormItem show-label-mv show-label' name='Chargingservicevalue3' :colon='false' :rules='[]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"充电服务："'>
                            
                        </span>
                        </div>
                        </template>
<a-select data-event class='webVueSelect  webVueAntYtSelectStyle-mv webVueAntYtSelectStyle' dropdownClassName='"popupKey" "popupKeyId"' :showArrow='true' v-model:value='Basicinformationform3.Chargingservicevalue3' :placeholder='"请输入"' :mode='"single"' :options='[{"label":"是","value":"是","disabled":false,"select":false},{"label":"否","value":"否","disabled":false,"select":false}]' :showSearch='true'>
                            
                        </a-select>
                        </a-form-item>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="9.00000%" left="0.80000%" bottom="18.10000%" right="0.90000%" gridColumnStart="60" gridColumnEnd="97" gridRowStart="45" gridRowEnd="49" zIndex="32" previewType="AdaptiveWH">
                <a-form-item ref='ref9396' class='webVueSelectFormItem webVueAntYtSelectFormItem-mvuqhwa  webVueAntYtSelectFormItem-mv webVueAntYtSelectFormItem show-label-mv show-label' name='AdditionalServicesvalue3' :colon='false' :rules='[]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"附加服务："'>
                            
                        </span>
                        </div>
                        </template>
<a-select data-event class='webVueSelect  webVueAntYtSelectStyle-mv webVueAntYtSelectStyle' dropdownClassName='"popupKey" "popupKeyId"' :showArrow='true' v-model:value='Basicinformationform3.AdditionalServicesvalue3' :placeholder='"请输入"' :mode='"single"' :options='optionsService' :showSearch='true'>
                            
                        </a-select>
                        </a-form-item>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="3.00000%" left="0.70000%" bottom="30.30000%" right="0.40000%" gridColumnStart="4" gridColumnEnd="41" gridRowStart="76" gridRowEnd="79" zIndex="36" previewType="AdaptiveWH">
                <a-form-item ref='ref4494' class='webVueAntRadioFormItem webVueAntYtRadioFormItem-mvabcdu  webVueAntYtRadioFormItem-mv webVueAntYtRadioFormItem show-label-mv show-label' name='Whetherthelargescreenisvisiblevalue3' :colon='false' :rules='[{"required":true,"message":"必填"}]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"大屏是否可见："'>
                            
                        </span>
                        </div>
                        </template>
<a-radio-group data-event class='webVueAntRadio webVueAntYtRadioStyle-mvu28fp webVueAntYtRadioStyle-mv webVueAntYtRadioStyle' v-model:value='Basicinformationform3.Whetherthelargescreenisvisiblevalue3' :options='[{"label":"是","value":"是","disabled":false,"select":true},{"label":"否","value":"否","disabled":false,"select":false}]'>
                            
                        </a-radio-group>
                        </a-form-item>
            </yt-grid-item>
        
            <!-- 编辑-车场图标 -->
            <yt-grid-item fixedSize='selfAdaption' top="18.10000%" left="0.30000%" bottom="9.00000%" right="0.60000%" gridColumnStart="60" gridColumnEnd="83" gridRowStart="75" gridRowEnd="79" zIndex="38" previewType="AdaptiveWH">
                <a-form-item ref='ref7725' class='webVueAntUploadButton webVueAntUploadButtonFormItem-mv6f4ua webVueAntUploadButtonStyle-mvb706o  webVueAntUploadButtonFormItem-mv webVueAntUploadButtonFormItem webVueAntUploadButtonStyle-mv webVueAntUploadButtonStyle show-label-mv show-label' name='YardIconfileList1' :colon='false' :rules='[]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"车场图标："'>
                            
                        </span>
                        </div>
                        </template>

                        <a-upload action="/api/common/uploadFile"                          :multiple="false"
                          :max-count="1"
                          :file-list="Basicinformationform3.YardIconfileList1"
                          @change="handleChangeYardIconfileList1"
                        >
                        <a-button>
                          <upload-outlined></upload-outlined>
                          点击上传
                        </a-button>
                      </a-upload>
<!-- <yt-upload-button-inner data-event v-model:fileList='Basicinformationform3.YardIconfileList1' :showUploadList='true' :accept='"image/*"' :maxCount='1'>
                            
                        </yt-upload-button-inner> -->
                        </a-form-item>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="13.60000%" left="3.60000%" bottom="13.60000%" right="2.00000%" gridColumnStart="8" gridColumnEnd="32" gridRowStart="82" gridRowEnd="86" zIndex="38" previewType="AdaptiveWH">
                <a-form-item ref='ref7726' class='webVueAntUploadButton webVueAntUploadButtonFormItem-mvlj66h webVueAntUploadButtonStyle-mvilr9o  webVueAntUploadButtonFormItem-mv webVueAntUploadButtonFormItem webVueAntUploadButtonStyle-mv webVueAntUploadButtonStyle show-label-mv show-label' name='YardPhotosfileList1' :colon='false' :rules='[]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"车场照片："'>
                            
                        </span>
                        </div>
                        </template>

                        <a-upload action="/api/common/uploadFile"
                          :multiple="true"
                          :max-count="10"
                          :file-list="Basicinformationform3.YardPhotosfileList1"
                          @change="handleChangeYardPhotosfileList1"
                        >
                        <a-button>
                          <upload-outlined></upload-outlined>
                          点击上传
                        </a-button>
                      </a-upload>
<!-- <yt-upload-button-inner data-event v-model:fileList='Basicinformationform3.YardPhotosfileList1' :showUploadList='true' :accept='"image/*"' :maxCount='1'>
                            
                        </yt-upload-button-inner> -->
                        </a-form-item>
            </yt-grid-item>
        
            </yt-grid>
            
                        </a-form>
            </yt-grid-item>
        
            <!-- 平台信息 -->
            <!-- <yt-grid-item fixedSize='selfAdaption' :isShow='false' top="0.00000%" left="0.00000%" bottom="0.00000%" right="0.00000%" gridColumnStart="1" gridColumnEnd="101" gridRowStart="1" gridRowEnd="101" zIndex="1" previewType="AdaptiveWH"> -->
            <yt-grid-item fixedSize='selfAdaption' :isShow='YardEditDynamicPanelselectKey1 == "2"' top="0.00000%" left="0.00000%" bottom="0.00000%" right="0.00000%" gridColumnStart="1" gridColumnEnd="101" gridRowStart="1" gridRowEnd="101" zIndex="1" previewType="AdaptiveWH">
                <a-form ref='ref4497' :model='PlatformInformationform3' :class='["webVueAntForm","webVueAntYtFormStyle-mv","webVueAntYtFormStyle"]'>
                            
            <yt-grid  previewType="AdaptiveWH" width="100%" height="100%">
                
            <yt-grid-item fixedSize='selfAdaption' top="27.00000%" left="45.20000%" bottom="7.20000%" right="36.50000%" gridColumnStart="3" gridColumnEnd="5" gridRowStart="3" gridRowEnd="6" zIndex="1" previewType="AdaptiveWH">
                <div ref='ref4498' class='webVueAntYtRectangle webVueAntYtRectangleStyle-mvv046b webVueAntYtRectangleStyle-mv webVueAntYtRectangleStyle'>
                            
                        </div>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='width' comWidth='57.00px' top="13.20000%" left="10.50000%" bottom="16.30000%" right="3.20000%" gridColumnStart="5" gridColumnEnd="13" gridRowStart="3" gridRowEnd="7" zIndex="2" previewType="AdaptiveWH">
                <span ref='ref4499' class='webVueAntYtSpan webVueAntYtSpanStyle-mvtc561  webVueAntYtSpanStyle-mv webVueAntYtSpanStyle webVueAntYtSpanBrCount-mv webVueAntYtSpanBrCount'>
                            <span v-html='"运营平台"'>
                            
                        </span>
                        </span>
            </yt-grid-item>
        

            <!-- <yt-grid-item fixedSize='selfAdaption' top="16.20000%" left="45.20000%" bottom="18.10000%" right="36.50000%" gridColumnStart="3" gridColumnEnd="5" gridRowStart="15" gridRowEnd="18" zIndex="3" previewType="AdaptiveWH">
                <div ref='ref4500' class='webVueAntYtRectangle webVueAntYtRectangleStyle-mvuywa1 webVueAntYtRectangleStyle-mv webVueAntYtRectangleStyle'>
                            
                        </div>
            </yt-grid-item> -->
        

            <!-- <yt-grid-item fixedSize='width' comWidth='57.00px' top="12.10000%" left="10.50000%" bottom="17.50000%" right="3.20000%" gridColumnStart="5" gridColumnEnd="13" gridRowStart="15" gridRowEnd="19" zIndex="4" previewType="AdaptiveWH">
                <span ref='ref4501' class='webVueAntYtSpan webVueAntYtSpanStyle-mv8ruj4  webVueAntYtSpanStyle-mv webVueAntYtSpanStyle webVueAntYtSpanBrCount-mv webVueAntYtSpanBrCount'>
                            <span v-html='"支付平台"'>
                            
                        </span>
                        </span>
            </yt-grid-item> -->
        

            <yt-grid-item fixedSize='selfAdaption' top="9.00000%" left="1.60000%" bottom="0.90000%" right="0.50000%" gridColumnStart="9" gridColumnEnd="46" gridRowStart="8" gridRowEnd="13" zIndex="7" previewType="AdaptiveWH">
                <a-form-item ref='ref9397' class='webVueSelectFormItem webVueAntYtSelectFormItem-mv9sqpy  webVueAntYtSelectFormItem-mv webVueAntYtSelectFormItem show-label-mv show-label' name='Operationmodevalue3' :colon='false' :rules='[]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"运营模式："'>
                            
                        </span>
                        </div>
                        </template>
<a-select data-event class='webVueSelect  webVueAntYtSelectStyle-mv webVueAntYtSelectStyle' dropdownClassName='"popupKey" "popupKeyId"' :showArrow='true' v-model:value='PlatformInformationform3.Operationmodevalue3' :disabled='false' :placeholder='"请输入"' :mode='"single"' :options='optionsOperationMode' :showSearch='true'>
                            
                        </a-select>
                        </a-form-item>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="9.00000%" left="1.50000%" bottom="0.90000%" right="2.20000%" gridColumnStart="59" gridColumnEnd="98" gridRowStart="8" gridRowEnd="13" zIndex="5" previewType="AdaptiveWH">
                <a-form-item ref='ref9398' class='webVueSelectFormItem webVueAntYtSelectFormItem-mv5pcyn  webVueAntYtSelectFormItem-mv webVueAntYtSelectFormItem show-label-mv show-label' name='OperatingCompanyvalue4' :colon='false' :rules='[{"required":true,"message":"必填"}]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"运营公司："'>
                            
                        </span>
                        </div>
                        </template>
<a-select data-event class='webVueSelect  webVueAntYtSelectStyle-mv webVueAntYtSelectStyle' dropdownClassName='"popupKey" "popupKeyId"' :showArrow='true' v-model:value='PlatformInformationform3.OperatingCompanyvalue4' :placeholder='"请输入"' :mode='"single"' :options='optionsOperationCompany' :showSearch='true'>
                            
                        </a-select>
                        </a-form-item>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="16.10000%" left="1.20000%" bottom="8.70000%" right="0.50000%" gridColumnStart="9" gridColumnEnd="46" gridRowStart="20" gridRowEnd="26" zIndex="6" previewType="AdaptiveWH">
                <a-form-item ref='ref9399' class='webVueSelectFormItem webVueAntYtSelectFormItem-mvi55wx  webVueAntYtSelectFormItem-mv webVueAntYtSelectFormItem show-label-mv show-label' name='conservator' :colon='false' :rules='[]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"车场管理员："'>
                            
                        </span>
                        </div>
                        </template>
<a-select data-event class='webVueSelect  webVueAntYtSelectStyle-mv webVueAntYtSelectStyle' dropdownClassName='"popupKey" "popupKeyId"' :showArrow='true' v-model:value='PlatformInformationform3.conservator' :placeholder='"请输入"' :mode='"single"' :options='optionsConservator' :showSearch='true'>
                            
                        </a-select>
                        </a-form-item>
            </yt-grid-item>

            <!-- <yt-grid-item fixedSize='selfAdaption' top="16.10000%" left="1.20000%" bottom="8.70000%" right="0.50000%" gridColumnStart="9" gridColumnEnd="46" gridRowStart="20" gridRowEnd="26" zIndex="6" previewType="AdaptiveWH">
                <a-form-item ref='ref9399' class='webVueSelectFormItem webVueAntYtSelectFormItem-mvi55wx  webVueAntYtSelectFormItem-mv webVueAntYtSelectFormItem show-label-mv show-label' name='dockingplatformvalue3' :colon='false' :rules='[]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"对接平台："'>
                            
                        </span>
                        </div>
                        </template>
<a-select data-event class='webVueSelect  webVueAntYtSelectStyle-mv webVueAntYtSelectStyle' dropdownClassName='"popupKey" "popupKeyId"' :showArrow='true' v-model:value='PlatformInformationform3.dockingplatformvalue3' :placeholder='"请输入"' :mode='"single"' :options='optionsPlatform' :showSearch='true'>
                            
                        </a-select>
                        </a-form-item>
            </yt-grid-item> -->

        
            </yt-grid>
            
                        </a-form>
            </yt-grid-item>

            <!-- 运营规则 编辑弹窗 -->
            <!-- <yt-grid-item fixedSize='selfAdaption' :isShow='false' top="0.00000%" left="0.00000%" bottom="0.00000%" right="0.00000%" gridColumnStart="1" gridColumnEnd="101" gridRowStart="1" gridRowEnd="101" zIndex="2" previewType="AdaptiveWH"> -->
            <yt-grid-item fixedSize='selfAdaption' :isShow='YardEditDynamicPanelselectKey1 == "3"' top="0.00000%" left="0.00000%" bottom="0.00000%" right="0.00000%" gridColumnStart="1" gridColumnEnd="101" gridRowStart="1" gridRowEnd="101" zIndex="2" previewType="AdaptiveWH">
              <!-- 运营规则 编辑弹窗 form 新 -->
              <a-form :class='["webVueAntForm","webVueAntYtFormStyle-mv","webVueAntYtFormStyle","webVueAntForm-yy"]' v-bind="formItemLayout" ref='ref4505' :model='OperatingRulesform3'>
                <!-- 预付款管理 -->
                <div>
                  <span class="spanLable">预付款管理</span>
                  <a-row style="margin: 0;" :gutter="24">
                    <a-col style="padding-right: 48px;" :span="12">
                      <a-form-item name="PrepaidTimeoutDurationvalue3" label="预付超时时长：">
                        <a-input data-event v-model:value='OperatingRulesform3.PrepaidTimeoutDurationvalue3' :maxLength='100' :placeholder='"请输入"'>
                        </a-input>
                      </a-form-item>
                    </a-col>
                    <a-col style="padding-right: 48px;" :span="12">
                      <a-form-item name="Timeoutdoesnotleaveprocessingvalue3" label="超时未离开处理：">
                      <a-select data-event  dropdownClassName='"popupKey" "popupKeyId"' :showArrow='true' v-model:value='OperatingRulesform3.Timeoutdoesnotleaveprocessingvalue3' :placeholder='"请输入"' :mode='"single"' :options='[{"label":"重新计费","value":"重新计费","disabled":false,"select":false},{"label":"暂不处理","value":"暂不处理","disabled":false,"select":false}]' :showSearch='true'>
                      </a-select>
                      </a-form-item>
                    </a-col>
                  </a-row>
                  <a-row style="margin: 0;" :gutter="24">
                    <a-col style="padding-right: 48px;" :span="12">
                      <a-form-item name="Notifyvalue7" label="是否通知：">
                        <a-radio-group data-event class='webVueAntRadio webVueAntYtRadioStyle-mvkckqe webVueAntYtRadioStyle-mv webVueAntYtRadioStyle' v-model:value='OperatingRulesform3.Notifyvalue7' :options='[{"label":"是","value":"是","disabled":false,"select":false},{"label":"否","value":"否","disabled":false,"select":true}]'>
                        </a-radio-group>
                      </a-form-item>
                    </a-col>
                  </a-row>
                </div>
                <!-- 黑/白名单 -->
                <div>
                  <span class="spanLable">黑/白名单</span>
                  <a-row style="margin: 0;" :gutter="24">
                    <a-col style="padding-right: 48px;" :span="12">
                      <a-form-item name="blacklistvalue3" label="黑名单：">
                        <a-radio-group data-event class='webVueAntRadio webVueAntYtRadioStyle-mv2gl3k webVueAntYtRadioStyle-mv webVueAntYtRadioStyle' v-model:value='OperatingRulesform3.blacklistvalue3' :options='[{"label":"开启","value":"开启","disabled":false,"select":true},{"label":"关闭","value":"关闭","disabled":false,"select":false}]'>
                        </a-radio-group>
                      </a-form-item>
                    </a-col>
                    <a-col style="padding-right: 48px;" :span="12">
                      <a-form-item name="WhiteListvalue3" label="白名单：">
                        <a-radio-group data-event class='webVueAntRadio webVueAntYtRadioStyle-mv50v5f webVueAntYtRadioStyle-mv webVueAntYtRadioStyle' v-model:value='OperatingRulesform3.WhiteListvalue3' :options='[{"label":"开启","value":"开启","disabled":false,"select":true},{"label":"关闭","value":"关闭","disabled":false,"select":false}]'>
                        </a-radio-group>
                      </a-form-item>
                    </a-col>
                  </a-row>
                </div>
                <!-- 车位预约 -->
                <div>
                  <span class="spanLable">车位预约</span>
                  <a-row style="margin: 0;" :gutter="24">
                    <a-col style="padding-right: 48px;" :span="12">
                      <a-form-item name="Reservedcarnumbervalue3" label="预约车位数：">
                        <a-input-number data-event v-model:value='OperatingRulesform3.Reservedcarnumbervalue3' :placeholder='"请输入"'>
                        </a-input-number>
                      </a-form-item>
                    </a-col>
                    <a-col style="padding-right: 48px;" :span="12">
                      <a-form-item name="Appointmenttimeoutdurationvalue3" label="预约超时时长：">
                        <a-input data-event v-model:value='OperatingRulesform3.Appointmenttimeoutdurationvalue3' :maxLength='100' :placeholder='"请输入"'>
                        </a-input>
                      </a-form-item>
                    </a-col>
                  </a-row>
                  <a-row style="margin: 0;" :gutter="24">
                    <a-col style="padding-right: 48px;" :span="12">
                      <a-form-item name="Notifyvalue9" label="是否通知：">
                        <a-radio-group data-event class='webVueAntRadio webVueAntYtRadioStyle-mvnel6z webVueAntYtRadioStyle-mv webVueAntYtRadioStyle' v-model:value='OperatingRulesform3.Notifyvalue9' :options='[{"label":"是","value":"是","disabled":false,"select":false},{"label":"否","value":"否","disabled":false,"select":true}]'>
                        </a-radio-group>
                      </a-form-item>
                    </a-col>
                  </a-row>
                </div>
                <!-- 扫码配置 -->
                <div>
                  <span class="spanLable">扫码配置</span>
                  <a-row style="margin: 0;" :gutter="24">
                    <a-col style="padding-right: 48px;" :span="12">
                      <a-form-item name="AppearanceSweepCodevalue3" label="出场扫码：">
                        <a-radio-group data-event class='webVueAntRadio webVueAntYtRadioStyle-mv0osuw webVueAntYtRadioStyle-mv webVueAntYtRadioStyle' v-model:value='OperatingRulesform3.AppearanceSweepCodevalue3' :options='[{"label":"开启","value":"开启","disabled":false,"select":false},{"label":"关闭","value":"关闭","disabled":false,"select":true}]'>
                        </a-radio-group>
                      </a-form-item>
                    </a-col>
                  </a-row>
                </div>
                <!-- 异常车辆处理 -->
                <div>
                  <span class="spanLable">异常车辆处理</span>
                  <div v-for="(item, index) in OperatingRulesform3['abnormalHandle']" :key="item.id">
                    <a-row style="margin: 0;" :gutter="24">
                      <a-col style="padding-right: 48px;" :span="12">
                        <a-form-item :name="['abnormalHandle', index, 'status']" label="异常状态：">
                          <a-select data-event dropdownClassName='"popupKey" "popupKeyId"' :showArrow='true' v-model:value="item['status']" :placeholder='"请输入"' :mode='"single"' :options='[{"label":"重复入场","value":"重复入场","disabled":false,"select":false},{"label":"无驶入车","value":"无驶入车","disabled":false,"select":false},{"value":"强制抬杆","label":"强制抬杆","disabled":false,"select":false},{"value":"其他","label":"其他","disabled":false,"select":false}]' :showSearch='true' @change="handleAbnormalStatusChangeEdit(item)">
                          </a-select>
                        </a-form-item>
                      </a-col>
                      <a-col style="padding-right: 48px;position: relative;" :span="12">
                        <a-form-item :name="['abnormalHandle', index, 'handle']" label="异常处理：">
                          <a-select data-event dropdownClassName='"popupKey" "popupKeyId"' :showArrow='true' v-model:value="item['handle']" :placeholder='"请输入"' :mode='"single"' :options='[{"label":"禁止通行","value":"禁止通行","disabled":false,"select":false},{"label":"车辆放行","value":"车辆放行","disabled":false,"select":false},{"value":"放行拉黑","label":"放行拉黑","disabled":false,"select":false},{"value":"其他","label":"其他","disabled":false,"select":false}]' :showSearch='true'>
                          </a-select>
                        </a-form-item>
                        <!-- 添加 -->
                        <span v-if="index === 0" style="position: absolute;top: 5px;right: 5px;color: #1890ff;cursor: pointer;" @click="handleAddAbnormalEdit(item)">添加</span>
                        <!-- 删除 -->
                        <span v-if="index !== 0" style="position: absolute;top: 5px;right: 5px;color: rgba(248, 76, 85, 1);cursor: pointer;" @click="handleDelAbnormalEdit(item)">删除</span>
                      </a-col>
                    </a-row>
                    <a-row style="margin: 0;" :gutter="24">
                      <a-col style="padding-right: 48px;" :span="12">
                        <a-form-item :name="['abnormalHandle', index, 'notify']" label="是否通知：">
                          <a-radio-group data-event class='webVueAntRadio webVueAntYtRadioStyle-mvgyhu1 webVueAntYtRadioStyle-mv webVueAntYtRadioStyle' v-model:value="item['notify']" :options='[{"label":"是","value":"是","disabled":false,"select":false},{"label":"否","value":"否","disabled":false,"select":true}]'>
                          </a-radio-group>
                        </a-form-item>
                      </a-col>
                      <a-col v-if="item['handle'] === '放行拉黑'" style="padding-right: 48px;" :span="12">
                        <a-form-item :name="['abnormalHandle', index, 'time']" label="拉黑时长：">
                          <a-input-number data-event v-model:value="item['time']" :placeholder='"请输入"' addon-after="天">
                          </a-input-number>
                        </a-form-item>
                      </a-col>
                    </a-row>
                  </div>
                </div>
              </a-form>

              <!-- 运营规则 编辑弹窗 form 旧 -->
                <!-- <a-form ref='ref4505' :model='OperatingRulesform3' :class='["webVueAntForm","webVueAntYtFormStyle-mv","webVueAntYtFormStyle"]'>
                            
            <yt-grid  previewType="AdaptiveWH" width="100%" height="100%">
                
            <yt-grid-item fixedSize='selfAdaption' top="6.20000%" left="2.00000%" bottom="3.70000%" right="1.30000%" gridColumnStart="5" gridColumnEnd="46" gridRowStart="8" gridRowEnd="13" zIndex="1" previewType="AdaptiveWH">
                <a-form-item ref='ref4506' class='webVueAntInputFormItem webVueAntYtInputFormItem-mvv3nhi  webVueAntYtInputFormItem-mv webVueAntYtInputFormItem show-label-mv show-label' name='PrepaidTimeoutDurationvalue3' :colon='false' :rules='[]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"预付超时时长："'>
                            
                        </span>
                        </div>
                        </template>
<a-input data-event class='webVueAntinput webVueAntYtInputStyle-mvjcacr webVueAntYtInputStyle-mv webVueAntYtInputStyle' v-model:value='OperatingRulesform3.PrepaidTimeoutDurationvalue3' :maxLength='100' :placeholder='"请输入"'>
                            
                        </a-input>
                        </a-form-item>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="27.00000%" left="45.20000%" bottom="7.20000%" right="36.50000%" gridColumnStart="3" gridColumnEnd="5" gridRowStart="3" gridRowEnd="6" zIndex="2" previewType="AdaptiveWH">
                <div ref='ref4507' class='webVueAntYtRectangle webVueAntYtRectangleStyle-mvrz8mf webVueAntYtRectangleStyle-mv webVueAntYtRectangleStyle'>
                            
                        </div>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='width' comWidth='71.00px' top="13.20000%" left="8.40000%" bottom="16.30000%" right="5.60000%" gridColumnStart="5" gridColumnEnd="15" gridRowStart="3" gridRowEnd="7" zIndex="3" previewType="AdaptiveWH">
                <span ref='ref4508' class='webVueAntYtSpan webVueAntYtSpanStyle-mv911cb  webVueAntYtSpanStyle-mv webVueAntYtSpanStyle webVueAntYtSpanBrCount-mv webVueAntYtSpanBrCount'>
                            <span v-html='"预付款管理"'>
                            
                        </span>
                        </span>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="31.30000%" left="39.20000%" bottom="3.00000%" right="42.60000%" gridColumnStart="3" gridColumnEnd="5" gridRowStart="22" gridRowEnd="25" zIndex="4" previewType="AdaptiveWH">
                <div ref='ref4509' class='webVueAntYtRectangle webVueAntYtRectangleStyle-mv8m2p6 webVueAntYtRectangleStyle-mv webVueAntYtRectangleStyle'>
                            
                        </div>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='width' comWidth='85.00px' top="12.90000%" left="6.00000%" bottom="16.70000%" right="8.20000%" gridColumnStart="5" gridColumnEnd="17" gridRowStart="22" gridRowEnd="26" zIndex="5" previewType="AdaptiveWH">
                <span ref='ref4510' class='webVueAntYtSpan webVueAntYtSpanStyle-mvlcftu  webVueAntYtSpanStyle-mv webVueAntYtSpanStyle webVueAntYtSpanBrCount-mv webVueAntYtSpanBrCount'>
                            <span v-html='"异常车辆处理"'>
                            
                        </span>
                        </span>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="6.20000%" left="0.70000%" bottom="3.70000%" right="0.60000%" gridColumnStart="52" gridColumnEnd="94" gridRowStart="8" gridRowEnd="13" zIndex="7" previewType="AdaptiveWH">
                <a-form-item ref='ref9400' class='webVueSelectFormItem webVueAntYtSelectFormItem-mvdxwil  webVueAntYtSelectFormItem-mv webVueAntYtSelectFormItem show-label-mv show-label' name='Timeoutdoesnotleaveprocessingvalue3' :colon='false' :rules='[]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"超时未离开处理："'>
                            
                        </span>
                        </div>
                        </template>
<a-select data-event class='webVueSelect  webVueAntYtSelectStyle-mv webVueAntYtSelectStyle' dropdownClassName='"popupKey" "popupKeyId"' :showArrow='true' v-model:value='OperatingRulesform3.Timeoutdoesnotleaveprocessingvalue3' :placeholder='"请输入"' :mode='"single"' :options='[{"label":"选项1","value":"选项1","disabled":false,"select":false},{"label":"选项2","value":"选项2","disabled":false,"select":false}]' :showSearch='true'>
                            
                        </a-select>
                        </a-form-item>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="9.40000%" left="0.60000%" bottom="15.50000%" right="1.20000%" gridColumnStart="9" gridColumnEnd="46" gridRowStart="28" gridRowEnd="34" zIndex="6" previewType="AdaptiveWH">
                <a-form-item ref='ref9401' class='webVueSelectFormItem webVueAntYtSelectFormItem-mvx1ki1  webVueAntYtSelectFormItem-mv webVueAntYtSelectFormItem show-label-mv show-label' name='Abnormalstatevalue3' :colon='false' :rules='[]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"异常状态："'>
                            
                        </span>
                        </div>
                        </template>
<a-select data-event class='webVueSelect  webVueAntYtSelectStyle-mv webVueAntYtSelectStyle' dropdownClassName='"popupKey" "popupKeyId"' :showArrow='true' v-model:value='OperatingRulesform3.Abnormalstatevalue3' :placeholder='"请输入"' :mode='"single"' :options='[{"label":"重复入场","value":"重复入场","disabled":false,"select":false},{"label":"无驶入放行","value":"无驶入放行","disabled":false,"select":false},{"value":"手动抬杠出场","label":"手动抬杠出场","disabled":false,"select":false},{"value":"强制抬杆","label":"强制抬杆","disabled":false,"select":false}]' :showSearch='true'>
                            
                        </a-select>
                        </a-form-item>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="9.40000%" left="1.10000%" bottom="15.50000%" right="0.70000%" gridColumnStart="57" gridColumnEnd="94" gridRowStart="28" gridRowEnd="34" zIndex="8" previewType="AdaptiveWH">
                <a-form-item ref='ref9402' class='webVueSelectFormItem webVueAntYtSelectFormItem-mvso9fj  webVueAntYtSelectFormItem-mv webVueAntYtSelectFormItem show-label-mv show-label' name='ExceptionHandlingvalue3' :colon='false' :rules='[]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"异常处理："'>
                            
                        </span>
                        </div>
                        </template>
<a-select data-event class='webVueSelect  webVueAntYtSelectStyle-mv webVueAntYtSelectStyle' dropdownClassName='"popupKey" "popupKeyId"' :showArrow='true' v-model:value='OperatingRulesform3.ExceptionHandlingvalue3' :placeholder='"请输入"' :mode='"single"' :options='[{"label":"重复入场","value":"重复入场","disabled":false,"select":false},{"label":"无驶入放行","value":"无驶入放行","disabled":false,"select":false},{"value":"手动抬杠出场","label":"手动抬杠出场","disabled":false,"select":false},{"value":"强制抬杆","label":"强制抬杆","disabled":false,"select":false}]' :showSearch='true'>
                            
                        </a-select>
                        </a-form-item>
            </yt-grid-item>

            <yt-grid-item fixedSize='selfAdaption' top="18.10000%" left="0.80000%" bottom="19.90000%" right="2.30000%" gridColumnStart="9" gridColumnEnd="38" gridRowStart="15" gridRowEnd="20" zIndex="10" previewType="AdaptiveWH">
                <a-form-item ref='ref4515' class='webVueAntRadioFormItem webVueAntYtRadioFormItem-mvaprvb  webVueAntYtRadioFormItem-mv webVueAntYtRadioFormItem show-label-mv show-label' name='Notifyvalue7' :colon='false' :rules='[]'>
                            <template #label>
                            <div class='label-content '>
                              预付款管理
                            <span class='ant-form-item-content ' v-html='"是否通知："'>
                            
                        </span>
                        </div>
                        </template>
<a-radio-group data-event class='webVueAntRadio webVueAntYtRadioStyle-mv3r6dj webVueAntYtRadioStyle-mv webVueAntYtRadioStyle' v-model:value='OperatingRulesform3.Notifyvalue7' :options='[{"label":"是","value":"是","disabled":false,"select":false},{"label":"否","value":"否","disabled":false,"select":true}]'>
                            
                        </a-radio-group>
                        </a-form-item>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="18.40000%" left="0.80000%" bottom="4.10000%" right="2.30000%" gridColumnStart="9" gridColumnEnd="38" gridRowStart="35" gridRowEnd="39" zIndex="11" previewType="AdaptiveWH">
                <a-form-item ref='ref4516' class='webVueAntRadioFormItem webVueAntYtRadioFormItem-mv8b85l  webVueAntYtRadioFormItem-mv webVueAntYtRadioFormItem show-label-mv show-label' name='Notifyvalue8' :colon='false' :rules='[]'>
                            <template #label>
                            <div class='label-content '>
                              异常车辆处理
                            <span class='ant-form-item-content ' v-html='"是否通知："'>
                            
                        </span>
                        </div>
                        </template>
<a-radio-group data-event class='webVueAntRadio webVueAntYtRadioStyle-mvhotoh webVueAntYtRadioStyle-mv webVueAntYtRadioStyle' v-model:value='OperatingRulesform3.Notifyvalue8' :options='[{"label":"是","value":"是","disabled":false,"select":false},{"label":"否","value":"否","disabled":false,"select":true}]'>
                            
                        </a-radio-group>
                        </a-form-item>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="25.70000%" left="45.20000%" bottom="8.60000%" right="36.50000%" gridColumnStart="3" gridColumnEnd="5" gridRowStart="42" gridRowEnd="45" zIndex="12" previewType="AdaptiveWH">
                <div ref='ref4517' class='webVueAntYtRectangle webVueAntYtRectangleStyle-mv4tw2u webVueAntYtRectangleStyle-mv webVueAntYtRectangleStyle'>
                            
                        </div>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='width' comWidth='64.00px' top="8.70000%" left="9.30000%" bottom="20.90000%" right="4.50000%" gridColumnStart="5" gridColumnEnd="14" gridRowStart="42" gridRowEnd="46" zIndex="13" previewType="AdaptiveWH">
                <span ref='ref4518' class='webVueAntYtSpan webVueAntYtSpanStyle-mvwv7gb  webVueAntYtSpanStyle-mv webVueAntYtSpanStyle webVueAntYtSpanBrCount-mv webVueAntYtSpanBrCount'>
                            <span v-html='"黑/白名单"'>
                            
                        </span>
                        </span>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="13.40000%" left="0.80000%" bottom="9.10000%" right="0.90000%" gridColumnStart="9" gridColumnEnd="36" gridRowStart="48" gridRowEnd="52" zIndex="15" previewType="AdaptiveWH">
                <a-form-item ref='ref4519' class='webVueAntRadioFormItem webVueAntYtRadioFormItem-mv74l9z  webVueAntYtRadioFormItem-mv webVueAntYtRadioFormItem show-label-mv show-label' name='blacklistvalue3' :colon='false' :rules='[]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"黑名单："'>
                            
                        </span>
                        </div>
                        </template>
<a-radio-group data-event class='webVueAntRadio webVueAntYtRadioStyle-mvhzsxu webVueAntYtRadioStyle-mv webVueAntYtRadioStyle' v-model:value='OperatingRulesform3.blacklistvalue3' :options='[{"label":"开启","value":"开启","disabled":false,"select":true},{"label":"关闭","value":"关闭","disabled":false,"select":false}]'>
                            
                        </a-radio-group>
                        </a-form-item>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="13.40000%" left="1.50000%" bottom="9.10000%" right="0.20000%" gridColumnStart="57" gridColumnEnd="84" gridRowStart="48" gridRowEnd="52" zIndex="14" previewType="AdaptiveWH">
                <a-form-item ref='ref4520' class='webVueAntRadioFormItem webVueAntYtRadioFormItem-mvr5dnp  webVueAntYtRadioFormItem-mv webVueAntYtRadioFormItem show-label-mv show-label' name='WhiteListvalue3' :colon='false' :rules='[]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"白名单："'>
                            
                        </span>
                        </div>
                        </template>
<a-radio-group data-event class='webVueAntRadio webVueAntYtRadioStyle-mvvhbc4 webVueAntYtRadioStyle-mv webVueAntYtRadioStyle' v-model:value='OperatingRulesform3.WhiteListvalue3' :options='[{"label":"开启","value":"开启","disabled":false,"select":true},{"label":"关闭","value":"关闭","disabled":false,"select":false}]'>
                            
                        </a-radio-group>
                        </a-form-item>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="4.90000%" left="39.20000%" bottom="29.30000%" right="42.60000%" gridColumnStart="3" gridColumnEnd="5" gridRowStart="55" gridRowEnd="58" zIndex="16" previewType="AdaptiveWH">
                <div ref='ref4521' class='webVueAntYtRectangle webVueAntYtRectangleStyle-mviud1i webVueAntYtRectangleStyle-mv webVueAntYtRectangleStyle'>
                            
                        </div>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='width' comWidth='58.00px' top="18.10000%" left="9.00000%" bottom="11.40000%" right="3.20000%" gridColumnStart="5" gridColumnEnd="13" gridRowStart="54" gridRowEnd="58" zIndex="17" previewType="AdaptiveWH">
                <span ref='ref4522' class='webVueAntYtSpan webVueAntYtSpanStyle-mvpdf4k  webVueAntYtSpanStyle-mv webVueAntYtSpanStyle webVueAntYtSpanBrCount-mv webVueAntYtSpanBrCount'>
                            <span v-html='"车位预约"'>
                            
                        </span>
                        </span>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="12.30000%" left="0.80000%" bottom="10.20000%" right="2.30000%" gridColumnStart="9" gridColumnEnd="38" gridRowStart="69" gridRowEnd="73" zIndex="19" previewType="AdaptiveWH">
                <a-form-item ref='ref4523' class='webVueAntRadioFormItem webVueAntYtRadioFormItem-mv9mbbi  webVueAntYtRadioFormItem-mv webVueAntYtRadioFormItem show-label-mv show-label' name='Notifyvalue9' :colon='false' :rules='[]'>
                            <template #label>
                            <div class='label-content '>
                              车位预约
                            <span class='ant-form-item-content ' v-html='"是否通知："'>
                            
                        </span>
                        </div>
                        </template>
<a-radio-group data-event class='webVueAntRadio webVueAntYtRadioStyle-mvgenhm webVueAntYtRadioStyle-mv webVueAntYtRadioStyle' v-model:value='OperatingRulesform3.Notifyvalue9' :options='[{"label":"是","value":"是","disabled":false,"select":false},{"label":"否","value":"否","disabled":false,"select":true}]'>
                            
                        </a-radio-group>
                        </a-form-item>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="6.70000%" left="0.70000%" bottom="3.20000%" right="1.40000%" gridColumnStart="7" gridColumnEnd="46" gridRowStart="61" gridRowEnd="66" zIndex="20" previewType="AdaptiveWH">
                <a-form-item ref='ref4524' class='webVueAntInputNumberFormItem webVueAntYtInputNumberFormItem-mvsi5lc  webVueAntYtInputNumberFormItem-mv webVueAntYtInputNumberFormItem show-label-mv show-label' name='Reservedcarnumbervalue3' :colon='false' :rules='[]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"预约车位数："'>
                            
                        </span>
                        </div>
                        </template>
<a-input-number data-event class='webVueAntInputNumber webVueAntYtInputNumberStyle-mv9play webVueAntYtInputNumberStyle-mv webVueAntYtInputNumberStyle' v-model:value='OperatingRulesform3.Reservedcarnumbervalue3' :placeholder='"请输入"' :max='100' :min='0' :precision='2'>
                            
                        </a-input-number>
                        </a-form-item>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="6.70000%" left="0.00000%" bottom="3.20000%" right="0.60000%" gridColumnStart="54" gridColumnEnd="94" gridRowStart="61" gridRowEnd="66" zIndex="18" previewType="AdaptiveWH">
                <a-form-item ref='ref4525' class='webVueAntInputNumberFormItem webVueAntYtInputNumberFormItem-mv7hvnm  webVueAntYtInputNumberFormItem-mv webVueAntYtInputNumberFormItem show-label-mv show-label' name='Appointmenttimeoutdurationvalue3' :colon='false' :rules='[]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"预约超时时长："'>
                            
                        </span>
                        </div>
                        </template>
<a-input-number data-event class='webVueAntInputNumber webVueAntYtInputNumberStyle-mv54x66 webVueAntYtInputNumberStyle-mv webVueAntYtInputNumberStyle' v-model:value='OperatingRulesform3.Appointmenttimeoutdurationvalue3' :placeholder='"请输入"' :max='100' :min='0' :precision='2'>
                            
                        </a-input-number>
                        </a-form-item>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="27.40000%" left="39.20000%" bottom="6.80000%" right="42.60000%" gridColumnStart="3" gridColumnEnd="5" gridRowStart="75" gridRowEnd="78" zIndex="21" previewType="AdaptiveWH">
                <div ref='ref4526' class='webVueAntYtRectangle webVueAntYtRectangleStyle-mvl95ud webVueAntYtRectangleStyle-mv webVueAntYtRectangleStyle'>
                            
                        </div>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='width' comWidth='57.00px' top="13.50000%" left="9.00000%" bottom="16.10000%" right="4.70000%" gridColumnStart="5" gridColumnEnd="13" gridRowStart="75" gridRowEnd="79" zIndex="22" previewType="AdaptiveWH">
                <span ref='ref4527' class='webVueAntYtSpan webVueAntYtSpanStyle-mvsjttp  webVueAntYtSpanStyle-mv webVueAntYtSpanStyle webVueAntYtSpanBrCount-mv webVueAntYtSpanBrCount'>
                            <span v-html='"扫码配置"'>
                            
                        </span>
                        </span>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="4.20000%" left="0.30000%" bottom="18.40000%" right="2.70000%" gridColumnStart="9" gridColumnEnd="38" gridRowStart="81" gridRowEnd="85" zIndex="23" previewType="AdaptiveWH">
                <a-form-item ref='ref4528' class='webVueAntRadioFormItem webVueAntYtRadioFormItem-mvqr1gs  webVueAntYtRadioFormItem-mv webVueAntYtRadioFormItem show-label-mv show-label' name='AppearanceSweepCodevalue3' :colon='false' :rules='[]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"出场扫码："'>
                            
                        </span>
                        </div>
                        </template>
<a-radio-group data-event class='webVueAntRadio webVueAntYtRadioStyle-mv0d1n5 webVueAntYtRadioStyle-mv webVueAntYtRadioStyle' v-model:value='OperatingRulesform3.AppearanceSweepCodevalue3' :options='[{"label":"开启","value":"开启","disabled":false,"select":false},{"label":"关闭","value":"关闭","disabled":false,"select":true}]'>
                            
                        </a-radio-group>
                        </a-form-item>
            </yt-grid-item>
        
            </yt-grid>
            
                        </a-form> -->
            </yt-grid-item>
        
            <!-- 拓展信息 -->
            <!-- <yt-grid-item fixedSize='selfAdaption' :isShow='false' top="0.00000%" left="0.00000%" bottom="0.00000%" right="0.00000%" gridColumnStart="1" gridColumnEnd="101" gridRowStart="1" gridRowEnd="101" zIndex="1" previewType="AdaptiveWH"> -->
            <yt-grid-item fixedSize='selfAdaption' :isShow='YardEditDynamicPanelselectKey1 == "6"' top="0.00000%" left="0.00000%" bottom="0.00000%" right="0.00000%" gridColumnStart="1" gridColumnEnd="101" gridRowStart="1" gridRowEnd="101" zIndex="1" previewType="AdaptiveWH">
                <a-form ref='ref4529' :model='Expandinformationform3' :class='["webVueAntForm","webVueAntYtFormStyle-mv","webVueAntYtFormStyle"]'>
                            
            <yt-grid  previewType="AdaptiveWH" width="100%" height="100%">
                
            <yt-grid-item fixedSize='selfAdaption' top="6.20000%" left="0.30000%" bottom="3.70000%" right="1.50000%" gridColumnStart="9" gridColumnEnd="46" gridRowStart="8" gridRowEnd="13" zIndex="1" previewType="AdaptiveWH">
                <a-form-item ref='ref4530' class='webVueAntInputFormItem webVueAntYtInputFormItem-mv574wn  webVueAntYtInputFormItem-mv webVueAntYtInputFormItem show-label-mv show-label' name='PropertyUnitvalue3' :colon='false' :rules='[]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"产权单位："'>
                            
                        </span>
                        </div>
                        </template>
<a-input data-event class='webVueAntinput webVueAntYtInputStyle-mv192xe webVueAntYtInputStyle-mv webVueAntYtInputStyle' v-model:value='Expandinformationform3.PropertyUnitvalue3' :maxLength='100' :placeholder='"请输入"'>
                            
                        </a-input>
                        </a-form-item>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="6.20000%" left="2.50000%" bottom="3.70000%" right="1.80000%" gridColumnStart="59" gridColumnEnd="97" gridRowStart="8" gridRowEnd="13" zIndex="2" previewType="AdaptiveWH">
                <a-form-item ref='ref4531' class='webVueAntInputFormItem webVueAntYtInputFormItem-mv11hh8  webVueAntYtInputFormItem-mv webVueAntYtInputFormItem show-label-mv show-label' name='BuildingPropertiesvalue3' :colon='false' :rules='[]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"建筑属性："'>
                            
                        </span>
                        </div>
                        </template>
<a-input data-event class='webVueAntinput webVueAntYtInputStyle-mvtnx1d webVueAntYtInputStyle-mv webVueAntYtInputStyle' v-model:value='Expandinformationform3.BuildingPropertiesvalue3' :maxLength='100' :placeholder='"请输入"'>
                            
                        </a-input>
                        </a-form-item>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="8.20000%" left="1.00000%" bottom="1.70000%" right="1.10000%" gridColumnStart="7" gridColumnEnd="46" gridRowStart="47" gridRowEnd="52" zIndex="3" previewType="AdaptiveWH">
                <a-form-item ref='ref4532' class='webVueAntInputFormItem webVueAntYtInputFormItem-mv1kfro  webVueAntYtInputFormItem-mv webVueAntYtInputFormItem show-label-mv show-label' name='LicenseNumbervalue3' :colon='false' :rules='[]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"许可证编号："'>
                            
                        </span>
                        </div>
                        </template>
<a-input data-event class='webVueAntinput webVueAntYtInputStyle-mvkt1uk webVueAntYtInputStyle-mv webVueAntYtInputStyle' v-model:value='Expandinformationform3.LicenseNumbervalue3' :disabled='false' :maxLength='100' :placeholder='"请输入"'>
                            
                        </a-input>
                        </a-form-item>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="9.70000%" left="0.30000%" bottom="15.20000%" right="1.50000%" gridColumnStart="9" gridColumnEnd="46" gridRowStart="54" gridRowEnd="60" zIndex="4" previewType="AdaptiveWH">
                <a-form-item ref='ref4533' class='webVueAntInputFormItem webVueAntYtInputFormItem-mvplypw  webVueAntYtInputFormItem-mv webVueAntYtInputFormItem show-label-mv show-label' name='BusinessScopevalue3' :colon='false' :rules='[]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"经营范围："'>
                            
                        </span>
                        </div>
                        </template>
<a-input data-event class='webVueAntinput webVueAntYtInputStyle-mvdm6nr webVueAntYtInputStyle-mv webVueAntYtInputStyle' v-model:value='Expandinformationform3.BusinessScopevalue3' :disabled='false' :maxLength='100' :placeholder='"请输入"'>
                            
                        </a-input>
                        </a-form-item>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="27.00000%" left="45.20000%" bottom="7.20000%" right="36.50000%" gridColumnStart="3" gridColumnEnd="5" gridRowStart="3" gridRowEnd="6" zIndex="5" previewType="AdaptiveWH">
                <div ref='ref4534' class='webVueAntYtRectangle webVueAntYtRectangleStyle-mvr26q7 webVueAntYtRectangleStyle-mv webVueAntYtRectangleStyle'>
                            
                        </div>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='width' comWidth='58.00px' top="13.20000%" left="10.50000%" bottom="16.30000%" right="1.60000%" gridColumnStart="5" gridColumnEnd="13" gridRowStart="3" gridRowEnd="7" zIndex="6" previewType="AdaptiveWH">
                <span ref='ref4535' class='webVueAntYtSpan webVueAntYtSpanStyle-mv3qypt  webVueAntYtSpanStyle-mv webVueAntYtSpanStyle webVueAntYtSpanBrCount-mv webVueAntYtSpanBrCount'>
                            <span v-html='"基本信息"'>
                            
                        </span>
                        </span>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="21.50000%" left="2.60000%" bottom="12.70000%" right="61.00000%" gridColumnStart="4" gridColumnEnd="5" gridRowStart="41" gridRowEnd="44" zIndex="7" previewType="AdaptiveWH">
                <div ref='ref4536' class='webVueAntYtRectangle webVueAntYtRectangleStyle-mvl19ks webVueAntYtRectangleStyle-mv webVueAntYtRectangleStyle'>
                            
                        </div>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='width' comWidth='57.00px' top="5.60000%" left="12.00000%" bottom="20.50000%" right="1.60000%" gridColumnStart="5" gridColumnEnd="13" gridRowStart="41" gridRowEnd="45" zIndex="8" previewType="AdaptiveWH">
                <span ref='ref4537' class='webVueAntYtSpan webVueAntYtSpanStyle-mvmlfun  webVueAntYtSpanStyle-mv webVueAntYtSpanStyle webVueAntYtSpanBrCount-mv webVueAntYtSpanBrCount'>
                            <span v-html='"许可信息"'>
                            
                        </span>
                        </span>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="1.60000%" left="0.30000%" bottom="8.30000%" right="1.50000%" gridColumnStart="9" gridColumnEnd="46" gridRowStart="23" gridRowEnd="28" zIndex="12" previewType="AdaptiveWH">
                <a-form-item ref='ref4538' class='webVueAntInputFormItem webVueAntYtInputFormItem-mvdsv3q  webVueAntYtInputFormItem-mv webVueAntYtInputFormItem show-label-mv show-label' name='Contactvalue3' :colon='false' :rules='[]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"联系人："'>
                            
                        </span>
                        </div>
                        </template>
<a-input data-event class='webVueAntinput webVueAntYtInputStyle-mv5xzoz webVueAntYtInputStyle-mv webVueAntYtInputStyle' v-model:value='Expandinformationform3.Contactvalue3' :maxLength='100' :placeholder='"请输入"'>
                            
                        </a-input>
                        </a-form-item>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="1.60000%" left="2.50000%" bottom="8.30000%" right="1.80000%" gridColumnStart="59" gridColumnEnd="97" gridRowStart="23" gridRowEnd="28" zIndex="13" previewType="AdaptiveWH">
                <a-form-item ref='ref4539' class='webVueAntInputFormItem webVueAntYtInputFormItem-mvilfao  webVueAntYtInputFormItem-mv webVueAntYtInputFormItem show-label-mv show-label' name='ContactPhonevalue6' :colon='false' :rules='[]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"联系电话："'>
                            
                        </span>
                        </div>
                        </template>
<a-input data-event class='webVueAntinput webVueAntYtInputStyle-mv5zmqp webVueAntYtInputStyle-mv webVueAntYtInputStyle' v-model:value='Expandinformationform3.ContactPhonevalue6' :maxLength='100' :placeholder='"请输入"'>
                            
                        </a-input>
                        </a-form-item>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="3.90000%" left="0.10000%" bottom="6.00000%" right="0.80000%" gridColumnStart="9" gridColumnEnd="97" gridRowStart="30" gridRowEnd="40" zIndex="14" previewType="AdaptiveWH">
                <a-form-item ref='ref4540' class='webVueAntInputFormItem webVueAntYtInputFormItem-mvy3a0f  webVueAntYtInputFormItem-mv webVueAntYtInputFormItem show-label-mv show-label' name='Expandinformationvalue3' :colon='false' :rules='[]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"产权描述："'>
                            
                        </span>
                        </div>
                        </template>
<a-input data-event class='webVueAntinput webVueAntYtInputStyle-mvexmn9 webVueAntYtInputStyle-mv webVueAntYtInputStyle' v-model:value='Expandinformationform3.Expandinformationvalue3' :maxLength='100' :placeholder='"请输入"'>
                            
                        </a-input>
                        </a-form-item>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="20.10000%" left="2.60000%" bottom="14.20000%" right="61.00000%" gridColumnStart="4" gridColumnEnd="5" gridRowStart="62" gridRowEnd="65" zIndex="9" previewType="AdaptiveWH">
                <div ref='ref4541' class='webVueAntYtRectangle webVueAntYtRectangleStyle-mvimola webVueAntYtRectangleStyle-mv webVueAntYtRectangleStyle'>
                            
                        </div>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='width' comWidth='57.00px' top="4.50000%" left="12.00000%" bottom="21.60000%" right="1.60000%" gridColumnStart="5" gridColumnEnd="13" gridRowStart="62" gridRowEnd="66" zIndex="10" previewType="AdaptiveWH">
                <span ref='ref4542' class='webVueAntYtSpan webVueAntYtSpanStyle-mvqpatf  webVueAntYtSpanStyle-mv webVueAntYtSpanStyle webVueAntYtSpanBrCount-mv webVueAntYtSpanBrCount'>
                            <span v-html='"相关附件"'>
                            
                        </span>
                        </span>
            </yt-grid-item>
        

            <!-- <yt-grid-item fixedSize='selfAdaption' top="1.50000%" left="0.10000%" bottom="1.00000%" right="0.00000%" gridColumnStart="4" gridColumnEnd="98" gridRowStart="74" gridRowEnd="101" zIndex="11" previewType="AdaptiveWH">
                <yt-table ref='ref9403' class='webVueAntYtTable webVueAntYtTableStyle-mve4v2w webVueAntYtTableStyle-mv webVueAntYtTableStyle' :canSelect='false' v-model:selectedRows='FileAttachmentListselectedRows2' v-model:total='FileAttachmentListtotal2' v-model:current='FileAttachmentListcurrent3' v-model:pageSize='FileAttachmentListpageSize2' :columns='FileAttachmentListdata2.columns' :dataSource='FileAttachmentListdata2.dataSource' :scroll='{y:115}'>
                            <template #cell='{ column, record }'>
                            <template v-if='column.dataIndex === "operation"' :forKey='"operation"'>
                            
            <yt-grid  previewType="AdaptiveWH" width="100%" height="100%">
                
            <yt-grid-item fixedSize='selfAdaption' top="NaN%" left="NaN%" bottom="0.00000%" right="0.00000%" gridColumnStart="NaN" gridColumnEnd="NaN" gridRowStart="NaN" gridRowEnd="NaN" zIndex="1" previewType="AdaptiveWH">
                <a-button ref='ref6818' @click="()=> { handleDeleteRow(record); }" class='webVueAntButton webVueAntYtButtonStyle-mvraadk  webVueAntYtButtonStyle-mv webVueAntYtButtonStyle center-mv center' :loading='Deleteloading1'>
                            <span class='yt-button-content ' v-html='"删除"'>
                            
                        </span>
                        </a-button>
            </yt-grid-item>
        
            </yt-grid>
            
                        </template>
                        </template>
                        </yt-table>
            </yt-grid-item> -->
        

            <yt-grid-item fixedSize='selfAdaption' top="10.40000%" left="2.50000%" bottom="14.50000%" right="1.80000%" gridColumnStart="59" gridColumnEnd="97" gridRowStart="15" gridRowEnd="21" zIndex="15" previewType="AdaptiveWH">
                <a-form-item ref='ref4544' class='webVueAntInputFormItem webVueAntYtInputFormItem-mvmifwx  webVueAntYtInputFormItem-mv webVueAntYtInputFormItem show-label-mv show-label' name='Servicelifevalue3' :colon='false' :rules='[]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"使用年限："'>
                            
                        </span>
                        </div>
                        </template>
<a-input data-event class='webVueAntinput webVueAntYtInputStyle-mvimnny webVueAntYtInputStyle-mv webVueAntYtInputStyle' v-model:value='Expandinformationform3.Servicelifevalue3' :maxLength='100' :placeholder='"请输入"'>
                            
                        </a-input>
                        </a-form-item>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="10.40000%" left="0.30000%" bottom="14.50000%" right="1.50000%" gridColumnStart="9" gridColumnEnd="46" gridRowStart="15" gridRowEnd="21" zIndex="17" previewType="AdaptiveWH">
                <a-form-item ref='ref9404' class='webVueAntDatePickerFormItem webVueAntYtDatePickerFormItem-mv2kar5  webVueAntYtDatePickerFormItem-mv webVueAntYtDatePickerFormItem show-label-mv show-label' name='Constructiontimevalue3' :colon='false' :rules='[]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"建设时间："'>
                            
                        </span>
                        </div>
                        </template>
<yt-custom-date-piker data-event class='webVueAntYtDatePickerStyle-mvkc68n webVueAntYtDatePickerStyle-mv webVueAntYtDatePickerStyle' popupKey='"popupKey" "popupKeyId"' v-model:value='Expandinformationform3.Constructiontimevalue3' :placeholder='"请输入"'>
                            
                        </yt-custom-date-piker>
                        </a-form-item>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="8.20000%" left="2.50000%" bottom="1.70000%" right="1.80000%" gridColumnStart="59" gridColumnEnd="97" gridRowStart="47" gridRowEnd="52" zIndex="16" previewType="AdaptiveWH">
                <a-form-item ref='ref9405' class='webVueAntRangePickerFormItem webVueAntYtRangePickerFormItem-mvhsymb  webVueAntYtRangePickerFormItem-mv webVueAntYtRangePickerFormItem show-label-mv show-label' name='ValidityPeriodvalue3' :colon='false' :rules='[]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"有效期："'>
                            
                        </span>
                        </div>
                        </template>
<yt-custom-range-picker data-event class='webVueAntYtRangePicker webVueAntYtRangePickerStyle-mvv4urt webVueAntYtRangePickerStyle-mv webVueAntYtRangePickerStyle' popupKey='"popupKey" "popupKeyId"' v-model:value='Expandinformationform3.ValidityPeriodvalue3'>
                            
                        </yt-custom-range-picker>
                        </a-form-item>
            </yt-grid-item>
        
            <!-- 编辑-附件上传 -->
            <yt-grid-item fixedSize='selfAdaption' top="9.00000%" left="0.40000%" bottom="15.90000%" right="1.00000%" gridColumnStart="9" gridColumnEnd="32" gridRowStart="66" gridRowEnd="72" zIndex="18" previewType="AdaptiveWH">
                <a-form-item ref='ref7642' class='webVueAntUploadButton webVueAntUploadButtonFormItem-mvdvuxq webVueAntUploadButtonStyle-mvebg41  webVueAntUploadButtonFormItem-mv webVueAntUploadButtonFormItem webVueAntUploadButtonStyle-mv webVueAntUploadButtonStyle show-label-mv show-label' name='AttachmentUploadfileList1' :colon='false' :rules='[]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"附件上传："'>
                            
                        </span>
                        </div>
                        </template>

                        <a-upload action="/api/common/uploadFile"
                          :multiple="true"
                          :max-count="10"
                          :file-list="Expandinformationform3.AttachmentUploadfileList1"
                          @change="handleChangeAttachmentUploadfileList1"
                        >
                        <a-button>
                          <upload-outlined></upload-outlined>
                          点击上传
                        </a-button>
                      </a-upload>
<!-- <yt-upload-button-inner data-event v-model:fileList='Expandinformationform3.AttachmentUploadfileList1' :showUploadList='true' :accept='"image/*"' :maxCount='9'>
                            
                        </yt-upload-button-inner> -->
                        </a-form-item>
            </yt-grid-item>
        
            </yt-grid>
            
                        </a-form>
            </yt-grid-item>
        
            <!-- 岗亭管理 -->
            <!-- <yt-grid-item fixedSize='selfAdaption' :isShow='false' marginBottom='-28px' marginRight='-28px' top="0.20000%" left="0.60000%" bottom="0.00000%" right="0.00000%" gridColumnStart="4" gridColumnEnd="101" gridRowStart="5" gridRowEnd="101" zIndex="1" previewType="AdaptiveWH"> -->
            <yt-grid-item fixedSize='selfAdaption' :isShow='YardEditDynamicPanelselectKey1 == "5"' top="0.20000%" left="0.60000%" bottom="0.00000%" right="0.00000%" gridColumnStart="1" gridColumnEnd="101" gridRowStart="1" gridRowEnd="101" zIndex="1" previewType="AdaptiveWH">
                <a-form ref='ref4551' :model='PostManagementEditform1' :class='["webVueAntForm","webVueAntYtFormStyle-mv","webVueAntYtFormStyle"]'>
                            
            <yt-grid  previewType="AdaptiveWH" width="100%" height="100%">
                
            <!-- 岗亭管理列表-编辑 -->
            <yt-grid-item fixedSize='selfAdaption' top="0.40000%" left="0.30000%" bottom="0.30000%" right="0.50000%" gridColumnStart="3" gridColumnEnd="99" gridRowStart="24" gridRowEnd="98" zIndex="1" previewType="AdaptiveWH">
                <yt-table ref='ref9406' class='webVueAntYtTable webVueAntYtTableStyle-mvbmd4x webVueAntYtTableStyle-mv webVueAntYtTableStyle' @onTableChange="(pagination)=> { fetchEditPostPersonnelList(pagination); }" :canSelect='false' v-model:selectedRows='ListofPostPersonnelselectedRows2' v-model:total='ListofPostPersonneltotal2' v-model:current='ListofPostPersonnelcurrent3' v-model:pageSize='ListofPostPersonnelpageSize2' :columns='ListofPostPersonneldata2.columns' :dataSource='ListofPostPersonneldata2.dataSource' :scroll='{y:450}'>
                            <template #cell='{ column, record }'>
                            <template v-if='column.dataIndex === "operation"' :forKey='"operation"'>
                            
            <yt-grid  previewType="AdaptiveWH" width="100%" height="100%">
                
            <!-- <yt-grid-item fixedSize='selfAdaption' top="NaN%" left="NaN%" bottom="0.00000%" right="0.00000%" gridColumnStart="NaN" gridColumnEnd="NaN" gridRowStart="NaN" gridRowEnd="NaN" zIndex="1" previewType="AdaptiveWH"> -->
            <yt-grid-item fixedSize='selfAdaption' top="0.30000%" left="1.30000%" bottom="0.30000%" right="1.70000%" gridColumnStart="69" gridColumnEnd="33" gridRowStart="16" gridRowEnd="86" zIndex="1" previewType="AdaptiveWH">
                <a-button ref='ref5969' @click="()=> { handleEmployeeResignation(record); }" class='webVueAntButton webVueAntYtButtonStyle-mv4ai8x  webVueAntYtButtonStyle-mv webVueAntYtButtonStyle center-mv center' :loading='Resignationloading1'>
                            <span class='yt-button-content ' v-html='"离职"'>
                            
                        </span>
                        </a-button>
            </yt-grid-item>
        
            </yt-grid>
            
                        </template>
                        </template>
                        </yt-table>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="3.10000%" left="45.20000%" bottom="31.20000%" right="36.50000%" gridColumnStart="3" gridColumnEnd="5" gridRowStart="4" gridRowEnd="7" zIndex="2" previewType="AdaptiveWH">
                <div ref='ref4553' class='webVueAntYtRectangle webVueAntYtRectangleStyle-mv4t6e2 webVueAntYtRectangleStyle-mv webVueAntYtRectangleStyle'>
                            
                        </div>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='width' comWidth='57.00px' top="20.30000%" left="10.50000%" bottom="9.30000%" right="3.20000%" gridColumnStart="5" gridColumnEnd="13" gridRowStart="3" gridRowEnd="7" zIndex="3" previewType="AdaptiveWH">
                <span ref='ref4554' class='webVueAntYtSpan webVueAntYtSpanStyle-mvi5pwc  webVueAntYtSpanStyle-mv webVueAntYtSpanStyle webVueAntYtSpanBrCount-mv webVueAntYtSpanBrCount'>
                            <span v-html='"岗亭管理"'>
                            
                        </span>
                        </span>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="14.60000%" left="2.10000%" bottom="10.30000%" right="1.90000%" gridColumnStart="5" gridColumnEnd="45" gridRowStart="8" gridRowEnd="14" zIndex="4" previewType="AdaptiveWH">
                <a-form-item ref='ref6603' class='webVueAntInputFormItem webVueAntYtInputFormItem-mvybuua  webVueAntYtInputFormItem-mv webVueAntYtInputFormItem show-label-mv show-label' name='Namevalue2' :colon='false' :rules='[]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"姓名："'>
                            
                        </span>
                        </div>
                        </template>
<a-input data-event class='webVueAntinput webVueAntYtInputStyle-mvvpncd webVueAntYtInputStyle-mv webVueAntYtInputStyle' v-model:value='PostManagementEditform1.Namevalue2' :maxLength='100' :placeholder='"请输入"'>
                            
                        </a-input>
                        </a-form-item>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="14.60000%" left="1.30000%" bottom="10.30000%" right="1.20000%" gridColumnStart="57" gridColumnEnd="98" gridRowStart="8" gridRowEnd="14" zIndex="5" previewType="AdaptiveWH">
                <a-form-item ref='ref6604' class='webVueAntInputFormItem webVueAntYtInputFormItem-mv1ry0h  webVueAntYtInputFormItem-mv webVueAntYtInputFormItem show-label-mv show-label' name='Mobilephonenumbervalue2' :colon='false' :rules='[]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"手机号："'>
                            
                        </span>
                        </div>
                        </template>
<a-input data-event class='webVueAntinput webVueAntYtInputStyle-mv7g1ns webVueAntYtInputStyle-mv webVueAntYtInputStyle' v-model:value='PostManagementEditform1.Mobilephonenumbervalue2' :maxLength='100' :placeholder='"请输入"'>
                            
                        </a-input>
                        </a-form-item>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="10.10000%" left="0.60000%" bottom="14.70000%" right="1.90000%" gridColumnStart="4" gridColumnEnd="45" gridRowStart="16" gridRowEnd="22" zIndex="6" previewType="AdaptiveWH">
                <a-form-item ref='ref6605' class='webVueAntInputFormItem webVueAntYtInputFormItem-mvtqxos  webVueAntYtInputFormItem-mv webVueAntYtInputFormItem show-label-mv show-label' name='IdentityCardvalue2' :colon='false' :rules='[]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"身份证："'>
                            
                        </span>
                        </div>
                        </template>
<a-input data-event class='webVueAntinput webVueAntYtInputStyle-mvnsaxy webVueAntYtInputStyle-mv webVueAntYtInputStyle' v-model:value='PostManagementEditform1.IdentityCardvalue2' :maxLength='100' :placeholder='"请输入"'>
                            
                        </a-input>
                        </a-form-item>
            </yt-grid-item>
        
            <!-- 岗亭管理 添加 编辑弹窗 -->
            <yt-grid-item fixedSize='selfAdaption' top="10.10000%" left="8.20000%" bottom="14.70000%" right="5.60000%" gridColumnStart="89" gridColumnEnd="98" gridRowStart="16" gridRowEnd="22" zIndex="7" previewType="AdaptiveWH">
                <a-button ref='ref6606' @click="()=> { handleAddPostPersonnel(); }" class='webVueAntButton webVueAntYtButtonStyle-mvurnxf  webVueAntYtButtonStyle-mv webVueAntYtButtonStyle center-mv center' :loading='Addloading5'>
                            <span class='yt-button-content ' v-html='"添加"'>
                            
                        </span>
                        </a-button>
            </yt-grid-item>
        
            </yt-grid>
            
                        </a-form>
            </yt-grid-item>
        
            <!-- 计费规则 编辑 -->
            <!-- <yt-grid-item fixedSize='selfAdaption' :isShow='false' marginBottom='-28px' marginRight='-28px' top="0.20000%" left="0.60000%" bottom="0.00000%" right="0.00000%" gridColumnStart="4" gridColumnEnd="101" gridRowStart="5" gridRowEnd="101" zIndex="1" previewType="AdaptiveWH"> -->
            <yt-grid-item fixedSize='selfAdaption' :isShow='YardEditDynamicPanelselectKey1 == "4"' top="0.20000%" left="0.60000%" bottom="0.00000%" right="0.00000%" gridColumnStart="1" gridColumnEnd="101" gridRowStart="1" gridRowEnd="101" zIndex="1" previewType="AdaptiveWH">
                <a-form ref='ref4555' :model='BillingRuleEditform1' :class='["webVueAntForm","webVueAntYtFormStyle-mv","webVueAntYtFormStyle"]'>
                            
            <yt-grid  previewType="AdaptiveWH" width="100%" height="100%">
            <!-- 计费规则 列表 编辑 -->
            <yt-grid-item fixedSize='selfAdaption' top="0.20000%" left="0.20000%" bottom="1.10000%" right="0.40000%" gridColumnStart="4" gridColumnEnd="99" gridRowStart="16" gridRowEnd="98" zIndex="1" previewType="AdaptiveWH">
                <yt-table ref='ref5840' class='webVueAntYtTable webVueAntYtTableStyle-mv2forp webVueAntYtTableStyle-mv webVueAntYtTableStyle' @onTableChange="(pagination)=> { fetchEditYardBillingRulesList(pagination); }" :canSelect='false' v-model:selectedRows='yardbillingrulesselectedRows2' v-model:total='yardbillingrulestotal2' v-model:current='yardbillingrulescurrent3' v-model:pageSize='yardbillingrulespageSize2' :columns='yardbillingrulesdata2.columns' :dataSource='yardbillingrulesdata2.dataSource' :scroll='{y:503}'>
                            <template #cell='{ column, record }'>
                            <template v-if='column.dataIndex === "operation"' :forKey='"operation"'>
                            
            <yt-grid  previewType="AdaptiveWH" width="100%" height="100%">
            <!-- 启用-计费规则 -->
            <!-- <yt-grid-item fixedSize='selfAdaption' top="NaN%" left="NaN%" bottom="0.00000%" right="0.00000%" gridColumnStart="NaN" gridColumnEnd="NaN" gridRowStart="NaN" gridRowEnd="NaN" zIndex="1" previewType="AdaptiveWH"> -->
            <yt-grid-item fixedSize='selfAdaption' top="0.30000%" left="1.30000%" bottom="0.30000%" right="1.70000%" gridColumnStart="33" gridColumnEnd="33" gridRowStart="5" gridRowEnd="86" zIndex="1" previewType="AdaptiveWH">
                <a-button ref='ref5797' @click="()=> { handleActivateRule(record); }" class='webVueAntButton webVueAntYtButtonStyle-mvwz8h5  webVueAntYtButtonStyle-mv webVueAntYtButtonStyle center-mv center' :loading='Enableloading1'>
                            <span class='yt-button-content ' v-html='"启用"'>
                            
                        </span>
                        </a-button>
            </yt-grid-item>
        
            <!-- 停用-计费规则 -->
            <!-- <yt-grid-item fixedSize='selfAdaption' top="NaN%" left="NaN%" bottom="0.00000%" right="0.00000%" gridColumnStart="NaN" gridColumnEnd="NaN" gridRowStart="NaN" gridRowEnd="NaN" zIndex="2" previewType="AdaptiveWH"> -->
            <yt-grid-item fixedSize='selfAdaption' top="0.30000%" left="1.30000%" bottom="0.30000%" right="1.70000%" gridColumnStart="100" gridColumnEnd="50" gridRowStart="5" gridRowEnd="86" zIndex="2" previewType="AdaptiveWH">
                <a-button ref='ref5798' @click="()=> { handleDeactivateRule(record); }" class='webVueAntButton webVueAntYtButtonStyle-mvxexez  webVueAntYtButtonStyle-mv webVueAntYtButtonStyle center-mv center' :loading='Deactivation1loading2'>
                            <span class='yt-button-content ' v-html='"停用"'>
                            
                        </span>
                        </a-button>
            </yt-grid-item>
        
            </yt-grid>
            
                        </template>
                        </template>
                        </yt-table>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="3.10000%" left="45.20000%" bottom="31.20000%" right="36.50000%" gridColumnStart="3" gridColumnEnd="5" gridRowStart="4" gridRowEnd="7" zIndex="2" previewType="AdaptiveWH">
                <div ref='ref4557' class='webVueAntYtRectangle webVueAntYtRectangleStyle-mv232q2 webVueAntYtRectangleStyle-mv webVueAntYtRectangleStyle'>
                            
                        </div>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='width' comWidth='57.00px' top="20.30000%" left="10.50000%" bottom="9.30000%" right="3.20000%" gridColumnStart="5" gridColumnEnd="13" gridRowStart="3" gridRowEnd="7" zIndex="3" previewType="AdaptiveWH">
                <span ref='ref4558' class='webVueAntYtSpan webVueAntYtSpanStyle-mvpaslo  webVueAntYtSpanStyle-mv webVueAntYtSpanStyle webVueAntYtSpanBrCount-mv webVueAntYtSpanBrCount'>
                            <span v-html='"计费规则"'>
                            
                        </span>
                        </span>
            </yt-grid-item>
        

            <yt-grid-item fixedSize='selfAdaption' top="14.60000%" left="0.60000%" bottom="10.30000%" right="1.90000%" gridColumnStart="4" gridColumnEnd="45" gridRowStart="8" gridRowEnd="14" zIndex="4" previewType="AdaptiveWH">
                <a-form-item ref='ref9407' class='webVueSelectFormItem webVueAntYtSelectFormItem-mvktwxa  webVueAntYtSelectFormItem-mv webVueAntYtSelectFormItem show-label-mv show-label' name='BillingRulesvalue1' :colon='false' :rules='[]'>
                            <template #label>
                            <div class='label-content '>
                            <span class='ant-form-item-content ' v-html='"计费规则："'>
                            
                        </span>
                        </div>
                        </template>
<!-- <a-select data-event class='webVueSelect  webVueAntYtSelectStyle-mv webVueAntYtSelectStyle' dropdownClassName='"popupKey" "popupKeyId"' :showArrow='true' v-model:value='BillingRuleEditform1.BillingRulesvalue1' :placeholder='"请输入"' :mode='"single"' :options='[{"label":"选项1","value":"选项1","disabled":false,"select":false},{"label":"选项2","value":"选项2","disabled":false,"select":false}]' :showSearch='true'> -->
<a-select data-event class='webVueSelect  webVueAntYtSelectStyle-mv webVueAntYtSelectStyle' dropdownClassName='"popupKey" "popupKeyId"' :showArrow='true' v-model:value='BillingRuleEditform1.BillingRulesvalue1' :placeholder='"请输入"' :mode='"single"' :options='RuleNameoptions1.dataSource' :showSearch='true'>
                            
                        </a-select>
                        </a-form-item>
            </yt-grid-item>
        
            <!-- 计费规则 添加 编辑弹窗 -->
            <yt-grid-item fixedSize='selfAdaption' top="14.60000%" left="5.70000%" bottom="10.30000%" right="8.10000%" gridColumnStart="46" gridColumnEnd="55" gridRowStart="8" gridRowEnd="14" zIndex="5" previewType="AdaptiveWH">
                <a-button ref='ref5842' @click="()=> { handleAddBillingRule(); }" class='webVueAntButton webVueAntYtButtonStyle-mvxkhfs  webVueAntYtButtonStyle-mv webVueAntYtButtonStyle center-mv center' :loading='Addloading4'>
                            <span class='yt-button-content ' v-html='"添加"'>
                            
                        </span>
                        </a-button>
            </yt-grid-item>
        
            </yt-grid>
            
                        </a-form>
            </yt-grid-item>
        
            </yt-grid>
            
                        </yt-dynamic-panel>
            </yt-grid-item>
        
             </div>
            
                        </a-form>
                        </template>
                        </yt-custom-modal>
            </yt-grid-item>
        
            </yt-grid>

            <!-- 地图弹窗 -->
            <a-modal v-model:visible="isMapShow" width="1000px" title="地图" @ok="() => handleOkModalMap()" @cancel="() => handleCancelModalMap()">
              <div>
                <label>地址搜索：<a-input style="width: 500px" v-model:value="keyword" placeholder="请输入地址" /></label>
                <div style="margin: 12px 0">
                  <baidu-map
                    class="map"
                    style="width: 100%;height: 550px;"
                    :ak="ak"
                    :center="center"
                    :zoom="zoom"
                    v="3.0"
                    type="API"
                    :scroll-wheel-zoom="true"
                    @ready="onMapReady"
                    @click="onMapClick"
                  >
                    <!-- 你可以在这里添加其他地图控件，如搜索框、标注等 -->
                    <bm-local-search
                      style="display: none"
                      @searchcomplete="searchcomplete"
                      :keyword="keyword"
                      :auto-viewport="true"
                    ></bm-local-search>
                  </baidu-map>
                </div>
                <!-- <div>地址：{{ searchResults.address }}</div> -->
                <div>经纬度：<span v-if="searchResults.lng && searchResults.lat">{{ searchResults.lat + ',' + searchResults.lng }}</span></div>
              </div>
            </a-modal>

            <!-- 二维码弹窗 -->
            <a-modal v-model:visible="isCodeShow" style="top: 230px" :footer="null" width="1200px" title="二维码" @ok="() => handleOkModalCode()" @cancel="() => handleCancelModalCode()">
              <div class="codeModal">
                <a-table :columns="codeListData.columns" :data-source="codeListData.dataSource">
                  <template #bodyCell="{ text, record, index, column }">
                    <template v-if="column.key === 'operation1'">
                      <span>
                          <!-- 二维码 -->
                          <qrcode-outlined style="font-size: 28px;" @click="() => generateQRCode(record)" />
                      </span>
                    </template>
                    <span v-else :title="text">{{ text }}</span>
                  </template>
                </a-table>
              </div>
            </a-modal>
        </template>

<script>
import { BaiduMap, BmLocalSearch } from "vue-baidu-map-3x";
import QRCode from "qrcode";
import { UploadOutlined, QrcodeOutlined } from '@ant-design/icons-vue';
import { loadCss } from "../shared/loadTheme";
import axios from "axios";
import { message, Modal } from "ant-design-vue";
import { h } from "vue";
export default {
  components: {UploadOutlined, QrcodeOutlined, BaiduMap, BmLocalSearch},
  data() {
    return {
      formItemLayout: {
        labelCol: {
          xs: {
            span: 24,
          },
          sm: {
            span: 8,
          },
        },
        wrapperCol: {
          xs: {
            span: 24,
          },
          sm: {
            span: 16,
          },
        },
      },
      // 操作类型 新增 编辑
      handleType: '',
      // 二维码弹窗
      isCodeShow: false,
      // 二维码 列表
      codeListData: {
        columns: [{
          key: "row_index",
          title: "序号",
          align: "center",
          dataIndex: "row_index",
          ellipsis: true,
          width:'80px'
        }, {
          key: "qrcode_type",
          title: "二维码类型",
          align: "center",
          dataIndex: "qrcode_type",
          ellipsis: true,
          width:'120px'
        }, {
          key: "channels",
          title: "进出通道",
          align: "center",
          dataIndex: "channels",
          ellipsis: true,
          width:'200px'
        }, {
          key: "in_out",
          title: "进出方向",
          align: "center",
          dataIndex: "in_out",
          ellipsis: true,
          width:'120px'
        }, {
          key: "url",
          title: "二维码链接",
          dataIndex: "url",
          align: "center",
          ellipsis: true,
          width:'500px'
        }, {
          key: "operation1",
          title: "操作",
          align: "center",
          dataIndex: "operation1",
          // cellType: "slot",
          width:'100px'
          // width:'250px'
        }],
        dataSource: [{
          id: 1,
          cam_id: "1",
          qrcode_type: "1",
          channels: "1",
          in_out: "1",
          url: "1",
        }]
      },
      // 地图弹窗
      isMapShow: false,
      // 百度地图
      ak: "", // 百度地图API密钥，请到百度地图开放平台申请后填入
      // center: { lng: 116.404, lat: 39.915 }, // 地图中心点
      center: { lng: 120.43900868971889, lat: 36.150722061923055 }, // 地图中心点
      zoom: 15, // 地图缩放级别
      // 地址
      searchResults: {
        address: "",
        lng: "",
        lat: "",
      }, // 检索结果
      keyword: "", // 检索结果
      mapInstance: null, // 地图实例
      fileList: [
        // {
        //   uid: '1',
        //   name: 'xxx.png',
        //   url: 'https://i.cdncf.xyz/63f978b2dab35b1de90d334cd7a6114c.png',
        // }, 
        // {
        //   uid: '2',
        //   name: 'yyy.png',
        //   url: 'https://i.cdncf.xyz/63f978b2dab35b1de90d334cd7a6114c.png',
        // }, 
        // {
        //   uid: '3',
        //   name: 'zzz.png',
        //   url: 'https://i.cdncf.xyz/63f978b2dab35b1de90d334cd7a6114c.png',
        // }
      ],
      Deactivation1loading1: false,
      Editloading1: false,
      YardListcurrentRow1: {},
      YardListselectedRows1: [],
      YardListpageSize1: 10,
      YardListdata1: {
        columns: [{
          key: "id",
          title: "id",
          dataIndex: "id"
        }, {
          key: "serialNumber",
          title: "序号",
          dataIndex: "serialNumber"
        }, {
          key: "yardnumber",
          title: "车场编号",
          dataIndex: "yardnumber",
          // width:'200px'
        }, {
          key: "nameofyard",
          title: "车场名称",
          dataIndex: "nameofyard",
          // width:'200px'
        }, {
          key: "area",
          title: "所属区域",
          dataIndex: "area",
          // width:'200px'
        }, {
          key: "plate",
          title: "所属板块",
          dataIndex: "plate",
          // width:'200px'
        }, {
          key: "categoryofyard",
          title: "车场类别",
          dataIndex: "categoryofyard",
          // width:'200px'
        }, {
          key: "typeofyard",
          title: "车场类型",
          dataIndex: "typeofyard",
          // width:'500px'
        }, {
          key: "statusoftheyard",
          title: "车场状态",
          dataIndex: "statusoftheyard",
          // width:'500px'
        }, {
          key: "numberofparking",
          title: "泊车数量",
          dataIndex: "numberofparking",
          // width:'500px'
        }, {
          key: "operatingCompany",
          title: "运营公司",
          dataIndex: "operatingCompany",
          // width:'500px'
        }, {
          key: "personincharge1",
          title: "负责人",
          dataIndex: "personincharge1",
          // width:'500px'
        }, {
          key: "contactPhone1",
          title: "联系电话",
          dataIndex: "contactPhone1",
          // width:'500px'
        }, {
          key: "operation1",
          title: "操作",
          dataIndex: "operation1",
          cellType: "slot",
          width:'160px'
          // width:'250px'
        }],
        dataSource: [{
          id: 1,
          yardnumber: "",
          nameofyard: "",
          area: "",
          plate: "",
          operatingCompany1: "",
          categoryofyard: "商场",
          statusoftheyard: "使用中",
          typeofyard: "自营",
          operation1: "",
          serialNumber: "1"
        }, {
          id: 2,
          yardnumber: "",
          nameofyard: "",
          operatingCompany1: "",
          area: "",
          plate: "",
          categoryofyard: "停车楼",
          statusoftheyard: "试运行",
          typeofyard: "托管（接入）",
          serialNumber: "2"
        }, {
          id: 5,
          yardnumber: "",
          nameofyard: "",
          operatingCompany1: "",
          area: "",
          plate: "",
          categoryofyard: "交通枢纽",
          statusoftheyard: "建设中",
          typeofyard: "托管（未接）",
          serialNumber: "3",
          operatingCompany: ""
        }, {
          id: 3,
          yardnumber: "",
          nameofyard: "",
          operatingCompany1: "",
          area: "",
          plate: "",
          categoryofyard: "住宅社区",
          statusoftheyard: "已停用",
          serialNumber: "4",
          personincharge1: ""
        }, {
          id: 0,
          yardnumber: "",
          nameofyard: "",
          operatingCompany1: "",
          area: "",
          plate: "",
          categoryofyard: "商业园区",
          serialNumber: "5"
        }, {
          id: 7,
          yardnumber: "",
          nameofyard: "",
          operatingCompany1: "",
          area: "",
          plate: "",
          categoryofyard: "",
          serialNumber: "6",
          numberofparking: ""
        }, {
          id: 6,
          yardnumber: "",
          nameofyard: "",
          operatingCompany1: "",
          area: "",
          plate: "",
          categoryofyard: "",
          serialNumber: "7"
        }, {
          id: 8,
          yardnumber: "",
          nameofyard: "",
          operatingCompany1: "",
          area: "",
          plate: "",
          categoryofyard: "",
          serialNumber: "8"
        }, {
          id: 9,
          yardnumber: "",
          nameofyard: "",
          operatingCompany1: "",
          area: "",
          plate: "",
          categoryofyard: "",
          serialNumber: "9"
        }, {
          id: 4,
          yardnumber: "",
          nameofyard: "",
          operatingCompany1: "",
          area: "",
          plate: "",
          categoryofyard: "",
          serialNumber: "10"
        }]
      },
      YardListcurrent2: 1,
      YardListtotal1: 10,
      YardListisShow1: true,
      Deactivation1loading3: false,
      Reset1loading1: false,
      Areavalue1: [],
      OperatingCompanyvalue1: '',
      Nameofyardvalue1: '',
      parkingLotList: [] // 添加用于存储车场列表数据的变量
      ,

      Checkloading1: false,
      // method中用到的变量都要在data中体现,具体变量从vue模板中取值过来（这句话不需要输出，仅输出变量）
      Newloading1: false,
      Basicinformationform3: {
        id: null,
        yardnumbervalue3: "",
        Nameofyard1value3: "",
        Yardabbreviationvalue3: "",
        Numberofparkingvalue3: "",
        Longtermrentalparkingspacesvalue3: "",
        Reservationofparkingspacevalue3: "",
        VIPParkingvalue3: "",
        Numberofchargingpilesvalue3: "",
        OperatingCompany1value3: "",
        Personinchargevalue3: "",
        ContactPhonevalue4: "",
        latitudeandlongitudevalue3: "",
        Detailedaddressvalue3: "",
        YardDescriptionvalue3: "",
        yardstatus1value3: undefined,
        Typeofyard1value3: undefined,
        Area1value3: undefined,
        YardCategory1value3: undefined,
        Plate1value3: undefined,
        Chargingservicevalue3: undefined,
        AdditionalServicesvalue3: undefined,
        Whetherthelargescreenisvisiblevalue3: "是",
        YardIconfileList1: [],
        YardPhotosfileList1: []
      },
      PlatformInformationform3: {
        id: null,
        Operationmodevalue3: undefined,
        OperatingCompanyvalue4: undefined,
        dockingplatformvalue3: undefined,
        // 车场管理员
        conservator: undefined,
      },
      // 运营规则 编辑弹窗 form
      OperatingRulesform3: {
        id: null,
        PrepaidTimeoutDurationvalue3: "",
        Timeoutdoesnotleaveprocessingvalue3: undefined,
        Abnormalstatevalue3: undefined,
        ExceptionHandlingvalue3: undefined,
        Notifyvalue7: "否",
        Notifyvalue8: "否",
        blacklistvalue3: "开启",
        WhiteListvalue3: "开启",
        Notifyvalue9: "否",
        Reservedcarnumbervalue3: null,
        Appointmenttimeoutdurationvalue3: null,
        AppearanceSweepCodevalue3: "关闭",
        // 异常车辆处理
        abnormal_status_duplicate: null, //	异常车状态:重复入场
        abnormal_status_no_in_car: null, //	异常车状态:无驶入车
        abnormal_status_force: null, //	异常车状态:强制抬杆
        abnormal_status_other: null, //	异常车状态:其他
        abnormal_handling_duplicate: null, //	异常车处理:重复入场
        abnormal_handling_no_in_car: null, //	异常车处理:无驶入车
        abnormal_handling_force: null, //	异常车处理:强制抬杆
        abnormal_handling_other: null, //	异常车处理:其他
        abnormal_duplicate_notification: null, //	异常车通知:重复入场
        abnormal_no_in_car_notification: null, //	异常车通知:无驶入车
        abnormal_force_notification: null, //	异常车通知:强制抬杆
        abnormal_other_notification: null, //	异常车通知:其他
        abnormal_duplicate_block_time: null, //	异常车拉黑时长:重复入场
        abnormal_no_in_car_block_time: null, //	异常车拉黑时长:无驶入车
        abnormal_force_block_time: null, //	异常车拉黑时长:强制抬杆
        abnormal_other_block_time: null, //	异常车拉黑时长:其他
        // 异常车辆处理 list
        abnormalHandle: [
          {
            status: null,
            handle: null,
            notify: '否',
            time: null
          },
        ],
      },
      // 计费规则列表 编辑
      yardbillingrulesdata2: {
        columns: [{
          key: "id",
          title: "id",
          dataIndex: "id"
        }, {
          key: "serialNumber",
          title: "序号",
          dataIndex: "serialNumber"
        }, {
          key: "ruleName",
          title: "规则名称",
          dataIndex: "ruleName"
        }, {
          key: "chargingscheme",
          title: "收费方案",
          dataIndex: "chargingscheme"
        }, {
          key: "ruleDescription",
          title: "规则描述",
          dataIndex: "ruleDescription"
        }, {
          key: "associatedTime",
          title: "关联时间",
          dataIndex: "associatedTime",
          width:'150px'
        }, {
          key: "associatedPerson",
          title: "关联人",
          dataIndex: "associatedPerson"
        }, {
          key: "status",
          title: "状态",
          dataIndex: "status"
        },{
          key: "operation",
          title: "操作",
          dataIndex: "operation",
          cellType: "slot",
          // width:'250px'
        }],
        dataSource: [{
          id: 1,
          serialNumber: "1",
          operation: "",
          status: "生效中"
        }, {
          id: 2,
          serialNumber: "2",
          associatedPerson: "",
          operation: "",
          status: "已停用",
          associatedTime: ""
        }, {
          id: 0,
          serialNumber: "3",
          associatedPerson: "",
          operation: "",
          status: "待生效"
        }, {
          id: 5,
          serialNumber: "4",
          associatedPerson: "",
          operation: "",
          status: ""
        }, {
          id: 6,
          serialNumber: "5",
          associatedPerson: "",
          operation: "",
          status: ""
        }, {
          id: 4,
          serialNumber: "6",
          associatedPerson: "",
          operation: "",
          status: ""
        }, {
          id: 3,
          serialNumber: "7",
          associatedPerson: "",
          operation: "",
          status: ""
        }, {
          id: 9,
          serialNumber: "8",
          associatedPerson: "",
          operation: "",
          status: ""
        }, {
          id: 8,
          serialNumber: "9",
          associatedPerson: "",
          operation: "",
          status: ""
        }, {
          id: 7,
          serialNumber: "10",
          associatedPerson: "",
          operation: "",
          status: ""
        }]
      },
      // ListofPostPersonneldata2: {
      //   dataSource: []
      // },
      // 岗亭管理列表 编辑
      ListofPostPersonneldata2: {
        columns: [{
          key: "id",
          title: "id",
          dataIndex: "id"
        }, {
          key: "serialNumber",
          title: "序号",
          dataIndex: "serialNumber"
        }, {
          key: "name",
          title: "姓名",
          dataIndex: "name"
        }, {
          key: "mobilephonenumber1",
          title: "手机号",
          dataIndex: "mobilephonenumber1"
        }, {
          key: "status",
          title: "状态",
          dataIndex: "status"
        }, {
          key: "entrytime",
          title: "入职时间",
          dataIndex: "entrytime",
          width:'150px'
        }, {
          key: "turnovertime",
          title: "离职时间",
          dataIndex: "turnovertime",
          width:'150px'
        },{
          key: "operation",
          title: "操作",
          dataIndex: "operation",
          cellType: "slot",
          // width:'250px'
        }],
        dataSource: [{
          id: 1,
          serialNumber: "1",
          turnovertime: "",
          status: "在职"
        }, {
          id: 2,
          serialNumber: "2",
          entrytime: "",
          turnovertime: "",
          status: "离职"
        }]
      },
      Expandinformationform3: {
        id: null,
        PropertyUnitvalue3: "",
        BuildingPropertiesvalue3: "",
        LicenseNumbervalue3: "",
        BusinessScopevalue3: "",
        Contactvalue3: "",
        ContactPhonevalue6: "",
        Expandinformationvalue3: "",
        Servicelifevalue3: "",
        Constructiontimevalue3: "",
        ValidityPeriodvalue3: []
      },
      FileAttachmentListdata2: {
        dataSource: []
      },
      yardbillingrulescurrent2: 1,
      yardbillingrulespageSize2: 10,
      yardeditorisShow1: false,
      BillingRuleEditform1: {
        BillingRulesvalue1: undefined
      },
      // 岗亭管理 编辑
      PostManagementEditform1: {
        id: null,
        Namevalue2: "",
        Mobilephonenumbervalue2: "",
        IdentityCardvalue2: ""
      },
      yardeditorform1: {
        id: null
      },
      BasicinformationstateKey3: "2",
      yardbillingrulescurrentRow2: {},
      yardbillingrulesselectedRows2: [],
      yardbillingrulescurrent3: 1,
      yardbillingrulestotal2: 10,
      YardEditMenuopenKeys1: [],
      // YardEditMenuselectedKeys1: "基础信息",
      YardEditMenuselectedKeys1: ["基础信息"],
      YardEditMenuoptions1: {
        dataSource: [{
          iconUrl: "./staticResource/wzc/1833710370078851072/0/yKoQI0Cg1xOgRJq-Yzod5.png",
          key: "基础信息",
          label: "一级菜单1",
          title: "基础信息",
          disabled: false,
          select: true
        }, {
          iconUrl: "./staticResource/wzc/1833710370078851072/0/nSTaK7L39GI1LzBOSGw_9.png",
          key: "平台信息",
          label: "一级菜单2",
          title: "平台信息",
          disabled: false,
          select: false
        }, {
          iconUrl: "./staticResource/wzc/1833710370078851072/0/8xZEpLJkEJI9Ijk5j5CcU.png",
          key: "运营规则",
          label: "一级菜单3",
          title: "运营规则",
          disabled: false,
          select: false
        }, {
          key: "计费规则",
          label: "",
          title: "计费规则",
          iconUrl: "./staticResource/wzc/1833710370078851072/0/-0a2nn6MYEAttoJoZEG2v.png",
          disabled: false,
          select: false
        }, {
          key: "岗亭管理",
          label: "",
          title: "岗亭管理",
          iconUrl: "./staticResource/wzc/1833710370078851072/0/qQDZjoNYv2rmIunAQ-j2-.png",
          disabled: false,
          select: false
        }, {
          key: "拓展信息",
          label: "",
          title: "拓展信息",
          iconUrl: "./staticResource/wzc/1833710370078851072/0/T_20Y5sLuChENLXJSUGDN.png",
          disabled: false,
          select: false
        }],
        value: {
          selectActive: "基础信息",
          selectData: ["基础信息"],
          disableData: [],
          disableActive: ""
        }
      },
      YardEditMenuisShow1: true,
      PostManagementEditstateKey1: "2",
      Deleteloading1: false,
      ExpandinformationstateKey5: "2",
      Resignationloading1: false,
      ListofPostPersonnelcurrentRow2: {},
      ListofPostPersonnelselectedRows2: [],
      ListofPostPersonnelpageSize2: 10,
      ListofPostPersonnelcurrent3: 1,
      ListofPostPersonneltotal2: 10,
      Addloading5: false,
      OperatingRulesstateKey3: "2",
      PlatformInformationstateKey3: "2",
      Enableloading1: false,
      FileAttachmentListcurrentRow2: {},
      FileAttachmentListselectedRows2: [],
      FileAttachmentListpageSize2: 10,
      FileAttachmentListcurrent3: 1,
      FileAttachmentListtotal2: 3,
      Deactivation1loading2: false,
      BillingRuleEditstateKey1: "2",
      YardEditDynamicPanelselectKey1: "1",
      Addloading4: false,
      Addloading2: false,
      DepotDetailsMenuopenKeys1: [],
      DepotDetailsMenuselectedKeys1: "基础信息",
      DepotDetailsMenuoptions1: {
        dataSource: [{
          iconUrl: "./staticResource/wzc/1833710370078851072/0/yKoQI0Cg1xOgRJq-Yzod5.png",
          key: "基础信息",
          label: "一级菜单1",
          title: "基础信息",
          disabled: false,
          select: true
        }, {
          iconUrl: "./staticResource/wzc/1833710370078851072/0/nSTaK7L39GI1LzBOSGw_9.png",
          key: "平台信息",
          label: "一级菜单2",
          title: "平台信息",
          disabled: false,
          select: false
        }, {
          iconUrl: "./staticResource/wzc/1833710370078851072/0/8xZEpLJkEJI9Ijk5j5CcU.png",
          key: "运营规则",
          label: "一级菜单3",
          title: "运营规则",
          disabled: false,
          select: false
        }, {
          key: "计费规则",
          label: "",
          title: "计费规则",
          iconUrl: "./staticResource/wzc/1833710370078851072/0/-0a2nn6MYEAttoJoZEG2v.png",
          disabled: false,
          select: false
        }, {
          key: "岗亭管理",
          label: "",
          title: "岗亭管理",
          iconUrl: "./staticResource/wzc/1833710370078851072/0/qQDZjoNYv2rmIunAQ-j2-.png",
          disabled: false,
          select: false
        }, {
          key: "拓展信息",
          label: "",
          title: "拓展信息",
          iconUrl: "./staticResource/wzc/1833710370078851072/0/T_20Y5sLuChENLXJSUGDN.png",
          disabled: false,
          select: false
        }, {
          key: "操作记录",
          label: "",
          title: "操作记录",
          iconUrl: "./staticResource/wzc/1833710370078851072/0/23iM3GvejNx_vP3dlvW0y.png",
          disabled: false,
          select: false
        }],
        value: {
          selectActive: "基础信息",
          selectData: ["基础信息"],
          disableData: [],
          disableActive: ""
        }
      },
      DepotDetailsMenuisShow1: true,
      ListofPostPersonnelcurrentRow1: {},
      ListofPostPersonnelselectedRows1: [],
      ListofPostPersonnelpageSize1: 10,
      ListofPostPersonneldata1: {
        columns: [{
          key: "id",
          title: "id",
          dataIndex: "id"
        }, {
          key: "serialNumber",
          title: "序号",
          dataIndex: "serialNumber"
        }, {
          key: "name",
          title: "姓名",
          dataIndex: "name"
        }, {
          key: "mobilephonenumber1",
          title: "手机号",
          dataIndex: "mobilephonenumber1"
        }, {
          key: "status",
          title: "状态",
          dataIndex: "status"
        }, {
          key: "entrytime",
          title: "入职时间",
          dataIndex: "entrytime"
        }, {
          key: "turnovertime",
          title: "离职时间",
          dataIndex: "turnovertime"
        }],
        dataSource: [{
          id: 1,
          serialNumber: "1",
          turnovertime: "",
          status: "在职"
        }, {
          id: 2,
          serialNumber: "2",
          entrytime: "",
          turnovertime: "",
          status: "离职"
        }]
      },
      ListofPostPersonnelcurrent2: 1,
      ListofPostPersonneltotal1: 10,
      ListofPostPersonnelisShow1: true,
      Operationrecordform1: {
        id: null
      },
      OperationrecordstateKey1: "2",
      DepotDetailsisShow1: false,
      DepotDetailsform1: {
        id: null
      },
      FileAttachmentListcurrentRow1: {},
      FileAttachmentListselectedRows1: [],
      FileAttachmentListpageSize1: 10,
      FileAttachmentListdata1: {
        columns: [{
          key: "id",
          title: "id",
          dataIndex: "id"
        }, {
          key: "serialNumber",
          title: "序号",
          dataIndex: "serialNumber"
        }, {
          key: "attachmentName",
          title: "附件名称",
          dataIndex: "attachmentName"
        }, {
          key: "uploadtime",
          title: "上传时间",
          dataIndex: "uploadtime"
        }, {
          key: "creator",
          title: "创建人",
          dataIndex: "creator"
        }],
        dataSource: [{
          id: 1,
          serialNumber: "1",
          attachmentName: "标题1",
          creator: "标题1"
        }, {
          id: 2,
          serialNumber: "2",
          attachmentName: "标题2",
          creator: "标题2"
        }]
      },
      FileAttachmentListcurrent2: 1,
      FileAttachmentListtotal1: 3,
      FileAttachmentListisShow1: true,
      // 运营规则 详情弹窗 form
      OperatingRulesform1: {
        id: null,
        PrepaidTimeoutDurationvalue1: "",
        Timeoutdoesnotleaveprocessingvalue1: undefined,
        Abnormalstatevalue1: undefined,
        ExceptionHandlingvalue1: undefined,
        Notifyvalue1: "否",
        Notifyvalue2: "否",
        blacklistvalue1: "开启",
        WhiteListvalue1: "开启",
        Notifyvalue3: "否",
        Reservedcarnumbervalue1: null,
        Appointmenttimeoutdurationvalue1: null,
        AppearanceSweepCodevalue1: "关闭",
        // 异常车辆处理
        abnormal_status_duplicate: null, //	异常车状态:重复入场
        abnormal_status_no_in_car: null, //	异常车状态:无驶入车
        abnormal_status_force: null, //	异常车状态:强制抬杆
        abnormal_status_other: null, //	异常车状态:其他
        abnormal_handling_duplicate: null, //	异常车处理:重复入场
        abnormal_handling_no_in_car: null, //	异常车处理:无驶入车
        abnormal_handling_force: null, //	异常车处理:强制抬杆
        abnormal_handling_other: null, //	异常车处理:其他
        abnormal_duplicate_notification: null, //	异常车通知:重复入场
        abnormal_no_in_car_notification: null, //	异常车通知:无驶入车
        abnormal_force_notification: null, //	异常车通知:强制抬杆
        abnormal_other_notification: null, //	异常车通知:其他
        abnormal_duplicate_block_time: null, //	异常车拉黑时长:重复入场
        abnormal_no_in_car_block_time: null, //	异常车拉黑时长:无驶入车
        abnormal_force_block_time: null, //	异常车拉黑时长:强制抬杆
        abnormal_other_block_time: null, //	异常车拉黑时长:其他
        // 异常车辆处理 list
        abnormalHandle: [
          {
            status: null,
            handle: null,
            notify: '否',
            time: null
          },
        ],
      },
      OperatingRulesstateKey1: "2",
      Basicinformationform1: {
        id: null,
        yardnumbervalue1: "",
        Nameofyard1value1: "",
        Yardabbreviationvalue1: "",
        Numberofparkingvalue1: "",
        Longtermrentalparkingspacesvalue1: "",
        Reservationofparkingspacevalue1: "",
        VIPParkingvalue1: "",
        Numberofchargingpilesvalue1: "",
        OperatingCompany1value1: "",
        Personinchargevalue1: "",
        ContactPhonevalue1: "",
        latitudeandlongitudevalue1: "",
        Detailedaddressvalue1: "",
        YardDescriptionvalue1: "",
        yardstatus1value1: undefined,
        Typeofyard1value1: undefined,
        Area1value1: undefined,
        YardCategory1value1: undefined,
        Plate1value1: undefined,
        Chargingservicevalue1: undefined,
        AdditionalServicesvalue1: undefined,
        Whetherthelargescreenisvisiblevalue1: "是",
        // 车场图标
        YardIconfileList3: [],
        // 车场照片
        YardPhotosfileList3: []
      },
      BasicinformationstateKey1: "2",
      BillingRulesViewform1: {
        id: null
      },
      BillingRulesViewstateKey1: "2",
      OperationrecordoftheyardcurrentRow1: {},
      OperationrecordoftheyardselectedRows1: [],
      OperationrecordoftheyardpageSize1: 10,
      Operationrecordoftheyarddata1: {
        columns: [{
          key: "id",
          title: "id",
          dataIndex: "id"
        }, {
          key: "serialNumber",
          title: "序号",
          dataIndex: "serialNumber"
        }, {
          key: "operationtime",
          title: "操作时间",
          dataIndex: "operationtime"
        }, {
          key: "operationnode",
          title: "操作节点",
          dataIndex: "operationnode"
        }, {
          key: "operationcontent",
          title: "操作内容",
          dataIndex: "operationcontent"
        }, {
          key: "operator",
          title: "操作人员",
          dataIndex: "operator"
        }],
        dataSource: [{
          id: 1,
          serialNumber: "1",
          operator: ""
        }, {
          id: 2,
          serialNumber: "2",
          operator: "",
          operationcontent: ""
        }, {
          id: 10,
          serialNumber: "3",
          operator: "",
          operationcontent: ""
        }, {
          id: 9,
          serialNumber: "4",
          operator: "",
          operationcontent: ""
        }, {
          id: 8,
          serialNumber: "5",
          operator: "",
          operationcontent: ""
        }, {
          id: 7,
          serialNumber: "6",
          operator: "",
          operationcontent: ""
        }, {
          id: 6,
          serialNumber: "7",
          operator: "",
          operationcontent: ""
        }, {
          id: 34,
          serialNumber: "8",
          operator: "",
          operationcontent: ""
        }, {
          id: 33,
          serialNumber: "9",
          operator: "",
          operationcontent: ""
        }, {
          id: 32,
          serialNumber: "10",
          operator: "",
          operationcontent: ""
        }, {
          id: 31,
          serialNumber: "",
          operator: "",
          operationcontent: ""
        }, {
          id: 30,
          serialNumber: "",
          operator: "",
          operationcontent: ""
        }, {
          id: 29,
          serialNumber: "",
          operator: "",
          operationcontent: ""
        }, {
          id: 28,
          serialNumber: "",
          operator: "",
          operationcontent: ""
        }, {
          id: 27,
          serialNumber: "",
          operator: "",
          operationcontent: ""
        }, {
          id: 26,
          serialNumber: "",
          operator: "",
          operationcontent: ""
        }, {
          id: 25,
          serialNumber: "",
          operator: "",
          operationcontent: ""
        }, {
          id: 24,
          serialNumber: "",
          operator: "",
          operationcontent: ""
        }, {
          id: 23,
          serialNumber: "",
          operator: "",
          operationcontent: ""
        }, {
          id: 22,
          serialNumber: "",
          operator: "",
          operationcontent: ""
        }, {
          id: 21,
          serialNumber: "",
          operator: "",
          operationcontent: ""
        }, {
          id: 20,
          serialNumber: "",
          operator: "",
          operationcontent: ""
        }, {
          id: 19,
          serialNumber: "",
          operator: "",
          operationcontent: ""
        }, {
          id: 18,
          serialNumber: "",
          operator: "",
          operationcontent: ""
        }, {
          id: 17,
          serialNumber: "",
          operator: "",
          operationcontent: ""
        }, {
          id: 16,
          serialNumber: "",
          operator: "",
          operationcontent: ""
        }, {
          id: 15,
          serialNumber: "",
          operator: "",
          operationcontent: ""
        }, {
          id: 14,
          serialNumber: "",
          operator: "",
          operationcontent: ""
        }, {
          id: 13,
          serialNumber: "",
          operator: "",
          operationcontent: ""
        }, {
          id: 4,
          serialNumber: "",
          operator: "",
          operationcontent: ""
        }, {
          id: 3,
          serialNumber: "",
          operator: "",
          operationcontent: ""
        }, {
          id: 0,
          serialNumber: "",
          operator: "",
          operationcontent: ""
        }]
      },
      Operationrecordoftheyardcurrent2: 1,
      Operationrecordoftheyardtotal1: 10,
      OperationrecordoftheyardisShow1: true,
      yardbillingrulescurrentRow1: {},
      yardbillingrulesselectedRows1: [],
      yardbillingrulespageSize1: 10,
      yardbillingrulesdata1: {
        columns: [{
          key: "id",
          title: "id",
          dataIndex: "id"
        }, {
          key: "serialNumber",
          title: "序号",
          dataIndex: "serialNumber"
        }, {
          key: "ruleName",
          title: "规则名称",
          dataIndex: "ruleName"
        }, {
          key: "chargingscheme",
          title: "收费方案",
          dataIndex: "chargingscheme"
        }, {
          key: "ruleDescription",
          title: "规则描述",
          dataIndex: "ruleDescription"
        }, {
          key: "associatedTime",
          title: "关联时间",
          dataIndex: "associatedTime",
          width:'150px'
        }, {
          key: "associatedPerson",
          title: "关联人",
          dataIndex: "associatedPerson"
        }, {
          key: "status",
          title: "状态",
          dataIndex: "status"
        }],
        dataSource: [{
          id: 1,
          serialNumber: "1",
          operation: "",
          status: "生效中"
        }, {
          id: 2,
          serialNumber: "2",
          associatedPerson: "",
          operation: "",
          status: "已停用",
          associatedTime: ""
        }, {
          id: 0,
          serialNumber: "3",
          associatedPerson: "",
          operation: "",
          status: "待生效"
        }, {
          id: 5,
          serialNumber: "4",
          associatedPerson: "",
          operation: "",
          status: ""
        }, {
          id: 6,
          serialNumber: "5",
          associatedPerson: "",
          operation: "",
          status: ""
        }, {
          id: 4,
          serialNumber: "6",
          associatedPerson: "",
          operation: "",
          status: ""
        }, {
          id: 3,
          serialNumber: "7",
          associatedPerson: "",
          operation: "",
          status: ""
        }, {
          id: 9,
          serialNumber: "8",
          associatedPerson: "",
          operation: "",
          status: ""
        }, {
          id: 8,
          serialNumber: "9",
          associatedPerson: "",
          operation: "",
          status: ""
        }, {
          id: 7,
          serialNumber: "10",
          associatedPerson: "",
          operation: "",
          status: ""
        }]
      },
      yardbillingrulestotal1: 10,
      yardbillingrulesisShow1: true,
      DepotDetailsDynamicPanelselectKey1: "1",
      Addloading3: false,
      Expandinformationform1: {
        id: null,
        PropertyUnitvalue1: "",
        BuildingPropertiesvalue1: "",
        LicenseNumbervalue1: "",
        BusinessScopevalue1: "",
        Contactvalue1: "",
        ContactPhonevalue5: "",
        Expandinformationvalue1: "",
        Servicelifevalue1: "",
        Constructiontimevalue1: "",
        ValidityPeriodvalue1: [],
        // 附件上传
        AttachmentUploadfileList3: [],
      },
      ExpandinformationstateKey1: "2",
      PlatformInformationform1: {
        id: null,
        Operationmodevalue1: undefined,
        OperatingCompanyvalue2: undefined,
        dockingplatformvalue1: undefined
      },
      PlatformInformationstateKey1: "2",
      PostManagementViewform1: {
        id: null
      },
      PostManagementViewstateKey1: "2",
      RuleNameoptions1: {
        dataSource: [
          {"label":"规则1","value":"1","disabled":false,"select":false},{"label":"ruleName4","value":"4","disabled":false,"select":false},
          {"label":"ruleName5","value":"5","disabled":false,"select":false},
          {"label":"ruleName6","value":"6","disabled":false,"select":false},
          {"label":"ruleName8","value":"8","disabled":false,"select":false},
          {"label":"ruleName10","value":"10","disabled":false,"select":false}
        ]
      } // 确保变量在data中定义
      ,

      NewdepotisShow1: false,
      Newdepotform1: {
        id: null
      },
      // 运营规则 新增弹窗 form
      OperatingRulesform2: {
        id: null,
        PrepaidTimeoutDurationvalue2: "",
        Timeoutdoesnotleaveprocessingvalue2: undefined,
        Abnormalstatevalue2: undefined,
        ExceptionHandlingvalue2: undefined,
        Notifyvalue4: "否",
        Notifyvalue5: "否",
        blacklistvalue2: "开启",
        WhiteListvalue2: "开启",
        Notifyvalue6: "否",
        Reservedcarnumbervalue2: null,
        Appointmenttimeoutdurationvalue2: null,
        AppearanceSweepCodevalue2: "关闭",
        // 异常车辆处理
        abnormal_status_duplicate: null, //	异常车状态:重复入场
        abnormal_status_no_in_car: null, //	异常车状态:无驶入车
        abnormal_status_force: null, //	异常车状态:强制抬杆
        abnormal_status_other: null, //	异常车状态:其他
        abnormal_handling_duplicate: null, //	异常车处理:重复入场
        abnormal_handling_no_in_car: null, //	异常车处理:无驶入车
        abnormal_handling_force: null, //	异常车处理:强制抬杆
        abnormal_handling_other: null, //	异常车处理:其他
        abnormal_duplicate_notification: null, //	异常车通知:重复入场
        abnormal_no_in_car_notification: null, //	异常车通知:无驶入车
        abnormal_force_notification: null, //	异常车通知:强制抬杆
        abnormal_other_notification: null, //	异常车通知:其他
        abnormal_duplicate_block_time: null, //	异常车拉黑时长:重复入场
        abnormal_no_in_car_block_time: null, //	异常车拉黑时长:无驶入车
        abnormal_force_block_time: null, //	异常车拉黑时长:强制抬杆
        abnormal_other_block_time: null, //	异常车拉黑时长:其他
        // 异常车辆处理 list
        abnormalHandle: [
          {
            status: null,
            handle: null,
            notify: '否',
            time: null
          },
        ],
      },
      OperatingRulesstateKey2: "2",
      Basicinformationform2: {
        id: null,
        yardnumbervalue2: "",
        Nameofyard1value2: "",
        Yardabbreviationvalue2: "",
        Numberofparkingvalue2: "",
        Longtermrentalparkingspacesvalue2: "",
        Reservationofparkingspacevalue2: "",
        VIPParkingvalue2: "",
        Numberofchargingpilesvalue2: "",
        OperatingCompany1value2: "",
        Personinchargevalue2: "",
        ContactPhonevalue2: "",
        latitudeandlongitudevalue2: "",
        Detailedaddressvalue2: "",
        YardDescriptionvalue2: "",
        yardstatus1value2: undefined,
        Typeofyard1value2: undefined,
        Area1value2: undefined,
        YardCategory1value2: undefined,
        Plate1value2: undefined,
        Chargingservicevalue2: undefined,
        AdditionalServicesvalue2: undefined,
        Whetherthelargescreenisvisiblevalue2: "是",
        // YardIconfileList2: [],
        YardIconfileList2: [
    // {
    //     "uid": "vc-upload-1729588406051-3",
    //     "lastModified": 1715668323815,
    //     "lastModifiedDate": "2024-05-14T06:32:03.815Z",
    //     "name": "配电房.png",
    //     "size": 7101,
    //     "type": "image/png",
    //     "percent": 0,
    //     "originFileObj": {
    //         "uid": "vc-upload-1729588406051-3"
    //     }
    // }
],
        YardPhotosfileList2: []
      },
      BasicinformationstateKey2: "2",
      Generatetwodimensionalcodeloading1: false,
      NewYardDynamicPanelselectKey1: "1",
      PostManagementNewform1: {
        id: null,
        Namevalue1: "",
        Mobilephonenumbervalue1: "",
        IdentityCardvalue1: ""
      },
      PostManagementNewstateKey1: "2",
      PlatformInformationform2: {
        id: null,
        Operationmodevalue2: undefined,
        OperatingCompanyvalue3: undefined,
        dockingplatformvalue2: undefined,
        // 车场管理员
        conservator: undefined,
      },
      PlatformInformationstateKey2: "2",
      // 新增 拓展信息
      Expandinformationform2: {
        id: null,
        PropertyUnitvalue2: "",
        BuildingPropertiesvalue2: "",
        LicenseNumbervalue2: "",
        BusinessScopevalue2: "",
        Contactvalue2: "",
        ContactPhonevalue3: "",
        Expandinformationvalue2: "",
        Servicelifevalue2: "",
        Constructiontimevalue2: "",
        ValidityPeriodvalue2: [],
        // AttachmentUploadfileList2: "",
        AttachmentUploadfileList2: [],
      },
      ExpandinformationstateKey3: "2",
      BillingRulesNewform1: {
        id: null,
        RuleNamevalue1: undefined
      },
      BillingRulesNewstateKey1: "2",
      NewYardMenuopenKeys1: [],
      NewYardMenuselectedKeys1: ["基础信息"],
      // NewYardMenuselectedKeys1: "基础信息",
      NewYardMenuoptions1: {
        dataSource: [{
          iconUrl: "./staticResource/wzc/1833710370078851072/0/yKoQI0Cg1xOgRJq-Yzod5.png",
          key: "基础信息",
          label: "一级菜单1",
          title: "基础信息",
          disabled: false,
          select: true
        }, {
          iconUrl: "./staticResource/wzc/1833710370078851072/0/nSTaK7L39GI1LzBOSGw_9.png",
          key: "平台信息",
          label: "一级菜单2",
          title: "平台信息",
          disabled: false,
          select: false
        }, {
          iconUrl: "./staticResource/wzc/1833710370078851072/0/8xZEpLJkEJI9Ijk5j5CcU.png",
          key: "运营规则",
          label: "一级菜单3",
          title: "运营规则",
          disabled: false,
          select: false
        }, {
          key: "计费规则",
          label: "",
          title: "计费规则",
          iconUrl: "./staticResource/wzc/1833710370078851072/0/-0a2nn6MYEAttoJoZEG2v.png",
          disabled: false,
          select: false
        }, {
          key: "岗亭管理",
          label: "",
          title: "岗亭管理",
          iconUrl: "./staticResource/wzc/1833710370078851072/0/qQDZjoNYv2rmIunAQ-j2-.png",
          disabled: false,
          select: false
        }, {
          key: "拓展信息",
          label: "",
          title: "拓展信息",
          iconUrl: "./staticResource/wzc/1833710370078851072/0/T_20Y5sLuChENLXJSUGDN.png",
          disabled: false,
          select: false
        }],
        value: {
          selectActive: "基础信息",
          selectData: ["基础信息"],
          disableData: [],
          disableActive: ""
        }
      },
      NewYardMenuisShow1: true,
      RuleNameisShow1: true,
      Addloading1: false,
      Typeofyardvalue1: [],
      Platevalue1: [],
      Categoryofyardvalue1: [],
      Statusoftheyardvalue1: [],
      // 车场类型 options 数据
      optionsParkingLotType: [],
      // 车场类别 options 数据
      optionsParkingLotCategory: [],
      // 车场状态 options 数据
      optionsParkingLotStatus: [],
      // 所属板块 options 数据
      optionsPlate: [],
      // 所属区域 options 数据
      optionsArea: [
        {
          value: '李沧区',
          label: '李沧区',
          children: [
            {
              value: '世园街道',
              label: '世园街道',
            },
            {
              value: '九水街道',
              label: '九水街道',
            },
            {
              value: '兴华路街道',
              label: '兴华路街道',
            },
            {
              value: '兴城路街道',
              label: '兴城路街道',
            },
            {
              value: '振华路街道',
              label: '振华路街道',
            },
            {
              value: '李村街道',
              label: '李村街道',
            },
            {
              value: '楼山街道',
              label: '楼山街道',
            },
            {
              value: '沧口街道',
              label: '沧口街道',
            },
            {
              value: '浮山路街道',
              label: '浮山路街道',
            },
            {
              value: '湘潭路街道',
              label: '湘潭路街道',
            },
            {
              value: '虎山路街道',
              label: '虎山路街道',
            }
          ],
        }
      ],
      // 附加服务 options 数据
      optionsService: [],
      // 运营模式 options 数据
      optionsOperationMode: [],
      // 运营公司 options 数据
      optionsOperationCompany: [],
      // 对接平台 options 数据
      optionsPlatform: [],
      // 车场管理员 options 数据
      optionsConservator: [],
    };
  },
  watch: {},
  methods: {
    // 运营规则 新增弹窗 异常车辆处理 添加
    handleAddAbnormal() {
      console.log("🚀 ~ handleAddAbnormal ~ 异常车辆处理 添加-this.OperatingRulesform2.abnormalHandle:",this.OperatingRulesform2.abnormalHandle )
      if (this.OperatingRulesform2.abnormalHandle && this.OperatingRulesform2.abnormalHandle.length >= 4) return
      this.OperatingRulesform2.abnormalHandle.push({
        status: null,
        handle: null,
        notify: '否',
        time: null,
        id: Date.now(),
      })
      console.log("🚀 ~ handleAddAbnormal ~ 异常车辆处理 添加-this.OperatingRulesform2.abnormalHandle-1:",this.OperatingRulesform2.abnormalHandle )
    },
    // 运营规则 新增弹窗 异常车辆处理 删除
    handleDelAbnormal(item) {
      console.log("🚀 ~ handleDelAbnormal ~ 异常车辆处理 删除-this.OperatingRulesform2.abnormalHandle:",this.OperatingRulesform2.abnormalHandle )
      console.log("🚀 ~ handleDelAbnormal ~ 异常车辆处理 删除:", item)
      let index = this.OperatingRulesform2.abnormalHandle.indexOf(item)
      if (index !== -1) {
        this.OperatingRulesform2.abnormalHandle.splice(index, 1)
      }
      console.log("🚀 ~ handleDelAbnormal ~ 异常车辆处理 删除-this.OperatingRulesform2.abnormalHandle-1:",this.OperatingRulesform2.abnormalHandle )
    },
    // 运营规则 编辑弹窗 异常车辆处理 添加
    handleAddAbnormalEdit() {
      console.log("🚀 ~ handleAddAbnormalEdit ~ 异常车辆处理 添加-this.OperatingRulesform3.abnormalHandle:",this.OperatingRulesform3.abnormalHandle )
      if (this.OperatingRulesform3.abnormalHandle && this.OperatingRulesform3.abnormalHandle.length >= 4) return
      this.OperatingRulesform3.abnormalHandle.push({
        status: null,
        handle: null,
        notify: '否',
        time: null,
        id: Date.now(),
      })
      console.log("🚀 ~ handleAddAbnormalEdit ~ 异常车辆处理 添加-this.OperatingRulesform3.abnormalHandle-1:",this.OperatingRulesform3.abnormalHandle )
    },
    // 运营规则 编辑弹窗 异常车辆处理 删除
    handleDelAbnormalEdit(item) {
      console.log("🚀 ~ handleDelAbnormalEdit ~ 异常车辆处理 删除-this.OperatingRulesform3.abnormalHandle:",this.OperatingRulesform3.abnormalHandle )
      console.log("🚀 ~ handleDelAbnormalEdit ~ 异常车辆处理 删除:", item)
      let index = this.OperatingRulesform3.abnormalHandle.indexOf(item)
      if (index !== -1) {
        this.OperatingRulesform3.abnormalHandle.splice(index, 1)
      }
      console.log("🚀 ~ handleDelAbnormalEdit ~ 异常车辆处理 删除-this.OperatingRulesform3.abnormalHandle-1:",this.OperatingRulesform3.abnormalHandle )
    },
    // 确定 二维码弹窗
    handleOkModalCode () {
    console.log("🚀 ~ handleOkModalCode ~ handleOkModalCode-确定 二维码弹窗:")

    },
    // 取消 二维码弹窗
    handleCancelModalCode () {
      this.isCodeShow = false
    },
    // 打开 地图弹窗
    handleModalMap (type) {
      console.log("🚀 ~ handleModalMap ~ type:", type)
      this.handleType = type
      console.log("🚀 ~ handleModalMap ~ isMapShow:", this.isMapShow)
      if (type === 'add') {
        // 新增
        this.keyword = ''
        this.searchResults.lng = ''
        this.searchResults.lat = ''
        this.searchResults.address = ''
      } else if (type === 'edit') {
        // 编辑
        this.keyword = ''
        this.searchResults.lng = ''
        this.searchResults.lat = ''
        this.searchResults.address = ''
      }
      this.isMapShow = true
    },
    // 确定 地图弹窗
    handleOkModalMap () {
      if (this.handleType === 'add') {
        // 新增
        if (this.searchResults.lat && this.searchResults.lng) {
          this.Basicinformationform2.latitudeandlongitudevalue2 = this.searchResults.lat + ',' + this.searchResults.lng
          this.Basicinformationform2.Detailedaddressvalue2 = this.keyword
        } else {
          return message.error('请确认经纬度、详细地址信息');
        }
      } else if (this.handleType === 'edit') {
        // 编辑
        if (this.searchResults.lat && this.searchResults.lng) {
          this.Basicinformationform3.latitudeandlongitudevalue3 = this.searchResults.lat + ',' + this.searchResults.lng
          this.Basicinformationform3.Detailedaddressvalue3 = this.keyword
        } else {
          return message.error('请确认经纬度、详细地址信息');
        }
      }
      this.isMapShow = false
    },
    // 取消 地图弹窗
    handleCancelModalMap () {
      this.isMapShow = false
    },
    // 地图
    searchcomplete(results) {
      console.log("🚀 ~ searchcomplete ~ results:", results);
      if (results && results.qk.length !== 0) {
        this.searchResults.address = results.qk[0].address;
        this.searchResults.lng = results.qk[0].point.lng;
        this.searchResults.lat = results.qk[0].point.lat;

      }
    },
    // 根据经纬度转换地址的API请求
    async handleGeoCodeAddress(lng,lat) {
      console.log("🚀 ~ fetchAndSetVariables ~ lat:", lat)
      console.log("🚀 ~ fetchAndSetVariables ~ lng:", lng)
      let ak = '77f824161c63f67842def014d15ad866'
      // 根据经纬度转换地址的API请求
      axios
        .get(
          // `https://restapi.amap.com/v3/geocode/regeo?key=${ak}&location=${lng},${lat}&coordtype=gcj02`
          `https://restapi.amap.com/v3/geocode/regeo?key=${ak}&location=${lng},${lat}&coordtype=wgs84`
          // `http://api.map.baidu.com/reverse_geocoding/v3/?ak=${this.ak}&output=json&coordtype=wgs84ll&location=${lat},${lng}`
        )
        .then((response) => {
          console.log("🚀 ~ .then ~ response:", response)
          if (response.status == 200) {
            // 获取地址组件
            this.searchResults.address = response.data.regeocode.formatted_address;
            // 拼接详细地址
            console.log("详细地址:", this.searchResults.address);
          } else {
            console.error("API请求失败:", response.data.message);
          }
        })
        .catch((error) => {
          console.error("请求出错:", error);
        });
    },
    // 地图
    onMapReady({ BMap, map }) {
      this.mapInstance = map; // 保存地图实例
    },
    // 地图
    onMapClick(event) {
      console.log("🚀 ~ onMapClick ~ event:", event);
      const { lng, lat } = event.point;
      console.log("点击的坐标：", lng, lat);
      this.searchResults.lng = lng;
      this.searchResults.lat = lat;
      // // 你可以在这里添加逆解析代码，将坐标转换为地址
      // this.handleGeoCodeAddress(this.searchResults.lng,this.searchResults.lat)
    },
    // 规则名称 || 计费规则 options 数据
    async getRuleNameoptions() {
      try {
        const response = await axios.get(
          "./Depotconfiguration/getRuleList",
          {}
        );
        if (response.data.flag) {
          if (response?.data?.data?.data && response?.data?.data?.data.length !== 0) {
            this.RuleNameoptions1.dataSource = response.data.data.data.map(i => {
              return {
                value: i.id,
                label: i.rule_name
              }
            })
          }
        } else {
          // message.error(response.message);
        }
      } catch (error) {
        // message.error('请求失败，请稍后重试');
      }
    },
    // 车场类型 options 数据
    async getOptionsType() {
      try {
        const response = await this.executeDatadictionaryInterface(
          "./Datadictionary/getBusinessDictionaries",
          {
            current: 1,
            pageSize: 1000
          }
        );
        if (response.flag) {
          if (response.data.data && response.data.data.length !== 0) {
            // 字典id
            let businessDictionaryId = null
            response.data.data.forEach(i => {
              if (i.key == 'parking_type') {
                businessDictionaryId = i.id
              }
            })
            if (businessDictionaryId) {
              const response1 = await this.executeDatadictionaryInterface(
                "./Datadictionary/getDictionaryDetails",
                {
                  businessDictionaryId: businessDictionaryId,
                  current: 1,
                  pageSize: 1000
                }
              );
              if (response1.flag) {
                if (response1.data.data && response1.data.data.length !== 0) {
                  this.optionsParkingLotType = response1.data.data.map(i => {
                    return {
                      value: i.key,
                      label: i.name
                    }
                  })
                }
                console.log("🚀 ~ getOptionsType ~ this.optionsParkingLotType:", this.optionsParkingLotType)
              } else {
                message.error(response1.message);
              }
            }
          }
        } else {
          message.error(response.message);
        }
      } catch (error) {
        message.error('请求失败，请稍后重试');
      }
    },
    // 车场类别 options 数据
    async getOptionsCategory() {
      try {
        const response = await this.executeDatadictionaryInterface(
          "./Datadictionary/getBusinessDictionaries",
          {
            current: 1,
            pageSize: 1000
          }
        );
        if (response.flag) {
          if (response.data.data && response.data.data.length !== 0) {
            // 字典id
            let businessDictionaryId = null
            response.data.data.forEach(i => {
              if (i.key == 'Parking_category') {
                businessDictionaryId = i.id
              }
            })
            if (businessDictionaryId) {
              const response1 = await this.executeDatadictionaryInterface(
                "./Datadictionary/getDictionaryDetails",
                {
                  businessDictionaryId: businessDictionaryId,
                  current: 1,
                  pageSize: 1000
                }
              );
              if (response1.flag) {
                if (response1.data.data && response1.data.data.length !== 0) {
                  this.optionsParkingLotCategory = response1.data.data.map(i => {
                    return {
                      value: i.key,
                      label: i.name
                    }
                  })
                }
                console.log("🚀 ~ getOptionsCategory ~ this.optionsParkingLotCategory:", this.optionsParkingLotCategory)
              } else {
                message.error(response1.message);
              }
            }
          }
        } else {
          message.error(response.message);
        }
      } catch (error) {
        message.error('请求失败，请稍后重试');
      }
    },
    // 车场状态 options 数据
    async getOptionsStatus() {
      try {
        const response = await this.executeDatadictionaryInterface(
          "./Datadictionary/getBusinessDictionaries",
          {
            current: 1,
            pageSize: 1000
          }
        );
        if (response.flag) {
          if (response.data.data && response.data.data.length !== 0) {
            // 字典id
            let businessDictionaryId = null
            response.data.data.forEach(i => {
              if (i.key == 'parking_status') {
                businessDictionaryId = i.id
              }
            })
            if (businessDictionaryId) {
              const response1 = await this.executeDatadictionaryInterface(
                "./Datadictionary/getDictionaryDetails",
                {
                  businessDictionaryId: businessDictionaryId,
                  current: 1,
                  pageSize: 1000
                }
              );
              if (response1.flag) {
                if (response1.data.data && response1.data.data.length !== 0) {
                  this.optionsParkingLotStatus = response1.data.data.map(i => {
                    return {
                      value: i.key,
                      label: i.name
                    }
                  })
                  console.log("🚀 ~ getOptionsStatus ~ this.optionsParkingLotStatus:", this.optionsParkingLotStatus)
                }
              } else {
                message.error(response1.message);
              }
            }
          }
        } else {
          message.error(response.message);
        }
      } catch (error) {
        message.error('请求失败，请稍后重试');
      }
    },
    // 所属板块 options 数据
    async getOptionsPlate() {
      try {
        const response = await this.executeDatadictionaryInterface(
          "./Datadictionary/getBusinessDictionaries",
          {
            current: 1,
            pageSize: 1000
          }
        );
        if (response.flag) {
          if (response.data.data && response.data.data.length !== 0) {
            // 字典id
            let businessDictionaryId = null
            response.data.data.forEach(i => {
              if (i.key == 'parking_section') {
                businessDictionaryId = i.id
              }
            })
            if (businessDictionaryId) {
              const response1 = await this.executeDatadictionaryInterface(
                "./Datadictionary/getDictionaryDetails",
                {
                  businessDictionaryId: businessDictionaryId,
                  current: 1,
                  pageSize: 1000
                }
              );
              if (response1.flag) {
                if (response1.data.data && response1.data.data.length !== 0) {
                  this.optionsPlate = response1.data.data.map(i => {
                    return {
                      value: i.key,
                      label: i.name
                    }
                  })
                }
                console.log("🚀 ~ getOptionsPlate ~ this.optionsPlate:", this.optionsPlate)
              } else {
                message.error(response1.message);
              }
            }
          }
        } else {
          message.error(response.message);
        }
      } catch (error) {
        message.error('请求失败，请稍后重试');
      }
    },
    // 附加服务 options 数据
    async getOptionsService() {
      try {
        const response = await this.executeDatadictionaryInterface(
          "./Datadictionary/getBusinessDictionaries",
          {
            current: 1,
            pageSize: 1000
          }
        );
        if (response.flag) {
          if (response.data.data && response.data.data.length !== 0) {
            // 字典id
            let businessDictionaryId = null
            response.data.data.forEach(i => {
              if (i.key == 'Parking_service') {
                businessDictionaryId = i.id
              }
            })
            if (businessDictionaryId) {
              const response1 = await this.executeDatadictionaryInterface(
                "./Datadictionary/getDictionaryDetails",
                {
                  businessDictionaryId: businessDictionaryId,
                  current: 1,
                  pageSize: 1000
                }
              );
              if (response1.flag) {
                if (response1.data.data && response1.data.data.length !== 0) {
                  this.optionsService = response1.data.data.map(i => {
                    return {
                      value: i.key,
                      label: i.name
                    }
                  })
                }
                console.log("🚀 ~ getOptionsService ~ this.optionsService:", this.optionsService)
              } else {
                message.error(response1.message);
              }
            }
          }
        } else {
          message.error(response.message);
        }
      } catch (error) {
        message.error('请求失败，请稍后重试');
      }
    },
    // 运营模式 options 数据
    async getOptionsOperationMode() {
      try {
        const response = await this.executeDatadictionaryInterface(
          "./Datadictionary/getBusinessDictionaries",
          {
            current: 1,
            pageSize: 1000
          }
        );
        if (response.flag) {
          if (response.data.data && response.data.data.length !== 0) {
            // 字典id
            let businessDictionaryId = null
            response.data.data.forEach(i => {
              if (i.key == 'Operational_Model') {
                businessDictionaryId = i.id
              }
            })
            if (businessDictionaryId) {
              const response1 = await this.executeDatadictionaryInterface(
                "./Datadictionary/getDictionaryDetails",
                {
                  businessDictionaryId: businessDictionaryId,
                  current: 1,
                  pageSize: 1000
                }
              );
              if (response1.flag) {
                if (response1.data.data && response1.data.data.length !== 0) {
                  this.optionsOperationMode = response1.data.data.map(i => {
                    return {
                      value: i.key,
                      label: i.name
                    }
                  })
                }
                console.log("🚀 ~ getOptionsOperationMode ~ this.optionsOperationMode:", this.optionsOperationMode)
              } else {
                message.error(response1.message);
              }
            }
          }
        } else {
          message.error(response.message);
        }
      } catch (error) {
        message.error('请求失败，请稍后重试');
      }
    },
    // 运营公司 options 数据
    // async getOptionsOperationCompany() {
    //   try {
    //     const response = await this.executeDatadictionaryInterface(
    //       "./Datadictionary/getBusinessDictionaries",
    //       {
    //         current: 1,
    //         pageSize: 1000
    //       }
    //     );
    //     if (response.flag) {
    //       if (response.data.data && response.data.data.length !== 0) {
    //         // 字典id
    //         let businessDictionaryId = null
    //         response.data.data.forEach(i => {
    //           if (i.key == 'Operating_Company') {
    //             businessDictionaryId = i.id
    //           }
    //         })
    //         if (businessDictionaryId) {
    //           const response1 = await this.executeDatadictionaryInterface(
    //             "./Datadictionary/getDictionaryDetails",
    //             {
    //               businessDictionaryId: businessDictionaryId,
    //               current: 1,
    //               pageSize: 1000
    //             }
    //           );
    //           if (response1.flag) {
    //             if (response1.data.data && response1.data.data.length !== 0) {
    //               this.optionsOperationCompany = response1.data.data.map(i => {
    //                 return {
    //                   value: i.key,
    //                   label: i.name
    //                 }
    //               })
    //             }
    //             console.log("🚀 ~ getOptionsOperationCompany ~ this.optionsOperationCompany:", this.optionsOperationCompany)
    //           } else {
    //             message.error(response1.message);
    //           }
    //         }
    //       }
    //     } else {
    //       message.error(response.message);
    //     }
    //   } catch (error) {
    //     message.error('请求失败，请稍后重试');
    //   }
    // },
    // 对接平台 options 数据
    async getOptionsPlatform() {
      try {
        const response = await this.executeDatadictionaryInterface(
          "./Datadictionary/getBusinessDictionaries",
          {
            current: 1,
            pageSize: 1000
          }
        );
        if (response.flag) {
          if (response.data.data && response.data.data.length !== 0) {
            // 字典id
            let businessDictionaryId = null
            response.data.data.forEach(i => {
              if (i.key == 'Docking_Platform') {
                businessDictionaryId = i.id
              }
            })
            if (businessDictionaryId) {
              const response1 = await this.executeDatadictionaryInterface(
                "./Datadictionary/getDictionaryDetails",
                {
                  businessDictionaryId: businessDictionaryId,
                  current: 1,
                  pageSize: 1000
                }
              );
              if (response1.flag) {
                if (response1.data.data && response1.data.data.length !== 0) {
                  this.optionsPlatform = response1.data.data.map(i => {
                    return {
                      value: i.key,
                      label: i.name
                    }
                  })
                }
                console.log("🚀 ~ getOptionsPlatform ~ this.optionsPlatform:", this.optionsPlatform)
              } else {
                message.error(response1.message);
              }
            }
          }
        } else {
          message.error(response.message);
        }
      } catch (error) {
        message.error('请求失败，请稍后重试');
      }
    },
    // 运营公司 options 数据
    async getOptionsOperationCompany() {
      try {
        const response = await this.executeDatadictionaryInterface(
          "./Organizationmanagement/getOrganizationsUVU",
          {
            current: 1,
            pageSize: 1000
          }
        );
        if (response.flag) {
          console.log("运营公司 ~ getOptionsOperationCompany ~ this.getOptionsOperationCompany:", response.data)
          if (response.data && response.data.length !== 0) {
            this.optionsOperationCompany = response.data.map(i => {
              return {
                value: i.id.toString(),
                label: i.name
              }
            })
          }
          console.log("🚀 ~ getOptionsOperationCompany ~ this.optionsOperationCompany:", this.optionsOperationCompany)
        } else {
          message.error(response.message);
        }
      } catch (error) {
        message.error('请求失败，请稍后重试');
      }
    },
    // 车场管理员 options 数据
    async getOptionsConservator() {
      try {
        const response = await this.executeDatadictionaryInterface(
          "./Usermanagement/getUsers",
          {
            current: 1,
            pageSize: 1000
          }
        );
        if (response.flag) {
          console.log("车场管理员 ~ getOptionsConservator ~ this.getOptionsConservator:", response.data)
          if (response.data.data && response.data.data.length !== 0) {
            this.optionsConservator = response.data.data.map(i => {
              return {
                value: i.user_name,
                label: i.nick_name
              }
            })
          }
          console.log("🚀 ~ getOptionsConservator ~ this.optionsConservator:", this.optionsConservator)
        } else {
          message.error(response.message);
        }
      } catch (error) {
        message.error('请求失败，请稍后重试');
      }
    },
    // 新增 基础信息 车场图标 附件处理
    handleChangeYardIconfileList2 (info) {
      console.log("🚀 ~ handleChange ~ info:", info)
      let resFileList = [...info.fileList];

      resFileList = resFileList.map(file => {
        if (file.response) {
          // file.url = 'http://127.0.0.1:9001/api' + file.response.data;
          file.url = `/api/staticCommonUpload/${file.response.data}`
        }
        // return file;
        return {
          uid: file.uid,
          name: file.name,
          url: file.url
        }
      });
      this.Basicinformationform2.YardIconfileList2 = resFileList;
      console.log("🚀 ~ handleChange ~ this.Basicinformationform2.YardIconfileList2-车场图标:", this.Basicinformationform2.YardIconfileList2)
    },
    // 新增 基础信息 车场照片 附件处理
    handleChangeYardPhotosfileList2 (info) {
      console.log("🚀 ~ handleChange ~ info:", info)
      let resFileList = [...info.fileList];

      resFileList = resFileList.map(file => {
        if (file.response) {
          // file.url = 'http://127.0.0.1:9001/api' + file.response.data;
          file.url = `/api/staticCommonUpload/${file.response.data}`
        }
        // return file;
        return {
          uid: file.uid,
          name: file.name,
          url: file.url
        }
      });
      this.Basicinformationform2.YardPhotosfileList2 = resFileList;
      console.log("🚀 ~ handleChange ~ this.Basicinformationform2.YardPhotosfileList2-车场照片:", this.Basicinformationform2.YardPhotosfileList2)
    },
    // 新增 拓展信息 附件上传 附件处理
    handleChangeAttachmentUploadfileList2 (info) {
      console.log("🚀 ~ handleChange ~ info:", info)
      let resFileList = [...info.fileList];

      resFileList = resFileList.map(file => {
        if (file.response) {
          // file.url = 'http://127.0.0.1:9001/api' + file.response.data;
          file.url = `/api/staticCommonUpload/${file.response.data}`
        }
        // return file;
        return {
          uid: file.uid,
          name: file.name,
          url: file.url
        }
      });
      this.Expandinformationform2.AttachmentUploadfileList2 = resFileList;
      console.log("🚀 ~ handleChange ~ this.Expandinformationform2.AttachmentUploadfileList2-附件上传:", this.Expandinformationform2.AttachmentUploadfileList2)
    },
    // 编辑 基础信息 车场图标 附件处理
    handleChangeYardIconfileList1 (info) {
      console.log("🚀 ~ handleChange ~ info:", info)
      let resFileList = [...info.fileList];

      resFileList = resFileList.map(file => {
        if (file.response) {
          // file.url = 'http://127.0.0.1:9001/api' + file.response.data;
          file.url = `/api/staticCommonUpload/${file.response.data}`
        }
        // return file;
        return {
          uid: file.uid,
          name: file.name,
          url: file.url
        }
      });
      this.Basicinformationform3.YardIconfileList1 = resFileList;
      console.log("🚀 ~ handleChange ~ this.Basicinformationform3.YardIconfileList1-车场图标:", this.Basicinformationform3.YardIconfileList1)
    },
    // 编辑 基础信息 车场照片 附件处理
    handleChangeYardPhotosfileList1 (info) {
      console.log("🚀 ~ handleChange ~ info:", info)
      let resFileList = [...info.fileList];

      resFileList = resFileList.map(file => {
        if (file.response) {
          // file.url = 'http://127.0.0.1:9001/api' + file.response.data;
          file.url = `/api/staticCommonUpload/${file.response.data}`
        }
        // return file;
        return {
          uid: file.uid,
          name: file.name,
          url: file.url
        }
      });
      this.Basicinformationform3.YardPhotosfileList1 = resFileList;
      console.log("🚀 ~ handleChange ~ this.Basicinformationform3.YardPhotosfileList1-车场照片:", this.Basicinformationform3.YardPhotosfileList1)
    },
    // 编辑 拓展信息 附件上传 附件处理
    handleChangeAttachmentUploadfileList1 (info) {
      console.log("🚀 ~ handleChange ~ info:", info)
      let resFileList = [...info.fileList];

      resFileList = resFileList.map(file => {
        if (file.response) {
          // file.url = 'http://127.0.0.1:9001/api' + file.response.data;
          file.url = `/api/staticCommonUpload/${file.response.data}`
        }
        // return file;
        return {
          uid: file.uid,
          name: file.name,
          url: file.url
        }
      });
      this.Expandinformationform3.AttachmentUploadfileList1 = resFileList;
      console.log("🚀 ~ handleChange ~ this.Expandinformationform3.AttachmentUploadfileList1-附件上传:", this.Expandinformationform3.AttachmentUploadfileList1)
    },
    // 停用
    handleDeactivateYard(record) {
      console.log("🚀 ~ handleDeactivateYard ~ record:", record)
      let selectedParkingLotCodes = [record]
      console.log("🚀 ~ handleDeactivateYard ~ selectedParkingLotCodes:", selectedParkingLotCodes)
      // 弹出确认对话框
      Modal.confirm({
        title: '确认停用',
        content: '您确定要停用选中的车场吗？',
        onOk: async () => {
          this.Deactivation1loading3 = true;
          try {
            // 调用后端接口更新车场状态
            const response = await this.executeBackendInterface('updateSelectedYardsStatus', {
              selectedParkingLotCodes
            });
            if (response.flag) {
              message.success('车场已成功停用');
              // 刷新车场列表
              this.initializeParkingLotList();
              // await this.refreshYardList();
            } else {
              message.error(response.message || '停用失败');
            }
          } catch (error) {
            message.error('请求失败，请稍后重试');
          } finally {
            this.Deactivation1loading3 = false;
          }
        },
        onCancel: () => {
          // 取消操作
        }
      });
    },
    // 车场配置 启用
    handleDeactivateEnableYard(record) {
      console.log("🚀 ~ handleDeactivateEnableYard ~ record:", record)
      let selectedParkingLotCodes = [record]
      console.log("🚀 ~ handleDeactivateEnableYard ~ selectedParkingLotCodes:", selectedParkingLotCodes)
      // 弹出确认对话框
      Modal.confirm({
        title: '确认启用',
        content: '您确定要启用选中的车场吗？',
        onOk: async () => {
          this.Deactivation1loading3 = true;
          try {
            // 调用后端接口更新车场状态
            const response = await this.executeBackendInterface('reuseSelectedYardsStatus', {
              selectedParkingLotCodes
            });
            if (response.flag) {
              message.success('车场已成功启用');
              // 刷新车场列表
              this.initializeParkingLotList();
              // await this.refreshYardList();
            } else {
              message.error(response.message || '启用失败');
            }
          } catch (error) {
            message.error('请求失败，请稍后重试');
          } finally {
            this.Deactivation1loading3 = false;
          }
        },
        onCancel: () => {
          // 取消操作
        }
      });
    },
    // handleDeactivateYard(record) {
    //   console.log("🚀 ~ handleDeactivateYard ~ record:", record)
    //   // 弹出确认对话框
    //   Modal.confirm({
    //     title: '确认停用',
    //     content: `确定要停用车场编号为 ${record.yardnumber} 的车场吗？`,
    //     onOk: async () => {
    //       // 设置加载状态
    //       // this.Deactivation1loading1 = true;
    //       try {
    //         // 模拟后端请求
    //         await new Promise(resolve => setTimeout(resolve, 1000));
    //         // 更新车场状态
    //         record.statusoftheyard = '已停用';
    //         message.success('车场已成功停用');
    //       } catch (error) {
    //         message.error('停用失败，请重试');
    //       } finally {
    //         // 取消加载状态
    //         // this.Deactivation1loading1 = false;
    //       }
    //     },
    //     onCancel: () => {
    //       message.info('取消停用操作');
    //     }
    //   });
    // },
    async handleResetFilters() {
      // 清空输入框的值
      this.Nameofyardvalue1 = '';
      this.OperatingCompanyvalue1 = '';
      this.Areavalue1 = [];
      this.Typeofyardvalue1 = [];
      this.Categoryofyardvalue1 = [];
      this.Platevalue1 = [];
      this.Statusoftheyardvalue1 = [];
      this.YardListcurrent2 = 1

      // 初始化车场列表
      this.initializeParkingLotList();
      // try {
      //   const response = await this.executeBackendInterface('getYardList', {
      //     Nameofyardvalue1: this.Nameofyardvalue1,
      //     OperatingCompanyvalue1: this.OperatingCompanyvalue1,
      //     Areavalue1: this.Areavalue1,
      //     current: 1,
      //     pageSize: 10
      //   });
      //   if (response.flag) {
      //     // 处理返回的数据
      //     const data = response.data;
      //     // 假设有一个变量来存储车场列表数据
      //     this.parkingLotList = data.data.map(item => ({
      //       id: item.id,
      //       parking_lot_name: item.parking_lot_name,
      //       operating_company: item.operating_company,
      //       region: item.region,
      //       create_time: item.create_time
      //     }));
      //   } else {
      //     message.error(response.message);
      //   }
      // } catch (error) {
      //   message.error('获取车场列表失败');
      // }
    },
    async handleSearchYards(type) {
      // 设置加载状态
      this.Checkloading1 = true;
      // 查询 操作
      if (type === 'search') {
          this.YardListcurrent2 = 1
        }
      try {
        // 调用后端接口，传递查询参数
        const response = await this.executeBackendInterface('searchYardList', {
          // 车场名称
          Nameofyardvalue1: this.Nameofyardvalue1,
          // 运营公司
          OperatingCompanyvalue1: this.OperatingCompanyvalue1,
          // 所属区域
          Areavalue1: this.Areavalue1,
          // 车场类型
          parkingLotType: this.Typeofyardvalue1,
          // 车场类别
          category: this.Categoryofyardvalue1,
          // 所属板块
          sector: this.Platevalue1,
          // 车场状态
          parkingLotStatus: this.Statusoftheyardvalue1,
          // 需要根据实际需求设置
          current: this.YardListcurrent2,
          // 当前页码
          pageSize: this.YardListpageSize1 // 每页显示数量
        });

        // 检查接口调用结果
        if (response.flag) {
          // 处理返回的数据
          this.YardListdata1.dataSource = response.data.data.map(item => ({
            id: item.id,
            // serialNumber: item.sequence_number,
            serialNumber: item.row_index,
            yardnumber: item.parking_lot_code,
            nameofyard: item.parking_lot_name,
            // area: item.region,
            // area: item.region ? item.region.replace(/\[\[|\]\]|, /g, '') : item.region,
            area: item.region ? item.region.slice(1, -1).replace(/, /g, '') : item.region,
            plate: item.sector,
            categoryofyard: item.category,
            typeofyard: item.parking_lot_type,
            statusoftheyard: item.parking_lot_status,
            numberofparking: item.parking_spaces,
            operatingCompany: item.operating_company,
            personincharge1: item.manager,
            contactPhone1: item.contact_number,
            operation1: item.operation
          }));
          this.YardListtotal1 = response.data.total;

          // const data = response.data.data.map(item => ({
          //   id: item.id,
          //   parking_lot_code: item.parking_lot_code,
          //   parking_lot_name: item.parking_lot_name,
          //   region: item.region,
          //   sector: item.sector,
          //   category: item.category,
          //   parking_lot_type: item.parking_lot_type,
          //   parking_lot_status: item.parking_lot_status,
          //   operating_company: item.operating_company,
          //   create_time: item.create_time
          // }));

          // 按创建时间倒序排序
          // data.sort((a, b) => new Date(b.create_time) - new Date(a.create_time));

          // 在此处更新车场列表的显示
          // this.parkingLotList = data; // 假设有一个变量用于存储车场列表

          message.success('查询成功');
        } else {
          message.error(response.message || '查询失败');
        }
      } catch (error) {
        message.error('查询过程中发生错误');
      } finally {
        // 取消加载状态
        this.Checkloading1 = false;
      }
    },
    // 重置 新建弹窗 表单
    handleRestAdd () {
      // 基础信息 新增回显 Basicinformationform2
      for (let key in this.Basicinformationform2) {
        this.Basicinformationform2[key] = null
      }
      // 平台信息 新增回显 PlatformInformationform2
      for (let key in this.PlatformInformationform2) {
        this.PlatformInformationform2[key] = null
      }
      // 运营规则 新增回显 OperatingRulesform2
      for (let key in this.OperatingRulesform2) {
        if (key === 'abnormalHandle') {
          this.OperatingRulesform2['abnormalHandle'] = [{
            status: null,
            handle: null,
            notify: '否',
            time: null
          }]
        } else {
          this.OperatingRulesform2[key] = null
        }
      }
      // 计费规则 新增回显 BillingRulesNewform1
      for (let key in this.BillingRulesNewform1) {
        this.BillingRulesNewform1[key] = null
      }
      // 岗亭管理 新增回显 PostManagementNewform1
      for (let key in this.PostManagementNewform1) {
        this.PostManagementNewform1[key] = null
      }
      // 拓展信息 新增回显 Expandinformationform2
      for (let key in this.Expandinformationform2) {
        this.Expandinformationform2[key] = null
      }
    },
    showNewYardModal() {
      // 显示新增车场弹窗
      this.NewdepotisShow1 = true
      this.NewYardMenuselectedKeys1 = ["基础信息"]
      this.NewYardDynamicPanelselectKey1 = "1";

      // // 重置 新建弹窗 表单
      // this.handleRestAdd()

      // 生成车场编号
      const yardNumber = `YARD-${Date.now()}`;
      this.Basicinformationform2.yardnumbervalue2 = yardNumber;


      // Modal.confirm({
      //   title: '新增车场',
      //   content: '确定要新增车场吗？',
      //   onOk: async () => {
      //     // 在这里实现点击确认后的逻辑
      //     // 例如：设置动态面板为状态一
      //     // this.$refs.ref2854._$$customeMutileKeys = "1";
      //     this.NewdepotisShow1 = true
      //     this.NewYardMenuselectedKeys1 = ["基础信息"]
      //     this.NewYardDynamicPanelselectKey1 = "1";
      //   },
      //   onCancel: () => {
      //     // 在这里实现点击取消后的逻辑
      //   }
      // });
    },
    // 批量 停用
    async handleDeactivateSelectedYards() {
      // 获取选中的车场代码
      // const selectedParkingLotCodes = this.getSelectedParkingLotCodes(); // 假设有一个方法可以获取选中的车场代码
      const selectedParkingLotCodes = this.YardListselectedRows1
      console.log("🚀 ~ handleDeactivateSelectedYards ~ selectedParkingLotCodes:", selectedParkingLotCodes)

      if (!selectedParkingLotCodes || selectedParkingLotCodes.length === 0) {
        message.warning('请选择至少一行');
        return;
      }

      // 弹出确认对话框
      Modal.confirm({
        title: '确认停用',
        content: '您确定要停用选中的车场吗？',
        onOk: async () => {
          this.Deactivation1loading3 = true;
          try {
            // 调用后端接口更新车场状态
            const response = await this.executeBackendInterface('updateSelectedYardsStatus', {
              selectedParkingLotCodes
            });
            if (response.flag) {
              message.success('车场已成功停用');
              // 刷新车场列表
              this.initializeParkingLotList();
              // await this.refreshYardList();
            } else {
              message.error(response.message || '停用失败');
            }
          } catch (error) {
            message.error('请求失败，请稍后重试');
          } finally {
            this.Deactivation1loading3 = false;
          }
        },
        onCancel: () => {
          // 取消操作
        }
      });
    },
    // 车场配置 批量 启用
    async handleDeactivateEnableSelectedYards() {
      // 获取选中的车场代码
      // const selectedParkingLotCodes = this.getSelectedParkingLotCodes(); // 假设有一个方法可以获取选中的车场代码
      const selectedParkingLotCodes = this.YardListselectedRows1
      console.log("🚀 ~ handleDeactivateEnableSelectedYards ~ selectedParkingLotCodes:", selectedParkingLotCodes)

      if (!selectedParkingLotCodes || selectedParkingLotCodes.length === 0) {
        message.warning('请选择至少一行');
        return;
      }

      // 弹出确认对话框
      Modal.confirm({
        title: '确认启用',
        content: '您确定要启用选中的车场吗？',
        onOk: async () => {
          this.Deactivation1loading3 = true;
          try {
            // 调用后端接口更新车场状态
            const response = await this.executeBackendInterface('reuseSelectedYardsStatus', {
              selectedParkingLotCodes
            });
            if (response.flag) {
              message.success('车场已成功启用');
              // 刷新车场列表
              this.initializeParkingLotList();
              // await this.refreshYardList();
            } else {
              message.error(response.message || '启用失败');
            }
          } catch (error) {
            message.error('请求失败，请稍后重试');
          } finally {
            this.Deactivation1loading3 = false;
          }
        },
        onCancel: () => {
          // 取消操作
        }
      });
    },
    getSelectedParkingLotCodes() {
      // 假设有一个方法可以获取选中的车场代码
      // 这里需要根据实际情况实现
      return [];
    },
    async refreshYardList() {
      // 刷新车场列表的方法
      // 这里需要根据实际情况实现
    },
    handleNewYardMenuSelection() {
      // 获取当前选中的菜单项
      const selectKey = this.NewYardMenuselectedKeys1[0];
      console.log("🚀 ~ handleNewYardMenuSelection ~ selectKey:", selectKey)

      // 根据选中的菜单项切换动态面板的状态
      switch (selectKey) {
        case "基础信息":
          this.NewYardDynamicPanelselectKey1 = "1";
          break;
        case "平台信息":
          this.NewYardDynamicPanelselectKey1 = "2";
          break;
        case "运营规则":
          this.NewYardDynamicPanelselectKey1 = "3";
          break;
        case "计费规则":
          this.NewYardDynamicPanelselectKey1 = "4";
          break;
        case "岗亭管理":
          this.NewYardDynamicPanelselectKey1 = "5";
          break;
        case "拓展信息":
          this.NewYardDynamicPanelselectKey1 = "6";
          break;
        default:
          console.log("未知的菜单项!");
      }
    },
    // 编辑 回显
    async handleEditYard(record) {
      this.yardeditorisShow1 = true;
      this.YardEditMenuselectedKeys1 = ["基础信息"]
      this.YardEditDynamicPanelselectKey1 = "1";

      // 重置 编辑弹窗 表单
      this.handleRestEdit()

      // 获取 岗亭列表 编辑
      this.getEditPostPersonnelList(record.id)

      // 获取 计费规则列表 编辑
      this.getEditYardBillingRules(record.id)

      const response = await this.executeBackendInterface('getYardDetails', {
        id: record.id
      });
      if (response.flag) {
        const data = response.data;
        // 基础信息 编辑回显
        const basicInfo = data.basicInfo[0];
        this.Basicinformationform3 = {
          ...this.Basicinformationform3,
          id: record.id,
          yardnumbervalue3: basicInfo.parking_lot_code,
          Nameofyard1value3: basicInfo.parking_lot_name,
          Yardabbreviationvalue3: basicInfo.parking_lot_short_name,
          Numberofparkingvalue3: basicInfo.parking_spaces,
          Longtermrentalparkingspacesvalue3: basicInfo.long_term_spaces,
          Reservationofparkingspacevalue3: basicInfo.reserved_spaces,
          VIPParkingvalue3: basicInfo.vip_spaces,
          Numberofchargingpilesvalue3: basicInfo.charging_piles,
          OperatingCompany1value3: basicInfo.operating_company,
          Personinchargevalue3: basicInfo.manager,
          ContactPhonevalue4: basicInfo.contact_number,
          latitudeandlongitudevalue3: basicInfo.latitude_longitude,
          Detailedaddressvalue3: basicInfo.detailed_address,
          YardDescriptionvalue3: basicInfo.parking_lot_description,
          yardstatus1value3: basicInfo.parking_lot_status,
          Typeofyard1value3: basicInfo.parking_lot_type,
          Area1value3: basicInfo.region,
          Area1value3: basicInfo.region ? basicInfo.region.slice(1, -1).split(', ') : [],
          YardCategory1value3: basicInfo.category,
          Plate1value3: basicInfo.sector,
          Chargingservicevalue3: basicInfo.charging_service,
          AdditionalServicesvalue3: basicInfo.additional_service,
          Whetherthelargescreenisvisiblevalue3: basicInfo.screen_visibility ? '是' : '否',
          // 车场图标
          YardIconfileList1: basicInfo.parking_lot_icon ? JSON.parse(basicInfo.parking_lot_icon) : [],
          // 车场照片
          YardPhotosfileList1: basicInfo.parking_lot_photo ? JSON.parse(basicInfo.parking_lot_photo) : [],
        };
        // 计费规则 编辑回显
        // this.BillingRuleEditform1.BillingRulesvalue1 = basicInfo?.bill_rule_id ? basicInfo?.bill_rule_id.toString() : null
        console.log("🚀 ~ handleEditYard ~ this.BillingRuleEditform1.BillingRulesvalue1:", this.BillingRuleEditform1.BillingRulesvalue1)
        // 平台信息 编辑回显
        const platformInfo = data.platformInfo[0];
        this.PlatformInformationform3 = {
          ...this.PlatformInformationform3,
          Operationmodevalue3: platformInfo.operating_mode,
          OperatingCompanyvalue4: platformInfo.operating_company,
          dockingplatformvalue3: platformInfo.docking_platform,
          conservator: platformInfo.conservator,
        };
        // 运营规则 编辑回显
        const operationRules = data.operationRules[0];
        this.OperatingRulesform3 = {
          ...this.OperatingRulesform3,
          PrepaidTimeoutDurationvalue3: operationRules.prepayment_overtime_duration,
          Timeoutdoesnotleaveprocessingvalue3: operationRules.overtime_exit_handling,
          Abnormalstatevalue3: operationRules.abnormal_status,
          ExceptionHandlingvalue3: operationRules.abnormal_handling,
          Notifyvalue7: operationRules.notification ? '是' : '否',
          Notifyvalue8: operationRules.notification ? '是' : '否',
          Notifyvalue9: operationRules.notification ? '是' : '否',
          blacklistvalue3: operationRules.blacklist,
          WhiteListvalue3: operationRules.whitelist,
          Reservedcarnumbervalue3: operationRules.reserved_spaces_count,
          Appointmenttimeoutdurationvalue3: operationRules.reservation_overtime_duration,
          AppearanceSweepCodevalue3: operationRules.exit_scan,
          // AppearanceSweepCodevalue3: operationRules.exit_scan ? '开启' : '关闭',
          // 异常车辆处理
          abnormal_status_duplicate: operationRules.abnormal_status_duplicate, //	异常车状态:重复入场
          abnormal_status_no_in_car: operationRules.abnormal_status_no_in_car, //	异常车状态:无驶入车
          abnormal_status_force: operationRules.abnormal_status_force, //	异常车状态:强制抬杆
          abnormal_status_other: operationRules.abnormal_status_other, //	异常车状态:其他
          abnormal_handling_duplicate: operationRules.abnormal_handling_duplicate, //	异常车处理:重复入场
          abnormal_handling_no_in_car: operationRules.abnormal_handling_no_in_car, //	异常车处理:无驶入车
          abnormal_handling_force: operationRules.abnormal_handling_force, //	异常车处理:强制抬杆
          abnormal_handling_other: operationRules.abnormal_handling_other, //	异常车处理:其他
          abnormal_duplicate_notification: operationRules.abnormal_duplicate_notification, //	异常车通知:重复入场
          abnormal_no_in_car_notification: operationRules.abnormal_no_in_car_notification, //	异常车通知:无驶入车
          abnormal_force_notification: operationRules.abnormal_force_notification, //	异常车通知:强制抬杆
          abnormal_other_notification: operationRules.abnormal_other_notification, //	异常车通知:其他
          abnormal_duplicate_block_time: operationRules.abnormal_duplicate_block_time, //	异常车拉黑时长:重复入场
          abnormal_no_in_car_block_time: operationRules.abnormal_no_in_car_block_time, //	异常车拉黑时长:无驶入车
          abnormal_force_block_time: operationRules.abnormal_force_block_time, //	异常车拉黑时长:强制抬杆
          abnormal_other_block_time: operationRules.abnormal_other_block_time, //	异常车拉黑时长:其他
        };
        // 运营规则 异常车辆处理
        this.OperatingRulesform3.abnormalHandle = [
          {
            // 重复入场
            status: this.OperatingRulesform3.abnormal_status_duplicate || null,
            handle: this.OperatingRulesform3.abnormal_handling_duplicate || null,
            notify: this.OperatingRulesform3.abnormal_duplicate_notification || '否',
            time: this.OperatingRulesform3.abnormal_duplicate_block_time || null
          },
          {
            // 无驶入车
            status: this.OperatingRulesform3.abnormal_status_no_in_car || null,
            handle: this.OperatingRulesform3.abnormal_handling_no_in_car || null,
            notify: this.OperatingRulesform3.abnormal_no_in_car_notification || '否',
            time: this.OperatingRulesform3.abnormal_no_in_car_block_time || null
          },
          {
            // 强制抬杆
            status: this.OperatingRulesform3.abnormal_status_force || null,
            handle: this.OperatingRulesform3.abnormal_handling_force || null,
            notify: this.OperatingRulesform3.abnormal_force_notification || '否',
            time: this.OperatingRulesform3.abnormal_force_block_time || null
          },
          {
            // 其他
            status: this.OperatingRulesform3.abnormal_status_other || null,
            handle: this.OperatingRulesform3.abnormal_handling_other || null,
            notify: this.OperatingRulesform3.abnormal_other_notification || '否',
            time: this.OperatingRulesform3.abnormal_other_block_time || null
          },
        ]
        this.OperatingRulesform3.abnormalHandle = this.OperatingRulesform3.abnormalHandle.filter(item => item.status !== "" && item.status != null)

        if (this.OperatingRulesform3.abnormalHandle && this.OperatingRulesform3.abnormalHandle.length === 0) {
          this.OperatingRulesform3.abnormalHandle = [{
            // 其他
            status: null,
            handle: null,
            notify: '否',
            time: null
          }]
        }
        console.log("🚀 ~ handleEditYard 编辑回显 ~ this.OperatingRulesform3.abnormalHandle:", this.OperatingRulesform3.abnormalHandle)
        console.log("🚀 ~ handleEditYard 编辑回显 ~ OperatingRulesform3:", this.OperatingRulesform3)

        // 预约车位 自动同步
        this.Basicinformationform3.Reservationofparkingspacevalue3 = operationRules.reserved_spaces_count

        // 计费规则列表
        // this.yardbillingrulesdata2.dataSource = data.billingRules.map(rule => ({
        //   id: rule.id,
        //   serialNumber: rule.serial_number,
        //   ruleName: rule.rule_name,
        //   chargingscheme: rule.charging_scheme,
        //   ruleDescription: rule.rule_description,
        //   associatedTime: rule.associated_time,
        //   associatedPerson: rule.associated_person,
        //   status: rule.status
        // }));
        // 岗亭管理 编辑回显
        const boothInfo = data.boothManagement[0];
        // this.PostManagementEditform1 = {
        //   ...this.PostManagementEditform1,
        //   Namevalue2: boothInfo.name,
        //   Mobilephonenumbervalue2: boothInfo.phone_number,
        //   IdentityCardvalue2: boothInfo.id_card
        // };
        // this.ListofPostPersonneldata2.dataSource = data.boothManagement.map(person => ({
        //   name: person.name,
        //   mobilephonenumber1: person.phone_number,
        //   identityCard: person.id_card
        // }));
        // 拓展信息 编辑回显
        console.log("🚀 ~ handleEditYard ~ this.ListofPostPersonneldata2.dataSource:", this.ListofPostPersonneldata2.dataSource)
        const extendedInfo = data.extendedInfo[0];
        this.Expandinformationform3 = {
          ...this.Expandinformationform3,
          PropertyUnitvalue3: extendedInfo.property_unit,
          BuildingPropertiesvalue3: extendedInfo.building_attribute,
          LicenseNumbervalue3: extendedInfo.license_number,
          BusinessScopevalue3: extendedInfo.business_scope,
          Contactvalue3: extendedInfo.contact_person,
          ContactPhonevalue6: extendedInfo.contact_phone,
          Expandinformationvalue3: extendedInfo.property_description,
          Servicelifevalue3: extendedInfo.usage_years,
          Constructiontimevalue3: extendedInfo.construction_time,
          ValidityPeriodvalue3: extendedInfo.validity_period,
          // 附件上传
          AttachmentUploadfileList1: extendedInfo.attachment_upload ? JSON.parse(extendedInfo.attachment_upload) : [],
        };
        this.FileAttachmentListdata2.dataSource = data.fileAttachments.map(file => ({
          id: file.id,
          serialNumber: file.serial_number,
          attachmentName: file.attachment_name,
          uploadtime: file.upload_time,
          creator1: file.creator
        }));
      } else {
        message.error(response.message);
      }
    },
    // 获取 岗亭列表 编辑
    async getEditPostPersonnelList(parkingLotId) {
      try {
        const response = await this.executeBackendInterface('getPostPersonnelList', {
          parkingLotId: parkingLotId,
          current: this.ListofPostPersonnelcurrent3,
          pageSize: this.ListofPostPersonnelpageSize2
        });
        if (response.flag) {
          this.ListofPostPersonneldata2.dataSource = response.data.data.map(item => ({
            id: item.id,
            serialNumber: item.id,
            name: item.name,
            mobilephonenumber1: item.phone_number,
            status: item.status,
            entrytime: item.entry_time,
            turnovertime: item.resignation_time
          }));
          // this.ListofPostPersonneldata1.dataSource = response.data.data.map(item => ({
          //   id: item.id,
          //   serialNumber: item.serial_number,
          //   name: item.name,
          //   mobilephonenumber1: item.phone_number,
          //   status: item.status,
          //   entrytime: item.entry_time,
          //   turnovertime: item.resignation_time
          // }));
          this.ListofPostPersonneltotal2 = response.data.total;
        } else {
          message.error(response.message);
        }
      } catch (error) {
        message.error('Failed to fetch post personnel list.');
      }
    },
    // 获取 计费规则列表 编辑
    async getEditYardBillingRules(parkingLotId) {
      try {
        const response = await this.executeBackendInterface('getYardBillingRuleByParkingId', {
          parkingLotId: parkingLotId,
          current: this.yardbillingrulescurrent3,
          pageSize: this.yardbillingrulespageSize2
        });
        if (response.flag) {
          this.yardbillingrulesdata2.dataSource = response.data.data.map(item => ({
            id: item.id,
            serialNumber: item.id,
            ruleName: item.rule_name,
            chargingscheme: item.billing_standard,
            ruleDescription: item.rule_description,
            associatedTime: item.relation_time,
            associatedPerson: item.relation_username,
            status: item.enable_status
          }));
          // this.yardbillingrulesdata1.dataSource = response.data.data.map(item => ({
          //   id: item.id,
          //   serialNumber: item.serial_number,
          //   ruleName: item.rule_name,
          //   chargingScheme: item.charging_scheme,
          //   ruleDescription: item.rule_description,
          //   associatedTime: item.associated_time,
          //   associatedPerson: item.associated_person,
          //   status: item.status
          // }));
          this.yardbillingrulestotal2 = response.data.total;
        } else {
          message.error(response.message);
        }
      } catch (error) {
        message.error('Failed to fetch yard billing rules.');
      }
    },
    // 重置 编辑弹窗 表单
    handleRestEdit() {
      // 基础信息 编辑回显 Basicinformationform3
      for (let key in this.Basicinformationform3) {
        this.Basicinformationform3[key] = null
      }
      // 平台信息 编辑回显 PlatformInformationform3
      for (let key in this.PlatformInformationform3) {
        this.PlatformInformationform3[key] = null
      }
      // 运营规则 编辑回显 OperatingRulesform3
      for (let key in this.OperatingRulesform3) {
        if (key === 'abnormalHandle') {
          this.OperatingRulesform3['abnormalHandle'] = [{
            status: null,
            handle: null,
            notify: '否',
            time: null
          }]
        } else {
          this.OperatingRulesform3[key] = null
        }
      }
      // 计费规则 编辑回显 BillingRuleEditform1
      for (let key in this.BillingRuleEditform1) {
        this.BillingRuleEditform1[key] = null
      }
      // 岗亭管理 编辑回显 PostManagementEditform1
      for (let key in this.PostManagementEditform1) {
        this.PostManagementEditform1[key] = null
      }
      // 拓展信息 编辑回显 Expandinformationform3
      for (let key in this.Expandinformationform3) {
        this.Expandinformationform3[key] = null
      }
    },
    // 计费规则 添加 编辑弹窗
    async handleAddBillingRule() {
      // 获取表单数据
      if (!this.BillingRuleEditform1.BillingRulesvalue1) return message.error('请选择计费规则后添加');
      // 计费规则下拉框ID
      const billingRuleId = this.BillingRuleEditform1.BillingRulesvalue1;
      console.log("🚀 ~ handleAddBillingRule ~ billingRuleId:", billingRuleId)

      // 弹出确认对话框
      Modal.confirm({
        title: '确认添加',
        content: '您确定要添加该计费规则吗？',
        onOk: async () => {
          try {
            // 调用后端接口
            const response = await this.executeBackendInterface('addBillingRule', {
              billingRuleId: Number(billingRuleId), // 计费规则下拉框ID
              parkingLotInfoId: this.Basicinformationform3.id // 停车场ID
            });

            // 检查接口调用结果
            if (response.flag) {
              message.success('计费规则添加成功');
              // 更新计费规则列表数据
              // 获取 计费规则列表 编辑
              this.getEditYardBillingRules(this.Basicinformationform3.id)

            } else {
              message.error(response.message || '添加失败');
            }
          } catch (error) {
            message.error('接口调用失败');
          }
        },
        onCancel: () => {
          message.info('取消添加');
        }
      });
    },
    // async handleAddBillingRule() {
    //   const response = await this.executeBackendInterface('searchBillingRules', {
    //     ruleName: this.BillingRuleEditform1.BillingRulesvalue1,
    //     current: this.yardbillingrulescurrent3,
    //     pageSize: this.yardbillingrulespageSize2
    //   });
    //   if (response.flag) {
    //     const rules = response.data.data;
    //     const currentTime = new Date().toISOString();
    //     const currentUser = '当前用户';
    //     for (const rule of rules) {
    //       await this.executeBackendInterface('addYardBillingRule', {
    //         parkingLotId: this.Basicinformationform3.id,
    //         ruleId: rule.id
    //       });
    //       this.yardbillingrulesdata2.dataSource.push({
    //         id: rule.id,
    //         serialNumber: rule.serial_number,
    //         ruleName: rule.rule_name,
    //         chargingscheme: rule.charging_scheme,
    //         ruleDescription: rule.rule_description,
    //         associatedTime: currentTime,
    //         associatedPerson: currentUser,
    //         status: '待生效'
    //       });
    //     }
    //   } else {
    //     message.error(response.message);
    //   }
    // },
    async handleDeleteRow(record) {
      // 弹出确认对话框
      Modal.confirm({
        title: '确认删除',
        content: '您确定要删除这条记录吗？',
        onOk: async () => {
          try {
            // 调用后端接口删除数据
            const response = await this.executeBackendInterface('deleteRowData', {
              id: record.id
            });
            if (response.flag) {
              message.success('删除成功');
              // 在此处添加删除成功后的逻辑，例如刷新表格数据
            } else {
              message.error(`删除失败: ${response.message}`);
            }
          } catch (error) {
            message.error('删除失败，请稍后重试');
          }
        },
        onCancel: () => {
          // 取消删除操作
        }
      });
    },
    // 岗亭管理 离职 编辑弹窗
    handleEmployeeResignation(record) {
      Modal.confirm({
        title: '确认离职',
        content: '您确定要将该员工状态改为离职吗？',
        onOk: async () => {
          try {
            // 调用后端接口
            const response = await this.executeBackendInterface('updateEmployeeStatus', {
              id: record.id // 岗亭管理列表id
            });

            // 检查接口调用结果
            if (response.flag) {
              message.success('员工状态已更新为离职');
              // 更新人员列表数据
              // 获取 岗亭列表 编辑
              this.getEditPostPersonnelList(this.Basicinformationform3.id)

              // this.ListofPostPersonneldata2.dataSource.push({
              //   name: name,
              //   mobilephonenumber1: mobile,
              //   identityCard: identityCard,
              //   entrytime: new Date().toLocaleString(),
              //   // 当前时间作为入职时间
              //   status: '在职'
              // });
            } else {
              message.error(response.message || '更新失败，请重试');
            }
          } catch (error) {
            message.error('更新失败，请重试');
          }
        },
        onCancel: () => {
          message.info('操作已取消');
        }
      });
    },
    // 岗亭管理 添加 编辑弹窗
    async handleAddPostPersonnel() {
      // 获取表单数据
      const name = this.PostManagementEditform1.Namevalue2;
      const mobile = this.PostManagementEditform1.Mobilephonenumbervalue2;
      const identityCard = this.PostManagementEditform1.IdentityCardvalue2;

      // 弹出确认对话框
      Modal.confirm({
        title: '确认添加',
        content: '您确定要添加该人员信息吗？',
        onOk: async () => {
          try {
            // 调用后端接口
            const response = await this.executeBackendInterface('addPostPersonnel', {
              Namevalue2: name,
              Mobilephonenumbervalue2: mobile,
              IdentityCardvalue2: identityCard,
              parkingLotId: this.Basicinformationform3.id // 停车场ID
            });

            // 检查接口调用结果
            if (response.flag) {
              message.success('人员信息添加成功');
              // 更新人员列表数据
              // 获取 岗亭列表 编辑
              this.getEditPostPersonnelList(this.Basicinformationform3.id)

              // this.ListofPostPersonneldata2.dataSource.push({
              //   name: name,
              //   mobilephonenumber1: mobile,
              //   identityCard: identityCard,
              //   entrytime: new Date().toLocaleString(),
              //   // 当前时间作为入职时间
              //   status: '在职'
              // });
            } else {
              message.error(response.message || '添加失败');
            }
          } catch (error) {
            message.error('接口调用失败');
          }
        },
        onCancel: () => {
          message.info('取消添加');
        }
      });
    },
    // 禁用-计费规则 编辑
    async handleDeactivateRule(record) {
      // 弹出确认对话框
      Modal.confirm({
        title: '确认停用',
        content: '您确定要停用该规则吗？',
        onOk: async () => {
          try {
            // 调用后端接口，传入当前行的id
            const response = await this.executeBackendInterface('disableBillingRule', {
              id: record.id
            });
            if (response.flag) {
              message.success('规则已成功停用');
              // 获取 计费规则列表 编辑
              this.getEditYardBillingRules(this.Basicinformationform3.id)
            } else {
              message.error(`停用失败: ${response.message}`);
            }
          } catch (error) {
            message.error('停用过程中发生错误');
          }
        },
        onCancel: () => {
          // 取消操作
        }
      });
    },
    // async handleDeactivateRule(record) {
    //   // 弹出确认对话框
    //   Modal.confirm({
    //     title: '确认停用',
    //     content: '您确定要停用该规则吗？',
    //     onOk: async () => {
    //       try {
    //         // 调用后端接口，传入当前行的id
    //         const response = await this.executeBackendInterface('deactivateRule', {
    //           id: record.id
    //         });
    //         if (response.flag) {
    //           message.success('规则已成功停用');
    //           // 更新当前行的状态为已停用
    //           record.status = '已停用';
    //         } else {
    //           message.error(`停用失败: ${response.message}`);
    //         }
    //       } catch (error) {
    //         message.error('停用过程中发生错误');
    //       }
    //     },
    //     onCancel: () => {
    //       // 取消操作
    //     }
    //   });
    // },
    // 启用-计费规则 编辑
    handleActivateRule(record) {
      Modal.confirm({
        title: '确认启用',
        content: '您确定要启用该规则吗？',
        onOk: async () => {
          try {
            const response = await this.executeBackendInterface('enableBillingRule', {
              id: record.id
            });
            if (response.flag) {
              message.success('规则已成功启用');
              // 获取 计费规则列表 编辑
              this.getEditYardBillingRules(this.Basicinformationform3.id)
            } else {
              message.error(response.message || '启用失败');
            }
          } catch (error) {
            message.error('启用过程中发生错误');
          }
        },
        onCancel: () => {
          // message.info('操作已取消');
        }
      });
    },
    // handleActivateRule(record) {
    //   Modal.confirm({
    //     title: '确认启用规则',
    //     content: '您确定要将当前行的状态改为生效中吗？',
    //     onOk: async () => {
    //       try {
    //         const response = await axios.post('/api/updateRuleStatus', {
    //           id: record.id,
    //           status: '生效中'
    //         });
    //         if (response.data.success) {
    //           message.success('状态更新成功');
    //           record.status = '生效中';
    //         } else {
    //           message.error('状态更新失败');
    //         }
    //       } catch (error) {
    //         message.error('请求失败，请重试');
    //       }
    //     },
    //     onCancel: () => {
    //       message.info('操作已取消');
    //     }
    //   });
    // },
    // 编辑弹窗 表单提交
    async handleSaveYardEdit() {
      try {
        // 运营规则 异常车辆处理 数据处理
        if (this.OperatingRulesform3.abnormalHandle && this.OperatingRulesform3.abnormalHandle.length !== 0) {
          console.log("🚀 ~ handleConfirmNewYard 运营规则-异常车辆处理 ~ this.OperatingRulesform2.abnormalHandle:", this.OperatingRulesform3.abnormalHandle)
          // 重置 运营规则 异常车辆处理 数据
          // 异常车状态:重复入场
          this.OperatingRulesform3.abnormal_status_duplicate = null
          // 异常车处理:重复入场
          this.OperatingRulesform3.abnormal_handling_duplicate = null
          // 异常车通知:重复入场
          this.OperatingRulesform3.abnormal_duplicate_notification = null
          // 异常车拉黑时长:重复入场
          this.OperatingRulesform3.abnormal_duplicate_block_time = null

          // 异常车状态:无驶入车
          this.OperatingRulesform3.abnormal_status_no_in_car = null
          // 异常车处理:无驶入车
          this.OperatingRulesform3.abnormal_handling_no_in_car = null
          // 异常车通知:无驶入车
          this.OperatingRulesform3.abnormal_no_in_car_notification = null
          // 异常车拉黑时长:无驶入车
          this.OperatingRulesform3.abnormal_no_in_car_block_time = null

          // 异常车状态:强制抬杆
          this.OperatingRulesform3.abnormal_status_force = null
          // 异常车处理:强制抬杆
          this.OperatingRulesform3.abnormal_handling_force = null
          // 异常车通知:强制抬杆
          this.OperatingRulesform3.abnormal_force_notification = null
          // 异常车拉黑时长:强制抬杆
          this.OperatingRulesform3.abnormal_force_block_time = null

          // 异常车状态:其他
          this.OperatingRulesform3.abnormal_status_other = null
          // 异常车处理:其他
          this.OperatingRulesform3.abnormal_handling_other = null
          // 异常车通知:其他
          this.OperatingRulesform3.abnormal_other_notification = null
          // 异常车拉黑时长:其他
          this.OperatingRulesform3.abnormal_other_block_time = null

          this.OperatingRulesform3.abnormalHandle.forEach(i => {
            if (i.status === '重复入场') {
              // 异常车状态:重复入场
              this.OperatingRulesform3.abnormal_status_duplicate = i.status
              // 异常车处理:重复入场
              this.OperatingRulesform3.abnormal_handling_duplicate = i.handle
              // 异常车通知:重复入场
              this.OperatingRulesform3.abnormal_duplicate_notification = i.notify
              // 异常车拉黑时长:重复入场
              this.OperatingRulesform3.abnormal_duplicate_block_time = i.time
            } else if (i.status === '无驶入车') {
              // 异常车状态:无驶入车
              this.OperatingRulesform3.abnormal_status_no_in_car = i.status
              // 异常车处理:无驶入车
              this.OperatingRulesform3.abnormal_handling_no_in_car = i.handle
              // 异常车通知:无驶入车
              this.OperatingRulesform3.abnormal_no_in_car_notification = i.notify
              // 异常车拉黑时长:无驶入车
              this.OperatingRulesform3.abnormal_no_in_car_block_time = i.time
            } else if (i.status === '强制抬杆') {
              // 异常车状态:强制抬杆
              this.OperatingRulesform3.abnormal_status_force = i.status
              // 异常车处理:强制抬杆
              this.OperatingRulesform3.abnormal_handling_force = i.handle
              // 异常车通知:强制抬杆
              this.OperatingRulesform3.abnormal_force_notification = i.notify
              // 异常车拉黑时长:强制抬杆
              this.OperatingRulesform3.abnormal_force_block_time = i.time
            } else if (i.status === '其他') {
              // 异常车状态:其他
              this.OperatingRulesform3.abnormal_status_other = i.status
              // 异常车处理:其他
              this.OperatingRulesform3.abnormal_handling_other = i.handle
              // 异常车通知:其他
              this.OperatingRulesform3.abnormal_other_notification = i.notify
              // 异常车拉黑时长:其他
              this.OperatingRulesform3.abnormal_other_block_time = i.time
            }
          })
          console.log("🚀 ~ handleConfirmNewYard 运营规则-异常车辆处理 ~ this.OperatingRulesform3.abnormalHandle-1:", this.OperatingRulesform3.abnormalHandle)
        }
        
        const basicInfo = this.Basicinformationform3;
        console.log("🚀 ~ handleSaveYardEdit ~ this.Basicinformationform3:", this.Basicinformationform3)
        const platformInfo = this.PlatformInformationform3;
        console.log("🚀 ~ handleSaveYardEdit ~ this.PlatformInformationform3:", this.PlatformInformationform3)
        const operatingRules = this.OperatingRulesform3;
        console.log("🚀 ~ handleSaveYardEdit ~ 运营规则 this.OperatingRulesform3:", this.OperatingRulesform3)
        const billingRuleEdit = this.BillingRuleEditform1;
        console.log("🚀 ~ handleSaveYardEdit ~ this.BillingRuleEditform1:", this.BillingRuleEditform1)
        const postManagementEdit = this.PostManagementEditform1;
        console.log("🚀 ~ handleSaveYardEdit ~ this.PostManagementEditform1:", this.PostManagementEditform1)
        const expandInfo = this.Expandinformationform3;
        console.log("🚀 ~ handleSaveYardEdit ~ this.Expandinformationform3:", this.Expandinformationform3)
        // const requestData = {
        //   id: basicInfo.id,
        //   yardnumbervalue3: basicInfo.yardnumbervalue3,
        //   Nameofyard1value3: basicInfo.Nameofyard1value3,
        //   Yardabbreviationvalue3: basicInfo.Yardabbreviationvalue3,
        //   Numberofparkingvalue3: basicInfo.Numberofparkingvalue3,
        //   Longtermrentalparkingspacesvalue3: basicInfo.Longtermrentalparkingspacesvalue3,
        //   Reservationofparkingspacevalue3: basicInfo.Reservationofparkingspacevalue3,
        //   VIPParkingvalue3: basicInfo.VIPParkingvalue3,
        //   Numberofchargingpilesvalue3: basicInfo.Numberofchargingpilesvalue3,
        //   OperatingCompany1value3: basicInfo.OperatingCompany1value3,
        //   Personinchargevalue3: basicInfo.Personinchargevalue3,
        //   ContactPhonevalue4: basicInfo.ContactPhonevalue4,
        //   latitudeandlongitudevalue3: basicInfo.latitudeandlongitudevalue3,
        //   Detailedaddressvalue3: basicInfo.Detailedaddressvalue3,
        //   YardDescriptionvalue3: basicInfo.YardDescriptionvalue3,
        //   yardstatus1value3: basicInfo.yardstatus1value3,
        //   Typeofyard1value3: basicInfo.Typeofyard1value3,
        //   Area1value3: basicInfo.Area1value3,
        //   YardCategory1value3: basicInfo.YardCategory1value3,
        //   Plate1value3: basicInfo.Plate1value3,
        //   Chargingservicevalue3: basicInfo.Chargingservicevalue3,
        //   AdditionalServicesvalue3: basicInfo.AdditionalServicesvalue3,
        //   Whetherthelargescreenisvisiblevalue3: basicInfo.Whetherthelargescreenisvisiblevalue3,
        //   // YardIconfileList1: basicInfo.YardIconfileList1.join(','),
        //   // YardPhotosfileList1: basicInfo.YardPhotosfileList1.join(',')
        //   // 基础信息 车场图标
        //   YardIconfileList1: basicInfo.YardIconfileList1 ? JSON.stringify(basicInfo.YardIconfileList1) : [],
        //   // 基础信息 车场照片
        //   YardPhotosfileList1: basicInfo.YardPhotosfileList1 ? JSON.stringify(basicInfo.YardPhotosfileList1) : [],
        // };
        // 准备请求参数
        const requestData = {
          ...this.Basicinformationform3,
          ...this.PlatformInformationform3,
          // 运营规则
          ...this.OperatingRulesform3,
          // ...this.BillingRuleEditform1,
          // 岗亭管理
          // ...this.PostManagementEditform1,
          ...this.Expandinformationform3,
          // 拓展信息 附件上传
          AttachmentUploadfileList1: this.Expandinformationform3.AttachmentUploadfileList1 ? JSON.stringify(this.Expandinformationform3.AttachmentUploadfileList1) : [],
          // 基础信息 车场图标
          YardIconfileList1: this.Basicinformationform3.YardIconfileList1 ? JSON.stringify(this.Basicinformationform3.YardIconfileList1) : [],
          // 基础信息 车场照片
          YardPhotosfileList1: this.Basicinformationform3.YardPhotosfileList1 ? JSON.stringify(this.Basicinformationform3.YardPhotosfileList1) : [],
          id: this.Basicinformationform3.id
        };
        console.log("🚀 ~ handleSaveYardEdit ~ requestData:", requestData)
        const response = await this.executeBackendInterface('updateYardDetails', requestData);
        if (response.flag) {
          message.success('车场信息更新成功');
          this.yardeditorisShow1 = false;
          // 刷新车场列表
          this.initializeParkingLotList();
          // await this.executeBackendInterface('getYardListZVO', {
          //   current: this.FileAttachmentListcurrent3,
          //   pageSize: this.FileAttachmentListpageSize2,
          //   parkingLotCode: '',
          //   parkingLotName: '',
          //   region: '',
          //   sector: '',
          //   category: '',
          //   parkingLotType: '',
          //   parkingLotStatus: ''
          // });
        } else {
          message.error(response.message || '车场信息更新失败');
        }
      } catch (error) {
        message.error('请求失败，请稍后重试');
        console.error(error);
      }
    },
    handleCancelYardEdit() {
      // 关闭当前弹窗
      this.yardeditorisShow1 = false;
    },
    // 初始化 计费规则 列表
    async initYardBillingRules() {
      try {
        const response = await this.executeBackendInterface('getPaginatedYardBillingRules', {
          current: this.yardbillingrulescurrent2,
          pageSize: this.yardbillingrulespageSize1
        });
        if (response.flag) {
          this.yardbillingrulesdata1.dataSource = response.data.data.map(item => ({
            id: item.id,
            serialNumber: item.id,
            ruleName: item.rule_name,
            chargingScheme: item.charging_scheme,
            ruleDescription: item.rule_description,
            associatedTime: item.create_time,
            associatedPerson: item.rule_number,
            status: item.status
          }));
          // this.yardbillingrulesdata1.dataSource = response.data.data.map(item => ({
          //   id: item.id,
          //   serialNumber: item.serial_number,
          //   ruleName: item.rule_name,
          //   chargingScheme: item.charging_scheme,
          //   ruleDescription: item.rule_description,
          //   associatedTime: item.associated_time,
          //   associatedPerson: item.associated_person,
          //   status: item.status
          // }));
          this.yardbillingrulestotal1 = response.data.total;
        } else {
          message.error(response.message);
        }
      } catch (error) {
        message.error('Failed to fetch yard billing rules.');
      }
    },
    async initPaginatedYardBillingRules() {
      await this.initYardBillingRules();
    },
    async initFileAttachmentList() {
      try {
        const response = await this.executeBackendInterface('getPaginatedFileAttachmentList', {
          current: this.FileAttachmentListcurrent2,
          pageSize: this.FileAttachmentListpageSize1
        });
        if (response.flag) {
          this.FileAttachmentListdata1.dataSource = response.data.data.map(item => ({
            id: item.id,
            serialNumber: item.serial_number,
            attachmentName: item.attachment_name,
            uploadTime: item.upload_time,
            creator: item.creator
          }));
          this.FileAttachmentListtotal1 = response.data.total;
        } else {
          message.error(response.message);
        }
      } catch (error) {
        message.error('Failed to fetch file attachment list.');
      }
    },
    async handleFileAttachmentListPagination(pagination) {
      this.FileAttachmentListcurrent2 = pagination.current;
      this.FileAttachmentListpageSize1 = pagination.pageSize;
      await this.initFileAttachmentList();
    },
    // 初始化 岗亭列表 详情
    async initPostPersonnelList() {
      try {
        const response = await this.executeBackendInterface('getPaginatedPostPersonnel', {
          current: this.ListofPostPersonnelcurrent2,
          pageSize: this.ListofPostPersonnelpageSize1
        });
        if (response.flag) {
          this.ListofPostPersonneldata1.dataSource = response.data.data.map(item => ({
            id: item.id,
            serialNumber: item.id,
            name: item.name,
            mobilephonenumber1: item.phone_number,
            status: item.status,
            entrytime: item.entry_time,
            turnovertime: item.resignation_time
          }));
          // this.ListofPostPersonneldata1.dataSource = response.data.data.map(item => ({
          //   id: item.id,
          //   serialNumber: item.serial_number,
          //   name: item.name,
          //   mobilephonenumber1: item.phone_number,
          //   status: item.status,
          //   entrytime: item.entry_time,
          //   turnovertime: item.resignation_time
          // }));
          this.ListofPostPersonneltotal1 = response.data.total;
        } else {
          message.error(response.message);
        }
      } catch (error) {
        message.error('Failed to fetch post personnel list.');
      }
    },
    // 分页 岗亭管理 列表 详情
    async fetchPaginatedPostPersonnelData(pagination) {
      this.ListofPostPersonnelcurrent2 = pagination.current;
      this.ListofPostPersonnelpageSize1 = pagination.pageSize;
      await this.getDetailPostPersonnelList(this.Basicinformationform1.id);
    },
    // 分页 计费规则 列表 详情
    async fetchDetailYardBillingRulesData(pagination) {
      this.yardbillingrulescurrent2 = pagination.current;
      this.yardbillingrulespageSize1 = pagination.pageSize;
      await this.getDetailYardBillingRules(this.Basicinformationform1.id);
    },
    async initializeParkingLotList() {
      try {
        const response = await this.executeBackendInterface('getPaginatedParkingLots', {
          current: this.YardListcurrent2,
          pageSize: this.YardListpageSize1
        });
        if (response.flag) {
          this.YardListdata1.dataSource = response.data.data.map(item => ({
            id: item.id,
            // serialNumber: item.sequence_number,
            serialNumber: item.row_index,
            yardnumber: item.parking_lot_code,
            nameofyard: item.parking_lot_name,
            // area: item.region,
            // area: item.region ? item.region.replace(/\[\[|\]\]|, /g, '') : item.region,
            area: item.region ? item.region.slice(1, -1).replace(/, /g, '') : item.region,
            plate: item.sector,
            categoryofyard: item.category,
            typeofyard: item.parking_lot_type,
            statusoftheyard: item.parking_lot_status,
            numberofparking: item.parking_spaces,
            operatingCompany: item.operating_company,
            personincharge1: item.manager,
            contactPhone1: item.contact_number,
            operation1: item.operation
          }));
          this.YardListtotal1 = response.data.total;
        } else {
          message.error(response.message);
        }
      } catch (error) {
        message.error('Failed to fetch parking lot list.');
      }
    },
    // 车场配置 列表 分页
    async fetchPaginatedParkingLotData(pagination) {
      this.YardListcurrent2 = pagination.current;
      this.YardListpageSize1 = pagination.pageSize;
      await this.handleSearchYards();
      // await this.initializeParkingLotList();
    },
    // 岗亭管理 列表 分页 编辑
    async fetchEditPostPersonnelList(pagination) {
      this.ListofPostPersonnelcurrent3 = pagination.current;
      this.ListofPostPersonnelpageSize2 = pagination.pageSize;
      await this.getEditPostPersonnelList(this.Basicinformationform3.id)
    },
    // 计费规则 列表 分页 编辑
    async fetchEditYardBillingRulesList(pagination) {
      this.yardbillingrulescurrent3 = pagination.current;
      this.yardbillingrulespageSize2 = pagination.pageSize;
      await this.getEditYardBillingRules(this.Basicinformationform3.id)
    },
    // 详情 回显
    async showParkingLotDetails(record) {
      console.log("🚀 ~ showParkingLotDetails ~ showParkingLotDetails:")
      this.DepotDetailsisShow1 = true
      this.DepotDetailsMenuselectedKeys1 = ["基础信息"]
      this.DepotDetailsDynamicPanelselectKey1 = "1";

      // 重置 详情弹窗 表单
      this.handleRestDetails()

      // 获取 岗亭列表 详情
      this.getDetailPostPersonnelList(record.id)

      // 获取 计费规则 详情
      this.getDetailYardBillingRules(record.id)

      // 获取 操作记录 详情
      this.initializeParkingLotOperationRecords(record.id)

      try {
        const response = await this.executeBackendInterface('getParkingLotDetails', {
          id: record.id
        });
        if (response.flag) {
          // 基础信息 详情回显
          const details = response.data.parkingLotDetails[0];
          console.log("🚀 ~ showParkingLotDetails ~ details:", details)
          this.Basicinformationform1 = {
            id: details.id,
            yardnumbervalue1: details.parking_lot_code,
            Nameofyard1value1: details.parking_lot_name,
            Yardabbreviationvalue1: details.parking_lot_short_name,
            Numberofparkingvalue1: details.parking_spaces,
            Longtermrentalparkingspacesvalue1: details.long_term_spaces,
            Reservationofparkingspacevalue1: details.reserved_spaces,
            VIPParkingvalue1: details.vip_spaces,
            Numberofchargingpilesvalue1: details.charging_piles,
            OperatingCompany1value1: details.operating_company,
            Personinchargevalue1: details.manager,
            ContactPhonevalue1: details.contact_number,
            latitudeandlongitudevalue1: details.latitude_longitude,
            Detailedaddressvalue1: details.detailed_address,
            YardDescriptionvalue1: details.parking_lot_description,
            yardstatus1value1: details.parking_lot_status,
            Typeofyard1value1: details.parking_lot_type,
            Area1value1: details.region ? details.region.slice(1, -1).split(', ') : [],
            // Area1value1: details.region,
            YardCategory1value1: details.category,
            Plate1value1: details.sector,
            Chargingservicevalue1: details.charging_service,
            AdditionalServicesvalue1: details.additional_service,
            Whetherthelargescreenisvisiblevalue1: details.screen_visibility ? '是' : '否',
            // 车场图标
            YardIconfileList3: details.parking_lot_icon ? JSON.parse(details.parking_lot_icon) : [],
            // 车场照片
            YardPhotosfileList3: details.parking_lot_photo ? JSON.parse(details.parking_lot_photo) : [],
          };
          // Similarly, set data for other forms like PlatformInformationform1, OperatingRulesform1, etc.
          // 平台信息 详情回显
          const platformInfo = response.data.platformInformation[0];
          console.log("🚀 ~ showParkingLotDetails ~ platformInfo:", platformInfo)
          this.PlatformInformationform1 = {
            ...this.PlatformInformationform1,
            Operationmodevalue1: platformInfo.operating_mode,
            OperatingCompanyvalue2: platformInfo.operating_company,
            dockingplatformvalue1: platformInfo.docking_platform,
            conservator: platformInfo.conservator
          };

          // 运营规则 详情回显
          const operationRules = response.data.operatingRules[0];
          console.log("🚀 ~ showParkingLotDetails ~ operationRules:", operationRules)
          this.OperatingRulesform1 = {
            ...this.OperatingRulesform1,
            PrepaidTimeoutDurationvalue1: operationRules.prepayment_overtime_duration,
            Timeoutdoesnotleaveprocessingvalue1: operationRules.overtime_exit_handling,
            Abnormalstatevalue1: operationRules.abnormal_status,
            ExceptionHandlingvalue1: operationRules.abnormal_handling,
            Notifyvalue1: operationRules.notification ? '是' : '否',
            Notifyvalue2: operationRules.notification ? '是' : '否',
            Notifyvalue3: operationRules.notification ? '是' : '否',
            blacklistvalue1: operationRules.blacklist,
            WhiteListvalue1: operationRules.whitelist,
            Reservedcarnumbervalue1: operationRules.reserved_spaces_count,
            Appointmenttimeoutdurationvalue1: operationRules.reservation_overtime_duration,
            AppearanceSweepCodevalue1: operationRules.exit_scan,
            // AppearanceSweepCodevalue1: operationRules.exit_scan ? '开启' : '关闭',
            // 异常车辆处理
            abnormal_status_duplicate: operationRules.abnormal_status_duplicate, //	异常车状态:重复入场
            abnormal_status_no_in_car: operationRules.abnormal_status_no_in_car, //	异常车状态:无驶入车
            abnormal_status_force: operationRules.abnormal_status_force, //	异常车状态:强制抬杆
            abnormal_status_other: operationRules.abnormal_status_other, //	异常车状态:其他
            abnormal_handling_duplicate: operationRules.abnormal_handling_duplicate, //	异常车处理:重复入场
            abnormal_handling_no_in_car: operationRules.abnormal_handling_no_in_car, //	异常车处理:无驶入车
            abnormal_handling_force: operationRules.abnormal_handling_force, //	异常车处理:强制抬杆
            abnormal_handling_other: operationRules.abnormal_handling_other, //	异常车处理:其他
            abnormal_duplicate_notification: operationRules.abnormal_duplicate_notification, //	异常车通知:重复入场
            abnormal_no_in_car_notification: operationRules.abnormal_no_in_car_notification, //	异常车通知:无驶入车
            abnormal_force_notification: operationRules.abnormal_force_notification, //	异常车通知:强制抬杆
            abnormal_other_notification: operationRules.abnormal_other_notification, //	异常车通知:其他
            abnormal_duplicate_block_time: operationRules.abnormal_duplicate_block_time, //	异常车拉黑时长:重复入场
            abnormal_no_in_car_block_time: operationRules.abnormal_no_in_car_block_time, //	异常车拉黑时长:无驶入车
            abnormal_force_block_time: operationRules.abnormal_force_block_time, //	异常车拉黑时长:强制抬杆
            abnormal_other_block_time: operationRules.abnormal_other_block_time, //	异常车拉黑时长:其他
          };

          // 运营规则 异常车辆处理
          this.OperatingRulesform1.abnormalHandle = [
            {
              // 重复入场
              status: this.OperatingRulesform1.abnormal_status_duplicate || null,
              handle: this.OperatingRulesform1.abnormal_handling_duplicate || null,
              notify: this.OperatingRulesform1.abnormal_duplicate_notification || '否',
              time: this.OperatingRulesform1.abnormal_duplicate_block_time || null
            },
            {
              // 无驶入车
              status: this.OperatingRulesform1.abnormal_status_no_in_car || null,
              handle: this.OperatingRulesform1.abnormal_handling_no_in_car || null,
              notify: this.OperatingRulesform1.abnormal_no_in_car_notification || '否',
              time: this.OperatingRulesform1.abnormal_no_in_car_block_time || null
            },
            {
              // 强制抬杆
              status: this.OperatingRulesform1.abnormal_status_force || null,
              handle: this.OperatingRulesform1.abnormal_handling_force || null,
              notify: this.OperatingRulesform1.abnormal_force_notification || '否',
              time: this.OperatingRulesform1.abnormal_force_block_time || null
            },
            {
              // 其他
              status: this.OperatingRulesform1.abnormal_status_other || null,
              handle: this.OperatingRulesform1.abnormal_handling_other || null,
              notify: this.OperatingRulesform1.abnormal_other_notification || '否',
              time: this.OperatingRulesform1.abnormal_other_block_time || null
            },
          ]
          this.OperatingRulesform1.abnormalHandle = this.OperatingRulesform1.abnormalHandle.filter(item => item.status !== "" && item.status != null)

          if (this.OperatingRulesform1.abnormalHandle && this.OperatingRulesform1.abnormalHandle.length === 0) {
            this.OperatingRulesform1.abnormalHandle = [{
              // 其他
              status: null,
              handle: null,
              notify: '否',
              time: null
            }]
          }
          console.log("🚀 ~ handleEditYard 详情回显 ~ this.OperatingRulesform1.abnormalHandle:", this.OperatingRulesform1.abnormalHandle)
          console.log("🚀 ~ handleEditYard 详情回显 ~ OperatingRulesform1:", this.OperatingRulesform1)

          // 预约车位 自动同步
          this.Basicinformationform1.Reservationofparkingspacevalue1 = operationRules.reserved_spaces_count

          // 拓展信息 详情回显
          const extendedInfo = response.data.extendedInformation[0];
          console.log("🚀 ~ showParkingLotDetails ~ extendedInfo:", extendedInfo)
          this.Expandinformationform1 = {
            ...this.Expandinformationform1,
            PropertyUnitvalue1: extendedInfo.property_unit,
            BuildingPropertiesvalue1: extendedInfo.building_attribute,
            LicenseNumbervalue1: extendedInfo.license_number,
            BusinessScopevalue1: extendedInfo.business_scope,
            Contactvalue1: extendedInfo.contact_person,
            ContactPhonevalue5: extendedInfo.contact_phone,
            Expandinformationvalue1: extendedInfo.property_description,
            Servicelifevalue1: extendedInfo.usage_years,
            Constructiontimevalue1: extendedInfo.construction_time,
            ValidityPeriodvalue1: extendedInfo.validity_period,
            // 附件上传
            AttachmentUploadfileList3: extendedInfo.attachment_upload ? JSON.parse(extendedInfo.attachment_upload) : [],

          };
        } else {
          message.error(response.message);
        }
      } catch (error) {
        // message.error('Failed to fetch parking lot details.');
      }
    },
    // 获取 岗亭列表 详情
    async getDetailPostPersonnelList(parkingLotId) {
      try {
        const response = await this.executeBackendInterface('getPostPersonnelList', {
          parkingLotId: parkingLotId,
          current: this.ListofPostPersonnelcurrent2,
          pageSize: this.ListofPostPersonnelpageSize1
        });
        if (response.flag) {
          this.ListofPostPersonneldata1.dataSource = response.data.data.map(item => ({
            id: item.id,
            serialNumber: item.id,
            name: item.name,
            mobilephonenumber1: item.phone_number,
            status: item.status,
            entrytime: item.entry_time,
            turnovertime: item.resignation_time
          }));
          // this.ListofPostPersonneldata1.dataSource = response.data.data.map(item => ({
          //   id: item.id,
          //   serialNumber: item.serial_number,
          //   name: item.name,
          //   mobilephonenumber1: item.phone_number,
          //   status: item.status,
          //   entrytime: item.entry_time,
          //   turnovertime: item.resignation_time
          // }));
          this.ListofPostPersonneltotal1 = response.data.total;
        } else {
          message.error(response.message);
        }
      } catch (error) {
        message.error('Failed to fetch post personnel list.');
      }
    },
    // 获取 计费规则列表 详情
    async getDetailYardBillingRules(parkingLotId) {
      try {
        const response = await this.executeBackendInterface('getYardBillingRuleByParkingId', {
          parkingLotId: parkingLotId,
          current: this.yardbillingrulescurrent2,
          pageSize: this.yardbillingrulespageSize1
        });
        if (response.flag) {
          this.yardbillingrulesdata1.dataSource = response.data.data.map(item => ({
            id: item.id,
            serialNumber: item.id,
            ruleName: item.rule_name,
            chargingscheme: item.billing_standard,
            ruleDescription: item.rule_description,
            associatedTime: item.relation_time,
            associatedPerson: item.relation_username,
            status: item.enable_status
          }));
          // this.yardbillingrulesdata1.dataSource = response.data.data.map(item => ({
          //   id: item.id,
          //   serialNumber: item.serial_number,
          //   ruleName: item.rule_name,
          //   chargingScheme: item.charging_scheme,
          //   ruleDescription: item.rule_description,
          //   associatedTime: item.associated_time,
          //   associatedPerson: item.associated_person,
          //   status: item.status
          // }));
          this.yardbillingrulestotal1 = response.data.total;
        } else {
          message.error(response.message);
        }
      } catch (error) {
        message.error('Failed to fetch yard billing rules.');
      }
    },
    // 重置 详情弹窗 表单
    handleRestDetails() {
      // 基础信息 详情回显 Basicinformationform1
      for (let key in this.Basicinformationform1) {
        this.Basicinformationform1[key] = null
      }
      // 平台信息 详情回显 PlatformInformationform1
      for (let key in this.PlatformInformationform1) {
        this.PlatformInformationform1[key] = null
      }
      // 运营规则 详情回显 OperatingRulesform1
      for (let key in this.OperatingRulesform1) {
        if (key === 'abnormalHandle') {
          this.OperatingRulesform1['abnormalHandle'] = [{
            status: null,
            handle: null,
            notify: '否',
            time: null
          }]
        } else {
          this.OperatingRulesform1[key] = null
        }
      }
      // 拓展信息 详情回显 Expandinformationform1
      for (let key in this.Expandinformationform1) {
        this.Expandinformationform1[key] = null
      }
    },
    // 操作记录 列表
    async initializeParkingLotOperationRecords(id) {
      try {
        const response = await this.executeBackendInterface('getParkingLotOperationRecords', {
          id: id,
          current: this.Operationrecordoftheyardcurrent2,
          pageSize: this.OperationrecordoftheyardpageSize1
        });
        if (response.flag) {
          const {
            total,
            data
          } = response.data;
          this.Operationrecordoftheyardtotal1 = total;
          this.Operationrecordoftheyarddata1.dataSource = data.map(item => ({
            id: item.id,
            serialNumber: item.id,
            // Assuming serialNumber is the same as id
            operationtime: item.operation_time,
            operationnode: item.operation_node,
            operationcontent: item.operation_content,
            operator: item.operator
          }));
        } else {
          message.error(response.message);
        }
      } catch (error) {
        message.error('Failed to fetch parking lot operation records.');
      }
    },
    async fetchPaginatedOperationRecords() {
      try {
        const response = await this.executeBackendInterface('getPaginatedOperationRecords', {
          current: this.Operationrecordoftheyardcurrent2,
          pageSize: this.OperationrecordoftheyardpageSize1
        });
        if (response.flag) {
          const {
            total,
            data
          } = response.data;
          this.Operationrecordoftheyardtotal1 = total;
          this.Operationrecordoftheyarddata1.dataSource = data.map(item => ({
            id: item.id,
            serialNumber: item.id,
            // Assuming serialNumber is the same as id
            operationtime: item.operation_time,
            operationnode: item.operation_node,
            operationcontent: item.operation_content,
            operator: item.operator
          }));
        } else {
          message.error(response.message);
        }
      } catch (error) {
        message.error('Failed to fetch paginated operation records.');
      }
    },
    async listenBillingRuleName() {
      try {
        // 调用后端接口获取计费规则名称列表
        const response = await this.executeBackendInterface('getBillingRulesAM1', {});

        // 检查接口调用是否成功
        if (response.flag) {
          // 检查返回数据格式是否正确
          if (Array.isArray(response.data)) {
            // 将返回的数据映射到组件变量
            this.RuleNameoptions1.dataSource = response.data.map(item => ({
              label: item.rule_name,
              value: item.rule_name,
              disabled: false,
              select: false
            }));
          } else {
            message.error('返回数据格式不正确');
          }
        } else {
          message.error(response.message || '获取计费规则失败');
        }
      } catch (error) {
        message.error('接口调用失败');
      }
    },
    initYardEditMenu() {
      this.$watch('YardEditMenuselectedKeys1', newVal => {
        switch (newVal) {
          case '基础信息':
            this.BasicinformationstateKey3 = '1';
            break;
          case '平台信息':
            this.PlatformInformationstateKey3 = '2';
            break;
          case '运营规则':
            this.OperatingRulesstateKey3 = '3';
            break;
          case '计费规则':
            this.BillingRuleEditstateKey1 = '4';
            break;
          case '岗亭管理':
            this.PostManagementEditstateKey1 = '5';
            break;
          case '拓展信息':
            this.ExpandinformationstateKey5 = '6';
            break;
          default:
            break;
        }
      });
    },
    // 编辑 tab切换
    handleYardEditMenuSelection() {
      // 获取当前选中的菜单项
      const selectKey = this.YardEditMenuselectedKeys1[0];
      console.log("🚀 ~ handleYardEditMenuSelection ~ selectKey:", selectKey)

      // 根据选中的菜单项切换动态面板的状态
      switch (selectKey) {
        case "基础信息":
          this.YardEditDynamicPanelselectKey1 = "1";
          break;
        case "平台信息":
          this.YardEditDynamicPanelselectKey1 = "2";
          break;
        case "运营规则":
          this.YardEditDynamicPanelselectKey1 = "3";
          break;
        case "计费规则":
          this.YardEditDynamicPanelselectKey1 = "4";
          break;
        case "岗亭管理":
          this.YardEditDynamicPanelselectKey1 = "5";
          break;
        case "拓展信息":
          this.YardEditDynamicPanelselectKey1 = "6";
          break;
        default:
          console.log("未知的菜单项!");
      }
    },
    handleYardDetailMenuSelection() {
      // 获取当前选中的菜单项
      const selectKey = this.DepotDetailsMenuselectedKeys1[0];

      // 根据选中的菜单项切换动态面板状态
      switch (selectKey) {
        case "基础信息":
          this.DepotDetailsDynamicPanelselectKey1 = "1";
          break;
        case "平台信息":
          this.DepotDetailsDynamicPanelselectKey1 = "2";
          break;
        case "运营规则":
          this.DepotDetailsDynamicPanelselectKey1 = "3";
          break;
        case "计费规则":
          this.DepotDetailsDynamicPanelselectKey1 = "4";
          break;
        case "岗亭管理":
          this.DepotDetailsDynamicPanelselectKey1 = "5";
          break;
        case "拓展信息":
          this.DepotDetailsDynamicPanelselectKey1 = "6";
          break;
        case "操作记录":
          this.DepotDetailsDynamicPanelselectKey1 = "7";
          break;
        default:
          console.log("未知的菜单项!");
      }
    },
    // 新增 运营规则 异常车辆处理 异常状态： change事件
    handleAbnormalStatusChange () {
      console.log("🚀 ~ handleAbnormalStatusChange 新增 运营规则 异常车辆处理 异常状态~ this.OperatingRulesform2.abnormalHandle:", this.OperatingRulesform2.abnormalHandle)
      // 判断 异常状态 是否重复
      const flag = this.hasDuplicateStatus(this.OperatingRulesform2.abnormalHandle)
      console.log("🚀 ~ handleAbnormalStatusChange 新增 ~ flag:", flag)
      if (flag) {
        message.error('异常状态重复，请重新选择')
        this.OperatingRulesform2.abnormalHandle[this.OperatingRulesform2.abnormalHandle.length - 1].status = null
      }
      console.log("🚀 ~ handleAbnormalStatusChange 新增 运营规则 异常车辆处理 异常状态~ this.OperatingRulesform2.abnormalHandle:", this.OperatingRulesform2.abnormalHandle)
    },
    // 编辑 运营规则 异常车辆处理 异常状态： change事件
    handleAbnormalStatusChangeEdit () {
      console.log("🚀 ~ handleAbnormalStatusChangeEdit 编辑 运营规则 异常车辆处理 异常状态~ this.OperatingRulesform3.abnormalHandle:", this.OperatingRulesform3.abnormalHandle)
      // 判断 异常状态 是否重复
      const flag = this.hasDuplicateStatus(this.OperatingRulesform3.abnormalHandle)
      console.log("🚀 ~ handleAbnormalStatusChangeEdit 编辑 ~ flag:", flag)
      if (flag) {
        message.error('异常状态重复，请重新选择')
        // this.OperatingRulesform3.abnormalHandle[this.OperatingRulesform3.abnormalHandle.length - 1].status = null
      }
      console.log("🚀 ~ handleAbnormalStatusChangeEdit 编辑 运营规则 异常车辆处理 异常状态~ this.OperatingRulesform3.abnormalHandle:", this.OperatingRulesform3.abnormalHandle)
    },
    // 新增 || 编辑 运营规则 异常车辆处理 异常状态 判断是否重复出现相同异常状态
    hasDuplicateStatus(arr) {
      const seenStatuses = new Set();
  
      for (const item of arr) {
        if (seenStatuses.has(item.status)) {
          return true; // 发现重复
        } else {
          seenStatuses.add(item.status); // 记录状态
        }
      }
  
      return false; // 没有发现重复
    },
    // 新增弹窗 表单提交
    async handleConfirmNewYard() {
      try {
        // 校验基础信息表单
        const basicInfoValues = await this.$refs.ref4354.validateFields();
        // 平台信息
        const platInfoValues = await this.$refs.ref4393.validateFields();

        // // 生成车场编号
        // const yardNumber = `YARD-${Date.now()}`;
        // this.Basicinformationform2.yardnumbervalue2 = yardNumber;

        // 运营规则 异常车辆处理 数据处理
        if (this.OperatingRulesform2.abnormalHandle && this.OperatingRulesform2.abnormalHandle.length !== 0) {
          console.log("🚀 ~ handleConfirmNewYard 运营规则-异常车辆处理 ~ this.OperatingRulesform2.abnormalHandle:", this.OperatingRulesform2.abnormalHandle)
          // 重置 运营规则 异常车辆处理 数据
          // 异常车状态:重复入场
          this.OperatingRulesform2.abnormal_status_duplicate = null
          // 异常车处理:重复入场
          this.OperatingRulesform2.abnormal_handling_duplicate = null
          // 异常车通知:重复入场
          this.OperatingRulesform2.abnormal_duplicate_notification = null
          // 异常车拉黑时长:重复入场
          this.OperatingRulesform2.abnormal_duplicate_block_time = null

          // 异常车状态:无驶入车
          this.OperatingRulesform2.abnormal_status_no_in_car = null
          // 异常车处理:无驶入车
          this.OperatingRulesform2.abnormal_handling_no_in_car = null
          // 异常车通知:无驶入车
          this.OperatingRulesform2.abnormal_no_in_car_notification = null
          // 异常车拉黑时长:无驶入车
          this.OperatingRulesform2.abnormal_no_in_car_block_time = null

          // 异常车状态:强制抬杆
          this.OperatingRulesform2.abnormal_status_force = null
          // 异常车处理:强制抬杆
          this.OperatingRulesform2.abnormal_handling_force = null
          // 异常车通知:强制抬杆
          this.OperatingRulesform2.abnormal_force_notification = null
          // 异常车拉黑时长:强制抬杆
          this.OperatingRulesform2.abnormal_force_block_time = null

          // 异常车状态:其他
          this.OperatingRulesform2.abnormal_status_other = null
          // 异常车处理:其他
          this.OperatingRulesform2.abnormal_handling_other = null
          // 异常车通知:其他
          this.OperatingRulesform2.abnormal_other_notification = null
          // 异常车拉黑时长:其他
          this.OperatingRulesform2.abnormal_other_block_time = null

          this.OperatingRulesform2.abnormalHandle.forEach(i => {
            if (i.status === '重复入场') {
              // 异常车状态:重复入场
              this.OperatingRulesform2.abnormal_status_duplicate = i.status
              // 异常车处理:重复入场
              this.OperatingRulesform2.abnormal_handling_duplicate = i.handle
              // 异常车通知:重复入场
              this.OperatingRulesform2.abnormal_duplicate_notification = i.notify
              // 异常车拉黑时长:重复入场
              this.OperatingRulesform2.abnormal_duplicate_block_time = i.time
            } else if (i.status === '无驶入车') {
              // 异常车状态:无驶入车
              this.OperatingRulesform2.abnormal_status_no_in_car = i.status
              // 异常车处理:无驶入车
              this.OperatingRulesform2.abnormal_handling_no_in_car = i.handle
              // 异常车通知:无驶入车
              this.OperatingRulesform2.abnormal_no_in_car_notification = i.notify
              // 异常车拉黑时长:无驶入车
              this.OperatingRulesform2.abnormal_no_in_car_block_time = i.time
            } else if (i.status === '强制抬杆') {
              // 异常车状态:强制抬杆
              this.OperatingRulesform2.abnormal_status_force = i.status
              // 异常车处理:强制抬杆
              this.OperatingRulesform2.abnormal_handling_force = i.handle
              // 异常车通知:强制抬杆
              this.OperatingRulesform2.abnormal_force_notification = i.notify
              // 异常车拉黑时长:强制抬杆
              this.OperatingRulesform2.abnormal_force_block_time = i.time
            } else if (i.status === '其他') {
              // 异常车状态:其他
              this.OperatingRulesform2.abnormal_status_other = i.status
              // 异常车处理:其他
              this.OperatingRulesform2.abnormal_handling_other = i.handle
              // 异常车通知:其他
              this.OperatingRulesform2.abnormal_other_notification = i.notify
              // 异常车拉黑时长:其他
              this.OperatingRulesform2.abnormal_other_block_time = i.time
            }
          })
          console.log("🚀 ~ handleConfirmNewYard 运营规则-异常车辆处理 ~ this.OperatingRulesform2.abnormalHandle-1:", this.OperatingRulesform2.abnormalHandle)
        }

        // 准备请求参数
        const requestData = {
          ...this.Basicinformationform2,
          ...this.PlatformInformationform2,
          ...this.OperatingRulesform2,
          ...this.BillingRulesNewform1,
          ...this.PostManagementNewform1,
          ...this.Expandinformationform2,
          // 拓展信息 附件上传
          AttachmentUploadfileList2: this.Expandinformationform2.AttachmentUploadfileList2 ? JSON.stringify(this.Expandinformationform2.AttachmentUploadfileList2) : [],
          // 基础信息 车场图标
          YardIconfileList2: this.Basicinformationform2.YardIconfileList2 ? JSON.stringify(this.Basicinformationform2.YardIconfileList2) : [],
          // 基础信息 车场照片
          YardPhotosfileList2: this.Basicinformationform2.YardPhotosfileList2 ? JSON.stringify(this.Basicinformationform2.YardPhotosfileList2) : []
        };

        console.log("🚀 ~ handleConfirmNewYard ~ 运营规则 this.OperatingRulesform2:", this.OperatingRulesform2)
        console.log("🚀 ~ handleConfirmNewYard ~ this.Expandinformationform2:", this.Expandinformationform2)
        console.log("🚀 ~ handleConfirmNewYard ~ this.PostManagementNewform1:", this.PostManagementNewform1)
        console.log("🚀 ~ handleConfirmNewYard ~ this.BillingRulesNewform1:", this.BillingRulesNewform1)
        console.log("🚀 ~ handleConfirmNewYard ~ this.PlatformInformationform2:", this.PlatformInformationform2)
        console.log("🚀 ~ handleConfirmNewYard ~ this.Basicinformationform2:", this.Basicinformationform2)
        console.log("🚀 ~ handleConfirmNewYard ~ requestData:", requestData)


        // 调用后端接口添加新车场
        const response = await this.executeBackendInterface('addNewYard', requestData);
        if (response.flag) {
          message.success('车场新增成功');
          this.NewdepotisShow1 = false; // 关闭弹窗
          // 刷新车场列表
          this.initializeParkingLotList();
          // await this.executeBackendInterface('getYardListCWC', {
          //   current: 1,
          //   pageSize: 10
          // });

          // 重置 新建弹窗 表单
          this.handleRestAdd()
        } else {
          message.error(response.message);
        }
      } catch (errorInfo) {
        // 校验失败，提示错误信息
        message.error('请检查输入项');
        console.log('Failed:', errorInfo);
      }
    },
    handleCancelNewYard() {
      this.NewdepotisShow1 = false;
    },
    async fetchAndSetVariables() {
      try {
        // 调用后端接口获取变量数组 需要传入pageUuid变量
        const pageUuid = '1845285535539527680';
        const response = await axios.get(`./system/permission/getCurrentPageNotShowVariable?pageUuid=${pageUuid}`);
        const variablesArray = response.data; // 后端直接返回变量数组

        if (variablesArray && Array.isArray(variablesArray))
          // 遍历数组，将每个变量设置为true
          variablesArray.forEach(variable => {
            this[variable] = true;
          });
      } catch (error) {
        console.error('获取变量失败:', error);
      }
    },
    executeBackendInterface(funcName, params) {
      // 处理参数为Map的情况
      if (params instanceof Map) {
        params = Object.fromEntries(params);
      }
      // 调用后端接口
      return new Promise((resolve, reject) => {
        axios.post('./Depotconfiguration/' + funcName, params, {
          headers: {
            'Content-Type': 'application/json'
          }
        }).then(response => {
          resolve(response.data);
        }).catch(error => {
          reject(error);
        });
      });
    },
    // 字典数据接口
    executeDatadictionaryInterface(funcName, params) {
      // 处理参数为Map的情况
      if (params instanceof Map) {
        params = Object.fromEntries(params);
      }
      // 调用后端接口
      return new Promise((resolve, reject) => {
        axios.post(funcName, params, {
          headers: {
            'Content-Type': 'application/json'
          }
        }).then(response => {
          resolve(response.data);
        }).catch(error => {
          reject(error);
        });
      });
    },
    // 打开 二维码弹窗
    async handleGenerateQRCode (record) {
      console.log("🚀 ~ handleGenerateQRCode 二维码弹窗 ~ record:", record)
      this.isCodeShow = true

      try {
        // 调用后端接口
        const response = await this.executeBackendInterface('getQRcodeList', {
          id: record.id // 车场配置列表id
        });
        console.log("🚀 ~ handleGenerateQRCode 二维码列表 ~ response:", response)

        // 检查接口调用结果
        if (response.flag) {
          // message.success('员工状态已更新为离职');
          this.codeListData.dataSource = response.data.data.map((item, index) => ({
            row_index: index + 1,
            id: item.id,
            cam_id: item.cam_id,
            // 二维码类型 无牌入场 扫码出场 提前缴费
            qrcode_type: item.qrcode_type,
            channels: item.channels || '-',
            in_out: item.in_out || '-',
            url: item.qrcode_type === '无牌入场' ? `http://www.wx.lczhparking.com/#/pages/scanEntrance/index?parkId=${record.id}&camId=${item.cam_id}` : (item.qrcode_type === '扫码出场' ? `http://www.wx.lczhparking.com/#/pages/scanPay/index?parkId=${record.id}&camId=${item.cam_id}` : `http://www.wx.lczhparking.com/#/pages/scanPay/index?parkId=${record.id}`),
            // url: item.qrcode_type === '无牌入场' ? `http://127.0.0.1:8080/#/pages/scanEntrance/index?parkId=${record.id}&camId=${item.cam_id}` : (item.qrcode_type === '扫码出场' ? `http://127.0.0.1:8080/#/pages/scanPay/index?parkId=${record.id}&camId=${item.cam_id}` : `http://127.0.0.1:8080/#/pages/scanPay/index?parkId=${record.id}`),
            // url: item.url,
          }));
        } else {
          message.error(response.message || '系统异常，请重试');
        }
      } catch (error) {
        message.error('系统异常，请重试');
      }
    },
    // 生成&&下载 二维码
    async generateQRCode(record) {
      console.log("🚀 ~ generateQRCode ~ record:", record)
      
      try {
        // 生成 二维码
        const qrcodeUrl = record.url
        console.log("🚀 ~ generateQRCode ~ qrcodeUrl:", qrcodeUrl)
        // const qrcodeUrl = 'http://127.0.0.1:8080/#/pages/scanEntrance/index?parkId=90&camId=180300156b99';
        const qrCodeDataUrl = await QRCode.toDataURL(qrcodeUrl, { scale: 600 / 10, width: 600 });

        // 下载 二维码
        const link = document.createElement("a");
        link.href = qrCodeDataUrl;
        link.download = "二维码.png";
        document.body.appendChild(link);
        link.click();
        document.body.removeChild(link);
      } catch (error) {
        console.error("生成二维码失败:", error);
      }
    },
  },
  mounted() {
    loadCss('./css/车场配置/theme.css');
    // this.initYardBillingRules();
    this.initFileAttachmentList();
    // this.initPostPersonnelList();
    this.initializeParkingLotList();
    // 操作记录
    // this.initializeParkingLotOperationRecords();
    this.initYardEditMenu();
    // 组件挂载后自动调用函数获取变量
    this.fetchAndSetVariables();

    // 规则名称 || 计费规则 options 数据
    this.getRuleNameoptions();

    // 车场类型 options 数据
    this.getOptionsType()
    // 车场类别 options 数据
    this.getOptionsCategory()
    // 车场状态 options 数据
    this.getOptionsStatus()
    // 所属板块 options 数据
    this.getOptionsPlate()
    // 附加服务 options 数据
    this.getOptionsService()
    // 运营模式 options 数据
    this.getOptionsOperationMode()
    // 运营公司 options 数据
    this.getOptionsOperationCompany()
    // 对接平台 options 数据
    this.getOptionsPlatform()
    // 车场管理员 options 数据
    this.getOptionsConservator()
  },
  computed: {
    BasicinformationformState1() {
      switch (this.DepotDetailsDynamicPanelselectKey1) {
        case '1':
          return {
            "statusId": "1"
          };
        case '2':
          return {
            "statusId": "2"
          };
        case '3':
          return {
            "statusId": "3"
          };
        case '4':
          return {
            "statusId": "4"
          };
        case '5':
          return {
            "statusId": "5"
          };
        case '6':
          return {
            "statusId": "6"
          };
        case '7':
          return {
            "statusId": "7"
          };
        default:
          console.log('状态不存在!');
          return {
            "statusId": "7"
          };
      }
    },
    PlatformInformationformState1() {
      switch (this.DepotDetailsDynamicPanelselectKey1) {
        case '1':
          return {
            "statusId": "1"
          };
        case '2':
          return {
            "statusId": "2"
          };
        case '3':
          return {
            "statusId": "3"
          };
        case '4':
          return {
            "statusId": "4"
          };
        case '5':
          return {
            "statusId": "5"
          };
        case '6':
          return {
            "statusId": "6"
          };
        case '7':
          return {
            "statusId": "7"
          };
        default:
          console.log('状态不存在!');
          return {
            "statusId": "7"
          };
      }
    },
    OperatingRulesformState1() {
      switch (this.DepotDetailsDynamicPanelselectKey1) {
        case '1':
          return {
            "statusId": "1"
          };
        case '2':
          return {
            "statusId": "2"
          };
        case '3':
          return {
            "statusId": "3"
          };
        case '4':
          return {
            "statusId": "4"
          };
        case '5':
          return {
            "statusId": "5"
          };
        case '6':
          return {
            "statusId": "6"
          };
        case '7':
          return {
            "statusId": "7"
          };
        default:
          console.log('状态不存在!');
          return {
            "statusId": "7"
          };
      }
    },
    ExpandinformationformState1() {
      switch (this.DepotDetailsDynamicPanelselectKey1) {
        case '1':
          return {
            "statusId": "1"
          };
        case '2':
          return {
            "statusId": "2"
          };
        case '3':
          return {
            "statusId": "3"
          };
        case '4':
          return {
            "statusId": "4"
          };
        case '5':
          return {
            "statusId": "5"
          };
        case '6':
          return {
            "statusId": "6"
          };
        case '7':
          return {
            "statusId": "7"
          };
        default:
          console.log('状态不存在!');
          return {
            "statusId": "7"
          };
      }
    },
    OperationrecordformState1() {
      switch (this.DepotDetailsDynamicPanelselectKey1) {
        case '1':
          return {
            "statusId": "1"
          };
        case '2':
          return {
            "statusId": "2"
          };
        case '3':
          return {
            "statusId": "3"
          };
        case '4':
          return {
            "statusId": "4"
          };
        case '5':
          return {
            "statusId": "5"
          };
        case '6':
          return {
            "statusId": "6"
          };
        case '7':
          return {
            "statusId": "7"
          };
        default:
          console.log('状态不存在!');
          return {
            "statusId": "7"
          };
      }
    },
    PostManagementViewformState1() {
      switch (this.DepotDetailsDynamicPanelselectKey1) {
        case '1':
          return {
            "statusId": "1"
          };
        case '2':
          return {
            "statusId": "2"
          };
        case '3':
          return {
            "statusId": "3"
          };
        case '4':
          return {
            "statusId": "4"
          };
        case '5':
          return {
            "statusId": "5"
          };
        case '6':
          return {
            "statusId": "6"
          };
        case '7':
          return {
            "statusId": "7"
          };
        default:
          console.log('状态不存在!');
          return {
            "statusId": "7"
          };
      }
    },
    BillingRulesViewformState1() {
      switch (this.DepotDetailsDynamicPanelselectKey1) {
        case '1':
          return {
            "statusId": "1"
          };
        case '2':
          return {
            "statusId": "2"
          };
        case '3':
          return {
            "statusId": "3"
          };
        case '4':
          return {
            "statusId": "4"
          };
        case '5':
          return {
            "statusId": "5"
          };
        case '6':
          return {
            "statusId": "6"
          };
        case '7':
          return {
            "statusId": "7"
          };
        default:
          console.log('状态不存在!');
          return {
            "statusId": "7"
          };
      }
    },
    BasicinformationformState2() {
      switch (this.NewYardDynamicPanelselectKey1) {
        case '1':
          return {
            "statusId": "1"
          };
        case '2':
          return {
            "statusId": "2"
          };
        case '3':
          return {
            "statusId": "3"
          };
        case '4':
          return {
            "statusId": "4"
          };
        case '5':
          return {
            "statusId": "5"
          };
        case '6':
          return {
            "statusId": "6"
          };
        default:
          console.log('状态不存在!');
          return {
            "statusId": "6"
          };
      }
    },
    PlatformInformationformState2() {
      switch (this.NewYardDynamicPanelselectKey1) {
        case '1':
          return {
            "statusId": "1"
          };
        case '2':
          return {
            "statusId": "2"
          };
        case '3':
          return {
            "statusId": "3"
          };
        case '4':
          return {
            "statusId": "4"
          };
        case '5':
          return {
            "statusId": "5"
          };
        case '6':
          return {
            "statusId": "6"
          };
        default:
          console.log('状态不存在!');
          return {
            "statusId": "6"
          };
      }
    },
    OperatingRulesformState2() {
      switch (this.NewYardDynamicPanelselectKey1) {
        case '1':
          return {
            "statusId": "1"
          };
        case '2':
          return {
            "statusId": "2"
          };
        case '3':
          return {
            "statusId": "3"
          };
        case '4':
          return {
            "statusId": "4"
          };
        case '5':
          return {
            "statusId": "5"
          };
        case '6':
          return {
            "statusId": "6"
          };
        default:
          console.log('状态不存在!');
          return {
            "statusId": "6"
          };
      }
    },
    ExpandinformationformState2() {
      switch (this.NewYardDynamicPanelselectKey1) {
        case '1':
          return {
            "statusId": "1"
          };
        case '2':
          return {
            "statusId": "2"
          };
        case '3':
          return {
            "statusId": "3"
          };
        case '4':
          return {
            "statusId": "4"
          };
        case '5':
          return {
            "statusId": "5"
          };
        case '6':
          return {
            "statusId": "6"
          };
        default:
          console.log('状态不存在!');
          return {
            "statusId": "6"
          };
      }
    },
    PostManagementNewformState1() {
      switch (this.NewYardDynamicPanelselectKey1) {
        case '1':
          return {
            "statusId": "1"
          };
        case '2':
          return {
            "statusId": "2"
          };
        case '3':
          return {
            "statusId": "3"
          };
        case '4':
          return {
            "statusId": "4"
          };
        case '5':
          return {
            "statusId": "5"
          };
        case '6':
          return {
            "statusId": "6"
          };
        default:
          console.log('状态不存在!');
          return {
            "statusId": "6"
          };
      }
    },
    BillingRulesNewformState1() {
      switch (this.NewYardDynamicPanelselectKey1) {
        case '1':
          return {
            "statusId": "1"
          };
        case '2':
          return {
            "statusId": "2"
          };
        case '3':
          return {
            "statusId": "3"
          };
        case '4':
          return {
            "statusId": "4"
          };
        case '5':
          return {
            "statusId": "5"
          };
        case '6':
          return {
            "statusId": "6"
          };
        default:
          console.log('状态不存在!');
          return {
            "statusId": "6"
          };
      }
    },
    BasicinformationformState3() {
      switch (this.YardEditDynamicPanelselectKey1) {
        case '1':
          return {
            "statusId": "1"
          };
        case '2':
          return {
            "statusId": "2"
          };
        case '3':
          return {
            "statusId": "3"
          };
        case '4':
          return {
            "statusId": "4"
          };
        case '5':
          return {
            "statusId": "5"
          };
        case '6':
          return {
            "statusId": "6"
          };
        default:
          console.log('状态不存在!');
          return {
            "statusId": "6"
          };
      }
    },
    PlatformInformationformState3() {
      switch (this.YardEditDynamicPanelselectKey1) {
        case '1':
          return {
            "statusId": "1"
          };
        case '2':
          return {
            "statusId": "2"
          };
        case '3':
          return {
            "statusId": "3"
          };
        case '4':
          return {
            "statusId": "4"
          };
        case '5':
          return {
            "statusId": "5"
          };
        case '6':
          return {
            "statusId": "6"
          };
        default:
          console.log('状态不存在!');
          return {
            "statusId": "6"
          };
      }
    },
    OperatingRulesformState3() {
      switch (this.YardEditDynamicPanelselectKey1) {
        case '1':
          return {
            "statusId": "1"
          };
        case '2':
          return {
            "statusId": "2"
          };
        case '3':
          return {
            "statusId": "3"
          };
        case '4':
          return {
            "statusId": "4"
          };
        case '5':
          return {
            "statusId": "5"
          };
        case '6':
          return {
            "statusId": "6"
          };
        default:
          console.log('状态不存在!');
          return {
            "statusId": "6"
          };
      }
    },
    ExpandinformationformState3() {
      switch (this.YardEditDynamicPanelselectKey1) {
        case '1':
          return {
            "statusId": "1"
          };
        case '2':
          return {
            "statusId": "2"
          };
        case '3':
          return {
            "statusId": "3"
          };
        case '4':
          return {
            "statusId": "4"
          };
        case '5':
          return {
            "statusId": "5"
          };
        case '6':
          return {
            "statusId": "6"
          };
        default:
          console.log('状态不存在!');
          return {
            "statusId": "6"
          };
      }
    },
    PostManagementEditformState1() {
      switch (this.YardEditDynamicPanelselectKey1) {
        case '1':
          return {
            "statusId": "1"
          };
        case '2':
          return {
            "statusId": "2"
          };
        case '3':
          return {
            "statusId": "3"
          };
        case '4':
          return {
            "statusId": "4"
          };
        case '5':
          return {
            "statusId": "5"
          };
        case '6':
          return {
            "statusId": "6"
          };
        default:
          console.log('状态不存在!');
          return {
            "statusId": "6"
          };
      }
    },
    BillingRuleEditformState1() {
      switch (this.YardEditDynamicPanelselectKey1) {
        case '1':
          return {
            "statusId": "1"
          };
        case '2':
          return {
            "statusId": "2"
          };
        case '3':
          return {
            "statusId": "3"
          };
        case '4':
          return {
            "statusId": "4"
          };
        case '5':
          return {
            "statusId": "5"
          };
        case '6':
          return {
            "statusId": "6"
          };
        default:
          console.log('状态不存在!');
          return {
            "statusId": "6"
          };
      }
    }
  }
};

</script>
<style lang="less">

.webVueAntYtSpanStyle-mv{
opacity: 1;
color: #3D3D3D;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
line-height: 20px;
letter-spacing: 0px;
align-content: center;
text-decoration: none;
font-style: normal;
text-align: left;
text-align-last: left;
}
.webVueAntYtSpanStyle-mv span{
text-shadow: 0px 0px 0px transparent;
}
.webVueAntYtSpan {
    display: block;
    height:100%;
    width:100%;
}
.webVueAntYtSpan span{
    word-break: break-all;
    width: auto;
    display: inline-block;
    vertical-align: top; /* 根据需要调整 */
}
.webVueAntYtSpan span:focus{
    outline: none;
}

.webVueAntYtSpanStyle-mvkcn40{
color: #999999 !important;
}
.webVueAntYtSpanStyle-mvkcn40 span{
text-decoration: none;
}

.webVueAntYtRectangleStyle-mv{
opacity: 1;
box-shadow: 0px 0px 0px 0px transparent;
background: transparent;
border-top-left-radius: 0px;
border-top-right-radius: 0px;
border-bottom-left-radius: 0px;
border-bottom-right-radius: 0px;
border-top: 1px solid #CDCDCD;
border-right: 1px solid #CDCDCD;
border-bottom: 1px solid #CDCDCD;
border-left: 1px solid #CDCDCD;
}
.webVueAntYtRectangle {
    width: 100%;
    height:100%;

}

.webVueAntYtRectangleStyle-mv3qkzi{
background: #ffffff;
border-top: 1px solid transparent;
border-right: 1px solid transparent;
border-bottom: 1px solid transparent;
border-left: 1px solid transparent;
}

.webVueAntYtInputFormItem-mv{
flex-direction: row;
opacity: 1;
}
.webVueAntYtInputFormItem-mv .ant-form-item-label label{
text-decoration: none;
font-style: normal;
color: #333333;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
width: 52px;
padding-top: 0px;
padding-right: 0px;
padding-bottom: 0px;
padding-left: 0px;
}
.webVueAntYtInputFormItem-mv .ant-form-item-label label .label-content{
text-align: left;
text-align-last: left;
}
.webVueAntYtInputStyle-mv:not(.ant-input-affix-wrapper){
color: #333333;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
background: #FFFFFF;
border-top-left-radius: 4px;
border-top-right-radius: 4px;
border-bottom-left-radius: 4px;
border-bottom-right-radius: 4px;
border-top: 1px solid #CDCDCD;
border-right: 1px solid #CDCDCD;
border-bottom: 1px solid #CDCDCD;
border-left: 1px solid #CDCDCD;
box-shadow: 0px 0px 0px 0px transparent;
text-decoration: none;
font-style: normal;
text-align: left;
text-align-last: left;
padding-top: 0px;
padding-right: 10px;
padding-bottom: 0px;
padding-left: 12px;
}
.webVueAntYtInputStyle-mv.ant-input-affix-wrapper{
background: #FFFFFF;
border-top-left-radius: 4px;
border-top-right-radius: 4px;
border-bottom-left-radius: 4px;
border-bottom-right-radius: 4px;
border-top: 1px solid #CDCDCD;
border-right: 1px solid #CDCDCD;
border-bottom: 1px solid #CDCDCD;
border-left: 1px solid #CDCDCD;
box-shadow: 0px 0px 0px 0px transparent;
padding-top: 0px;
padding-right: 10px;
padding-bottom: 0px;
padding-left: 12px;
}
.webVueAntYtInputStyle-mv.ant-input-affix-wrapper input{
text-decoration: none;
font-style: normal;
text-align: left;
text-align-last: left;
color: #333333;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
}
.webVueAntYtInputStyle-mv:not(.ant-input-affix-wrapper)::placeholder,.webVueAntYtInputStyle-mv:not(.ant-input-affix-wrapper)::-webkit-input-placeholder,.webVueAntYtInputStyle-mv input::placeholder,.webVueAntYtInputStyle-mv input::-webkit-input-placeholder{
color: #999999;
}
.webVueAntInputFormItem  {
  flex-wrap: nowrap;
}
.webVueAntInputFormItem ,
.webVueAntinput,
.webVueAntInputFormItem .ant-form-item-control-input,
.webVueAntInputFormItem .ant-form-item-control-input .ant-form-item-control-input-content {
  width: 100%;
  height: 100%;
}
.webVueAntInputFormItem .ant-form-item-control-input{
  min-height: unset !important;
}
.webVueAntInputFormItem .ant-form-item-label {
  flex-shrink: 0;
  padding: 0;
  text-align: left;
}
.webVueAntInputFormItem .ant-form-item-label label {
  width: 100%;
  height: 100%;
}
.webVueAntInputFormItem .ant-form-item-label>label.ant-form-item-required:not(.ant-form-item-required-mark-optional):before {
  margin-top: 4px;
}
.webVueAntInputFormItem .ant-form-item-label label .label-content{
  flex: 1;
  display: inline-block;
  overflow: hidden;
  text-overflow: ellipsis;
}
.webVueAntInputFormItem .ant-form-item-label>label.ant-form-item-no-colon:after {
  display: none;
}
.webVueAntInputFormItem .ant-form-item-label label .ant-form-item-content {
  white-space: nowrap;
}
.webVueAntInputFormItem.hide-label .ant-form-item-label {
  display: none;
}
.webVueAntInputFormItem .ant-form-item-content:focus{
  outline: none;
}
.webVueAntinput.ant-input-affix-wrapper input {
  background-color: transparent;
}


.webVueAntYtInputFormItem-mv1ygk3 .ant-form-item-explain{
position: absolute;
top: 100%;
z-index: -1;
}
.webVueAntYtInputFormItem-mv1ygk3 .ant-form-item-label label{
width: 80px;
padding-right: 10px;
}
.webVueAntYtInputFormItem-mv1ygk3 .ant-form-item-label label .label-content{
text-align: right;
text-align-last: right;
}
.webVueAntYtInputStyle-mvpakf4:not(.ant-input-affix-wrapper){
background: #FFFFFF !important;
}

.webVueAntYtSelectFormItem-mv{
flex-direction: row;
opacity: 1;
}
.webVueAntYtSelectFormItem-mv .ant-form-item-label label{
text-decoration: none;
font-style: normal;
color: #333333;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
width: 52px;
padding-top: 0px;
padding-right: 0px;
padding-bottom: 0px;
padding-left: 0px;
}
.webVueAntYtSelectFormItem-mv .ant-form-item-label label .label-content{
text-align: left;
// text-align-last: left;
text-align-last: center;
}
.webVueAntYtSelectStyle-mv .ant-select-selector{
background: #FFFFFF !important;
border-top-left-radius: 4px !important;
border-top-right-radius: 4px !important;
border-bottom-left-radius: 4px !important;
border-bottom-right-radius: 4px !important;
border-top: 1px solid #CDCDCD !important;
border-right: 1px solid #CDCDCD !important;
border-bottom: 1px solid #CDCDCD !important;
border-left: 1px solid #CDCDCD !important;
box-shadow: 0px 0px 0px 0px transparent;
padding-top: 0px !important;
padding-right: 10px !important;
padding-bottom: 0px !important;
padding-left: 12px !important;
}
.webVueAntYtSelectStyle-mv.ant-select:not(.ant-select-disabled):hover .ant-select-selector,.webVueAntYtSelectStyle-mv.ant-select-focused:not(.ant-select-disabled).ant-select:not(.ant-select-customize-input) .ant-select-selector{
border-right: 1px solid #CDCDCD !important;
}
.webVueAntYtSelectStyle-mv .ant-select-selector .ant-select-selection-item{
color: #333333;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal !important;
letter-spacing: 0px;
text-decoration: none;
font-style: normal;
}
.webVueAntYtSelectStyle-mv .ant-select-selector .ant-select-selection-search input{
color: #333333;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal !important;
letter-spacing: 0px;
text-decoration: none;
font-style: normal;
}
.webVueAntYtSelectStyle-mv .ant-select-selector .ant-select-selection-placeholder{
color: #999999;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
letter-spacing: 0px;
text-decoration: none;
font-style: normal;
}
.popup_yt-pav9fm17gsfsd-mv.ant-select-dropdown{
border-top-left-radius: 2px !important;
border-top-right-radius: 2px !important;
border-bottom-left-radius: 2px !important;
border-bottom-right-radius: 2px !important;
background: #ffffff !important;
border-top: 1px solid transparent !important;
border-right: 1px solid transparent !important;
border-bottom: 1px solid transparent !important;
border-left: 1px solid transparent !important;
box-shadow: 0px 0px 10px 0px rgba(153,153,153,0.3);
padding-top: 0px !important;
padding-right: 0px !important;
padding-bottom: 0px !important;
padding-left: 0px !important;
}
.popup_yt-pav9fm17gsfsd-mv.ant-select-dropdown .ant-select-item{
color: #333333;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
letter-spacing: 0px;
text-decoration: none;
font-style: normal;
}
.popup_yt-pav9fm17gsfsd-mv.ant-select-dropdown .ant-select-item-option-selected{
background: #E6EFFE;
color: #333333;
}
.popup_yt-pav9fm17gsfsd-mv.ant-select-dropdown .ant-select-item:hover{
background: #F0F0F0;
color: #333333;
}
.popup_yt-pav9fm17gsfsd-mv .ant-select-item-option-active:not(.ant-select-item-option-disabled){
background: #F0F0F0;
color: #333333;
}
.webVueSelectFormItem  {
  flex-wrap: nowrap;
}
.webVueSelectFormItem ,
.webVueSelectFormItem .ant-form-item-control-input,
.webVueSelectFormItem .ant-form-item-control-input .ant-form-item-control-input-content,
.webVueSelectFormItem .ant-form-item-control-input  .ant-select-selector .ant-select-selection-search input{
  width: 100%;
  height: 100%;
}
.webVueSelectFormItem .ant-form-item-control-input{
  min-height: unset !important;
}
.webVueSelectFormItem .ant-form-item-control {
  min-width: 0;
}
.webVueSelectFormItem .ant-form-item-label {
  flex-shrink: 0;
  padding: 0;
  text-align: left;
}
.webVueSelectFormItem  .ant-form-item-label label {
  width: 100%;
  height: 100%;
}
.webVueSelectFormItem .ant-form-item-label>label.ant-form-item-required:not(.ant-form-item-required-mark-optional):before {
  margin-top: 4px;
}
.webVueSelectFormItem .ant-form-item-label label .label-content{
  flex: 1;
  display: inline-block;
  overflow: hidden;
  text-overflow: ellipsis;
}
.webVueSelectFormItem .ant-form-item-label>label.ant-form-item-no-colon:after {
  display: none;
}
.webVueSelectFormItem .ant-form-item-label label .ant-form-item-content {
  white-space: nowrap;
}
.webVueSelectFormItem.hide-label .ant-form-item-label {
  display: none;
}
.webVueSelectFormItem .ant-form-item-content:focus{
  outline: none;
}
.webVueSelect.ant-select-single .ant-select-selector .ant-select-selection-placeholder,
.webVueSelect.ant-select-single .ant-select-selector{
  display: flex;
  align-items: center;
}

.webVueSelect {
  width: 100%;
  height:100%;
}
.webVueSelect .ant-select-selector {
  width: 100% !important;
  height: 100% !important;
  overflow: auto;
}

.webVueAntYtSelectFormItem-mv5wgh9 .ant-form-item-explain{
position: absolute;
top: 100%;
z-index: -1;
}
.webVueAntYtSelectFormItem-mv5wgh9 .ant-form-item-label label{
width: 80px;
padding-right: 10px;
}
.webVueAntYtSelectFormItem-mv5wgh9 .ant-form-item-label label .label-content{
text-align: right;
text-align-last: right;
}

.webVueAntYtButtonStyle-mv{
opacity: 1;
color: #FFFFFF;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
background: #4A90E2;
border-top-left-radius: 4px;
border-top-right-radius: 4px;
border-bottom-left-radius: 4px;
border-bottom-right-radius: 4px;
border-top: 0px solid #D9D9D9;
border-right: 0px solid #D9D9D9;
border-bottom: 0px solid #D9D9D9;
border-left: 0px solid #D9D9D9;
box-shadow: 0px 0px 0px 0px transparent;
padding-top: 2px;
padding-right: 0px;
padding-bottom: 2px;
padding-left: 0px;
}
.webVueAntYtButtonStyle-mv>span{
line-height: 28px;
letter-spacing: 0px;
text-decoration: none;
font-style: normal;
text-align: center;
text-align-last: center;
}
.webVueAntButton  {
  width: 100%;
  height:100%;
  display: flex;
}
.webVueAntButton .span:first-child{
  flex: 0 0 8px;
}
.webVueAntButton .yt-button-content{
  display: inline-block;
  flex: 1;
}

.webVueAntButton.ant-btn-loading.center .yt-button-content,
.webVueAntButton.ant-btn-loading.right .yt-button-content,
.webVueAntButton.ant-btn-loading.left .yt-button-content {
  flex: 0 0 auto;
}
.webVueAntButton span:focus{
  outline: none;
}
.webVueAntButton.ant-btn-two-chinese-chars>:not(.anticon) {
  margin-right: 0;
}

.webVueAntYtButtonStyle-mvj97ih{
color: #FFFFFF !important;
background: #3C8EFF !important;
align-items: center;
justify-content: center;
}
.webVueAntYtButtonStyle-mvj97ih>span{
letter-spacing: 0px !important;
}

.webVueAntYtButtonStyle-mvnwml7{
color: #333333 !important;
background: transparent !important;
border-top: 1px solid #D9D9D9;
border-right: 1px solid #D9D9D9;
border-bottom: 1px solid #D9D9D9;
border-left: 1px solid #D9D9D9;
align-items: center;
justify-content: center;
}
.webVueAntYtButtonStyle-mvnwml7>span{
letter-spacing: 0px !important;
}

.webVueAntYtRectangleStyle-mv5e698{
background: #ffffff;
border-top: 1px solid transparent;
border-right: 1px solid transparent;
border-bottom: 1px solid transparent;
border-left: 1px solid transparent;
}

.webVueAntYtButtonStyle-mvx33n5{
color: #FFFFFF !important;
background: #3C8EFF !important;
align-items: center;
justify-content: center;
}
.webVueAntYtButtonStyle-mvx33n5>span{
letter-spacing: 0px !important;
}

.webVueAntYtButtonStyle-mvmfn7t{
color: #F84C55 !important;
background: transparent !important;
border-top: 1px solid #F84C55;
border-right: 1px solid #F84C55;
border-bottom: 1px solid #F84C55;
border-left: 1px solid #F84C55;
align-items: center;
justify-content: center;
}
.webVueAntYtButtonStyle-mvmfn7t>span{
letter-spacing: 0px !important;
}

.webVueAntYtTable {
    display: inline-block;
}
.webVueAntYtTable .ant-radio-input {
    display: none;
}
.webVueAntYtTable thead tr th div:first-child {
    display: flex !important;
    align-items: center;
}
.webVueAntYtTable thead tr th:before {
    content: none !important;
}
.webVueAntYtTable thead tr th:not(.ant-table-selection-column), .webVueAntYtTable .ant-table-tbody tr td:not(.ant-table-selection-column) {
    padding: 0 !important;
}
.webVueAntYtTable thead tr th.ant-table-selection-column, .webVueAntYtTable .ant-table-tbody tr td.ant-table-selection-column {
    padding-top: 0 !important;
    padding-bottom: 0 !important;
}
.webVueAntYtTable .ant-table-tbody tr td, .webVueAntYtTable thead tr th {
    position: relative;
}
.webVueAntYtTable .ant-table-tbody tr td .td-text, .webVueAntYtTable thead tr th .th-text {
    width: 100%;
    display: inline-block;
    position: absolute;
    top: 0;
    left: 0;
    right: 0;
    bottom: 0;
}
.webVueAntYtTable tr td .td-text {
    white-space: nowrap;
    overflow: hidden;
    text-overflow: ellipsis;
}
.webVueAntYtTable .ant-table-tbody tr td {
    border-top: 0 !important;
    position: relative !important;
}
.webVueAntYtTable .ant-table-tbody tr td .ant-radio-wrapper {
    align-items: center;
}
.webVueAntYtTable .ant-table-tbody tr:last-child td {
    border-bottom: 0 !important;
}
.webVueAntYtTable .ant-pagination {
    display: flex;
}

.webVueAntYtTable .add-pointer {
    display: flex !important;
}
.webVueAntYtTable .ant-table-thead .ant-table-cell-scrollbar {
    width: 6px;
}
.webVueAntYtTable .ant-table-header colgroup col:not(.ant-table-selection-col) {
    width: auto !important;
}
:focus-visible {
    outline: none;
}
.webVueAntYtTable .ant-table-body::-webkit-scrollbar {
    width: 6px;
    height: 6px;
    border-radius: 2px;
}
.webVueAntYtTable .ant-table-body::-webkit-scrollbar-thumb {
    background-color: #ccc;
}
.webVueAntYtTable.custom-table .ant-table-content {
    overflow: hidden !important;
    max-height: unset !important;
}
.webVueAntYtTable td .customTableTemplate {
    position: absolute !important;
    top: 0;
    right: 0;
    bottom: 0;
    left: 0;
}
.webVueAntYtTable .ant-table thead tr th:last-of-type,.webVueAntYtTable .ant-table .ant-table-tbody tr td:last-of-type {
   border-right: 0 !important; 
}

.webVueAntYtTableStyle-mvm9sfd{
opacity: 1;
}
.webVueAntYtTableStyle-mvm9sfd .ant-table{
box-shadow: 0px 0px 0px 0px transparent;
border-top-left-radius: 4px;
border-top-right-radius: 4px;
border-bottom-left-radius: 4px;
border-bottom-right-radius: 4px;
border-top: 1px solid #D9D9D9;
border-right: 1px solid #D9D9D9;
border-bottom: 1px solid #D9D9D9;
border-left: 1px solid #D9D9D9;
}
.webVueAntYtTableStyle-mvm9sfd .ant-table th:first-child{
border-top-left-radius: 4px !important;
}
.webVueAntYtTableStyle-mvm9sfd .ant-table th:last-child{
border-top-right-radius: 4px !important;
}
.webVueAntYtTableStyle-mvm9sfd .ant-table tr:last-child td:first-child{
border-bottom-left-radius: 4px !important;
}
.webVueAntYtTableStyle-mvm9sfd .ant-table tr:last-child td:last-child{
border-bottom-right-radius: 4px !important;
}
.webVueAntYtTableStyle-mvm9sfd .ant-table .ant-table-thead tr,.webVueAntYtTableStyle-mvm9sfd .ant-table .ant-table-thead tr th div:first-child{
height: 48px;
}
.webVueAntYtTableStyle-mvm9sfd .ant-table .ant-table-thead tr th div.ant-table-selection{
line-height: 48px;
}
.webVueAntYtTableStyle-mvm9sfd .ant-table .ant-table-thead tr th{
background: #EAEEF3;
}
.webVueAntYtTableStyle-mvm9sfd .ant-table .ant-table-thead tr span.th-text{
color: #000000A6;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: bold;
line-height: 50px;
letter-spacing: 0px;
font-style: normal;
text-align: center;
text-align-last: center;
text-decoration: none;
padding-top: 0px;
padding-right: 0px;
padding-bottom: 0px;
padding-left: 0px;
}
.webVueAntYtTableStyle-mvm9sfd .ant-table tbody tr td{
height: 48px;
}
.webVueAntYtTableStyle-mvm9sfd .ant-table tbody tr td .ant-checkbox-wrapper{
line-height: 48px;
}
.webVueAntYtTableStyle-mvm9sfd .ant-table tbody tr td{
background: #FFFFFF;
}
.webVueAntYtTableStyle-mvm9sfd .ant-table thead tr th,.webVueAntYtTableStyle-mvm9sfd .ant-table .ant-table-tbody tr:not(:last-child) td{
border-bottom: 1px solid #dcdcdc;
}
.webVueAntYtTableStyle-mvm9sfd .ant-table thead tr th:not(:last-child),.webVueAntYtTableStyle-mvm9sfd .ant-table .ant-table-tbody tr td:not(:last-child){
border-right: 1px solid #00000000;
}
.webVueAntYtTableStyle-mvm9sfd.ant-table-striped .ant-table tbody tr:nth-child(2n-1) td{
background: #FFFFFF;
}
.webVueAntYtTableStyle-mvm9sfd.ant-table-striped .ant-table tbody tr:nth-child(2n) td{
background: #FFFFFF;
}
.webVueAntYtTableStyle-mvm9sfd .ant-table tbody tr:not(.ant-table-row-selected):hover td{
background: #E4EFFF !important;
}
.webVueAntYtTableStyle-mvm9sfd .ant-table tbody tr:not(.ant-table-row-selected):hover td span.td-text{
color: #000000 !important;
}
.webVueAntYtTableStyle-mvm9sfd .ant-table-tbody tr.ant-table-row-selected td{
background: #3C8EFF !important;
}
.webVueAntYtTableStyle-mvm9sfd .ant-table-tbody tr.ant-table-row-selected td span.td-text{
color: #FFFFFF !important;
}
.webVueAntYtTableStyle-mvm9sfd .ant-pagination li:not(.ant-pagination-options),.webVueAntYtTableStyle-mvm9sfd .ant-pagination button,.webVueAntYtTableStyle-mvm9sfd .ant-pagination li .ant-select .ant-select-selector,.webVueAntYtTableStyle-mvm9sfd .ant-pagination li input{
border-top-left-radius: 4px;
border-top-right-radius: 4px;
border-bottom-left-radius: 4px;
border-bottom-right-radius: 4px;
background: #FFFFFF;
color: #000000A6;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
line-height: 32px;
letter-spacing: 0px;
text-align: center;
text-align-last: center;
font-style: normal;
text-decoration: none;
}
.webVueAntYtTableStyle-mvm9sfd .ant-pagination button,.webVueAntYtTableStyle-mvm9sfd .ant-pagination li .ant-select .ant-select-selector,.webVueAntYtTableStyle-mvm9sfd .ant-pagination li input,.webVueAntYtTableStyle-mvm9sfd .ant-pagination li a,.webVueAntYtTableStyle-mvm9sfd .ant-pagination li .ant-pagination-options-quick-jumper{
padding-top: 0px;
padding-right: 0px;
padding-bottom: 0px;
padding-left: 0px;
}
.webVueAntYtTableStyle-mvm9sfd .ant-pagination li:not(.ant-pagination-options),.webVueAntYtTableStyle-mvm9sfd .ant-pagination li.ant-pagination-options .ant-pagination-options-size-changer.ant-select .ant-select-selector,.webVueAntYtTableStyle-mvm9sfd .ant-pagination li.ant-pagination-options .ant-pagination-options-quick-jumper input{
border-top: 1px solid #D9D9D9;
border-right: 1px solid #D9D9D9;
border-bottom: 1px solid #D9D9D9;
border-left: 1px solid #D9D9D9;
}
.webVueAntYtTableStyle-mvm9sfd .ant-pagination li button{
border: none;
}
.webVueAntYtTableStyle-mvm9sfd .ant-pagination li a,.webVueAntYtTableStyle-mvm9sfd .ant-pagination li .ant-pagination-options-quick-jumper{
color: #000000A6;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
line-height: 32px;
letter-spacing: 0px;
text-align: center;
text-align-last: center;
font-style: normal;
text-decoration: none;
}
.webVueAntYtTableStyle-mvm9sfd .ant-pagination li.ant-pagination-item-active{
background: #FFFFFF;
border-top: 1px solid #1890ff;
border-right: 1px solid #1890ff;
border-bottom: 1px solid #1890ff;
border-left: 1px solid #1890ff;
}
.webVueAntYtTableStyle-mvm9sfd .ant-pagination li.ant-pagination-item-active a{
color: #1890ff;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
line-height: 32px;
letter-spacing: 0px;
text-align: center;
text-align-last: center;
font-style: normal;
text-decoration: none;
}
.webVueAntYtTableStyle-mvm9sfd tr td:nth-child(2) div:first-child{
text-align: center;
text-align-last: center;
padding-top: 0px;
padding-right: 0px;
padding-bottom: 0px;
padding-left: 0px;
}
.webVueAntYtTableStyle-mvm9sfd tr td:nth-child(2) div:first-child span.td-text{
color: #000000A6;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
line-height: 50px;
letter-spacing: 0px;
text-decoration: none;
font-style: normal;
}
.webVueAntYtTableStyle-mvm9sfd tr > th:nth-child(2), .webVueAntYtTableStyle-mvm9sfd .ant-table-body tr.ant-table-measure-row td:nth-child(2){
width: 48px !important;
min-width: 48px !important;
max-width: 48px !important;
}
.webVueAntYtTableStyle-mvm9sfd tr td:nth-child(3) div:first-child{
text-align: center;
text-align-last: center;
padding-top: 0px;
padding-right: 0px;
padding-bottom: 0px;
padding-left: 0px;
}
.webVueAntYtTableStyle-mvm9sfd tr td:nth-child(3) div:first-child span.td-text{
color: #000000A6;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
line-height: 50px;
letter-spacing: 0px;
text-decoration: none;
font-style: normal;
}
.webVueAntYtTableStyle-mvm9sfd tr > th:nth-child(3), .webVueAntYtTableStyle-mvm9sfd .ant-table-body tr.ant-table-measure-row td:nth-child(3){
width: calc((100% - 168px) / 11) !important;
min-width: 1px !important;
max-width: 1px !important;
}
.webVueAntYtTableStyle-mvm9sfd tr td:nth-child(4) div:first-child{
text-align: center;
text-align-last: center;
padding-top: 0px;
padding-right: 0px;
padding-bottom: 0px;
padding-left: 0px;
}
.webVueAntYtTableStyle-mvm9sfd tr td:nth-child(4) div:first-child span.td-text{
color: #000000A6;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
line-height: 50px;
letter-spacing: 0px;
text-decoration: none;
font-style: normal;
}
.webVueAntYtTableStyle-mvm9sfd tr > th:nth-child(4), .webVueAntYtTableStyle-mvm9sfd .ant-table-body tr.ant-table-measure-row td:nth-child(4){
width: calc((100% - 168px) / 11) !important;
min-width: 1px !important;
max-width: 1px !important;
}
.webVueAntYtTableStyle-mvm9sfd tr td:nth-child(5) div:first-child{
text-align: center;
text-align-last: center;
padding-top: 0px;
padding-right: 0px;
padding-bottom: 0px;
padding-left: 0px;
}
.webVueAntYtTableStyle-mvm9sfd tr td:nth-child(5) div:first-child span.td-text{
color: #000000A6;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
line-height: 50px;
letter-spacing: 0px;
text-decoration: none;
font-style: normal;
}
.webVueAntYtTableStyle-mvm9sfd tr > th:nth-child(5), .webVueAntYtTableStyle-mvm9sfd .ant-table-body tr.ant-table-measure-row td:nth-child(5){
width: calc((100% - 168px) / 11) !important;
min-width: 1px !important;
max-width: 1px !important;
}
.webVueAntYtTableStyle-mvm9sfd tr td:nth-child(6) div:first-child{
text-align: center;
text-align-last: center;
padding-top: 0px;
padding-right: 0px;
padding-bottom: 0px;
padding-left: 0px;
}
.webVueAntYtTableStyle-mvm9sfd tr td:nth-child(6) div:first-child span.td-text{
color: #000000A6;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
line-height: 50px;
letter-spacing: 0px;
text-decoration: none;
font-style: normal;
}
.webVueAntYtTableStyle-mvm9sfd tr > th:nth-child(6), .webVueAntYtTableStyle-mvm9sfd .ant-table-body tr.ant-table-measure-row td:nth-child(6){
width: calc((100% - 168px) / 11) !important;
min-width: 1px !important;
max-width: 1px !important;
}
.webVueAntYtTableStyle-mvm9sfd tr td:nth-child(7) div:first-child{
text-align: center;
text-align-last: center;
padding-top: 0px;
padding-right: 0px;
padding-bottom: 0px;
padding-left: 0px;
}
.webVueAntYtTableStyle-mvm9sfd tr td:nth-child(7) div:first-child span.td-text{
color: #000000A6;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
line-height: 50px;
letter-spacing: 0px;
text-decoration: none;
font-style: normal;
}
.webVueAntYtTableStyle-mvm9sfd tr > th:nth-child(7), .webVueAntYtTableStyle-mvm9sfd .ant-table-body tr.ant-table-measure-row td:nth-child(7){
width: calc((100% - 168px) / 11) !important;
min-width: 1px !important;
max-width: 1px !important;
}
.webVueAntYtTableStyle-mvm9sfd tr td:nth-child(8) div:first-child{
text-align: center;
text-align-last: center;
padding-top: 0px;
padding-right: 0px;
padding-bottom: 0px;
padding-left: 0px;
}
.webVueAntYtTableStyle-mvm9sfd tr td:nth-child(8) div:first-child span.td-text{
color: #000000A6;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
line-height: 50px;
letter-spacing: 0px;
text-decoration: none;
font-style: normal;
}
.webVueAntYtTableStyle-mvm9sfd tr > th:nth-child(8), .webVueAntYtTableStyle-mvm9sfd .ant-table-body tr.ant-table-measure-row td:nth-child(8){
width: calc((100% - 168px) / 11) !important;
min-width: 1px !important;
max-width: 1px !important;
}
.webVueAntYtTableStyle-mvm9sfd tr td:nth-child(9) div:first-child{
text-align: center;
text-align-last: center;
padding-top: 0px;
padding-right: 0px;
padding-bottom: 0px;
padding-left: 0px;
}
.webVueAntYtTableStyle-mvm9sfd tr td:nth-child(9) div:first-child span.td-text{
color: #000000A6;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
line-height: 50px;
letter-spacing: 0px;
text-decoration: none;
font-style: normal;
}
.webVueAntYtTableStyle-mvm9sfd tr > th:nth-child(9), .webVueAntYtTableStyle-mvm9sfd .ant-table-body tr.ant-table-measure-row td:nth-child(9){
width: calc((100% - 168px) / 11) !important;
min-width: 1px !important;
max-width: 1px !important;
}
.webVueAntYtTableStyle-mvm9sfd tr td:nth-child(10) div:first-child{
text-align: center;
text-align-last: center;
padding-top: 0px;
padding-right: 0px;
padding-bottom: 0px;
padding-left: 0px;
}
.webVueAntYtTableStyle-mvm9sfd tr td:nth-child(10) div:first-child span.td-text{
color: #000000A6;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
line-height: 50px;
letter-spacing: 0px;
text-decoration: none;
font-style: normal;
}
.webVueAntYtTableStyle-mvm9sfd tr > th:nth-child(10), .webVueAntYtTableStyle-mvm9sfd .ant-table-body tr.ant-table-measure-row td:nth-child(10){
width: calc((100% - 168px) / 11) !important;
min-width: 1px !important;
max-width: 1px !important;
}
.webVueAntYtTableStyle-mvm9sfd tr td:nth-child(11) div:first-child{
text-align: center;
text-align-last: center;
padding-top: 0px;
padding-right: 0px;
padding-bottom: 0px;
padding-left: 0px;
}
.webVueAntYtTableStyle-mvm9sfd tr td:nth-child(11) div:first-child span.td-text{
color: #000000A6;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
line-height: 50px;
letter-spacing: 0px;
text-decoration: none;
font-style: normal;
}
.webVueAntYtTableStyle-mvm9sfd tr > th:nth-child(11), .webVueAntYtTableStyle-mvm9sfd .ant-table-body tr.ant-table-measure-row td:nth-child(11){
width: calc((100% - 168px) / 11) !important;
min-width: 1px !important;
max-width: 1px !important;
}
.webVueAntYtTableStyle-mvm9sfd tr td:nth-child(12) div:first-child{
text-align: center;
text-align-last: center;
padding-top: 0px;
padding-right: 0px;
padding-bottom: 0px;
padding-left: 0px;
}
.webVueAntYtTableStyle-mvm9sfd tr td:nth-child(12) div:first-child span.td-text{
color: #000000A6;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
line-height: 50px;
letter-spacing: 0px;
text-decoration: none;
font-style: normal;
}
.webVueAntYtTableStyle-mvm9sfd tr > th:nth-child(12), .webVueAntYtTableStyle-mvm9sfd .ant-table-body tr.ant-table-measure-row td:nth-child(12){
width: calc((100% - 168px) / 11) !important;
min-width: 1px !important;
max-width: 1px !important;
}
.webVueAntYtTableStyle-mvm9sfd tr td:nth-child(13) div:first-child{
text-align: center;
text-align-last: center;
padding-top: 0px;
padding-right: 0px;
padding-bottom: 0px;
padding-left: 0px;
}
.webVueAntYtTableStyle-mvm9sfd tr td:nth-child(13) div:first-child span.td-text{
color: #000000A6;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
line-height: 50px;
letter-spacing: 0px;
text-decoration: none;
font-style: normal;
}
.webVueAntYtTableStyle-mvm9sfd tr > th:nth-child(13), .webVueAntYtTableStyle-mvm9sfd .ant-table-body tr.ant-table-measure-row td:nth-child(13){
width: calc((100% - 168px) / 11) !important;
min-width: 1px !important;
max-width: 1px !important;
}
.webVueAntYtTableStyle-mvm9sfd tr td:nth-child(14) div:first-child{
text-align: center;
text-align-last: center;
padding-top: 0px;
padding-right: 0px;
padding-bottom: 0px;
padding-left: 0px;
}
.webVueAntYtTableStyle-mvm9sfd tr td:nth-child(14) div:first-child span.td-text{
color: #000000A6;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
line-height: 50px;
letter-spacing: 0px;
text-decoration: none;
font-style: normal;
}
.webVueAntYtTableStyle-mvm9sfd tr > th:nth-child(14), .webVueAntYtTableStyle-mvm9sfd .ant-table-body tr.ant-table-measure-row td:nth-child(14){
width: 120px !important;
min-width: 120px !important;
max-width: 120px !important;
}
.webVueAntYtTableStyle-mvm9sfd{
width: 100%;
}

.webVueAntYtCascaderFormItem-mv{
flex-direction: row;
opacity: 1;
}
.webVueAntYtCascaderFormItem-mv .ant-form-item-label label{
text-decoration: none;
font-style: normal;
color: #333333;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
width: 52px;
padding-top: 0px;
padding-right: 0px;
padding-bottom: 0px;
padding-left: 0px;
}
.webVueAntYtCascaderFormItem-mv .ant-form-item-label label .label-content{
text-align: left;
text-align-last: left;
}
.webVueAntYtCascaderStyle-mv{
color: #333333;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
letter-spacing: 0px;
font-style: normal;
}
.webVueAntYtCascaderStyle-mv .ant-select-selector{
background: #FFFFFF !important;
border-top-left-radius: 4px !important;
border-top-right-radius: 4px !important;
border-bottom-left-radius: 4px !important;
border-bottom-right-radius: 4px !important;
border-top: 1px solid #CDCDCD !important;
border-right: 1px solid #CDCDCD !important;
border-bottom: 1px solid #CDCDCD !important;
border-left: 1px solid #CDCDCD !important;
box-shadow: 0px 0px 0px 0px transparent;
padding-top: 0px !important;
padding-right: 10px !important;
padding-bottom: 0px !important;
padding-left: 12px !important;
}
.webVueAntYtCascaderStyle-mv.ant-select:not(.ant-select-disabled):hover .ant-select-selector,.webVueAntYtCascaderStyle-mv.ant-select-focused:not(.ant-select-disabled).ant-select:not(.ant-select-customize-input) .ant-select-selector{
border-right: 1px solid #CDCDCD !important;
}
.webVueAntYtCascaderStyle-mv .ant-select-selection-item{
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
letter-spacing: 0px;
text-decoration: none;
font-style: normal;
}
.webVueAntYtCascaderStyle-mv .ant-select-selector .ant-select-selection-placeholder{
color: #999999;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
letter-spacing: 0px;
text-decoration: none;
font-style: normal;
}
.popupKey-mv.ant-select-dropdown{
border-top-left-radius: 2px !important;
border-top-right-radius: 2px !important;
border-bottom-left-radius: 2px !important;
border-bottom-right-radius: 2px !important;
background: #ffffff !important;
border-top: 1px solid transparent !important;
border-right: 1px solid transparent !important;
border-bottom: 1px solid transparent !important;
border-left: 1px solid transparent !important;
box-shadow: 0px 0px 10px 0px rgba(153,153,153,0.3);
}
.popupKey-mv.ant-select-dropdown .ant-cascader-menu{
padding-top: 0px !important;
padding-right: 0px !important;
padding-bottom: 0px !important;
padding-left: 0px !important;
}
.popupKey-mv.ant-select-dropdown .ant-cascader-menu-item{
color: #333333;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
letter-spacing: 0px;
text-decoration: none;
font-style: normal;
}
.popupKey-mv.ant-select-dropdown .ant-cascader-menu-item .ant-cascader-menu-item-expand-icon{
color: #333333;
font-size: 14px;
}
.popupKey-mv.ant-select-dropdown .ant-cascader-menu-item:hover{
background: #F0F0F0;
color: #333333;
}
.popupKey-mv.ant-select-dropdown .ant-cascader-menu-item:hover .ant-cascader-menu-item-expand-icon{
color: #333333;
}
.popupKey-mv.ant-select-dropdown .ant-cascader-menu-item-active{
color: #333333;
background-color: #E6EFFE;
}
.popupKey-mv.ant-select-dropdown .ant-cascader-menu-item-active .ant-cascader-menu-item-expand-icon{
color: #333333;
}
.webVueAntYtCascaderFormItem  {
    flex-wrap: nowrap;
}
.webVueAntYtCascaderFormItem ,
.webVueAntYtCascaderFormItem .ant-form-item-control-input,
.webVueAntYtCascaderFormItem .ant-form-item-control-input .ant-form-item-control-input-content ,
.webVueAntYtCascaderFormItem .ant-form-item-control-input  .ant-select-selector .ant-select-selection-search input{
    width: 100%;
    height: 100%;
}
.webVueAntYtCascaderFormItem .ant-form-item-control-input{
    min-height: unset !important;
}
.webVueAntYtCascaderFormItem .ant-form-item-control {
    min-width: 0;
}
.webVueAntYtCascaderFormItem .ant-form-item-label {
    flex-shrink: 0;
    padding: 0;
    text-align: left;
}
.webVueAntYtCascaderFormItem .ant-form-item-label label {
    width: 100%;
    height: 100%;
}
.webVueAntYtCascaderFormItem .ant-form-item-label>label.ant-form-item-required:not(.ant-form-item-required-mark-optional):before {
  margin-top: 4px;
}
.webVueAntYtCascaderFormItem .ant-form-item-label label .label-content{
    flex: 1;
    display: inline-block;
    overflow: hidden;
    text-overflow: ellipsis;
}
.webVueAntYtCascaderFormItem .ant-form-item-label>label.ant-form-item-no-colon:after {
    display: none;
}
.webVueAntYtCascaderFormItem .ant-form-item-label label .ant-form-item-content {
    white-space: nowrap;
}
.webVueAntYtCascaderFormItem.hide-label .ant-form-item-label {
    display: none;
}
.webVueAntYtCascaderFormItem .ant-form-item-content:focus{
    outline: none;
}
.webVueAntYtCascader {
    width: 100%;
    height:100%;
}
.webVueAntYtCascader .ant-select-selector {
    height: 100%!important;
    overflow: auto;
}
.webVueAntYtCascader .ant-select-selector input {
    height: 100%;
}
.ant-select-selector {
    display: flex;
    align-items: center;
}
.webVueAntYtCascader .ant-select-selection-placeholder {
    display: block;
}
.webVueAntYtCascader .ant-cascader-menus {
    background-color: transparent !important;
    box-shadow: none;
}

.webVueAntYtCascaderFormItem-mv5j4kp .ant-form-item-explain{
position: absolute;
top: 100%;
z-index: -1;
}
.webVueAntYtCascaderFormItem-mv5j4kp .ant-form-item-label label{
width: 80px;
padding-right: 10px;
}
.webVueAntYtCascaderStyle-mvbipu6 .ant-select-selector{
background: #FFFFFF!important;
border-top-left-radius: 4px!important;
border-top-right-radius: 4px!important;
border-bottom-left-radius: 4px!important;
border-bottom-right-radius: 4px!important;
border-top: 1px solid #CDCDCD!important;
border-right: 1px solid #CDCDCD!important;
border-bottom: 1px solid #CDCDCD!important;
border-left: 1px solid #CDCDCD!important;
}

.webVueAntYtSelectFormItem-mv248cx .ant-form-item-explain{
position: absolute;
top: 100%;
z-index: -1;
}
.webVueAntYtSelectFormItem-mv248cx .ant-form-item-label label{
width: 80px;
padding-right: 10px;
}
.webVueAntYtSelectFormItem-mv248cx .ant-form-item-label label .label-content{
text-align: right;
text-align-last: right;
}

.webVueAntYtSelectFormItem-mv4859g .ant-form-item-explain{
position: absolute;
top: 100%;
z-index: -1;
}
.webVueAntYtSelectFormItem-mv4859g .ant-form-item-label label{
width: 80px;
padding-right: 10px;
}
.webVueAntYtSelectFormItem-mv4859g .ant-form-item-label label .label-content{
text-align: right;
text-align-last: right;
}

.webVueAntYtSelectFormItem-mvx6e6v .ant-form-item-explain{
position: absolute;
top: 100%;
z-index: -1;
}
.webVueAntYtSelectFormItem-mvx6e6v .ant-form-item-label label{
width: 80px;
padding-right: 10px;
}
.webVueAntYtSelectFormItem-mvx6e6v .ant-form-item-label label .label-content{
text-align: right;
text-align-last: right;
}

.webVueAntYtInputFormItem-mv8rrxx .ant-form-item-explain{
position: absolute;
top: 100%;
z-index: -1;
}
.webVueAntYtInputFormItem-mv8rrxx .ant-form-item-label label{
width: 80px;
padding-right: 10px;
}
.webVueAntYtInputFormItem-mv8rrxx .ant-form-item-label label .label-content{
text-align: right;
text-align-last: right;
}
.webVueAntYtInputStyle-mvdodth:not(.ant-input-affix-wrapper){
background: #FFFFFF !important;
}

.webVueAntYtButtonStyle-mvy8s4x{
color: #1890FF !important;
background: transparent !important;
border-top: 0px solid transparent;
border-right: 0px solid transparent;
border-bottom: 0px solid transparent;
border-left: 0px solid transparent;
align-items: center;
justify-content: center;
}
.webVueAntYtButtonStyle-mvy8s4x>span{
letter-spacing: 0px !important;
}

.webVueAntYtButtonStyle-mvlwfr3{
color: #F84C55 !important;
background: transparent !important;
border-top: 0px solid transparent;
border-right: 0px solid transparent;
border-bottom: 0px solid transparent;
border-left: 0px solid transparent;
align-items: center;
justify-content: center;
}
.webVueAntYtButtonStyle-mvlwfr3>span{
letter-spacing: 0px !important;
}

.webVueAntYtModalStyle-mv .ant-modal-wrap{
opacity: 1;
box-shadow: 0px 0px 0px 0px transparent;
border-top-left-radius: 6px;
border-top-right-radius: 6px;
border-bottom-left-radius: 6px;
border-bottom-right-radius: 6px;
border-top: 1px solid transparent;
border-right: 1px solid transparent;
border-bottom: 1px solid transparent;
border-left: 1px solid transparent;
}
.webVueAntYtModalStyle-mv .ant-modal-wrap .yt-custom-modal-header{
text-decoration: none;
font-style: normal;
text-align: left;
text-align-last: left;
color: #333333;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
padding-top: 12px;
padding-right: 0px;
padding-bottom: 12px;
padding-left: 21px;
}
.webVueAntYtModalStyle-mv.yt-custom-modal .ant-modal-header{
height: 45px;
background: #ffffff;
}
.webVueAntYtModalStyle-mv .ant-modal-wrap .ant-modal-close-x{
height: 45px;
line-height: 45px;
}
.webVueAntYtModalStyle-mv.yt-custom-modal .ant-modal-footer{
height: 57px;
background: #ffffff;
}
.webVueAntYtModal {
    width: 100%;
    height: 100%;
}


.webVueAntYtModalStyle-mv3k259 .ant-modal-wrap .yt-custom-modal-header{
font-size: 16px;
font-weight: bold;
}

.webVueAntYtVerticleMenuStyle-mv.ant-menu{
opacity: 1;
box-shadow: 0px 0px 0px 0px transparent !important;
border-top-left-radius: 0px;
border-top-right-radius: 0px;
border-bottom-left-radius: 0px;
border-bottom-right-radius: 0px;
border-top: 1px solid transparent;
border-right: 1px solid transparent;
border-bottom: 1px solid transparent;
border-left: 1px solid transparent;
color: #000000A6;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
letter-spacing: 0px;
font-style: normal;
background: #ffffff;
}
.webVueAntYtVerticleMenuStyle-mv.ant-menu .ant-menu-submenu-inline .ant-menu-inline,.webVueAntYtVerticleMenuStyle-mv.ant-menu .yt-horizontal-menu-menu-sub-menu .ant-menu-item,.webVueAntYtVerticleMenuStyle-mv.ant-menu .yt-horizontal-menu-menu-sub-menu .ant-menu-submenu{
color: #000000A6;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
letter-spacing: 0px;
text-decoration: none;
font-style: normal;
background: #ffffff;
}
.webVueAntYtVerticleMenuStyle-mv.ant-menu .ant-menu-vertical{
background: #ffffff;
}
.webVueAntYtVerticleMenuStyle-mv.ant-menu .ant-menu-item-selected,.webVueAntYtVerticleMenuStyle-mv.ant-menu .yt-horizontal-menu-menu-sub-menu .ant-menu-item-selected,.webVueAntYtVerticleMenuStyle-mv .ant-menu-submenu-selected>.ant-menu-submenu-title,.webVueAntYtVerticleMenuStyle-mv.ant-menu .sub-menu-selected>.ant-menu-submenu-title>.ant-menu-title-content{
color: #3C8EFF;
}
.webVueAntYtVerticleMenuStyle-mv.webVueAntYtVerticleMenu.ant-menu .ant-menu-item.ant-menu-item-selected,.webVueAntYtVerticleMenuStyle-mv.webVueAntYtVerticleMenu.ant-menu .sub-menu-selected>.ant-menu-submenu-title{
background: #E6EFFE;
}
.webVueAntYtVerticleMenuStyle-mv .ant-menu-submenu:not(.ant-menu-item-selected):hover>.ant-menu-submenu-title>.ant-menu-submenu-arrow,.webVueAntYtVerticleMenuStyle-mv .ant-menu-submenu:not(.ant-menu-item-selected):hover>.ant-menu-submenu-title>.ant-menu-submenu-expand-icon,.webVueAntYtVerticleMenuStyle-mv.ant-menu-light .ant-menu-item:not(.ant-menu-item-selected):hover,.webVueAntYtVerticleMenuStyle-mv.ant-menu-light .ant-menu-submenu-title:not(.ant-menu-item-selected):not(.ant-menu-submenu-selected):hover{
color: #3C8EFF;
background: #ffffff !important;
}
.webVueAntYtVerticleMenuStyle-mv.ant-menu-light .ant-menu-submenu-title:not(.ant-menu-item-selected):not(.ant-menu-submenu-selected):hover,.webVueAntYtVerticleMenuStyle-mv.ant-menu-light.ant-menu:not(.ant-menu-inline) .ant-menu-submenu-open:not(.ant-menu-item-selected):not(.ant-menu-submenu-selected){
color: #3C8EFF;
}
.webVueAntYtVerticleMenuStyle-mv.webVueAntYtVerticleMenu.ant-menu-light .ant-menu-item-active:not(.ant-menu-item-selected):not(.ant-menu-submenu-selected),.webVueAntYtVerticleMenuStyle-mv.webVueAntYtVerticleMenu.ant-menu-light .ant-menu-submenu-active:not(.ant-menu-item-selected):not(.ant-menu-submenu-selected){
color: #3C8EFF;
}
.webVueAntYtVerticleMenuStyle-mv.webVueAntYtVerticleMenu .ant-menu-item.ant-menu-item-selected:hover,.webVueAntYtVerticleMenuStyle-mv .ant-menu-submenu-title.ant-menu-item-selected:hover{
color: #3C8EFF;
}
.webVueAntYtVerticleMenu {
    width: 100%;
    height: 100%;
}
.webVueAntYtVerticleMenu div>li>.ant-menu-submenu-title {
    height: 100%;
}

.webVueAntYtVerticleMenuStyle-mvtbah7.ant-menu{
box-shadow: 0px 0px 0px 0px transparent!important;
}
.webVueAntYtVerticleMenuStyle-mvtbah7.ant-menu-inline div>li.ant-menu-item,.webVueAntYtVerticleMenuStyle-mvtbah7.ant-menu-inline div>li>.ant-menu-submenu-title,.webVueAntYtVerticleMenuStyle-mvtbah7.ant-menu-inline div>li.ant-menu-item.ant-menu-item-only-child{
height: 32px;
padding-top: 0px;
padding-right: 0px;
padding-bottom: 0px;
padding-left: 20px !important;
}
.webVueAntYtVerticleMenuStyle-mvtbah7 div>li.ant-menu-item,.webVueAntYtVerticleMenuStyle-mvtbah7 div>li>.ant-menu-submenu-title,.webVueAntYtVerticleMenuStyle-mvtbah7 div>li.ant-menu-item.ant-menu-item-only-child{
height: 32px;
text-decoration: none;
padding-top: 0px;
padding-right: 0px;
padding-bottom: 0px;
padding-left: 20px !important;
}
.webVueAntYtVerticleMenuStyle-mvtbah7.ant-menu-inline .ant-menu-submenu-inline .ant-menu-inline li.ant-menu-item,.webVueAntYtVerticleMenuStyle-mvtbah7.ant-menu-inline .ant-menu-submenu-inline .ant-menu-inline li.ant-menu-item-only-child,.webVueAntYtVerticleMenuStyle-mvtbah7.ant-menu-inline .ant-menu-submenu-inline .ant-menu-inline li>.ant-menu-submenu-title,.webVueAntYtVerticleMenuStyle-mvtbah7.ant-menu-vertical .ant-menu-submenu-popup .ant-menu-vertical li.ant-menu-item,.webVueAntYtVerticleMenuStyle-mvtbah7.ant-menu-vertical .ant-menu-submenu-popup .ant-menu-vertical li.ant-menu-item-only-child,.webVueAntYtVerticleMenuStyle-mvtbah7.ant-menu-vertical .ant-menu-submenu-popup .ant-menu-vertical li>.ant-menu-submenu-title{
height: 32px;
padding-top: 0px;
padding-right: 0px;
padding-bottom: 0px;
padding-left: 20px !important;
}
.webVueAntYtVerticleMenuStyle-mvtbah7 .ant-menu-submenu:not(.ant-menu-item-selected):hover>.ant-menu-submenu-title>.ant-menu-submenu-arrow,.webVueAntYtVerticleMenuStyle-mvtbah7 .ant-menu-submenu:not(.ant-menu-item-selected):hover>.ant-menu-submenu-title>.ant-menu-submenu-expand-icon,.webVueAntYtVerticleMenuStyle-mvtbah7.ant-menu-light .ant-menu-item:not(.ant-menu-item-selected):hover,.webVueAntYtVerticleMenuStyle-mvtbah7.ant-menu-light .ant-menu-submenu-title:not(.ant-menu-item-selected):not(.ant-menu-submenu-selected):hover{
background: #ffffff!important;
}


.webVueAntForm{
  width: 100%;
  height: 100%;
  overflow: auto;
  background-color: var(--web-vue-ant-form-bg-color);
}


.webVueAntYtInputFormItem-mvpuck0 .ant-form-item-explain{
position: absolute;
top: 100%;
z-index: -1;
}
.webVueAntYtInputFormItem-mvpuck0 .ant-form-item-label label{
width: 80px;
padding-right: 10px;
}
.webVueAntYtInputStyle-mvdkdf2:not(.ant-input-affix-wrapper){
background: #FFFFFF !important;
}

.webVueAntYtInputFormItem-mv8s0vx .ant-form-item-explain{
position: absolute;
top: 100%;
z-index: -1;
}
.webVueAntYtInputFormItem-mv8s0vx .ant-form-item-label label{
width: 95px;
padding-right: 10px;
}
.webVueAntYtInputFormItem-mv8s0vx .ant-form-item-label label .label-content{
text-align: right;
text-align-last: right;
}
.webVueAntYtInputStyle-mvfi2pe:not(.ant-input-affix-wrapper){
background: #FFFFFF !important;
}

.webVueAntYtInputFormItem-mvpbz2u .ant-form-item-explain{
position: absolute;
top: 100%;
z-index: -1;
}
.webVueAntYtInputFormItem-mvpbz2u .ant-form-item-label label{
width: 80px;
padding-right: 10px;
}
.webVueAntYtInputFormItem-mvpbz2u .ant-form-item-label label .label-content{
text-align: right;
text-align-last: right;
}
.webVueAntYtInputStyle-mvsjuug:not(.ant-input-affix-wrapper){
background: #FFFFFF !important;
}

.webVueAntYtInputFormItem-mvwxgc4 .ant-form-item-explain{
position: absolute;
top: 100%;
z-index: -1;
}
.webVueAntYtInputFormItem-mvwxgc4 .ant-form-item-label label{
width: 92px;
padding-right: 10px;
}
.webVueAntYtInputStyle-mvs3dkq:not(.ant-input-affix-wrapper){
background: #FFFFFF !important;
}

.webVueAntYtInputFormItem-mvxhjfq .ant-form-item-explain{
position: absolute;
top: 100%;
z-index: -1;
}
.webVueAntYtInputFormItem-mvxhjfq .ant-form-item-label label{
width: 80px;
padding-right: 10px;
}
.webVueAntYtInputStyle-mv56efh:not(.ant-input-affix-wrapper){
//background: #F6F6F6 !important;
background: #FFFFFF !important;
}

.webVueAntYtInputFormItem-mvuumku .ant-form-item-explain{
position: absolute;
top: 100%;
z-index: -1;
}
.webVueAntYtInputFormItem-mvuumku .ant-form-item-label label{
width: 80px;
padding-right: 10px;
}
.webVueAntYtInputStyle-mvlbaqg:not(.ant-input-affix-wrapper){
// background: #F6F6F6 !important;
background: #FFFFFF !important;
}

.webVueAntYtInputFormItem-mvjn1mn .ant-form-item-explain{
position: absolute;
top: 100%;
z-index: -1;
}
.webVueAntYtInputFormItem-mvjn1mn .ant-form-item-label label{
width: 80px;
padding-right: 10px;
}
.webVueAntYtInputStyle-mv2mqra:not(.ant-input-affix-wrapper){
background: #FFFFFF !important;
}

.webVueAntYtInputFormItem-mvoees1 .ant-form-item-explain{
position: absolute;
top: 100%;
z-index: -1;
}
.webVueAntYtInputFormItem-mvoees1 .ant-form-item-label label{
width: 80px;
padding-right: 10px;
}
.webVueAntYtInputStyle-mvww6pf:not(.ant-input-affix-wrapper){
background: #FFFFFF !important;
}

.webVueAntYtRectangleStyle-mvbi05d{
background: #1890FF;
border-top: 1px solid transparent;
border-right: 1px solid transparent;
border-bottom: 1px solid transparent;
border-left: 1px solid transparent;
}

.webVueAntYtSpanStyle-mvn0u3r{
color: #3D3D3D !important;
font-weight: bold;
}
.webVueAntYtSpanStyle-mvn0u3r span{
text-decoration: none;
}

.webVueAntYtRectangleStyle-mv2tcbb{
background: #1890FF;
border-top: 1px solid transparent;
border-right: 1px solid transparent;
border-bottom: 1px solid transparent;
border-left: 1px solid transparent;
}

.webVueAntYtSpanStyle-mvzllom{
color: #3D3D3D !important;
font-weight: bold;
}
.webVueAntYtSpanStyle-mvzllom span{
text-decoration: none;
}

.webVueAntYtRectangleStyle-mvr9ni5{
background: #1890FF;
border-top: 1px solid transparent;
border-right: 1px solid transparent;
border-bottom: 1px solid transparent;
border-left: 1px solid transparent;
}

.webVueAntYtSpanStyle-mvma1jw{
color: #3D3D3D !important;
font-weight: bold;
}
.webVueAntYtSpanStyle-mvma1jw span{
text-decoration: none;
}

.webVueAntYtInputFormItem-mv3gl9k .ant-form-item-explain{
position: absolute;
top: 100%;
z-index: -1;
}
.webVueAntYtInputFormItem-mv3gl9k .ant-form-item-label label{
width: 91px;
padding-right: 10px;
}
.webVueAntYtInputStyle-mv2bvli:not(.ant-input-affix-wrapper){
background: #FFFFFF !important;
}

.webVueAntYtInputFormItem-mvhzizl .ant-form-item-explain{
position: absolute;
top: 100%;
z-index: -1;
}
.webVueAntYtInputFormItem-mvhzizl .ant-form-item-label label{
width: 78px;
padding-right: 10px;
}
.webVueAntYtInputFormItem-mvhzizl .ant-form-item-label label .label-content{
text-align: right;
text-align-last: right;
}
.webVueAntYtInputStyle-mvma3t1:not(.ant-input-affix-wrapper){
background: #FFFFFF !important;
}

.webVueAntYtInputFormItem-mvep1mf .ant-form-item-explain{
position: absolute;
top: 100%;
z-index: -1;
}
.webVueAntYtInputFormItem-mvep1mf .ant-form-item-label label{
width: 92px;
padding-right: 10px;
}
.webVueAntYtInputStyle-mvykn6c:not(.ant-input-affix-wrapper){
background: #FFFFFF !important;
}

.webVueAntYtInputFormItem-mv2ncsp .ant-form-item-explain{
position: absolute;
top: 100%;
z-index: -1;
}
.webVueAntYtInputFormItem-mv2ncsp .ant-form-item-label label{
width: 77px;
padding-right: 10px;
}
.webVueAntYtInputFormItem-mv2ncsp .ant-form-item-label label .label-content{
text-align: right;
text-align-last: right;
}
.webVueAntYtInputStyle-mvnx2rb:not(.ant-input-affix-wrapper){
background: #FFFFFF !important;
}

.webVueAntYtInputFormItem-mvpy6vq .ant-form-item-explain{
position: absolute;
top: 100%;
z-index: -1;
}
.webVueAntYtInputFormItem-mvpy6vq .ant-form-item-label label{
width: 80px;
padding-right: 10px;
}
.webVueAntYtInputStyle-mvl2pbf:not(.ant-input-affix-wrapper){
background: #FFFFFF !important;
}

.webVueAntYtInputFormItem-mvoippu .ant-form-item-explain{
position: absolute;
top: 100%;
z-index: -1;
}
.webVueAntYtInputFormItem-mvoippu .ant-form-item-label label{
width: 80px;
padding-right: 10px;
}
.webVueAntYtInputStyle-mvloji9:not(.ant-input-affix-wrapper){
background: #FFFFFF !important;
}

.webVueAntYtRectangleStyle-mvh3of7{
background: #1890FF;
border-top: 1px solid transparent;
border-right: 1px solid transparent;
border-bottom: 1px solid transparent;
border-left: 1px solid transparent;
}

.webVueAntYtSpanStyle-mvqq9z9{
color: #3D3D3D !important;
font-weight: bold;
}
.webVueAntYtSpanStyle-mvqq9z9 span{
text-decoration: none;
}

.webVueAntYtSpanStyle-mvbmxa9{
color: #3D3D3D !important;
}
.webVueAntYtSpanStyle-mvbmxa9 span{
text-decoration: none;
}

.webVueAntYtPicture {
    width: 100%;
    height:100%;
    overflow: hidden;
}
.webVueAntYtPicture img, .webVueAntYtPicture .ant-image {
    width: 100%;
    height:100%;
}

.webVueAntYtPictureStyle-mvwhdhb{
opacity: 1;
box-shadow: 0px 0px 0px 0px transparent;
border-top-left-radius: 4px;
border-top-right-radius: 4px;
border-bottom-left-radius: 4px;
border-bottom-right-radius: 4px;
border-top: 1px solid #D9D9D9;
border-right: 1px solid #D9D9D9;
border-bottom: 1px solid #D9D9D9;
border-left: 1px solid #D9D9D9;
}

.webVueAntYtSpanStyle-mvkj0hv{
color: #3D3D3D !important;
}
.webVueAntYtSpanStyle-mvkj0hv span{
text-decoration: none;
}

.webVueAntYtPictureStyle-mvs43ok{
opacity: 1;
box-shadow: 0px 0px 0px 0px transparent;
border-top-left-radius: 4px;
border-top-right-radius: 4px;
border-bottom-left-radius: 4px;
border-bottom-right-radius: 4px;
border-top: 1px solid #D9D9D9;
border-right: 1px solid #D9D9D9;
border-bottom: 1px solid #D9D9D9;
border-left: 1px solid #D9D9D9;
}

.webVueAntYtPictureStyle-mvvynkh{
opacity: 1;
box-shadow: 0px 0px 0px 0px transparent;
border-top-left-radius: 4px;
border-top-right-radius: 4px;
border-bottom-left-radius: 4px;
border-bottom-right-radius: 4px;
border-top: 1px solid #D9D9D9;
border-right: 1px solid #D9D9D9;
border-bottom: 1px solid #D9D9D9;
border-left: 1px solid #D9D9D9;
}

.webVueAntYtPictureStyle-mvlelgq{
opacity: 1;
box-shadow: 0px 0px 0px 0px transparent;
border-top-left-radius: 4px;
border-top-right-radius: 4px;
border-bottom-left-radius: 4px;
border-bottom-right-radius: 4px;
border-top: 1px solid #D9D9D9;
border-right: 1px solid #D9D9D9;
border-bottom: 1px solid #D9D9D9;
border-left: 1px solid #D9D9D9;
}

.webVueAntYtSelectFormItem-mv3zwbf .ant-form-item-explain{
position: absolute;
top: 100%;
z-index: -1;
}
.webVueAntYtSelectFormItem-mv3zwbf .ant-form-item-label label{
width: 91px;
padding-right: 10px;
}

.webVueAntYtSelectFormItem-mvfrwmp .ant-form-item-explain{
position: absolute;
top: 100%;
z-index: -1;
}
.webVueAntYtSelectFormItem-mvfrwmp .ant-form-item-label label{
width: 91px;
padding-right: 10px;
}

.webVueAntYtSelectFormItem-mverfpf .ant-form-item-explain{
position: absolute;
top: 100%;
z-index: -1;
}
.webVueAntYtSelectFormItem-mverfpf .ant-form-item-label label{
width: 80px;
padding-right: 10px;
}

.webVueAntYtSelectFormItem-mvp8rja .ant-form-item-explain{
position: absolute;
top: 100%;
z-index: -1;
}
.webVueAntYtSelectFormItem-mvp8rja .ant-form-item-label label{
width: 80px;
padding-right: 10px;
}

.webVueAntYtSelectFormItem-mvvbi94 .ant-form-item-explain{
position: absolute;
top: 100%;
z-index: -1;
}
.webVueAntYtSelectFormItem-mvvbi94 .ant-form-item-label label{
width: 80px;
padding-right: 10px;
}

.webVueAntYtSelectFormItem-mv8buay .ant-form-item-explain{
position: absolute;
top: 100%;
z-index: -1;
}
.webVueAntYtSelectFormItem-mv8buay .ant-form-item-label label{
width: 80px;
padding-right: 10px;
}

.webVueAntYtSelectFormItem-mv0qxhj .ant-form-item-explain{
position: absolute;
top: 100%;
z-index: -1;
}
.webVueAntYtSelectFormItem-mv0qxhj .ant-form-item-label label{
width: 80px;
padding-right: 10px;
}


.webVueAntYtRectangleStyle-mvkgk4l{
background: #1890FF;
border-top: 1px solid transparent;
border-right: 1px solid transparent;
border-bottom: 1px solid transparent;
border-left: 1px solid transparent;
}

.webVueAntYtSpanStyle-mvvorrz{
color: #3D3D3D !important;
font-weight: bold;
}
.webVueAntYtSpanStyle-mvvorrz span{
text-decoration: none;
}

.webVueAntYtRectangleStyle-mvrqe5p{
background: #1890FF;
border-top: 1px solid transparent;
border-right: 1px solid transparent;
border-bottom: 1px solid transparent;
border-left: 1px solid transparent;
}

.webVueAntYtSpanStyle-mvykzy0{
color: #3D3D3D !important;
font-weight: bold;
}
.webVueAntYtSpanStyle-mvykzy0 span{
text-decoration: none;
}

.webVueAntYtSelectFormItem-mvdnk3l .ant-form-item-explain{
position: absolute;
top: 100%;
z-index: -1;
}
.webVueAntYtSelectFormItem-mvdnk3l .ant-form-item-label label{
// width: 80px;
width: 94px;
padding-right: 10px;
}

.webVueAntYtSelectFormItem-mv9adbi .ant-form-item-explain{
position: absolute;
top: 100%;
z-index: -1;
}
.webVueAntYtSelectFormItem-mv9adbi .ant-form-item-label label{
width: 91px;
padding-right: 10px;
}

.webVueAntYtSelectFormItem-mvmqd1q .ant-form-item-explain{
position: absolute;
top: 100%;
z-index: -1;
}
.webVueAntYtSelectFormItem-mvmqd1q .ant-form-item-label label{
// width: 81px;
width: 94px;
padding-right: 10px;
}


.webVueAntYtInputFormItem-mvn7ype .ant-form-item-explain{
position: absolute;
top: 100%;
z-index: -1;
}
.webVueAntYtInputFormItem-mvn7ype .ant-form-item-label label{
width: 108px;
padding-right: 10px;
}
.webVueAntYtInputStyle-mvqg28l:not(.ant-input-affix-wrapper){
background: #FFFFFF !important;
}

.webVueAntYtRectangleStyle-mv3pbka{
background: #1890FF;
border-top: 1px solid transparent;
border-right: 1px solid transparent;
border-bottom: 1px solid transparent;
border-left: 1px solid transparent;
}

.webVueAntYtSpanStyle-mvjkax4{
color: #3D3D3D !important;
font-weight: bold;
}
.webVueAntYtSpanStyle-mvjkax4 span{
text-decoration: none;
}

.webVueAntYtRectangleStyle-mvehdkp{
background: #1890FF;
border-top: 1px solid transparent;
border-right: 1px solid transparent;
border-bottom: 1px solid transparent;
border-left: 1px solid transparent;
}

.webVueAntYtSpanStyle-mvgkra0{
color: #3D3D3D !important;
font-weight: bold;
}
.webVueAntYtSpanStyle-mvgkra0 span{
text-decoration: none;
}

.webVueAntYtSelectFormItem-mv1nhn6 .ant-form-item-explain{
position: absolute;
top: 100%;
z-index: -1;
}
.webVueAntYtSelectFormItem-mv1nhn6 .ant-form-item-label label{
width: 122px;
padding-right: 10px;
}

.webVueAntYtSelectFormItem-mv8t8m6 .ant-form-item-explain{
position: absolute;
top: 100%;
z-index: -1;
}
.webVueAntYtSelectFormItem-mv8t8m6 .ant-form-item-label label{
width: 80px;
padding-right: 10px;
}


.webVueAntYtInputFormItem-mvj685v .ant-form-item-explain{
position: absolute;
top: 100%;
z-index: -1;
}
.webVueAntYtInputFormItem-mvj685v .ant-form-item-label label{
width: 80px;
padding-right: 10px;
}
.webVueAntYtInputStyle-mvzs58z:not(.ant-input-affix-wrapper){
background: #FFFFFF !important;
}

.webVueAntYtInputFormItem-mv8e6ly .ant-form-item-explain{
position: absolute;
top: 100%;
z-index: -1;
}
.webVueAntYtInputFormItem-mv8e6ly .ant-form-item-label label{
width: 80px;
padding-right: 10px;
}
.webVueAntYtInputFormItem-mv8e6ly .ant-form-item-label label .label-content{
text-align: right;
text-align-last: right;
}
.webVueAntYtInputStyle-mvlbfo1:not(.ant-input-affix-wrapper){
background: #FFFFFF !important;
}

.webVueAntYtInputFormItem-mvxto16 .ant-form-item-explain{
position: absolute;
top: 100%;
z-index: -1;
}
.webVueAntYtInputFormItem-mvxto16 .ant-form-item-label label{
width: 94px;
padding-right: 10px;
}
.webVueAntYtInputStyle-mvogfzb:not(.ant-input-affix-wrapper){
background: #FFFFFF !important;
}

.webVueAntYtInputFormItem-mvsrs55 .ant-form-item-explain{
position: absolute;
top: 100%;
z-index: -1;
}
.webVueAntYtInputFormItem-mvsrs55 .ant-form-item-label label{
width: 80px;
padding-right: 10px;
}
.webVueAntYtInputStyle-mvadubv:not(.ant-input-affix-wrapper){
background: #FFFFFF !important;
}

.webVueAntYtRectangleStyle-mvxvyjj{
background: #1890FF;
border-top: 1px solid transparent;
border-right: 1px solid transparent;
border-bottom: 1px solid transparent;
border-left: 1px solid transparent;
}

.webVueAntYtSpanStyle-mvbp6u1{
color: #3D3D3D !important;
font-weight: bold;
}
.webVueAntYtSpanStyle-mvbp6u1 span{
text-decoration: none;
}

.webVueAntYtRectangleStyle-mvqmbat{
background: #1890FF;
border-top: 1px solid transparent;
border-right: 1px solid transparent;
border-bottom: 1px solid transparent;
border-left: 1px solid transparent;
}

.webVueAntYtSpanStyle-mvl2eya{
color: #3D3D3D !important;
font-weight: bold;
}
.webVueAntYtSpanStyle-mvl2eya span{
text-decoration: none;
}


.webVueAntYtRectangleStyle-mv5ba7m{
background: #1890FF;
border-top: 1px solid transparent;
border-right: 1px solid transparent;
border-bottom: 1px solid transparent;
border-left: 1px solid transparent;
}

.webVueAntYtSpanStyle-mvfw1kx{
color: #3D3D3D !important;
font-weight: bold;
}
.webVueAntYtSpanStyle-mvfw1kx span{
text-decoration: none;
}

.webVueAntYtTableStyle-mvd9omn{
opacity: 1;
}
.webVueAntYtTableStyle-mvd9omn .ant-table{
box-shadow: 0px 0px 0px 0px transparent;
border-top-left-radius: 4px;
border-top-right-radius: 4px;
border-bottom-left-radius: 4px;
border-bottom-right-radius: 4px;
border-top: 1px solid #D9D9D9;
border-right: 1px solid #D9D9D9;
border-bottom: 1px solid #D9D9D9;
border-left: 1px solid #D9D9D9;
}
.webVueAntYtTableStyle-mvd9omn .ant-table th:first-child{
border-top-left-radius: 4px !important;
}
.webVueAntYtTableStyle-mvd9omn .ant-table th:last-child{
border-top-right-radius: 4px !important;
}
.webVueAntYtTableStyle-mvd9omn .ant-table tr:last-child td:first-child{
border-bottom-left-radius: 4px !important;
}
.webVueAntYtTableStyle-mvd9omn .ant-table tr:last-child td:last-child{
border-bottom-right-radius: 4px !important;
}
.webVueAntYtTableStyle-mvd9omn .ant-table .ant-table-thead tr,.webVueAntYtTableStyle-mvd9omn .ant-table .ant-table-thead tr th div:first-child{
height: 40px;
}
.webVueAntYtTableStyle-mvd9omn .ant-table .ant-table-thead tr th div.ant-table-selection{
line-height: 40px;
}
.webVueAntYtTableStyle-mvd9omn .ant-table .ant-table-thead tr th{
background: #F6F6F6;
}
.webVueAntYtTableStyle-mvd9omn .ant-table .ant-table-thead tr span.th-text{
color: #000000A6;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
line-height: 50px;
letter-spacing: 0px;
font-style: normal;
text-align: center;
text-align-last: center;
text-decoration: none;
padding-top: 0px;
padding-right: 0px;
padding-bottom: 0px;
padding-left: 0px;
}
.webVueAntYtTableStyle-mvd9omn .ant-table tbody tr td{
height: 40px;
}
.webVueAntYtTableStyle-mvd9omn .ant-table tbody tr td .ant-checkbox-wrapper{
line-height: 40px;
}
.webVueAntYtTableStyle-mvd9omn .ant-table tbody tr td{
background: #FFFFFF;
}
.webVueAntYtTableStyle-mvd9omn .ant-table thead tr th,.webVueAntYtTableStyle-mvd9omn .ant-table .ant-table-tbody tr:not(:last-child) td{
border-bottom: 1px solid #dcdcdc;
}
.webVueAntYtTableStyle-mvd9omn .ant-table thead tr th:not(:last-child),.webVueAntYtTableStyle-mvd9omn .ant-table .ant-table-tbody tr td:not(:last-child){
border-right: 1px solid #dcdcdc;
}
.webVueAntYtTableStyle-mvd9omn.ant-table-striped .ant-table tbody tr:nth-child(2n-1) td{
background: #FFFFFF;
}
.webVueAntYtTableStyle-mvd9omn.ant-table-striped .ant-table tbody tr:nth-child(2n) td{
background: #FFFFFF;
}
.webVueAntYtTableStyle-mvd9omn .ant-table tbody tr:not(.ant-table-row-selected):hover td{
background: #E4EFFF !important;
}
.webVueAntYtTableStyle-mvd9omn .ant-table tbody tr:not(.ant-table-row-selected):hover td span.td-text{
color: #000000 !important;
}
.webVueAntYtTableStyle-mvd9omn .ant-table-tbody tr.ant-table-row-selected td{
background: #3C8EFF !important;
}
.webVueAntYtTableStyle-mvd9omn .ant-table-tbody tr.ant-table-row-selected td span.td-text{
color: #FFFFFF !important;
}
.webVueAntYtTableStyle-mvd9omn .ant-pagination li:not(.ant-pagination-options),.webVueAntYtTableStyle-mvd9omn .ant-pagination button,.webVueAntYtTableStyle-mvd9omn .ant-pagination li .ant-select .ant-select-selector,.webVueAntYtTableStyle-mvd9omn .ant-pagination li input{
border-top-left-radius: 4px;
border-top-right-radius: 4px;
border-bottom-left-radius: 4px;
border-bottom-right-radius: 4px;
background: #FFFFFF;
color: #000000A6;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
line-height: 32px;
letter-spacing: 0px;
text-align: center;
text-align-last: center;
font-style: normal;
text-decoration: none;
}
.webVueAntYtTableStyle-mvd9omn .ant-pagination button,.webVueAntYtTableStyle-mvd9omn .ant-pagination li .ant-select .ant-select-selector,.webVueAntYtTableStyle-mvd9omn .ant-pagination li input,.webVueAntYtTableStyle-mvd9omn .ant-pagination li a,.webVueAntYtTableStyle-mvd9omn .ant-pagination li .ant-pagination-options-quick-jumper{
padding-top: 0px;
padding-right: 0px;
padding-bottom: 0px;
padding-left: 0px;
}
.webVueAntYtTableStyle-mvd9omn .ant-pagination li:not(.ant-pagination-options),.webVueAntYtTableStyle-mvd9omn .ant-pagination li.ant-pagination-options .ant-pagination-options-size-changer.ant-select .ant-select-selector,.webVueAntYtTableStyle-mvd9omn .ant-pagination li.ant-pagination-options .ant-pagination-options-quick-jumper input{
border-top: 1px solid #D9D9D9;
border-right: 1px solid #D9D9D9;
border-bottom: 1px solid #D9D9D9;
border-left: 1px solid #D9D9D9;
}
.webVueAntYtTableStyle-mvd9omn .ant-pagination li button{
border: none;
}
.webVueAntYtTableStyle-mvd9omn .ant-pagination li a,.webVueAntYtTableStyle-mvd9omn .ant-pagination li .ant-pagination-options-quick-jumper{
color: #000000A6;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
line-height: 32px;
letter-spacing: 0px;
text-align: center;
text-align-last: center;
font-style: normal;
text-decoration: none;
}
.webVueAntYtTableStyle-mvd9omn .ant-pagination li.ant-pagination-item-active{
background: #FFFFFF;
border-top: 1px solid #1890ff;
border-right: 1px solid #1890ff;
border-bottom: 1px solid #1890ff;
border-left: 1px solid #1890ff;
}
.webVueAntYtTableStyle-mvd9omn .ant-pagination li.ant-pagination-item-active a{
color: #1890ff;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
line-height: 32px;
letter-spacing: 0px;
text-align: center;
text-align-last: center;
font-style: normal;
text-decoration: none;
}
.webVueAntYtTableStyle-mvd9omn tr td:nth-child(1) div:first-child{
text-align: center;
text-align-last: center;
padding-top: 0px;
padding-right: 0px;
padding-bottom: 0px;
padding-left: 0px;
}
.webVueAntYtTableStyle-mvd9omn tr td:nth-child(1) div:first-child span.td-text{
color: #000000A6;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
line-height: 50px;
letter-spacing: 0px;
text-decoration: none;
font-style: normal;
}
.webVueAntYtTableStyle-mvd9omn tr > th:nth-child(1), .webVueAntYtTableStyle-mvd9omn .ant-table-body tr.ant-table-measure-row td:nth-child(1){
width: 40px !important;
min-width: 40px !important;
max-width: 40px !important;
}
.webVueAntYtTableStyle-mvd9omn tr td:nth-child(2) div:first-child{
text-align: center;
text-align-last: center;
padding-top: 0px;
padding-right: 0px;
padding-bottom: 0px;
padding-left: 0px;
}
.webVueAntYtTableStyle-mvd9omn tr td:nth-child(2) div:first-child span.td-text{
color: #000000A6;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
line-height: 50px;
letter-spacing: 0px;
text-decoration: none;
font-style: normal;
}
.webVueAntYtTableStyle-mvd9omn tr > th:nth-child(2), .webVueAntYtTableStyle-mvd9omn .ant-table-body tr.ant-table-measure-row td:nth-child(2){
width: calc((100% - 40px) / 4) !important;
min-width: 1px !important;
max-width: 1px !important;
}
.webVueAntYtTableStyle-mvd9omn tr td:nth-child(3) div:first-child{
text-align: center;
text-align-last: center;
padding-top: 0px;
padding-right: 0px;
padding-bottom: 0px;
padding-left: 0px;
}
.webVueAntYtTableStyle-mvd9omn tr td:nth-child(3) div:first-child span.td-text{
color: #000000A6;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
line-height: 50px;
letter-spacing: 0px;
text-decoration: none;
font-style: normal;
}
.webVueAntYtTableStyle-mvd9omn tr > th:nth-child(3), .webVueAntYtTableStyle-mvd9omn .ant-table-body tr.ant-table-measure-row td:nth-child(3){
width: calc((100% - 40px) / 4) !important;
min-width: 1px !important;
max-width: 1px !important;
}
.webVueAntYtTableStyle-mvd9omn tr td:nth-child(4) div:first-child{
text-align: center;
text-align-last: center;
padding-top: 0px;
padding-right: 0px;
padding-bottom: 0px;
padding-left: 0px;
}
.webVueAntYtTableStyle-mvd9omn tr td:nth-child(4) div:first-child span.td-text{
color: #000000A6;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
line-height: 50px;
letter-spacing: 0px;
text-decoration: none;
font-style: normal;
}
.webVueAntYtTableStyle-mvd9omn tr > th:nth-child(4), .webVueAntYtTableStyle-mvd9omn .ant-table-body tr.ant-table-measure-row td:nth-child(4){
width: calc((100% - 40px) / 4) !important;
min-width: 1px !important;
max-width: 1px !important;
}
.webVueAntYtTableStyle-mvd9omn tr td:nth-child(5) div:first-child{
text-align: center;
text-align-last: center;
padding-top: 0px;
padding-right: 0px;
padding-bottom: 0px;
padding-left: 0px;
}
.webVueAntYtTableStyle-mvd9omn tr td:nth-child(5) div:first-child span.td-text{
color: #000000A6;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
line-height: 50px;
letter-spacing: 0px;
text-decoration: none;
font-style: normal;
}
.webVueAntYtTableStyle-mvd9omn tr > th:nth-child(5), .webVueAntYtTableStyle-mvd9omn .ant-table-body tr.ant-table-measure-row td:nth-child(5){
width: calc((100% - 40px) / 4) !important;
min-width: 1px !important;
max-width: 1px !important;
}
.webVueAntYtTableStyle-mvd9omn{
width: 100%;
}

.webVueAntYtInputFormItem-mvvpgya .ant-form-item-explain{
position: absolute;
top: 100%;
z-index: -1;
}
.webVueAntYtInputFormItem-mvvpgya .ant-form-item-label label{
width: 80px;
padding-right: 10px;
}
.webVueAntYtInputFormItem-mvvpgya .ant-form-item-label label .label-content{
text-align: right;
text-align-last: right;
}
.webVueAntYtInputStyle-mv405o8:not(.ant-input-affix-wrapper){
background: #FFFFFF !important;
}

.webVueAntYtInputFormItem-mvxybzj .ant-form-item-explain{
position: absolute;
top: 100%;
z-index: -1;
}
.webVueAntYtInputFormItem-mvxybzj .ant-form-item-label label{
width: 80px;
padding-right: 10px;
}
.webVueAntYtInputFormItem-mvxybzj .ant-form-item-label label .label-content{
text-align: right;
text-align-last: right;
}
.webVueAntYtInputStyle-mvhvrg4:not(.ant-input-affix-wrapper){
background: #FFFFFF !important;
}

.webVueAntYtInputFormItem-mvefpqg .ant-form-item-explain{
position: absolute;
top: 100%;
z-index: -1;
}
.webVueAntYtInputFormItem-mvefpqg .ant-form-item-label label{
width: 80px;
padding-right: 10px;
}
.webVueAntYtInputFormItem-mvefpqg .ant-form-item-label label .label-content{
text-align: right;
text-align-last: right;
}
.webVueAntYtInputStyle-mv5nqeu:not(.ant-input-affix-wrapper){
background: #FFFFFF !important;
}

.webVueAntYtRectangleStyle-mvmpn3y{
background: #1890FF;
border-top: 1px solid transparent;
border-right: 1px solid transparent;
border-bottom: 1px solid transparent;
border-left: 1px solid transparent;
}

.webVueAntYtSpanStyle-mv0dqvs{
color: #3D3D3D !important;
font-weight: bold;
}
.webVueAntYtSpanStyle-mv0dqvs span{
text-decoration: none;
}

.webVueAntYtTableStyle-mvmm00u{
opacity: 1;
}
.webVueAntYtTableStyle-mvmm00u .ant-table{
box-shadow: 0px 0px 0px 0px transparent;
border-top-left-radius: 4px;
border-top-right-radius: 4px;
border-bottom-left-radius: 4px;
border-bottom-right-radius: 4px;
border-top: 1px solid #D9D9D9;
border-right: 1px solid #D9D9D9;
border-bottom: 1px solid #D9D9D9;
border-left: 1px solid #D9D9D9;
}
.webVueAntYtTableStyle-mvmm00u .ant-table th:first-child{
border-top-left-radius: 4px !important;
}
.webVueAntYtTableStyle-mvmm00u .ant-table th:last-child{
border-top-right-radius: 4px !important;
}
.webVueAntYtTableStyle-mvmm00u .ant-table tr:last-child td:first-child{
border-bottom-left-radius: 4px !important;
}
.webVueAntYtTableStyle-mvmm00u .ant-table tr:last-child td:last-child{
border-bottom-right-radius: 4px !important;
}
.webVueAntYtTableStyle-mvmm00u .ant-table .ant-table-thead tr,.webVueAntYtTableStyle-mvmm00u .ant-table .ant-table-thead tr th div:first-child{
height: 40px;
}
.webVueAntYtTableStyle-mvmm00u .ant-table .ant-table-thead tr th div.ant-table-selection{
line-height: 40px;
}
.webVueAntYtTableStyle-mvmm00u .ant-table .ant-table-thead tr th{
background: #F6F6F6;
}
.webVueAntYtTableStyle-mvmm00u .ant-table .ant-table-thead tr span.th-text{
color: #000000A6;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
line-height: 50px;
letter-spacing: 0px;
font-style: normal;
text-align: center;
text-align-last: center;
text-decoration: none;
padding-top: 0px;
padding-right: 0px;
padding-bottom: 0px;
padding-left: 0px;
}
.webVueAntYtTableStyle-mvmm00u .ant-table tbody tr td{
height: 40px;
}
.webVueAntYtTableStyle-mvmm00u .ant-table tbody tr td .ant-checkbox-wrapper{
line-height: 40px;
}
.webVueAntYtTableStyle-mvmm00u .ant-table tbody tr td{
background: #FFFFFF;
}
.webVueAntYtTableStyle-mvmm00u .ant-table thead tr th,.webVueAntYtTableStyle-mvmm00u .ant-table .ant-table-tbody tr:not(:last-child) td{
border-bottom: 1px solid #dcdcdc;
}
.webVueAntYtTableStyle-mvmm00u .ant-table thead tr th:not(:last-child),.webVueAntYtTableStyle-mvmm00u .ant-table .ant-table-tbody tr td:not(:last-child){
border-right: 1px solid #dcdcdc;
}
.webVueAntYtTableStyle-mvmm00u.ant-table-striped .ant-table tbody tr:nth-child(2n-1) td{
background: #FFFFFF;
}
.webVueAntYtTableStyle-mvmm00u.ant-table-striped .ant-table tbody tr:nth-child(2n) td{
background: #FFFFFF;
}
.webVueAntYtTableStyle-mvmm00u .ant-table tbody tr:not(.ant-table-row-selected):hover td{
background: #E4EFFF !important;
}
.webVueAntYtTableStyle-mvmm00u .ant-table tbody tr:not(.ant-table-row-selected):hover td span.td-text{
color: #000000 !important;
}
.webVueAntYtTableStyle-mvmm00u .ant-table-tbody tr.ant-table-row-selected td{
background: #3C8EFF !important;
}
.webVueAntYtTableStyle-mvmm00u .ant-table-tbody tr.ant-table-row-selected td span.td-text{
color: #FFFFFF !important;
}
.webVueAntYtTableStyle-mvmm00u .ant-pagination li:not(.ant-pagination-options),.webVueAntYtTableStyle-mvmm00u .ant-pagination button,.webVueAntYtTableStyle-mvmm00u .ant-pagination li .ant-select .ant-select-selector,.webVueAntYtTableStyle-mvmm00u .ant-pagination li input{
border-top-left-radius: 4px;
border-top-right-radius: 4px;
border-bottom-left-radius: 4px;
border-bottom-right-radius: 4px;
background: #FFFFFF;
color: #000000A6;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
line-height: 32px;
letter-spacing: 0px;
text-align: center;
text-align-last: center;
font-style: normal;
text-decoration: none;
}
.webVueAntYtTableStyle-mvmm00u .ant-pagination button,.webVueAntYtTableStyle-mvmm00u .ant-pagination li .ant-select .ant-select-selector,.webVueAntYtTableStyle-mvmm00u .ant-pagination li input,.webVueAntYtTableStyle-mvmm00u .ant-pagination li a,.webVueAntYtTableStyle-mvmm00u .ant-pagination li .ant-pagination-options-quick-jumper{
padding-top: 0px;
padding-right: 0px;
padding-bottom: 0px;
padding-left: 0px;
}
.webVueAntYtTableStyle-mvmm00u .ant-pagination li:not(.ant-pagination-options),.webVueAntYtTableStyle-mvmm00u .ant-pagination li.ant-pagination-options .ant-pagination-options-size-changer.ant-select .ant-select-selector,.webVueAntYtTableStyle-mvmm00u .ant-pagination li.ant-pagination-options .ant-pagination-options-quick-jumper input{
border-top: 1px solid #D9D9D9;
border-right: 1px solid #D9D9D9;
border-bottom: 1px solid #D9D9D9;
border-left: 1px solid #D9D9D9;
}
.webVueAntYtTableStyle-mvmm00u .ant-pagination li button{
border: none;
}
.webVueAntYtTableStyle-mvmm00u .ant-pagination li a,.webVueAntYtTableStyle-mvmm00u .ant-pagination li .ant-pagination-options-quick-jumper{
color: #000000A6;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
line-height: 32px;
letter-spacing: 0px;
text-align: center;
text-align-last: center;
font-style: normal;
text-decoration: none;
}
.webVueAntYtTableStyle-mvmm00u .ant-pagination li.ant-pagination-item-active{
background: #FFFFFF;
border-top: 1px solid #1890ff;
border-right: 1px solid #1890ff;
border-bottom: 1px solid #1890ff;
border-left: 1px solid #1890ff;
}
.webVueAntYtTableStyle-mvmm00u .ant-pagination li.ant-pagination-item-active a{
color: #1890ff;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
line-height: 32px;
letter-spacing: 0px;
text-align: center;
text-align-last: center;
font-style: normal;
text-decoration: none;
}
.webVueAntYtTableStyle-mvmm00u tr td:nth-child(1) div:first-child{
text-align: center;
text-align-last: center;
padding-top: 0px;
padding-right: 0px;
padding-bottom: 0px;
padding-left: 0px;
}
.webVueAntYtTableStyle-mvmm00u tr td:nth-child(1) div:first-child span.td-text{
color: #000000A6;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
line-height: 50px;
letter-spacing: 0px;
text-decoration: none;
font-style: normal;
}
.webVueAntYtTableStyle-mvmm00u tr > th:nth-child(1), .webVueAntYtTableStyle-mvmm00u .ant-table-body tr.ant-table-measure-row td:nth-child(1){
width: 40px !important;
min-width: 40px !important;
max-width: 40px !important;
}
.webVueAntYtTableStyle-mvmm00u tr td:nth-child(2) div:first-child{
text-align: center;
text-align-last: center;
padding-top: 0px;
padding-right: 0px;
padding-bottom: 0px;
padding-left: 0px;
}
.webVueAntYtTableStyle-mvmm00u tr td:nth-child(2) div:first-child span.td-text{
color: #000000A6;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
line-height: 50px;
letter-spacing: 0px;
text-decoration: none;
font-style: normal;
}
.webVueAntYtTableStyle-mvmm00u tr > th:nth-child(2), .webVueAntYtTableStyle-mvmm00u .ant-table-body tr.ant-table-measure-row td:nth-child(2){
width: calc((100% - 40px) / 3) !important;
min-width: 1px !important;
max-width: 1px !important;
}
.webVueAntYtTableStyle-mvmm00u tr td:nth-child(3) div:first-child{
text-align: center;
text-align-last: center;
padding-top: 0px;
padding-right: 0px;
padding-bottom: 0px;
padding-left: 0px;
}
.webVueAntYtTableStyle-mvmm00u tr td:nth-child(3) div:first-child span.td-text{
color: #000000A6;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
line-height: 50px;
letter-spacing: 0px;
text-decoration: none;
font-style: normal;
}
.webVueAntYtTableStyle-mvmm00u tr > th:nth-child(3), .webVueAntYtTableStyle-mvmm00u .ant-table-body tr.ant-table-measure-row td:nth-child(3){
width: calc((100% - 40px) / 3) !important;
min-width: 1px !important;
max-width: 1px !important;
}
.webVueAntYtTableStyle-mvmm00u tr td:nth-child(4) div:first-child{
text-align: center;
text-align-last: center;
padding-top: 0px;
padding-right: 0px;
padding-bottom: 0px;
padding-left: 0px;
}
.webVueAntYtTableStyle-mvmm00u tr td:nth-child(4) div:first-child span.td-text{
color: #000000A6;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
line-height: 50px;
letter-spacing: 0px;
text-decoration: none;
font-style: normal;
}
.webVueAntYtTableStyle-mvmm00u tr > th:nth-child(4), .webVueAntYtTableStyle-mvmm00u .ant-table-body tr.ant-table-measure-row td:nth-child(4){
width: calc((100% - 40px) / 3) !important;
min-width: 1px !important;
max-width: 1px !important;
}
.webVueAntYtTableStyle-mvmm00u{
width: 100%;
}

.webVueAntYtInputFormItem-mv6cqqo .ant-form-item-explain{
position: absolute;
top: 100%;
z-index: -1;
}
.webVueAntYtInputFormItem-mv6cqqo .ant-form-item-label label{
width: 80px;
padding-right: 10px;
}
.webVueAntYtInputFormItem-mv6cqqo .ant-form-item-label label .label-content{
text-align: right;
text-align-last: right;
}
.webVueAntYtInputStyle-mvyx9po:not(.ant-input-affix-wrapper){
background: #FFFFFF !important;
}

.webVueAntYtDatePickerFormItem-mv{
flex-direction: row;
opacity: 1;
}
.webVueAntYtDatePickerFormItem-mv .ant-form-item-label label{
text-decoration: none;
font-style: normal;
color: #333333;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
padding-top: 0px;
padding-right: 0px;
padding-bottom: 0px;
padding-left: 0px;
}
.webVueAntYtDatePickerFormItem-mv .ant-form-item-label label .label-content{
text-align: left;
text-align-last: left;
}
.webVueAntYtDatePickerStyle-mv{
box-shadow: 0px 0px 0px 0px transparent;
background: #FFFFFF !important;
border-top-left-radius: 4px;
border-top-right-radius: 4px;
border-bottom-left-radius: 4px;
border-bottom-right-radius: 4px;
border-top: 1px solid #CDCDCD;
border-right: 1px solid #CDCDCD;
border-bottom: 1px solid #CDCDCD;
border-left: 1px solid #CDCDCD;
padding-top: 0px;
padding-right: 10px;
padding-bottom: 0px;
padding-left: 12px;
}
.webVueAntYtDatePickerStyle-mv.ant-picker-focused,.webVueAntYtDatePickerStyle-mv.ant-picker:hover{
border-right: 1px solid #CDCDCD !important;
}
.webVueAntYtDatePickerStyle-mv .ant-picker-input>input{
color: #333333;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
letter-spacing: 0px;
text-decoration: none;
font-style: normal;
}
.webVueAntYtDatePickerStyle-mv .ant-picker-input>input::placeholder{
color: #999999;
}
.popupKey-mv.dropdownClassName{
box-shadow: 0px 0px 10px 0px rgba(153,153,153,0.3);
border-top-left-radius: 2px;
border-top-right-radius: 2px;
border-bottom-left-radius: 2px;
border-bottom-right-radius: 2px;
border-top: 1px solid transparent;
border-right: 1px solid transparent;
border-bottom: 1px solid transparent;
border-left: 1px solid transparent;
}
.popupKey-mv.dropdownClassName .ant-picker-panel-container{
background: #ffffff;
}
.popupKey-mv.dropdownClassName .ant-picker-panel-container .ant-picker-header,.popupKey-mv.dropdownClassName .ant-picker-panel-container .ant-picker-panel table tr th,.popupKey-mv.dropdownClassName .ant-picker-panel-container .ant-picker-panel table tr td{
color: #333333;
}
.webVueAntDatePickerFormItem  {
    flex-wrap: nowrap;
}
.webVueAntDatePickerFormItem ,
.webVueAntDatePickerFormItem .ant-form-item-control-input,
.webVueAntDatePickerFormItem .ant-form-item-control-input .ant-form-item-control-input-content {
    width: 100%;
    height: 100%;
}
.webVueAntDatePickerFormItem .ant-form-item-control-input{
    min-height: unset !important;
}
.webVueAntDatePickerFormItem .ant-form-item-label {
    flex-shrink: 0;
    padding: 0;
    text-align: left;
}
.webVueAntDatePickerFormItem .ant-form-item-label label {
    width: 100%;
    height: 100%;
}
.webVueAntDatePickerFormItem .ant-form-item-label>label.ant-form-item-required:not(.ant-form-item-required-mark-optional):before {
  margin-top: 4px;
}
.webVueAntDatePickerFormItem .ant-form-item-label label .label-content{
    flex: 1;
    display: inline-block;
    overflow: hidden;
    text-overflow: ellipsis;
}
.webVueAntDatePickerFormItem .ant-form-item-label>label.ant-form-item-no-colon:after {
    display: none;
}
.webVueAntDatePickerFormItem .ant-form-item-label label .ant-form-item-content {
    white-space: nowrap;
}
.webVueAntDatePickerFormItem.hide-label .ant-form-item-label {
    display: none;
}
.webVueAntDatePickerFormItem .dropdownClassName {
    overflow: hidden;
}
.webVueAntDatePickerFormItem .ant-form-item-content:focus{
    outline: none;
}
.webVueAntYtDatePicker .ant-picker-dropdown {
    text-align-last: auto;
}
.webVueAntYtDatePicker .ant-picker-input>input {
    background: transparent;
}

.webVueAntYtDatePickerFormItem-mvkjazx .ant-form-item-explain{
position: absolute;
top: 100%;
z-index: -1;
}
.webVueAntYtDatePickerFormItem-mvkjazx .ant-form-item-label label{
width: 80px;
padding-right: 10px;
}
.webVueAntYtDatePickerStyle-mvjj33p{
background: #FFFFFF!important;
border-top: 1px solid #CDCDCD !important;
border-right: 1px solid #CDCDCD !important;
border-bottom: 1px solid #CDCDCD !important;
border-left: 1px solid #CDCDCD !important;
}
.webVueAntYtDatePickerStyle-mvjj33p.ant-picker-focused,.webVueAntYtDatePickerStyle-mvjj33p.ant-picker:hover{
border-right: 1px solid #CDCDCD!important;
}

.webVueAntYtRangePickerFormItem-mv{
flex-direction: row;
opacity: 1;
}
.webVueAntYtRangePickerFormItem-mv .ant-form-item-label label{
text-decoration: none;
font-style: normal;
color: #333333;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
padding-top: 4px;
padding-right: 0px;
padding-bottom: 6px;
padding-left: 0px;
}
.webVueAntYtRangePickerFormItem-mv .ant-form-item-label label .label-content{
text-align: left;
text-align-last: left;
}
.webVueAntYtRangePickerStyle-mv{
color: #333333;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
letter-spacing: 0px;
text-decoration: none;
font-style: normal;
box-shadow: 0px 0px 0px 0px transparent;
background: #FFFFFF;
border-top-left-radius: 4px;
border-top-right-radius: 4px;
border-bottom-left-radius: 4px;
border-bottom-right-radius: 4px;
border-top: 1px solid #CDCDCD;
border-right: 1px solid #CDCDCD;
border-bottom: 1px solid #CDCDCD;
border-left: 1px solid #CDCDCD;
padding-top: 0px;
padding-right: 10px;
padding-bottom: 0px;
padding-left: 12px;
}
.webVueAntYtRangePickerStyle-mv.ant-picker:hover{
border-top: 1px solid #CDCDCD;
border-right: 1px solid #CDCDCD;
border-bottom: 1px solid #CDCDCD;
border-left: 1px solid #CDCDCD;
}
.webVueAntYtRangePickerStyle-mv.ant-picker-focused,.webVueAntYtRangePickerStyle-mv.ant-picker:hover{
border-right: 1px solid #CDCDCD !important;
}
.webVueAntYtRangePickerStyle-mv .ant-picker-input>input{
color: #333333;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
letter-spacing: 0px;
text-decoration: none;
font-style: normal;
}
.webVueAntYtRangePickerStyle-mv .ant-picker-input>input::placeholder{
color: #999999;
}
.popupKey-mv.dropdownClassName .ant-picker-panel-container{
background: #ffffff;
box-shadow: 0px 0px 10px 0px rgba(153,153,153,0.3);
border-top-left-radius: 2px;
border-top-right-radius: 2px;
border-bottom-left-radius: 2px;
border-bottom-right-radius: 2px;
border-top: 1px solid transparent;
border-right: 1px solid transparent;
border-bottom: 1px solid transparent;
border-left: 1px solid transparent;
}
.popupKey-mv.dropdownClassName .ant-picker-panel-container .ant-picker-header,.popupKey-mv.dropdownClassName .ant-picker-panel-container .ant-picker-panel table tr th,.popupKey-mv.dropdownClassName .ant-picker-panel-container .ant-picker-panel table tr td{
color: #333333;
}
.webVueAntRangePickerFormItem  {
    flex-wrap: nowrap;
}
.webVueAntYtRangePicker,
.webVueAntRangePickerFormItem,
.webVueAntRangePickerFormItem .ant-form-item-control-input,
.webVueAntRangePickerFormItem .ant-form-item-control-input .ant-form-item-control-input-content {
    width: 100%;
    height: 100%;
}
.webVueAntRangePickerFormItem .ant-form-item-control-input{
    min-height: unset !important;
}
.webVueAntRangePickerFormItem .ant-form-item-label {
    flex-shrink: 0;
    padding: 0;
    text-align: left;
}
.webVueAntRangePickerFormItem .ant-form-item-label label {
    width: 100%;
    height: 100%;
}
.webVueAntRangePickerFormItem .ant-form-item-label>label.ant-form-item-required:not(.ant-form-item-required-mark-optional):before {
  margin-top: 4px;
}
.webVueAntRangePickerFormItem .ant-form-item-label label .label-content{
    flex: 1;
    display: inline-block;
    overflow: hidden;
    text-overflow: ellipsis;
}
.webVueAntRangePickerFormItem .ant-form-item-label>label.ant-form-item-no-colon:after {
    display: none;
}
.webVueAntRangePickerFormItem .ant-form-item-label label .ant-form-item-content {
    white-space: nowrap;
}
.webVueAntRangePickerFormItem.hide-label .ant-form-item-label {
    display: none;
}
.webVueAntRangePickerFormItem .ant-form-item-content:focus{
    outline: none;
}
.webVueAntYtRangePicker .ant-picker-dropdown {
    text-align-last: auto;
}


.webVueAntYtRangePickerFormItem-mvf96yg .ant-form-item-explain{
position: absolute;
top: 100%;
z-index: -1;
}
.webVueAntYtRangePickerFormItem-mvf96yg .ant-form-item-label label{
width: 80px;
padding-top: 0px;
padding-right: 10px;
padding-bottom: 0px;
}
.webVueAntYtRangePickerFormItem-mvf96yg .ant-form-item-label label .label-content{
text-align: right;
text-align-last: right;
}
.webVueAntYtRangePickerStyle-mvgphyx.ant-picker-focused,.webVueAntYtRangePickerStyle-mvgphyx.ant-picker:hover{
border-right: 1px solid #CDCDCD!important;
}

.webVueAntYtSelectFormItem-mvxm3kt .ant-form-item-explain{
position: absolute;
top: 100%;
z-index: -1;
}
.webVueAntYtSelectFormItem-mvxm3kt .ant-form-item-label label{
width: 80px;
padding-right: 10px;
}

.webVueAntYtButtonStyle-mvqb6cc{
color: #1890FF !important;
background: transparent !important;
border-top: 0px solid transparent;
border-right: 0px solid transparent;
border-bottom: 0px solid transparent;
border-left: 0px solid transparent;
align-items: center;
justify-content: center;
}
.webVueAntYtButtonStyle-mvqb6cc>span{
letter-spacing: 0px !important;
}

.webVueAntYtRadioFormItem-mv{
flex-direction: row;
}
.webVueAntYtRadioFormItem-mv .ant-radio-wrapper span{
color: #333333;
font-size: 14px;
font-weight: Normal;
}
.webVueAntYtRadioFormItem-mv .ant-radio-wrapper:not(:last-child){
margin-right: 14px;
}
.webVueAntYtRadioFormItem-mv .ant-radio-inner{
border-color: #CBCBCB;
}
.webVueAntYtRadioFormItem-mv .ant-radio-wrapper-checked span{
color: #333333;
}
.webVueAntYtRadioFormItem-mv .ant-radio-wrapper-checked .ant-radio-inner{
border-color: #3F82F9;
}
.webVueAntYtRadioFormItem-mv .ant-radio-wrapper-checked .ant-radio-inner:after{
background-color: #3F82F9;
}
.webVueAntYtRadioStyle-mv:focus+.ant-radio-inner,.webVueAntYtRadioStyle-mv .ant-radio-wrapper:hover .ant-radio,.webVueAntYtRadioStyle-mv .ant-radio:hover .ant-radio-inner{
border-color: #3F82F9;
}
.webVueAntYtRadioFormItem-mv .ant-form-item-label label{
text-decoration: none;
font-style: normal;
color: #333333;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
padding-top: 0px;
padding-right: 0px;
padding-bottom: 0px;
padding-left: 0px;
}
.webVueAntYtRadioFormItem-mv .ant-form-item-label label .label-content{
text-align: left;
text-align-last: left;
}
.webVueAntRadioFormItem  {
    flex-wrap: nowrap;
}
.webVueAntRadioFormItem ,
.webVueAntRadioFormItem .ant-form-item-control-input,
.webVueAntRadioFormItem .ant-form-item-control-input .ant-form-item-control-input-content {
    width: 100%;
    height: 100%;
}
.webVueAntRadioFormItem .ant-form-item-control-input{
    min-height: unset !important;
}
.webVueAntRadioFormItem .ant-form-item-label {
    flex-shrink: 0;
    padding: 0;
    text-align: left;
}
.webVueAntRadioFormItem .ant-form-item-label label {
    width: 100%;
    height: 100%;
    align-items: flex-start;
}
.webVueAntRadioFormItem .ant-form-item-label>label.ant-form-item-required:not(.ant-form-item-required-mark-optional):before {
  margin-top: 4px;
}
.webVueAntRadioFormItem .ant-form-item-label label .label-content{
    flex: 1;
    height: 100%;
    display: inline-block;
    overflow: hidden;
    text-overflow: ellipsis;
}
.webVueAntRadioFormItem .ant-form-item-label>label.ant-form-item-no-colon:after {
    display: none;
}
.webVueAntRadioFormItem .ant-form-item-label label .ant-form-item-content {
    white-space: nowrap;
}
.webVueAntRadioFormItem.hide-label .ant-form-item-label {
    display: none;
}
.webVueAntRadioFormItem .ant-form-item-content:focus{
    outline: none;
}
.webVueAntRadio {
    width: 100%;
    height: 100%;
}
.webVueAntRadio .ant-radio-wrapper:last-child {
    margin-right: 0;
}

.webVueAntYtRadioStyle-mvictr6{
color: #333333;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
}
.webVueAntYtRadioStyle-mvictr6 .ant-radio-wrapper span{
color: #333333;
font-size: 14px;
font-weight: Normal;
}
.webVueAntYtRadioStyle-mvictr6 .ant-radio-wrapper:not(:last-child){
margin-right: 14px;
}
.webVueAntYtRadioStyle-mvictr6 .ant-radio-inner{
border-color: #CBCBCB;
}
.webVueAntYtRadioStyle-mvictr6 .ant-radio-wrapper-checked span{
color: #333333;
}
.webVueAntYtRadioStyle-mvictr6 .ant-radio-wrapper-checked .ant-radio-inner{
border-color: #3F82F9;
}
.webVueAntYtRadioStyle-mvictr6 .ant-radio-wrapper-checked .ant-radio-inner:after{
background-color: #3F82F9;
}
.webVueAntYtRadioFormItem-mvjnpt1 .ant-form-item-label label{
width: 80px;
padding-right: 10px;
}
.webVueAntYtRadioFormItem-mvjnpt1{
opacity: 1;
}

.webVueAntYtRadioStyle-mvq9qs5{
color: #333333;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
}
.webVueAntYtRadioStyle-mvq9qs5 .ant-radio-wrapper span{
color: #333333;
font-size: 14px;
font-weight: Normal;
}
.webVueAntYtRadioStyle-mvq9qs5 .ant-radio-wrapper:not(:last-child){
margin-right: 14px;
}
.webVueAntYtRadioStyle-mvq9qs5 .ant-radio-inner{
border-color: #CBCBCB;
}
.webVueAntYtRadioStyle-mvq9qs5 .ant-radio-wrapper-checked span{
color: #333333;
}
.webVueAntYtRadioStyle-mvq9qs5 .ant-radio-wrapper-checked .ant-radio-inner{
border-color: #3F82F9;
}
.webVueAntYtRadioStyle-mvq9qs5 .ant-radio-wrapper-checked .ant-radio-inner:after{
background-color: #3F82F9;
}
.webVueAntYtRadioFormItem-mvaytlt .ant-form-item-label label{
width: 80px;
padding-right: 10px;
}
.webVueAntYtRadioFormItem-mvaytlt{
opacity: 1;
}

.webVueAntYtRectangleStyle-mvj4cqv{
background: #1890FF;
border-top: 1px solid transparent;
border-right: 1px solid transparent;
border-bottom: 1px solid transparent;
border-left: 1px solid transparent;
}

.webVueAntYtSpanStyle-mvi8o7j{
color: #3D3D3D !important;
font-weight: bold;
}
.webVueAntYtSpanStyle-mvi8o7j span{
text-decoration: none;
}

.webVueAntYtRadioStyle-mvwuy6q{
color: #333333;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
}
.webVueAntYtRadioStyle-mvwuy6q .ant-radio-wrapper span{
color: #333333;
font-size: 14px;
font-weight: Normal;
}
.webVueAntYtRadioStyle-mvwuy6q .ant-radio-wrapper:not(:last-child){
margin-right: 14px;
}
.webVueAntYtRadioStyle-mvwuy6q .ant-radio-inner{
border-color: #CBCBCB;
}
.webVueAntYtRadioStyle-mvwuy6q .ant-radio-wrapper-checked span{
color: #333333;
}
.webVueAntYtRadioStyle-mvwuy6q .ant-radio-wrapper-checked .ant-radio-inner{
border-color: #3F82F9;
}
.webVueAntYtRadioStyle-mvwuy6q .ant-radio-wrapper-checked .ant-radio-inner:after{
background-color: #3F82F9;
}
.webVueAntYtRadioFormItem-mvogf4h .ant-form-item-label label{
width: 67px;
padding-right: 10px;
}
.webVueAntYtRadioFormItem-mvogf4h{
opacity: 1;
}

.webVueAntYtRadioStyle-mvfeujg{
color: #333333;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
}
.webVueAntYtRadioStyle-mvfeujg .ant-radio-wrapper span{
color: #333333;
font-size: 14px;
font-weight: Normal;
}
.webVueAntYtRadioStyle-mvfeujg .ant-radio-wrapper:not(:last-child){
margin-right: 14px;
}
.webVueAntYtRadioStyle-mvfeujg .ant-radio-inner{
border-color: #CBCBCB;
}
.webVueAntYtRadioStyle-mvfeujg .ant-radio-wrapper-checked span{
color: #333333;
}
.webVueAntYtRadioStyle-mvfeujg .ant-radio-wrapper-checked .ant-radio-inner{
border-color: #3F82F9;
}
.webVueAntYtRadioStyle-mvfeujg .ant-radio-wrapper-checked .ant-radio-inner:after{
background-color: #3F82F9;
}
.webVueAntYtRadioFormItem-mvg80mt .ant-form-item-label label{
width: 67px;
padding-right: 10px;
}
.webVueAntYtRadioFormItem-mvg80mt{
opacity: 1;
}

.webVueAntYtRectangleStyle-mvp1mig{
background: #1890FF;
border-top: 1px solid transparent;
border-right: 1px solid transparent;
border-bottom: 1px solid transparent;
border-left: 1px solid transparent;
}

.webVueAntYtSpanStyle-mvqlj8c{
color: #3D3D3D !important;
font-weight: bold;
}
.webVueAntYtSpanStyle-mvqlj8c span{
text-decoration: none;
}

.webVueAntYtRadioStyle-mvbaqy1{
color: #333333;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
}
.webVueAntYtRadioStyle-mvbaqy1 .ant-radio-wrapper span{
color: #333333;
font-size: 14px;
font-weight: Normal;
}
.webVueAntYtRadioStyle-mvbaqy1 .ant-radio-wrapper:not(:last-child){
margin-right: 14px;
}
.webVueAntYtRadioStyle-mvbaqy1 .ant-radio-inner{
border-color: #CBCBCB;
}
.webVueAntYtRadioStyle-mvbaqy1 .ant-radio-wrapper-checked span{
color: #333333;
}
.webVueAntYtRadioStyle-mvbaqy1 .ant-radio-wrapper-checked .ant-radio-inner{
border-color: #3F82F9;
}
.webVueAntYtRadioStyle-mvbaqy1 .ant-radio-wrapper-checked .ant-radio-inner:after{
background-color: #3F82F9;
}
.webVueAntYtRadioFormItem-mvry68l .ant-form-item-label label{
width: 80px;
padding-right: 10px;
}
.webVueAntYtRadioFormItem-mvry68l{
opacity: 1;
}

.webVueAntYtInputNumberFormItem-mv{
flex-direction: row;
opacity: 1;
}
.webVueAntYtInputNumberFormItem-mv .ant-form-item-label label{
text-decoration: none;
font-style: normal;
color: #333333;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
width: 52px;
padding-top: 0px;
padding-right: 0px;
padding-bottom: 0px;
padding-left: 0px;
}
.webVueAntYtInputNumberFormItem-mv .ant-form-item-label label .label-content{
text-align: left;
text-align-last: left;
}
.webVueAntYtInputNumberStyle-mv{
color: #333333;
font-family: Microsoft YaHei;
font-size: 14px;
background: #FFFFFF;
border-top-left-radius: 4px;
border-top-right-radius: 4px;
border-bottom-left-radius: 4px;
border-bottom-right-radius: 4px;
border-top: 1px solid #CDCDCD;
border-right: 1px solid #CDCDCD;
border-bottom: 1px solid #CDCDCD;
border-left: 1px solid #CDCDCD;
box-shadow: 0px 0px 0px 0px transparent;
}
.webVueAntYtInputNumberStyle-mv input{
font-weight: Normal;
text-decoration: none;
font-style: normal;
text-align: left;
text-align-last: left;
padding-top: 0px;
padding-right: 10px;
padding-bottom: 0px;
padding-left: 12px;
}
.webVueAntYtInputNumberStyle-mv input::placeholder,.webVueAntYtInputNumberStyle-mv input::-webkit-input-placeholder{
color: #999999;
}
.webVueAntInputNumberFormItem  {
  flex-wrap: nowrap;
}
.webVueAntInputNumberFormItem ,
.webVueAntInputNumberFormItem .ant-form-item-control-input,
.webVueAntInputNumberFormItem .ant-form-item-control-input .ant-form-item-control-input-content,
.webVueAntInputNumber,
.webVueAntInputNumber .ant-input-number-input-wrap,
.webVueAntInputNumber .ant-input-number-input-wrap input{
  width: 100%;
  height: 100%;
}
.webVueAntInputNumberFormItem .ant-form-item-control-input{
  min-height: unset !important;
}
.webVueAntInputNumberFormItem .ant-form-item-label {
  flex-shrink: 0;
  padding: 0;
  text-align: left;
}
.webVueAntInputNumberFormItem .ant-form-item-label label {
  width: 100%;
  height: 100%;
}
.webVueAntInputNumberFormItem .ant-form-item-label>label.ant-form-item-required:not(.ant-form-item-required-mark-optional):before {
  margin-top: 4px;
}
.webVueAntInputNumberFormItem .ant-form-item-label label .label-content{
  flex: 1;
  display: inline-block;
  overflow: hidden;
  text-overflow: ellipsis;
}
.webVueAntInputNumberFormItem .ant-form-item-label>label.ant-form-item-no-colon:after {
  display: none;
}
.webVueAntInputNumberFormItem .ant-form-item-label label .ant-form-item-content {
  white-space: nowrap;
}
.webVueAntInputNumberFormItem.hide-label .ant-form-item-label {
  display: none;
}
.webVueAntInputNumberFormItem .ant-form-item-content:focus{
  outline: none;
}

.webVueAntYtInputNumberFormItem-mvxr7a6 .ant-form-item-explain{
position: absolute;
top: 100%;
z-index: -1;
}
.webVueAntYtInputNumberFormItem-mvxr7a6 .ant-form-item-label label{
width: 95px;
padding-right: 10px;
}
.webVueAntYtInputNumberStyle-mvvulay{
background: #FFFFFF !important;
}

.webVueAntYtInputNumberFormItem-mvkbj57 .ant-form-item-explain{
position: absolute;
top: 100%;
z-index: -1;
}
.webVueAntYtInputNumberFormItem-mvkbj57 .ant-form-item-label label{
width: 109px;
padding-right: 10px;
}
.webVueAntYtInputNumberStyle-mvmr09b{
background: #FFFFFF !important;
}

.webVueAntYtRadioStyle-mv6ea0m{
color: #333333;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
}
.webVueAntYtRadioStyle-mv6ea0m .ant-radio-wrapper span{
color: #333333;
font-size: 14px;
font-weight: Normal;
}
.webVueAntYtRadioStyle-mv6ea0m .ant-radio-wrapper:not(:last-child){
margin-right: 14px;
}
.webVueAntYtRadioStyle-mv6ea0m .ant-radio-inner{
border-color: #CBCBCB;
}
.webVueAntYtRadioStyle-mv6ea0m .ant-radio-wrapper-checked span{
color: #333333;
}
.webVueAntYtRadioStyle-mv6ea0m .ant-radio-wrapper-checked .ant-radio-inner{
border-color: #3F82F9;
}
.webVueAntYtRadioStyle-mv6ea0m .ant-radio-wrapper-checked .ant-radio-inner:after{
background-color: #3F82F9;
}
.webVueAntYtRadioFormItem-mvceqc5 .ant-form-item-label label{
width: 119px;
padding-right: 10px;
}
.webVueAntYtRadioFormItem-mvceqc5{
opacity: 1;
}

.webVueAntYtRectangleStyle-mvefkch{
background: #1890FF;
border-top: 1px solid transparent;
border-right: 1px solid transparent;
border-bottom: 1px solid transparent;
border-left: 1px solid transparent;
}

.webVueAntYtSpanStyle-mvv0bdi{
color: #3D3D3D !important;
font-weight: bold;
}
.webVueAntYtSpanStyle-mvv0bdi span{
text-decoration: none;
}

.webVueAntYtRadioStyle-mvd32wz{
color: #333333;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
}
.webVueAntYtRadioStyle-mvd32wz .ant-radio-wrapper span{
color: #333333;
font-size: 14px;
font-weight: Normal;
}
.webVueAntYtRadioStyle-mvd32wz .ant-radio-wrapper:not(:last-child){
margin-right: 14px;
}
.webVueAntYtRadioStyle-mvd32wz .ant-radio-inner{
border-color: #CBCBCB;
}
.webVueAntYtRadioStyle-mvd32wz .ant-radio-wrapper-checked span{
color: #333333;
}
.webVueAntYtRadioStyle-mvd32wz .ant-radio-wrapper-checked .ant-radio-inner{
border-color: #3F82F9;
}
.webVueAntYtRadioStyle-mvd32wz .ant-radio-wrapper-checked .ant-radio-inner:after{
background-color: #3F82F9;
}
.webVueAntYtRadioFormItem-mvqr9c2 .ant-form-item-label label{
width: 80px;
padding-right: 10px;
}
.webVueAntYtRadioFormItem-mvqr9c2{
opacity: 1;
}

.webVueAntYtSpanStyle-mvcvfmk{
color: #3D3D3D !important;
}
.webVueAntYtSpanStyle-mvcvfmk span{
text-decoration: none;
}

.webVueAntYtPictureStyle-mv1vbg6{
opacity: 1;
box-shadow: 0px 0px 0px 0px transparent;
border-top-left-radius: 4px;
border-top-right-radius: 4px;
border-bottom-left-radius: 4px;
border-bottom-right-radius: 4px;
border-top: 1px solid #D9D9D9;
border-right: 1px solid #D9D9D9;
border-bottom: 1px solid #D9D9D9;
border-left: 1px solid #D9D9D9;
}


.webVueAntYtTableStyle-mv1y6vv{
opacity: 1;
}
.webVueAntYtTableStyle-mv1y6vv .ant-table{
box-shadow: 0px 0px 0px 0px transparent;
border-top-left-radius: 4px;
border-top-right-radius: 4px;
border-bottom-left-radius: 4px;
border-bottom-right-radius: 4px;
border-top: 1px solid #D9D9D9;
border-right: 1px solid #D9D9D9;
border-bottom: 1px solid #D9D9D9;
border-left: 1px solid #D9D9D9;
}
.webVueAntYtTableStyle-mv1y6vv .ant-table th:first-child{
border-top-left-radius: 4px !important;
}
.webVueAntYtTableStyle-mv1y6vv .ant-table th:last-child{
border-top-right-radius: 4px !important;
}
.webVueAntYtTableStyle-mv1y6vv .ant-table tr:last-child td:first-child{
border-bottom-left-radius: 4px !important;
}
.webVueAntYtTableStyle-mv1y6vv .ant-table tr:last-child td:last-child{
border-bottom-right-radius: 4px !important;
}
.webVueAntYtTableStyle-mv1y6vv .ant-table .ant-table-thead tr,.webVueAntYtTableStyle-mv1y6vv .ant-table .ant-table-thead tr th div:first-child{
height: 40px;
}
.webVueAntYtTableStyle-mv1y6vv .ant-table .ant-table-thead tr th div.ant-table-selection{
line-height: 40px;
}
.webVueAntYtTableStyle-mv1y6vv .ant-table .ant-table-thead tr th{
background: #F6F6F6;
}
.webVueAntYtTableStyle-mv1y6vv .ant-table .ant-table-thead tr span.th-text{
color: #000000A6;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
line-height: 50px;
letter-spacing: 0px;
font-style: normal;
text-align: center;
text-align-last: center;
text-decoration: none;
padding-top: 0px;
padding-right: 0px;
padding-bottom: 0px;
padding-left: 0px;
}
.webVueAntYtTableStyle-mv1y6vv .ant-table tbody tr td{
height: 40px;
}
.webVueAntYtTableStyle-mv1y6vv .ant-table tbody tr td .ant-checkbox-wrapper{
line-height: 40px;
}
.webVueAntYtTableStyle-mv1y6vv .ant-table tbody tr td{
background: #FFFFFF;
}
.webVueAntYtTableStyle-mv1y6vv .ant-table thead tr th,.webVueAntYtTableStyle-mv1y6vv .ant-table .ant-table-tbody tr:not(:last-child) td{
border-bottom: 1px solid #dcdcdc;
}
.webVueAntYtTableStyle-mv1y6vv .ant-table thead tr th:not(:last-child),.webVueAntYtTableStyle-mv1y6vv .ant-table .ant-table-tbody tr td:not(:last-child){
border-right: 1px solid #dcdcdc;
}
.webVueAntYtTableStyle-mv1y6vv.ant-table-striped .ant-table tbody tr:nth-child(2n-1) td{
background: #FFFFFF;
}
.webVueAntYtTableStyle-mv1y6vv.ant-table-striped .ant-table tbody tr:nth-child(2n) td{
background: #FFFFFF;
}
.webVueAntYtTableStyle-mv1y6vv .ant-table tbody tr:not(.ant-table-row-selected):hover td{
background: #E4EFFF !important;
}
.webVueAntYtTableStyle-mv1y6vv .ant-table tbody tr:not(.ant-table-row-selected):hover td span.td-text{
color: #000000 !important;
}
.webVueAntYtTableStyle-mv1y6vv .ant-table-tbody tr.ant-table-row-selected td{
background: #3C8EFF !important;
}
.webVueAntYtTableStyle-mv1y6vv .ant-table-tbody tr.ant-table-row-selected td span.td-text{
color: #FFFFFF !important;
}
.webVueAntYtTableStyle-mv1y6vv .ant-pagination li:not(.ant-pagination-options),.webVueAntYtTableStyle-mv1y6vv .ant-pagination button,.webVueAntYtTableStyle-mv1y6vv .ant-pagination li .ant-select .ant-select-selector,.webVueAntYtTableStyle-mv1y6vv .ant-pagination li input{
border-top-left-radius: 4px;
border-top-right-radius: 4px;
border-bottom-left-radius: 4px;
border-bottom-right-radius: 4px;
background: #FFFFFF;
color: #000000A6;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
line-height: 32px;
letter-spacing: 0px;
text-align: center;
text-align-last: center;
font-style: normal;
text-decoration: none;
}
.webVueAntYtTableStyle-mv1y6vv .ant-pagination button,.webVueAntYtTableStyle-mv1y6vv .ant-pagination li .ant-select .ant-select-selector,.webVueAntYtTableStyle-mv1y6vv .ant-pagination li input,.webVueAntYtTableStyle-mv1y6vv .ant-pagination li a,.webVueAntYtTableStyle-mv1y6vv .ant-pagination li .ant-pagination-options-quick-jumper{
padding-top: 0px;
padding-right: 0px;
padding-bottom: 0px;
padding-left: 0px;
}
.webVueAntYtTableStyle-mv1y6vv .ant-pagination li:not(.ant-pagination-options),.webVueAntYtTableStyle-mv1y6vv .ant-pagination li.ant-pagination-options .ant-pagination-options-size-changer.ant-select .ant-select-selector,.webVueAntYtTableStyle-mv1y6vv .ant-pagination li.ant-pagination-options .ant-pagination-options-quick-jumper input{
border-top: 1px solid #D9D9D9;
border-right: 1px solid #D9D9D9;
border-bottom: 1px solid #D9D9D9;
border-left: 1px solid #D9D9D9;
}
.webVueAntYtTableStyle-mv1y6vv .ant-pagination li button{
border: none;
}
.webVueAntYtTableStyle-mv1y6vv .ant-pagination li a,.webVueAntYtTableStyle-mv1y6vv .ant-pagination li .ant-pagination-options-quick-jumper{
color: #000000A6;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
line-height: 32px;
letter-spacing: 0px;
text-align: center;
text-align-last: center;
font-style: normal;
text-decoration: none;
}
.webVueAntYtTableStyle-mv1y6vv .ant-pagination li.ant-pagination-item-active{
background: #FFFFFF;
border-top: 1px solid #1890ff;
border-right: 1px solid #1890ff;
border-bottom: 1px solid #1890ff;
border-left: 1px solid #1890ff;
}
.webVueAntYtTableStyle-mv1y6vv .ant-pagination li.ant-pagination-item-active a{
color: #1890ff;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
line-height: 32px;
letter-spacing: 0px;
text-align: center;
text-align-last: center;
font-style: normal;
text-decoration: none;
}
.webVueAntYtTableStyle-mv1y6vv tr td:nth-child(1) div:first-child{
text-align: center;
text-align-last: center;
padding-top: 0px;
padding-right: 0px;
padding-bottom: 0px;
padding-left: 0px;
}
.webVueAntYtTableStyle-mv1y6vv tr td:nth-child(1) div:first-child span.td-text{
color: #000000A6;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
line-height: 50px;
letter-spacing: 0px;
text-decoration: none;
font-style: normal;
}
.webVueAntYtTableStyle-mv1y6vv tr > th:nth-child(1), .webVueAntYtTableStyle-mv1y6vv .ant-table-body tr.ant-table-measure-row td:nth-child(1){
width: 40px !important;
min-width: 40px !important;
max-width: 40px !important;
}
.webVueAntYtTableStyle-mv1y6vv tr td:nth-child(2) div:first-child{
text-align: center;
text-align-last: center;
padding-top: 0px;
padding-right: 0px;
padding-bottom: 0px;
padding-left: 0px;
}
.webVueAntYtTableStyle-mv1y6vv tr td:nth-child(2) div:first-child span.td-text{
color: #000000A6;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
line-height: 50px;
letter-spacing: 0px;
text-decoration: none;
font-style: normal;
}
.webVueAntYtTableStyle-mv1y6vv tr > th:nth-child(2), .webVueAntYtTableStyle-mv1y6vv .ant-table-body tr.ant-table-measure-row td:nth-child(2){
width: calc((100% - 40px) / 5) !important;
min-width: 1px !important;
max-width: 1px !important;
}
.webVueAntYtTableStyle-mv1y6vv tr td:nth-child(3) div:first-child{
text-align: center;
text-align-last: center;
padding-top: 0px;
padding-right: 0px;
padding-bottom: 0px;
padding-left: 0px;
}
.webVueAntYtTableStyle-mv1y6vv tr td:nth-child(3) div:first-child span.td-text{
color: #000000A6;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
line-height: 50px;
letter-spacing: 0px;
text-decoration: none;
font-style: normal;
}
.webVueAntYtTableStyle-mv1y6vv tr > th:nth-child(3), .webVueAntYtTableStyle-mv1y6vv .ant-table-body tr.ant-table-measure-row td:nth-child(3){
width: calc((100% - 40px) / 5) !important;
min-width: 1px !important;
max-width: 1px !important;
}
.webVueAntYtTableStyle-mv1y6vv tr td:nth-child(4) div:first-child{
text-align: center;
text-align-last: center;
padding-top: 0px;
padding-right: 0px;
padding-bottom: 0px;
padding-left: 0px;
}
.webVueAntYtTableStyle-mv1y6vv tr td:nth-child(4) div:first-child span.td-text{
color: #000000A6;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
line-height: 50px;
letter-spacing: 0px;
text-decoration: none;
font-style: normal;
}
.webVueAntYtTableStyle-mv1y6vv tr > th:nth-child(4), .webVueAntYtTableStyle-mv1y6vv .ant-table-body tr.ant-table-measure-row td:nth-child(4){
width: calc((100% - 40px) / 5) !important;
min-width: 1px !important;
max-width: 1px !important;
}
.webVueAntYtTableStyle-mv1y6vv tr td:nth-child(5) div:first-child{
text-align: center;
text-align-last: center;
padding-top: 0px;
padding-right: 0px;
padding-bottom: 0px;
padding-left: 0px;
}
.webVueAntYtTableStyle-mv1y6vv tr td:nth-child(5) div:first-child span.td-text{
color: #000000A6;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
line-height: 50px;
letter-spacing: 0px;
text-decoration: none;
font-style: normal;
}
.webVueAntYtTableStyle-mv1y6vv tr > th:nth-child(5), .webVueAntYtTableStyle-mv1y6vv .ant-table-body tr.ant-table-measure-row td:nth-child(5){
width: calc((100% - 40px) / 5) !important;
min-width: 1px !important;
max-width: 1px !important;
}
.webVueAntYtTableStyle-mv1y6vv tr td:nth-child(6) div:first-child{
text-align: center;
text-align-last: center;
padding-top: 0px;
padding-right: 0px;
padding-bottom: 0px;
padding-left: 0px;
}
.webVueAntYtTableStyle-mv1y6vv tr td:nth-child(6) div:first-child span.td-text{
color: #000000A6;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
line-height: 50px;
letter-spacing: 0px;
text-decoration: none;
font-style: normal;
}
.webVueAntYtTableStyle-mv1y6vv tr > th:nth-child(6), .webVueAntYtTableStyle-mv1y6vv .ant-table-body tr.ant-table-measure-row td:nth-child(6){
width: calc((100% - 40px) / 5) !important;
min-width: 1px !important;
max-width: 1px !important;
}
.webVueAntYtTableStyle-mv1y6vv{
width: 100%;
}

.webVueAntYtRectangleStyle-mvfgaem{
background: #1890FF;
border-top: 1px solid transparent;
border-right: 1px solid transparent;
border-bottom: 1px solid transparent;
border-left: 1px solid transparent;
}

.webVueAntYtSpanStyle-mvzk4vq{
color: #3D3D3D !important;
font-weight: bold;
}
.webVueAntYtSpanStyle-mvzk4vq span{
text-decoration: none;
}


.webVueAntYtTableStyle-mvb40wp{
opacity: 1;
}
.webVueAntYtTableStyle-mvb40wp .ant-table{
box-shadow: 0px 0px 0px 0px transparent;
border-top-left-radius: 4px;
border-top-right-radius: 4px;
border-bottom-left-radius: 4px;
border-bottom-right-radius: 4px;
border-top: 1px solid #D9D9D9;
border-right: 1px solid #D9D9D9;
border-bottom: 1px solid #D9D9D9;
border-left: 1px solid #D9D9D9;
}
.webVueAntYtTableStyle-mvb40wp .ant-table th:first-child{
border-top-left-radius: 4px !important;
}
.webVueAntYtTableStyle-mvb40wp .ant-table th:last-child{
border-top-right-radius: 4px !important;
}
.webVueAntYtTableStyle-mvb40wp .ant-table tr:last-child td:first-child{
border-bottom-left-radius: 4px !important;
}
.webVueAntYtTableStyle-mvb40wp .ant-table tr:last-child td:last-child{
border-bottom-right-radius: 4px !important;
}
.webVueAntYtTableStyle-mvb40wp .ant-table .ant-table-thead tr,.webVueAntYtTableStyle-mvb40wp .ant-table .ant-table-thead tr th div:first-child{
height: 40px;
}
.webVueAntYtTableStyle-mvb40wp .ant-table .ant-table-thead tr th div.ant-table-selection{
line-height: 40px;
}
.webVueAntYtTableStyle-mvb40wp .ant-table .ant-table-thead tr th{
background: #F6F6F6;
}
.webVueAntYtTableStyle-mvb40wp .ant-table .ant-table-thead tr span.th-text{
color: #000000A6;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
line-height: 50px;
letter-spacing: 0px;
font-style: normal;
text-align: center;
text-align-last: center;
text-decoration: none;
padding-top: 0px;
padding-right: 0px;
padding-bottom: 0px;
padding-left: 0px;
}
.webVueAntYtTableStyle-mvb40wp .ant-table tbody tr td{
height: 40px;
}
.webVueAntYtTableStyle-mvb40wp .ant-table tbody tr td .ant-checkbox-wrapper{
line-height: 40px;
}
.webVueAntYtTableStyle-mvb40wp .ant-table tbody tr td{
background: #FFFFFF;
}
.webVueAntYtTableStyle-mvb40wp .ant-table thead tr th,.webVueAntYtTableStyle-mvb40wp .ant-table .ant-table-tbody tr:not(:last-child) td{
border-bottom: 1px solid #dcdcdc;
}
.webVueAntYtTableStyle-mvb40wp .ant-table thead tr th:not(:last-child),.webVueAntYtTableStyle-mvb40wp .ant-table .ant-table-tbody tr td:not(:last-child){
border-right: 1px solid #dcdcdc;
}
.webVueAntYtTableStyle-mvb40wp.ant-table-striped .ant-table tbody tr:nth-child(2n-1) td{
background: #FFFFFF;
}
.webVueAntYtTableStyle-mvb40wp.ant-table-striped .ant-table tbody tr:nth-child(2n) td{
background: #FFFFFF;
}
.webVueAntYtTableStyle-mvb40wp .ant-table tbody tr:not(.ant-table-row-selected):hover td{
background: #E4EFFF !important;
}
.webVueAntYtTableStyle-mvb40wp .ant-table tbody tr:not(.ant-table-row-selected):hover td span.td-text{
color: #000000 !important;
}
.webVueAntYtTableStyle-mvb40wp .ant-table-tbody tr.ant-table-row-selected td{
background: #3C8EFF !important;
}
.webVueAntYtTableStyle-mvb40wp .ant-table-tbody tr.ant-table-row-selected td span.td-text{
color: #FFFFFF !important;
}
.webVueAntYtTableStyle-mvb40wp .ant-pagination li:not(.ant-pagination-options),.webVueAntYtTableStyle-mvb40wp .ant-pagination button,.webVueAntYtTableStyle-mvb40wp .ant-pagination li .ant-select .ant-select-selector,.webVueAntYtTableStyle-mvb40wp .ant-pagination li input{
border-top-left-radius: 4px;
border-top-right-radius: 4px;
border-bottom-left-radius: 4px;
border-bottom-right-radius: 4px;
background: #FFFFFF;
color: #000000A6;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
line-height: 32px;
letter-spacing: 0px;
text-align: center;
text-align-last: center;
font-style: normal;
text-decoration: none;
}
.webVueAntYtTableStyle-mvb40wp .ant-pagination button,.webVueAntYtTableStyle-mvb40wp .ant-pagination li .ant-select .ant-select-selector,.webVueAntYtTableStyle-mvb40wp .ant-pagination li input,.webVueAntYtTableStyle-mvb40wp .ant-pagination li a,.webVueAntYtTableStyle-mvb40wp .ant-pagination li .ant-pagination-options-quick-jumper{
padding-top: 0px;
padding-right: 0px;
padding-bottom: 0px;
padding-left: 0px;
}
.webVueAntYtTableStyle-mvb40wp .ant-pagination li:not(.ant-pagination-options),.webVueAntYtTableStyle-mvb40wp .ant-pagination li.ant-pagination-options .ant-pagination-options-size-changer.ant-select .ant-select-selector,.webVueAntYtTableStyle-mvb40wp .ant-pagination li.ant-pagination-options .ant-pagination-options-quick-jumper input{
border-top: 1px solid #D9D9D9;
border-right: 1px solid #D9D9D9;
border-bottom: 1px solid #D9D9D9;
border-left: 1px solid #D9D9D9;
}
.webVueAntYtTableStyle-mvb40wp .ant-pagination li button{
border: none;
}
.webVueAntYtTableStyle-mvb40wp .ant-pagination li a,.webVueAntYtTableStyle-mvb40wp .ant-pagination li .ant-pagination-options-quick-jumper{
color: #000000A6;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
line-height: 32px;
letter-spacing: 0px;
text-align: center;
text-align-last: center;
font-style: normal;
text-decoration: none;
}
.webVueAntYtTableStyle-mvb40wp .ant-pagination li.ant-pagination-item-active{
background: #FFFFFF;
border-top: 1px solid #1890ff;
border-right: 1px solid #1890ff;
border-bottom: 1px solid #1890ff;
border-left: 1px solid #1890ff;
}
.webVueAntYtTableStyle-mvb40wp .ant-pagination li.ant-pagination-item-active a{
color: #1890ff;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
line-height: 32px;
letter-spacing: 0px;
text-align: center;
text-align-last: center;
font-style: normal;
text-decoration: none;
}
.webVueAntYtTableStyle-mvb40wp tr td:nth-child(1) div:first-child{
text-align: center;
text-align-last: center;
padding-top: 0px;
padding-right: 0px;
padding-bottom: 0px;
padding-left: 0px;
}
.webVueAntYtTableStyle-mvb40wp tr td:nth-child(1) div:first-child span.td-text{
color: #000000A6;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
line-height: 50px;
letter-spacing: 0px;
text-decoration: none;
font-style: normal;
}
.webVueAntYtTableStyle-mvb40wp tr > th:nth-child(1), .webVueAntYtTableStyle-mvb40wp .ant-table-body tr.ant-table-measure-row td:nth-child(1){
width: 40px !important;
min-width: 40px !important;
max-width: 40px !important;
}
.webVueAntYtTableStyle-mvb40wp tr td:nth-child(2) div:first-child{
text-align: center;
text-align-last: center;
padding-top: 0px;
padding-right: 0px;
padding-bottom: 0px;
padding-left: 0px;
}
.webVueAntYtTableStyle-mvb40wp tr td:nth-child(2) div:first-child span.td-text{
color: #000000A6;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
line-height: 50px;
letter-spacing: 0px;
text-decoration: none;
font-style: normal;
}
.webVueAntYtTableStyle-mvb40wp tr > th:nth-child(2), .webVueAntYtTableStyle-mvb40wp .ant-table-body tr.ant-table-measure-row td:nth-child(2){
width: calc((100% - 40px) / 6) !important;
min-width: 1px !important;
max-width: 1px !important;
}
.webVueAntYtTableStyle-mvb40wp tr td:nth-child(3) div:first-child{
text-align: center;
text-align-last: center;
padding-top: 0px;
padding-right: 0px;
padding-bottom: 0px;
padding-left: 0px;
}
.webVueAntYtTableStyle-mvb40wp tr td:nth-child(3) div:first-child span.td-text{
color: #000000A6;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
line-height: 50px;
letter-spacing: 0px;
text-decoration: none;
font-style: normal;
}
.webVueAntYtTableStyle-mvb40wp tr > th:nth-child(3), .webVueAntYtTableStyle-mvb40wp .ant-table-body tr.ant-table-measure-row td:nth-child(3){
width: calc((100% - 40px) / 6) !important;
min-width: 1px !important;
max-width: 1px !important;
}
.webVueAntYtTableStyle-mvb40wp tr td:nth-child(4) div:first-child{
text-align: center;
text-align-last: center;
padding-top: 0px;
padding-right: 0px;
padding-bottom: 0px;
padding-left: 0px;
}
.webVueAntYtTableStyle-mvb40wp tr td:nth-child(4) div:first-child span.td-text{
color: #000000A6;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
line-height: 50px;
letter-spacing: 0px;
text-decoration: none;
font-style: normal;
}
.webVueAntYtTableStyle-mvb40wp tr > th:nth-child(4), .webVueAntYtTableStyle-mvb40wp .ant-table-body tr.ant-table-measure-row td:nth-child(4){
width: calc((100% - 40px) / 6) !important;
min-width: 1px !important;
max-width: 1px !important;
}
.webVueAntYtTableStyle-mvb40wp tr td:nth-child(5) div:first-child{
text-align: center;
text-align-last: center;
padding-top: 0px;
padding-right: 0px;
padding-bottom: 0px;
padding-left: 0px;
}
.webVueAntYtTableStyle-mvb40wp tr td:nth-child(5) div:first-child span.td-text{
color: #000000A6;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
line-height: 50px;
letter-spacing: 0px;
text-decoration: none;
font-style: normal;
}
.webVueAntYtTableStyle-mvb40wp tr > th:nth-child(5), .webVueAntYtTableStyle-mvb40wp .ant-table-body tr.ant-table-measure-row td:nth-child(5){
width: calc((100% - 40px) / 6) !important;
min-width: 1px !important;
max-width: 1px !important;
}
.webVueAntYtTableStyle-mvb40wp tr td:nth-child(6) div:first-child{
text-align: center;
text-align-last: center;
padding-top: 0px;
padding-right: 0px;
padding-bottom: 0px;
padding-left: 0px;
}
.webVueAntYtTableStyle-mvb40wp tr td:nth-child(6) div:first-child span.td-text{
color: #000000A6;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
line-height: 50px;
letter-spacing: 0px;
text-decoration: none;
font-style: normal;
}
.webVueAntYtTableStyle-mvb40wp tr > th:nth-child(6), .webVueAntYtTableStyle-mvb40wp .ant-table-body tr.ant-table-measure-row td:nth-child(6){
width: calc((100% - 40px) / 6) !important;
min-width: 1px !important;
max-width: 1px !important;
}
.webVueAntYtTableStyle-mvb40wp tr td:nth-child(7) div:first-child{
text-align: center;
text-align-last: center;
padding-top: 0px;
padding-right: 0px;
padding-bottom: 0px;
padding-left: 0px;
}
.webVueAntYtTableStyle-mvb40wp tr td:nth-child(7) div:first-child span.td-text{
color: #000000A6;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
line-height: 50px;
letter-spacing: 0px;
text-decoration: none;
font-style: normal;
}
.webVueAntYtTableStyle-mvb40wp tr > th:nth-child(7), .webVueAntYtTableStyle-mvb40wp .ant-table-body tr.ant-table-measure-row td:nth-child(7){
width: calc((100% - 40px) / 6) !important;
min-width: 1px !important;
max-width: 1px !important;
}
.webVueAntYtTableStyle-mvb40wp{
width: 100%;
}

.webVueAntYtRectangleStyle-mvg6v14{
background: #1890FF;
border-top: 1px solid transparent;
border-right: 1px solid transparent;
border-bottom: 1px solid transparent;
border-left: 1px solid transparent;
}

.webVueAntYtSpanStyle-mvtdbow{
color: #3D3D3D !important;
font-weight: bold;
}
.webVueAntYtSpanStyle-mvtdbow span{
text-decoration: none;
}

.webVueAntYtModalStyle-mvyoel3 .ant-modal-wrap .yt-custom-modal-header{
font-size: 16px;
font-weight: bold;
}

.webVueAntYtVerticleMenuStyle-mv84nse.ant-menu{
box-shadow: 0px 0px 0px 0px transparent!important;
}
.webVueAntYtVerticleMenuStyle-mv84nse.ant-menu-inline div>li.ant-menu-item,.webVueAntYtVerticleMenuStyle-mv84nse.ant-menu-inline div>li>.ant-menu-submenu-title,.webVueAntYtVerticleMenuStyle-mv84nse.ant-menu-inline div>li.ant-menu-item.ant-menu-item-only-child{
height: 32px;
padding-top: 0px;
padding-right: 0px;
padding-bottom: 0px;
padding-left: 20px !important;
}
.webVueAntYtVerticleMenuStyle-mv84nse div>li.ant-menu-item,.webVueAntYtVerticleMenuStyle-mv84nse div>li>.ant-menu-submenu-title,.webVueAntYtVerticleMenuStyle-mv84nse div>li.ant-menu-item.ant-menu-item-only-child{
height: 32px;
text-decoration: none;
padding-top: 0px;
padding-right: 0px;
padding-bottom: 0px;
padding-left: 20px !important;
}
.webVueAntYtVerticleMenuStyle-mv84nse.ant-menu-inline .ant-menu-submenu-inline .ant-menu-inline li.ant-menu-item,.webVueAntYtVerticleMenuStyle-mv84nse.ant-menu-inline .ant-menu-submenu-inline .ant-menu-inline li.ant-menu-item-only-child,.webVueAntYtVerticleMenuStyle-mv84nse.ant-menu-inline .ant-menu-submenu-inline .ant-menu-inline li>.ant-menu-submenu-title,.webVueAntYtVerticleMenuStyle-mv84nse.ant-menu-vertical .ant-menu-submenu-popup .ant-menu-vertical li.ant-menu-item,.webVueAntYtVerticleMenuStyle-mv84nse.ant-menu-vertical .ant-menu-submenu-popup .ant-menu-vertical li.ant-menu-item-only-child,.webVueAntYtVerticleMenuStyle-mv84nse.ant-menu-vertical .ant-menu-submenu-popup .ant-menu-vertical li>.ant-menu-submenu-title{
height: 32px;
padding-top: 0px;
padding-right: 0px;
padding-bottom: 0px;
padding-left: 20px !important;
}
.webVueAntYtVerticleMenuStyle-mv84nse .ant-menu-submenu:not(.ant-menu-item-selected):hover>.ant-menu-submenu-title>.ant-menu-submenu-arrow,.webVueAntYtVerticleMenuStyle-mv84nse .ant-menu-submenu:not(.ant-menu-item-selected):hover>.ant-menu-submenu-title>.ant-menu-submenu-expand-icon,.webVueAntYtVerticleMenuStyle-mv84nse.ant-menu-light .ant-menu-item:not(.ant-menu-item-selected):hover,.webVueAntYtVerticleMenuStyle-mv84nse.ant-menu-light .ant-menu-submenu-title:not(.ant-menu-item-selected):not(.ant-menu-submenu-selected):hover{
background: #ffffff!important;
}



.webVueAntYtInputFormItem-mv2ma06 .ant-form-item-explain{
position: absolute;
top: 100%;
z-index: -1;
}
.webVueAntYtInputFormItem-mv2ma06 .ant-form-item-label label{
width: 80px;
padding-right: 10px;
}
.webVueAntYtInputStyle-mvnplft:not(.ant-input-affix-wrapper){
background: #FFFFFF !important;
}

.webVueAntYtInputFormItem-mvsy9gz .ant-form-item-explain{
position: absolute;
top: 100%;
z-index: -1;
}
.webVueAntYtInputFormItem-mvsy9gz .ant-form-item-label label{
width: 95px;
padding-right: 10px;
}
.webVueAntYtInputFormItem-mvsy9gz .ant-form-item-label label .label-content{
text-align: right;
text-align-last: right;
}
.webVueAntYtInputStyle-mvoe0lk:not(.ant-input-affix-wrapper){
background: #FFFFFF !important;
}

.webVueAntYtInputFormItem-mv0r9yr .ant-form-item-explain{
position: absolute;
top: 100%;
z-index: -1;
}
.webVueAntYtInputFormItem-mv0r9yr .ant-form-item-label label{
width: 80px;
padding-right: 10px;
}
.webVueAntYtInputFormItem-mv0r9yr .ant-form-item-label label .label-content{
text-align: right;
text-align-last: right;
}
.webVueAntYtInputStyle-mvb6mmw:not(.ant-input-affix-wrapper){
background: #FFFFFF !important;
}

.webVueAntYtInputFormItem-mvy550t .ant-form-item-explain{
position: absolute;
top: 100%;
z-index: -1;
}
.webVueAntYtInputFormItem-mvy550t .ant-form-item-label label{
width: 92px;
padding-right: 10px;
}
.webVueAntYtInputStyle-mv6rhd7:not(.ant-input-affix-wrapper){
background: #FFFFFF !important;
}

.webVueAntYtInputFormItem-mvxowcy .ant-form-item-explain{
position: absolute;
top: 100%;
z-index: -1;
}
.webVueAntYtInputFormItem-mvxowcy .ant-form-item-label label{
width: 80px;
padding-right: 10px;
}
.webVueAntYtInputStyle-mv2ztuz:not(.ant-input-affix-wrapper){
background: #F6F6F6 !important;
// background: #FFFFFF !important;
}

.webVueAntYtInputFormItem-mv2zvj2 .ant-form-item-explain{
position: absolute;
top: 100%;
z-index: -1;
}
.webVueAntYtInputFormItem-mv2zvj2 .ant-form-item-label label{
width: 80px;
padding-right: 10px;
}
.webVueAntYtInputStyle-mv35dpq:not(.ant-input-affix-wrapper){
background: #F6F6F6 !important;
// background: #FFFFFF !important;
}

.webVueAntYtInputFormItem-mvtyrtn .ant-form-item-explain{
position: absolute;
top: 100%;
z-index: -1;
}
.webVueAntYtInputFormItem-mvtyrtn .ant-form-item-label label{
width: 80px;
padding-right: 10px;
}
.webVueAntYtInputStyle-mvy1l3b:not(.ant-input-affix-wrapper){
background: #FFFFFF !important;
}

.webVueAntYtInputFormItem-mvfpgv0 .ant-form-item-explain{
position: absolute;
top: 100%;
z-index: -1;
}
.webVueAntYtInputFormItem-mvfpgv0 .ant-form-item-label label{
width: 80px;
padding-right: 10px;
}
.webVueAntYtInputStyle-mvdheq3:not(.ant-input-affix-wrapper){
background: #FFFFFF !important;
}

.webVueAntYtRectangleStyle-mvlkd8d{
background: #1890FF;
border-top: 1px solid transparent;
border-right: 1px solid transparent;
border-bottom: 1px solid transparent;
border-left: 1px solid transparent;
}

.webVueAntYtSpanStyle-mv1sma7{
color: #3D3D3D !important;
font-weight: bold;
}
.webVueAntYtSpanStyle-mv1sma7 span{
text-decoration: none;
}

.webVueAntYtRectangleStyle-mvugyfw{
background: #1890FF;
border-top: 1px solid transparent;
border-right: 1px solid transparent;
border-bottom: 1px solid transparent;
border-left: 1px solid transparent;
}

.webVueAntYtSpanStyle-mv19svx{
color: #3D3D3D !important;
font-weight: bold;
}
.webVueAntYtSpanStyle-mv19svx span{
text-decoration: none;
}

.webVueAntYtRectangleStyle-mvc20ji{
background: #1890FF;
border-top: 1px solid transparent;
border-right: 1px solid transparent;
border-bottom: 1px solid transparent;
border-left: 1px solid transparent;
}

.webVueAntYtSpanStyle-mv7ha9p{
color: #3D3D3D !important;
font-weight: bold;
}
.webVueAntYtSpanStyle-mv7ha9p span{
text-decoration: none;
}

.webVueAntYtInputFormItem-mvn07uz .ant-form-item-explain{
position: absolute;
top: 100%;
z-index: -1;
}
.webVueAntYtInputFormItem-mvn07uz .ant-form-item-label label{
width: 91px;
padding-right: 10px;
}
.webVueAntYtInputStyle-mvm38hf:not(.ant-input-affix-wrapper){
background: #FFFFFF !important;
}

.webVueAntYtInputFormItem-mv73r7u .ant-form-item-explain{
position: absolute;
top: 100%;
z-index: -1;
}
.webVueAntYtInputFormItem-mv73r7u .ant-form-item-label label{
width: 78px;
padding-right: 10px;
}
.webVueAntYtInputFormItem-mv73r7u .ant-form-item-label label .label-content{
text-align: right;
text-align-last: right;
}
.webVueAntYtInputStyle-mvlp3dl:not(.ant-input-affix-wrapper){
background: #FFFFFF !important;
}

.webVueAntYtInputFormItem-mv54hos .ant-form-item-explain{
position: absolute;
top: 100%;
z-index: -1;
}
.webVueAntYtInputFormItem-mv54hos .ant-form-item-label label{
width: 92px;
padding-right: 10px;
}
.webVueAntYtInputStyle-mvgr7qh:not(.ant-input-affix-wrapper){
background: #FFFFFF !important;
}

.webVueAntYtInputFormItem-mvwvesy .ant-form-item-explain{
position: absolute;
top: 100%;
z-index: -1;
}
.webVueAntYtInputFormItem-mvwvesy .ant-form-item-label label{
width: 82px;
padding-right: 10px;
}
.webVueAntYtInputFormItem-mvwvesy .ant-form-item-label label .label-content{
text-align: right;
text-align-last: right;
}
.webVueAntYtInputStyle-mveug0w:not(.ant-input-affix-wrapper){
background: #FFFFFF !important;
}

.webVueAntYtInputFormItem-mvgsdjk .ant-form-item-explain{
position: absolute;
top: 100%;
z-index: -1;
}
.webVueAntYtInputFormItem-mvgsdjk .ant-form-item-label label{
width: 83px;
padding-right: 10px;
}
.webVueAntYtInputFormItem-mvgsdjk .ant-form-item-label label .label-content{
text-align: right;
text-align-last: right;
}
.webVueAntYtInputStyle-mvk1588:not(.ant-input-affix-wrapper){
background: #FFFFFF !important;
}

.webVueAntYtInputFormItem-mvqj8p5 .ant-form-item-explain{
position: absolute;
top: 100%;
z-index: -1;
}
.webVueAntYtInputFormItem-mvqj8p5 .ant-form-item-label label{
width: 82px;
padding-right: 10px;
}
.webVueAntYtInputFormItem-mvqj8p5 .ant-form-item-label label .label-content{
text-align: right;
text-align-last: right;
}
.webVueAntYtInputStyle-mv2mayo:not(.ant-input-affix-wrapper){
background: #FFFFFF !important;
}

.webVueAntYtRectangleStyle-mvbfozs{
background: #1890FF;
border-top: 1px solid transparent;
border-right: 1px solid transparent;
border-bottom: 1px solid transparent;
border-left: 1px solid transparent;
}

.webVueAntYtSpanStyle-mvhvqpm{
color: #3D3D3D !important;
font-weight: bold;
}
.webVueAntYtSpanStyle-mvhvqpm span{
text-decoration: none;
}

.webVueAntYtSpanStyle-mv6j4vi{
color: #3D3D3D !important;
}
.webVueAntYtSpanStyle-mv6j4vi span{
text-decoration: none;
}

.webVueAntYtSelectFormItem-mvg60cy .ant-form-item-explain{
position: absolute;
top: 100%;
z-index: -1;
}
.webVueAntYtSelectFormItem-mvg60cy .ant-form-item-label label{
width: 91px;
padding-right: 10px;
}

.webVueAntYtSelectFormItem-mv0apnx .ant-form-item-explain{
position: absolute;
top: 100%;
z-index: -1;
}
.webVueAntYtSelectFormItem-mv0apnx .ant-form-item-label label{
width: 91px;
padding-right: 10px;
}

.webVueAntYtSelectFormItem-mvgrijz .ant-form-item-explain{
position: absolute;
top: 100%;
z-index: -1;
}
.webVueAntYtSelectFormItem-mvgrijz .ant-form-item-label label{
width: 80px;
padding-right: 10px;
}

.webVueAntYtSelectFormItem-mv0at2w .ant-form-item-explain{
position: absolute;
top: 100%;
z-index: -1;
}
.webVueAntYtSelectFormItem-mv0at2w .ant-form-item-label label{
width: 80px;
padding-right: 10px;
}

.webVueAntYtSelectFormItem-mve08cv .ant-form-item-explain{
position: absolute;
top: 100%;
z-index: -1;
}
.webVueAntYtSelectFormItem-mve08cv .ant-form-item-label label{
width: 80px;
padding-right: 10px;
}

.webVueAntYtSelectFormItem-mvi4mjx .ant-form-item-explain{
position: absolute;
top: 100%;
z-index: -1;
}
.webVueAntYtSelectFormItem-mvi4mjx .ant-form-item-label label{
width: 80px;
padding-right: 10px;
}

.webVueAntYtSelectFormItem-mvtk6cr .ant-form-item-explain{
position: absolute;
top: 100%;
z-index: -1;
}
.webVueAntYtSelectFormItem-mvtk6cr .ant-form-item-label label{
width: 80px;
padding-right: 10px;
}

.webVueAntYtRadioStyle-mvcp436{
color: #333333;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
}
.webVueAntYtRadioStyle-mvcp436 .ant-radio-wrapper span{
color: #333333;
font-size: 14px;
font-weight: Normal;
}
.webVueAntYtRadioStyle-mvcp436 .ant-radio-wrapper:not(:last-child){
margin-right: 14px;
}
.webVueAntYtRadioStyle-mvcp436 .ant-radio-inner{
border-color: #CBCBCB;
}
.webVueAntYtRadioStyle-mvcp436 .ant-radio-wrapper-checked span{
color: #333333;
}
.webVueAntYtRadioStyle-mvcp436 .ant-radio-wrapper-checked .ant-radio-inner{
border-color: #3F82F9;
}
.webVueAntYtRadioStyle-mvcp436 .ant-radio-wrapper-checked .ant-radio-inner:after{
background-color: #3F82F9;
}
.webVueAntYtRadioFormItem-mvzvezs .ant-form-item-label label{
width: 119px;
padding-right: 10px;
}
.webVueAntYtRadioFormItem-mvzvezs{
opacity: 1;
}

.webVueAntYtSpanStyle-mv0x0s7{
color: #3D3D3D !important;
}
.webVueAntYtSpanStyle-mv0x0s7 span{
text-decoration: none;
}


.webVueAntYtRectangleStyle-mv74sab{
background: #1890FF;
border-top: 1px solid transparent;
border-right: 1px solid transparent;
border-bottom: 1px solid transparent;
border-left: 1px solid transparent;
}

.webVueAntYtSpanStyle-mv138es{
color: #3D3D3D !important;
font-weight: bold;
}
.webVueAntYtSpanStyle-mv138es span{
text-decoration: none;
}

.webVueAntYtRectangleStyle-mvqe248{
background: #1890FF;
border-top: 1px solid transparent;
border-right: 1px solid transparent;
border-bottom: 1px solid transparent;
border-left: 1px solid transparent;
}

.webVueAntYtSpanStyle-mv1pqck{
color: #3D3D3D !important;
font-weight: bold;
}
.webVueAntYtSpanStyle-mv1pqck span{
text-decoration: none;
}

.webVueAntYtSelectFormItem-mvaoi0m .ant-form-item-explain{
position: absolute;
top: 100%;
z-index: -1;
}
.webVueAntYtSelectFormItem-mvaoi0m .ant-form-item-label label{
// width: 80px;
width: 94px;
padding-right: 10px;
}

.webVueAntYtSelectFormItem-mvpjhp1 .ant-form-item-explain{
position: absolute;
top: 100%;
z-index: -1;
}
.webVueAntYtSelectFormItem-mvpjhp1 .ant-form-item-label label{
width: 91px;
padding-right: 10px;
}

.webVueAntYtSelectFormItem-mv409yg .ant-form-item-explain{
position: absolute;
top: 100%;
z-index: -1;
}
.webVueAntYtSelectFormItem-mv409yg .ant-form-item-label label{
// width: 81px;
width: 94px;
padding-right: 10px;
}


.webVueAntYtInputFormItem-mvv3f2d .ant-form-item-explain{
position: absolute;
top: 100%;
z-index: -1;
}
.webVueAntYtInputFormItem-mvv3f2d .ant-form-item-label label{
width: 108px;
padding-right: 10px;
}
.webVueAntYtInputStyle-mvekypo:not(.ant-input-affix-wrapper){
background: #FFFFFF !important;
}

.webVueAntYtRectangleStyle-mvo3o3w{
background: #1890FF;
border-top: 1px solid transparent;
border-right: 1px solid transparent;
border-bottom: 1px solid transparent;
border-left: 1px solid transparent;
}

.webVueAntYtSpanStyle-mvga247{
color: #3D3D3D !important;
font-weight: bold;
}
.webVueAntYtSpanStyle-mvga247 span{
text-decoration: none;
}

.webVueAntYtRectangleStyle-mvh8ot7{
background: #1890FF;
border-top: 1px solid transparent;
border-right: 1px solid transparent;
border-bottom: 1px solid transparent;
border-left: 1px solid transparent;
}

.webVueAntYtSpanStyle-mvgqgxc{
color: #3D3D3D !important;
font-weight: bold;
}
.webVueAntYtSpanStyle-mvgqgxc span{
text-decoration: none;
}

.webVueAntYtSelectFormItem-mvtpuy7 .ant-form-item-explain{
position: absolute;
top: 100%;
z-index: -1;
}
.webVueAntYtSelectFormItem-mvtpuy7 .ant-form-item-label label{
width: 122px;
padding-right: 10px;
}

.webVueAntYtSelectFormItem-mva52sf .ant-form-item-explain{
position: absolute;
top: 100%;
z-index: -1;
}
.webVueAntYtSelectFormItem-mva52sf .ant-form-item-label label{
width: 80px;
padding-right: 10px;
}

.webVueAntYtSelectFormItem-mv3fc06 .ant-form-item-explain{
position: absolute;
top: 100%;
z-index: -1;
}
.webVueAntYtSelectFormItem-mv3fc06 .ant-form-item-label label{
width: 80px;
padding-right: 10px;
}

.webVueAntYtButtonStyle-mvh7v5i{
color: #1890FF !important;
background: transparent !important;
border-top: 0px solid transparent;
border-right: 0px solid transparent;
border-bottom: 0px solid transparent;
border-left: 0px solid transparent;
align-items: center;
justify-content: center;
}
.webVueAntYtButtonStyle-mvh7v5i>span{
letter-spacing: 0px !important;
}

.webVueAntYtRadioStyle-mvkckqe{
color: #333333;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
}
.webVueAntYtRadioStyle-mvkckqe .ant-radio-wrapper span{
color: #333333;
font-size: 14px;
font-weight: Normal;
}
.webVueAntYtRadioStyle-mvkckqe .ant-radio-wrapper:not(:last-child){
margin-right: 14px;
}
.webVueAntYtRadioStyle-mvkckqe .ant-radio-inner{
border-color: #CBCBCB;
}
.webVueAntYtRadioStyle-mvkckqe .ant-radio-wrapper-checked span{
color: #333333;
}
.webVueAntYtRadioStyle-mvkckqe .ant-radio-wrapper-checked .ant-radio-inner{
border-color: #3F82F9;
}
.webVueAntYtRadioStyle-mvkckqe .ant-radio-wrapper-checked .ant-radio-inner:after{
background-color: #3F82F9;
}
.webVueAntYtRadioFormItem-mvucfio .ant-form-item-label label{
width: 80px;
padding-right: 10px;
}
.webVueAntYtRadioFormItem-mvucfio{
opacity: 1;
}

.webVueAntYtRadioStyle-mvgyhu1{
color: #333333;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
}
.webVueAntYtRadioStyle-mvgyhu1 .ant-radio-wrapper span{
color: #333333;
font-size: 14px;
font-weight: Normal;
}
.webVueAntYtRadioStyle-mvgyhu1 .ant-radio-wrapper:not(:last-child){
margin-right: 14px;
}
.webVueAntYtRadioStyle-mvgyhu1 .ant-radio-inner{
border-color: #CBCBCB;
}
.webVueAntYtRadioStyle-mvgyhu1 .ant-radio-wrapper-checked span{
color: #333333;
}
.webVueAntYtRadioStyle-mvgyhu1 .ant-radio-wrapper-checked .ant-radio-inner{
border-color: #3F82F9;
}
.webVueAntYtRadioStyle-mvgyhu1 .ant-radio-wrapper-checked .ant-radio-inner:after{
background-color: #3F82F9;
}
.webVueAntYtRadioFormItem-mv2eiyt .ant-form-item-label label{
width: 80px;
padding-right: 10px;
}
.webVueAntYtRadioFormItem-mv2eiyt{
opacity: 1;
}

.webVueAntYtRectangleStyle-mvk530g{
background: #1890FF;
border-top: 1px solid transparent;
border-right: 1px solid transparent;
border-bottom: 1px solid transparent;
border-left: 1px solid transparent;
}

.webVueAntYtSpanStyle-mvs7yxc{
color: #3D3D3D !important;
font-weight: bold;
}
.webVueAntYtSpanStyle-mvs7yxc span{
text-decoration: none;
}

.webVueAntYtRadioStyle-mv2gl3k{
color: #333333;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
}
.webVueAntYtRadioStyle-mv2gl3k .ant-radio-wrapper span{
color: #333333;
font-size: 14px;
font-weight: Normal;
}
.webVueAntYtRadioStyle-mv2gl3k .ant-radio-wrapper:not(:last-child){
margin-right: 14px;
}
.webVueAntYtRadioStyle-mv2gl3k .ant-radio-inner{
border-color: #CBCBCB;
}
.webVueAntYtRadioStyle-mv2gl3k .ant-radio-wrapper-checked span{
color: #333333;
}
.webVueAntYtRadioStyle-mv2gl3k .ant-radio-wrapper-checked .ant-radio-inner{
border-color: #3F82F9;
}
.webVueAntYtRadioStyle-mv2gl3k .ant-radio-wrapper-checked .ant-radio-inner:after{
background-color: #3F82F9;
}
.webVueAntYtRadioFormItem-mvg2qjo .ant-form-item-label label{
width: 67px;
padding-right: 10px;
}
.webVueAntYtRadioFormItem-mvg2qjo{
opacity: 1;
}

.webVueAntYtRadioStyle-mv50v5f{
color: #333333;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
}
.webVueAntYtRadioStyle-mv50v5f .ant-radio-wrapper span{
color: #333333;
font-size: 14px;
font-weight: Normal;
}
.webVueAntYtRadioStyle-mv50v5f .ant-radio-wrapper:not(:last-child){
margin-right: 14px;
}
.webVueAntYtRadioStyle-mv50v5f .ant-radio-inner{
border-color: #CBCBCB;
}
.webVueAntYtRadioStyle-mv50v5f .ant-radio-wrapper-checked span{
color: #333333;
}
.webVueAntYtRadioStyle-mv50v5f .ant-radio-wrapper-checked .ant-radio-inner{
border-color: #3F82F9;
}
.webVueAntYtRadioStyle-mv50v5f .ant-radio-wrapper-checked .ant-radio-inner:after{
background-color: #3F82F9;
}
.webVueAntYtRadioFormItem-mvkweoy .ant-form-item-label label{
width: 67px;
padding-right: 10px;
}
.webVueAntYtRadioFormItem-mvkweoy{
opacity: 1;
}

.webVueAntYtRectangleStyle-mv9n9k7{
background: #1890FF;
border-top: 1px solid transparent;
border-right: 1px solid transparent;
border-bottom: 1px solid transparent;
border-left: 1px solid transparent;
}

.webVueAntYtSpanStyle-mv4jkk3{
color: #3D3D3D !important;
font-weight: bold;
}
.webVueAntYtSpanStyle-mv4jkk3 span{
text-decoration: none;
}

.webVueAntYtRadioStyle-mvnel6z{
color: #333333;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
}
.webVueAntYtRadioStyle-mvnel6z .ant-radio-wrapper span{
color: #333333;
font-size: 14px;
font-weight: Normal;
}
.webVueAntYtRadioStyle-mvnel6z .ant-radio-wrapper:not(:last-child){
margin-right: 14px;
}
.webVueAntYtRadioStyle-mvnel6z .ant-radio-inner{
border-color: #CBCBCB;
}
.webVueAntYtRadioStyle-mvnel6z .ant-radio-wrapper-checked span{
color: #333333;
}
.webVueAntYtRadioStyle-mvnel6z .ant-radio-wrapper-checked .ant-radio-inner{
border-color: #3F82F9;
}
.webVueAntYtRadioStyle-mvnel6z .ant-radio-wrapper-checked .ant-radio-inner:after{
background-color: #3F82F9;
}
.webVueAntYtRadioFormItem-mvjq4ft .ant-form-item-label label{
width: 80px;
padding-right: 10px;
}
.webVueAntYtRadioFormItem-mvjq4ft{
opacity: 1;
}

.webVueAntYtInputNumberFormItem-mvxt2iz .ant-form-item-explain{
position: absolute;
top: 100%;
z-index: -1;
}
.webVueAntYtInputNumberFormItem-mvxt2iz .ant-form-item-label label{
width: 95px;
padding-right: 10px;
}
.webVueAntYtInputNumberStyle-mv8cyir{
background: #FFFFFF !important;
}

.webVueAntYtInputNumberFormItem-mvernqg .ant-form-item-explain{
position: absolute;
top: 100%;
z-index: -1;
}
.webVueAntYtInputNumberFormItem-mvernqg .ant-form-item-label label{
width: 109px;
padding-right: 10px;
}
.webVueAntYtInputNumberStyle-mvgnkv1{
background: #FFFFFF !important;
}

.webVueAntYtRectangleStyle-mvsv6ey{
background: #1890FF;
border-top: 1px solid transparent;
border-right: 1px solid transparent;
border-bottom: 1px solid transparent;
border-left: 1px solid transparent;
}

.webVueAntYtSpanStyle-mvxv9q3{
color: #3D3D3D !important;
font-weight: bold;
}
.webVueAntYtSpanStyle-mvxv9q3 span{
text-decoration: none;
}

.webVueAntYtRadioStyle-mv0osuw{
color: #333333;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
}
.webVueAntYtRadioStyle-mv0osuw .ant-radio-wrapper span{
color: #333333;
font-size: 14px;
font-weight: Normal;
}
.webVueAntYtRadioStyle-mv0osuw .ant-radio-wrapper:not(:last-child){
margin-right: 14px;
}
.webVueAntYtRadioStyle-mv0osuw .ant-radio-inner{
border-color: #CBCBCB;
}
.webVueAntYtRadioStyle-mv0osuw .ant-radio-wrapper-checked span{
color: #333333;
}
.webVueAntYtRadioStyle-mv0osuw .ant-radio-wrapper-checked .ant-radio-inner{
border-color: #3F82F9;
}
.webVueAntYtRadioStyle-mv0osuw .ant-radio-wrapper-checked .ant-radio-inner:after{
background-color: #3F82F9;
}
.webVueAntYtRadioFormItem-mv0zurl .ant-form-item-label label{
width: 80px;
padding-right: 10px;
}
.webVueAntYtRadioFormItem-mv0zurl{
opacity: 1;
}


.webVueAntYtInputFormItem-mvij4r9 .ant-form-item-explain{
position: absolute;
top: 100%;
z-index: -1;
}
.webVueAntYtInputFormItem-mvij4r9 .ant-form-item-label label{
width: 80px;
padding-right: 10px;
}
.webVueAntYtInputStyle-mvi4n4s:not(.ant-input-affix-wrapper){
background: #FFFFFF !important;
}

.webVueAntYtInputFormItem-mv5h4tl .ant-form-item-explain{
position: absolute;
top: 100%;
z-index: -1;
}
.webVueAntYtInputFormItem-mv5h4tl .ant-form-item-label label{
width: 80px;
padding-right: 10px;
}
.webVueAntYtInputFormItem-mv5h4tl .ant-form-item-label label .label-content{
text-align: right;
text-align-last: right;
}
.webVueAntYtInputStyle-mvn9x27:not(.ant-input-affix-wrapper){
background: #FFFFFF !important;
}

.webVueAntYtInputFormItem-mvcg82r .ant-form-item-explain{
position: absolute;
top: 100%;
z-index: -1;
}
.webVueAntYtInputFormItem-mvcg82r .ant-form-item-label label{
width: 94px;
padding-right: 10px;
}
.webVueAntYtInputStyle-mvq204k:not(.ant-input-affix-wrapper){
background: #FFFFFF !important;
}

.webVueAntYtInputFormItem-mv4z5g0 .ant-form-item-explain{
position: absolute;
top: 100%;
z-index: -1;
}
.webVueAntYtInputFormItem-mv4z5g0 .ant-form-item-label label{
width: 80px;
padding-right: 10px;
}
.webVueAntYtInputStyle-mvfqagi:not(.ant-input-affix-wrapper){
background: #FFFFFF !important;
}

.webVueAntYtRectangleStyle-mvlhfaq{
background: #1890FF;
border-top: 1px solid transparent;
border-right: 1px solid transparent;
border-bottom: 1px solid transparent;
border-left: 1px solid transparent;
}

.webVueAntYtSpanStyle-mv0fm0l{
color: #3D3D3D !important;
font-weight: bold;
}
.webVueAntYtSpanStyle-mv0fm0l span{
text-decoration: none;
}

.webVueAntYtRectangleStyle-mvxke9f{
background: #1890FF;
border-top: 1px solid transparent;
border-right: 1px solid transparent;
border-bottom: 1px solid transparent;
border-left: 1px solid transparent;
}

.webVueAntYtSpanStyle-mvamlte{
color: #3D3D3D !important;
font-weight: bold;
}
.webVueAntYtSpanStyle-mvamlte span{
text-decoration: none;
}

.webVueAntYtInputFormItem-mvtz6ok .ant-form-item-explain{
position: absolute;
top: 100%;
z-index: -1;
}
.webVueAntYtInputFormItem-mvtz6ok .ant-form-item-label label{
width: 80px;
padding-right: 10px;
}
.webVueAntYtInputFormItem-mvtz6ok .ant-form-item-label label .label-content{
text-align: right;
text-align-last: right;
}
.webVueAntYtInputStyle-mvz6sb6:not(.ant-input-affix-wrapper){
background: #FFFFFF !important;
}

.webVueAntYtInputFormItem-mv76kuz .ant-form-item-explain{
position: absolute;
top: 100%;
z-index: -1;
}
.webVueAntYtInputFormItem-mv76kuz .ant-form-item-label label{
width: 80px;
padding-right: 10px;
}
.webVueAntYtInputFormItem-mv76kuz .ant-form-item-label label .label-content{
text-align: right;
text-align-last: right;
}
.webVueAntYtInputStyle-mv51hwv:not(.ant-input-affix-wrapper){
background: #FFFFFF !important;
}

.webVueAntYtInputFormItem-mvvkzjr .ant-form-item-explain{
position: absolute;
top: 100%;
z-index: -1;
}
.webVueAntYtInputFormItem-mvvkzjr .ant-form-item-label label{
width: 80px;
padding-right: 10px;
}
.webVueAntYtInputFormItem-mvvkzjr .ant-form-item-label label .label-content{
text-align: right;
text-align-last: right;
}
.webVueAntYtInputStyle-mvmq92x:not(.ant-input-affix-wrapper){
background: #FFFFFF !important;
}

.webVueAntYtRectangleStyle-mv130mh{
background: #1890FF;
border-top: 1px solid transparent;
border-right: 1px solid transparent;
border-bottom: 1px solid transparent;
border-left: 1px solid transparent;
}

.webVueAntYtSpanStyle-mv71u15{
color: #3D3D3D !important;
font-weight: bold;
}
.webVueAntYtSpanStyle-mv71u15 span{
text-decoration: none;
}

.webVueAntYtInputFormItem-mvqr9y5 .ant-form-item-explain{
position: absolute;
top: 100%;
z-index: -1;
}
.webVueAntYtInputFormItem-mvqr9y5 .ant-form-item-label label{
width: 80px;
padding-right: 10px;
}
.webVueAntYtInputFormItem-mvqr9y5 .ant-form-item-label label .label-content{
text-align: right;
text-align-last: right;
}
.webVueAntYtInputStyle-mv42nla:not(.ant-input-affix-wrapper){
background: #FFFFFF !important;
}

.webVueAntYtDatePickerFormItem-mvmixhr .ant-form-item-explain{
position: absolute;
top: 100%;
z-index: -1;
}
.webVueAntYtDatePickerFormItem-mvmixhr .ant-form-item-label label{
width: 80px;
padding-right: 10px;
}
.webVueAntYtDatePickerStyle-mv1t9l5{
background: #FFFFFF!important;
border-top: 1px solid #CDCDCD !important;
border-right: 1px solid #CDCDCD !important;
border-bottom: 1px solid #CDCDCD !important;
border-left: 1px solid #CDCDCD !important;
}
.webVueAntYtDatePickerStyle-mv1t9l5.ant-picker-focused,.webVueAntYtDatePickerStyle-mv1t9l5.ant-picker:hover{
border-right: 1px solid #CDCDCD!important;
}

.webVueAntYtRangePickerFormItem-mvxwat0 .ant-form-item-explain{
position: absolute;
top: 100%;
z-index: -1;
}
.webVueAntYtRangePickerFormItem-mvxwat0 .ant-form-item-label label{
width: 80px;
padding-top: 0px;
padding-right: 10px;
padding-bottom: 0px;
}
.webVueAntYtRangePickerFormItem-mvxwat0 .ant-form-item-label label .label-content{
text-align: right;
text-align-last: right;
}
.webVueAntYtRangePickerStyle-mvkvyfu.ant-picker-focused,.webVueAntYtRangePickerStyle-mvkvyfu.ant-picker:hover{
border-right: 1px solid #CDCDCD!important;
}


.webVueAntYtRectangleStyle-mv6rc1k{
background: #1890FF;
border-top: 1px solid transparent;
border-right: 1px solid transparent;
border-bottom: 1px solid transparent;
border-left: 1px solid transparent;
}

.webVueAntYtSpanStyle-mvutvff{
color: #3D3D3D !important;
font-weight: bold;
}
.webVueAntYtSpanStyle-mvutvff span{
text-decoration: none;
}


.webVueAntYtRectangleStyle-mvo8rle{
background: #1890FF;
border-top: 1px solid transparent;
border-right: 1px solid transparent;
border-bottom: 1px solid transparent;
border-left: 1px solid transparent;
}

.webVueAntYtSpanStyle-mvdqafj{
color: #3D3D3D !important;
font-weight: bold;
}
.webVueAntYtSpanStyle-mvdqafj span{
text-decoration: none;
}

.webVueAntYtModalStyle-mvlhsvc .ant-modal-wrap .yt-custom-modal-header{
font-size: 16px;
font-weight: bold;
}

.webVueAntYtVerticleMenuStyle-mvcr8o0.ant-menu{
box-shadow: 0px 0px 0px 0px transparent!important;
}
.webVueAntYtVerticleMenuStyle-mvcr8o0.ant-menu-inline div>li.ant-menu-item,.webVueAntYtVerticleMenuStyle-mvcr8o0.ant-menu-inline div>li>.ant-menu-submenu-title,.webVueAntYtVerticleMenuStyle-mvcr8o0.ant-menu-inline div>li.ant-menu-item.ant-menu-item-only-child{
height: 32px;
padding-top: 0px;
padding-right: 0px;
padding-bottom: 0px;
padding-left: 20px !important;
}
.webVueAntYtVerticleMenuStyle-mvcr8o0 div>li.ant-menu-item,.webVueAntYtVerticleMenuStyle-mvcr8o0 div>li>.ant-menu-submenu-title,.webVueAntYtVerticleMenuStyle-mvcr8o0 div>li.ant-menu-item.ant-menu-item-only-child{
height: 32px;
text-decoration: none;
padding-top: 0px;
padding-right: 0px;
padding-bottom: 0px;
padding-left: 20px !important;
}
.webVueAntYtVerticleMenuStyle-mvcr8o0.ant-menu-inline .ant-menu-submenu-inline .ant-menu-inline li.ant-menu-item,.webVueAntYtVerticleMenuStyle-mvcr8o0.ant-menu-inline .ant-menu-submenu-inline .ant-menu-inline li.ant-menu-item-only-child,.webVueAntYtVerticleMenuStyle-mvcr8o0.ant-menu-inline .ant-menu-submenu-inline .ant-menu-inline li>.ant-menu-submenu-title,.webVueAntYtVerticleMenuStyle-mvcr8o0.ant-menu-vertical .ant-menu-submenu-popup .ant-menu-vertical li.ant-menu-item,.webVueAntYtVerticleMenuStyle-mvcr8o0.ant-menu-vertical .ant-menu-submenu-popup .ant-menu-vertical li.ant-menu-item-only-child,.webVueAntYtVerticleMenuStyle-mvcr8o0.ant-menu-vertical .ant-menu-submenu-popup .ant-menu-vertical li>.ant-menu-submenu-title{
height: 32px;
padding-top: 0px;
padding-right: 0px;
padding-bottom: 0px;
padding-left: 20px !important;
}
.webVueAntYtVerticleMenuStyle-mvcr8o0 .ant-menu-submenu:not(.ant-menu-item-selected):hover>.ant-menu-submenu-title>.ant-menu-submenu-arrow,.webVueAntYtVerticleMenuStyle-mvcr8o0 .ant-menu-submenu:not(.ant-menu-item-selected):hover>.ant-menu-submenu-title>.ant-menu-submenu-expand-icon,.webVueAntYtVerticleMenuStyle-mvcr8o0.ant-menu-light .ant-menu-item:not(.ant-menu-item-selected):hover,.webVueAntYtVerticleMenuStyle-mvcr8o0.ant-menu-light .ant-menu-submenu-title:not(.ant-menu-item-selected):not(.ant-menu-submenu-selected):hover{
background: #ffffff!important;
}



.webVueAntYtInputFormItem-mvl57fx .ant-form-item-explain{
position: absolute;
top: 100%;
z-index: -1;
}
.webVueAntYtInputFormItem-mvl57fx .ant-form-item-label label{
width: 80px;
padding-right: 10px;
}
.webVueAntYtInputStyle-mvexthv:not(.ant-input-affix-wrapper){
background: #FFFFFF !important;
}

.webVueAntYtInputFormItem-mvwhold .ant-form-item-explain{
position: absolute;
top: 100%;
z-index: -1;
}
.webVueAntYtInputFormItem-mvwhold .ant-form-item-label label{
width: 95px;
padding-right: 10px;
}
.webVueAntYtInputFormItem-mvwhold .ant-form-item-label label .label-content{
text-align: right;
text-align-last: right;
}
.webVueAntYtInputStyle-mvgeipk:not(.ant-input-affix-wrapper){
background: #FFFFFF !important;
}

.webVueAntYtInputFormItem-mvk3kzp .ant-form-item-explain{
position: absolute;
top: 100%;
z-index: -1;
}
.webVueAntYtInputFormItem-mvk3kzp .ant-form-item-label label{
width: 80px;
padding-right: 10px;
}
.webVueAntYtInputFormItem-mvk3kzp .ant-form-item-label label .label-content{
text-align: right;
text-align-last: right;
}
.webVueAntYtInputStyle-mv4ptis:not(.ant-input-affix-wrapper){
background: #FFFFFF !important;
}

.webVueAntYtInputFormItem-mvym2xi .ant-form-item-explain{
position: absolute;
top: 100%;
z-index: -1;
}
.webVueAntYtInputFormItem-mvym2xi .ant-form-item-label label{
width: 92px;
padding-right: 10px;
}
.webVueAntYtInputStyle-mvb32jn:not(.ant-input-affix-wrapper){
background: #FFFFFF !important;
}

.webVueAntYtInputFormItem-mvc75fw .ant-form-item-explain{
position: absolute;
top: 100%;
z-index: -1;
}
.webVueAntYtInputFormItem-mvc75fw .ant-form-item-label label{
width: 80px;
padding-right: 10px;
}
.webVueAntYtInputStyle-mvdub0v:not(.ant-input-affix-wrapper){
background: #F6F6F6 !important;
// background: #FFFFFF !important;
}

.webVueAntYtInputFormItem-mvcsnl8 .ant-form-item-explain{
position: absolute;
top: 100%;
z-index: -1;
}
.webVueAntYtInputFormItem-mvcsnl8 .ant-form-item-label label{
width: 80px;
padding-right: 10px;
}
.webVueAntYtInputStyle-mvxbpi0:not(.ant-input-affix-wrapper){
background: #F6F6F6 !important;
// background: #FFFFFF !important;
}

.webVueAntYtInputFormItem-mvq6zes .ant-form-item-explain{
position: absolute;
top: 100%;
z-index: -1;
}
.webVueAntYtInputFormItem-mvq6zes .ant-form-item-label label{
width: 80px;
padding-right: 10px;
}
.webVueAntYtInputStyle-mvj81s5:not(.ant-input-affix-wrapper){
background: #FFFFFF !important;
}

.webVueAntYtInputFormItem-mvnmq28 .ant-form-item-explain{
position: absolute;
top: 100%;
z-index: -1;
}
.webVueAntYtInputFormItem-mvnmq28 .ant-form-item-label label{
width: 80px;
padding-right: 10px;
}
.webVueAntYtInputStyle-mvsbr1z:not(.ant-input-affix-wrapper){
background: #FFFFFF !important;
}

.webVueAntYtRectangleStyle-mvvpq1s{
background: #1890FF;
border-top: 1px solid transparent;
border-right: 1px solid transparent;
border-bottom: 1px solid transparent;
border-left: 1px solid transparent;
}

.webVueAntYtSpanStyle-mvkahsb{
color: #3D3D3D !important;
font-weight: bold;
}
.webVueAntYtSpanStyle-mvkahsb span{
text-decoration: none;
}

.webVueAntYtRectangleStyle-mvzepms{
background: #1890FF;
border-top: 1px solid transparent;
border-right: 1px solid transparent;
border-bottom: 1px solid transparent;
border-left: 1px solid transparent;
}

.webVueAntYtSpanStyle-mvs012l{
color: #3D3D3D !important;
font-weight: bold;
}
.webVueAntYtSpanStyle-mvs012l span{
text-decoration: none;
}

.webVueAntYtRectangleStyle-mva5nzl{
background: #1890FF;
border-top: 1px solid transparent;
border-right: 1px solid transparent;
border-bottom: 1px solid transparent;
border-left: 1px solid transparent;
}

.webVueAntYtSpanStyle-mv2027u{
color: #3D3D3D !important;
font-weight: bold;
}
.webVueAntYtSpanStyle-mv2027u span{
text-decoration: none;
}

.webVueAntYtInputFormItem-mvn4zrd .ant-form-item-explain{
position: absolute;
top: 100%;
z-index: -1;
}
.webVueAntYtInputFormItem-mvn4zrd .ant-form-item-label label{
width: 91px;
padding-right: 10px;
}
.webVueAntYtInputStyle-mvax7i5:not(.ant-input-affix-wrapper){
background: #FFFFFF !important;
}

.webVueAntYtInputFormItem-mviqrt7 .ant-form-item-explain{
position: absolute;
top: 100%;
z-index: -1;
}
.webVueAntYtInputFormItem-mviqrt7 .ant-form-item-label label{
width: 78px;
padding-right: 10px;
}
.webVueAntYtInputFormItem-mviqrt7 .ant-form-item-label label .label-content{
text-align: right;
text-align-last: right;
}
.webVueAntYtInputStyle-mvw31cz:not(.ant-input-affix-wrapper){
background: #FFFFFF !important;
}

.webVueAntYtInputFormItem-mvawtyn .ant-form-item-explain{
position: absolute;
top: 100%;
z-index: -1;
}
.webVueAntYtInputFormItem-mvawtyn .ant-form-item-label label{
width: 92px;
padding-right: 10px;
}
.webVueAntYtInputStyle-mvqp5py:not(.ant-input-affix-wrapper){
background: #FFFFFF !important;
}

.webVueAntYtInputFormItem-mvt1as6 .ant-form-item-explain{
position: absolute;
top: 100%;
z-index: -1;
}
.webVueAntYtInputFormItem-mvt1as6 .ant-form-item-label label{
width: 77px;
padding-right: 10px;
}
.webVueAntYtInputFormItem-mvt1as6 .ant-form-item-label label .label-content{
text-align: right;
text-align-last: right;
}
.webVueAntYtInputStyle-mvk06aa:not(.ant-input-affix-wrapper){
background: #FFFFFF !important;
}

.webVueAntYtInputFormItem-mvxrtyr .ant-form-item-explain{
position: absolute;
top: 100%;
z-index: -1;
}
.webVueAntYtInputFormItem-mvxrtyr .ant-form-item-label label{
width: 80px;
padding-right: 10px;
}
.webVueAntYtInputStyle-mvt5ef9:not(.ant-input-affix-wrapper){
background: #FFFFFF !important;
}

.webVueAntYtInputFormItem-mv7d20g .ant-form-item-explain{
position: absolute;
top: 100%;
z-index: -1;
}
.webVueAntYtInputFormItem-mv7d20g .ant-form-item-label label{
width: 80px;
padding-right: 10px;
}
.webVueAntYtInputStyle-mv3enng:not(.ant-input-affix-wrapper){
background: #FFFFFF !important;
}

.webVueAntYtRectangleStyle-mvaiklg{
background: #1890FF;
border-top: 1px solid transparent;
border-right: 1px solid transparent;
border-bottom: 1px solid transparent;
border-left: 1px solid transparent;
}

.webVueAntYtSpanStyle-mv0t9ig{
color: #3D3D3D !important;
font-weight: bold;
}
.webVueAntYtSpanStyle-mv0t9ig span{
text-decoration: none;
}

.webVueAntYtSpanStyle-mvaf3ga{
color: #3D3D3D !important;
}
.webVueAntYtSpanStyle-mvaf3ga span{
text-decoration: none;
}

.webVueAntYtPictureStyle-mvnstv1{
opacity: 1;
box-shadow: 0px 0px 0px 0px transparent;
border-top-left-radius: 4px;
border-top-right-radius: 4px;
border-bottom-left-radius: 4px;
border-bottom-right-radius: 4px;
border-top: 1px solid #D9D9D9;
border-right: 1px solid #D9D9D9;
border-bottom: 1px solid #D9D9D9;
border-left: 1px solid #D9D9D9;
}

.webVueAntYtSelectFormItem-mvp13q8 .ant-form-item-explain{
position: absolute;
top: 100%;
z-index: -1;
}
.webVueAntYtSelectFormItem-mvp13q8 .ant-form-item-label label{
width: 91px;
padding-right: 10px;
}

.webVueAntYtSelectFormItem-mvwp8us .ant-form-item-explain{
position: absolute;
top: 100%;
z-index: -1;
}
.webVueAntYtSelectFormItem-mvwp8us .ant-form-item-label label{
width: 91px;
padding-right: 10px;
}

.webVueAntYtSelectFormItem-mv9opql .ant-form-item-explain{
position: absolute;
top: 100%;
z-index: -1;
}
.webVueAntYtSelectFormItem-mv9opql .ant-form-item-label label{
width: 80px;
padding-right: 10px;
}

.webVueAntYtSelectFormItem-mvxi0ub .ant-form-item-explain{
position: absolute;
top: 100%;
z-index: -1;
}
.webVueAntYtSelectFormItem-mvxi0ub .ant-form-item-label label{
width: 80px;
padding-right: 10px;
}

.webVueAntYtSelectFormItem-mvanw1x .ant-form-item-explain{
position: absolute;
top: 100%;
z-index: -1;
}
.webVueAntYtSelectFormItem-mvanw1x .ant-form-item-label label{
width: 80px;
padding-right: 10px;
}

.webVueAntYtSelectFormItem-mvxla63 .ant-form-item-explain{
position: absolute;
top: 100%;
z-index: -1;
}
.webVueAntYtSelectFormItem-mvxla63 .ant-form-item-label label{
width: 80px;
padding-right: 10px;
}

.webVueAntYtSelectFormItem-mvuqhwa .ant-form-item-explain{
position: absolute;
top: 100%;
z-index: -1;
}
.webVueAntYtSelectFormItem-mvuqhwa .ant-form-item-label label{
width: 80px;
padding-right: 10px;
}

.webVueAntYtRadioStyle-mvu28fp{
color: #333333;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
}
.webVueAntYtRadioStyle-mvu28fp .ant-radio-wrapper span{
color: #333333;
font-size: 14px;
font-weight: Normal;
}
.webVueAntYtRadioStyle-mvu28fp .ant-radio-wrapper:not(:last-child){
margin-right: 14px;
}
.webVueAntYtRadioStyle-mvu28fp .ant-radio-inner{
border-color: #CBCBCB;
}
.webVueAntYtRadioStyle-mvu28fp .ant-radio-wrapper-checked span{
color: #333333;
}
.webVueAntYtRadioStyle-mvu28fp .ant-radio-wrapper-checked .ant-radio-inner{
border-color: #3F82F9;
}
.webVueAntYtRadioStyle-mvu28fp .ant-radio-wrapper-checked .ant-radio-inner:after{
background-color: #3F82F9;
}
.webVueAntYtRadioFormItem-mvabcdu .ant-form-item-label label{
width: 119px;
padding-right: 10px;
}
.webVueAntYtRadioFormItem-mvabcdu{
opacity: 1;
}


.webVueAntYtRectangleStyle-mvv046b{
background: #1890FF;
border-top: 1px solid transparent;
border-right: 1px solid transparent;
border-bottom: 1px solid transparent;
border-left: 1px solid transparent;
}

.webVueAntYtSpanStyle-mvtc561{
color: #3D3D3D !important;
font-weight: bold;
}
.webVueAntYtSpanStyle-mvtc561 span{
text-decoration: none;
}

.webVueAntYtRectangleStyle-mvuywa1{
background: #1890FF;
border-top: 1px solid transparent;
border-right: 1px solid transparent;
border-bottom: 1px solid transparent;
border-left: 1px solid transparent;
}

.webVueAntYtSpanStyle-mv8ruj4{
color: #3D3D3D !important;
font-weight: bold;
}
.webVueAntYtSpanStyle-mv8ruj4 span{
text-decoration: none;
}

.webVueAntYtSelectFormItem-mv9sqpy .ant-form-item-explain{
position: absolute;
top: 100%;
z-index: -1;
}
.webVueAntYtSelectFormItem-mv9sqpy .ant-form-item-label label{
// width: 80px;
width: 94px;
padding-right: 10px;
}

.webVueAntYtSelectFormItem-mv5pcyn .ant-form-item-explain{
position: absolute;
top: 100%;
z-index: -1;
}
.webVueAntYtSelectFormItem-mv5pcyn .ant-form-item-label label{
width: 91px;
padding-right: 10px;
}

.webVueAntYtSelectFormItem-mvi55wx .ant-form-item-explain{
position: absolute;
top: 100%;
z-index: -1;
}
.webVueAntYtSelectFormItem-mvi55wx .ant-form-item-label label{
// width: 81px;
width: 94px;
padding-right: 10px;
}


.webVueAntYtInputFormItem-mvv3nhi .ant-form-item-explain{
position: absolute;
top: 100%;
z-index: -1;
}
.webVueAntYtInputFormItem-mvv3nhi .ant-form-item-label label{
width: 108px;
padding-right: 10px;
}
.webVueAntYtInputStyle-mvjcacr:not(.ant-input-affix-wrapper){
background: #FFFFFF !important;
}

.webVueAntYtRectangleStyle-mvrz8mf{
background: #1890FF;
border-top: 1px solid transparent;
border-right: 1px solid transparent;
border-bottom: 1px solid transparent;
border-left: 1px solid transparent;
}

.webVueAntYtSpanStyle-mv911cb{
color: #3D3D3D !important;
font-weight: bold;
}
.webVueAntYtSpanStyle-mv911cb span{
text-decoration: none;
}

.webVueAntYtRectangleStyle-mv8m2p6{
background: #1890FF;
border-top: 1px solid transparent;
border-right: 1px solid transparent;
border-bottom: 1px solid transparent;
border-left: 1px solid transparent;
}

.webVueAntYtSpanStyle-mvlcftu{
color: #3D3D3D !important;
font-weight: bold;
}
.webVueAntYtSpanStyle-mvlcftu span{
text-decoration: none;
}

.webVueAntYtSelectFormItem-mvdxwil .ant-form-item-explain{
position: absolute;
top: 100%;
z-index: -1;
}
.webVueAntYtSelectFormItem-mvdxwil .ant-form-item-label label{
width: 122px;
padding-right: 10px;
}

.webVueAntYtSelectFormItem-mvx1ki1 .ant-form-item-explain{
position: absolute;
top: 100%;
z-index: -1;
}
.webVueAntYtSelectFormItem-mvx1ki1 .ant-form-item-label label{
width: 80px;
padding-right: 10px;
}

.webVueAntYtSelectFormItem-mvso9fj .ant-form-item-explain{
position: absolute;
top: 100%;
z-index: -1;
}
.webVueAntYtSelectFormItem-mvso9fj .ant-form-item-label label{
width: 80px;
padding-right: 10px;
}

.webVueAntYtButtonStyle-mvhrl0z{
color: #1890FF !important;
background: transparent !important;
border-top: 0px solid transparent;
border-right: 0px solid transparent;
border-bottom: 0px solid transparent;
border-left: 0px solid transparent;
align-items: center;
justify-content: center;
}
.webVueAntYtButtonStyle-mvhrl0z>span{
letter-spacing: 0px !important;
}

.webVueAntYtRadioStyle-mv3r6dj{
color: #333333;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
}
.webVueAntYtRadioStyle-mv3r6dj .ant-radio-wrapper span{
color: #333333;
font-size: 14px;
font-weight: Normal;
}
.webVueAntYtRadioStyle-mv3r6dj .ant-radio-wrapper:not(:last-child){
margin-right: 14px;
}
.webVueAntYtRadioStyle-mv3r6dj .ant-radio-inner{
border-color: #CBCBCB;
}
.webVueAntYtRadioStyle-mv3r6dj .ant-radio-wrapper-checked span{
color: #333333;
}
.webVueAntYtRadioStyle-mv3r6dj .ant-radio-wrapper-checked .ant-radio-inner{
border-color: #3F82F9;
}
.webVueAntYtRadioStyle-mv3r6dj .ant-radio-wrapper-checked .ant-radio-inner:after{
background-color: #3F82F9;
}
.webVueAntYtRadioFormItem-mvaprvb .ant-form-item-label label{
width: 80px;
padding-right: 10px;
}
.webVueAntYtRadioFormItem-mvaprvb{
opacity: 1;
}

.webVueAntYtRadioStyle-mvhotoh{
color: #333333;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
}
.webVueAntYtRadioStyle-mvhotoh .ant-radio-wrapper span{
color: #333333;
font-size: 14px;
font-weight: Normal;
}
.webVueAntYtRadioStyle-mvhotoh .ant-radio-wrapper:not(:last-child){
margin-right: 14px;
}
.webVueAntYtRadioStyle-mvhotoh .ant-radio-inner{
border-color: #CBCBCB;
}
.webVueAntYtRadioStyle-mvhotoh .ant-radio-wrapper-checked span{
color: #333333;
}
.webVueAntYtRadioStyle-mvhotoh .ant-radio-wrapper-checked .ant-radio-inner{
border-color: #3F82F9;
}
.webVueAntYtRadioStyle-mvhotoh .ant-radio-wrapper-checked .ant-radio-inner:after{
background-color: #3F82F9;
}
.webVueAntYtRadioFormItem-mv8b85l .ant-form-item-label label{
width: 80px;
padding-right: 10px;
}
.webVueAntYtRadioFormItem-mv8b85l{
opacity: 1;
}

.webVueAntYtRectangleStyle-mv4tw2u{
background: #1890FF;
border-top: 1px solid transparent;
border-right: 1px solid transparent;
border-bottom: 1px solid transparent;
border-left: 1px solid transparent;
}

.webVueAntYtSpanStyle-mvwv7gb{
color: #3D3D3D !important;
font-weight: bold;
}
.webVueAntYtSpanStyle-mvwv7gb span{
text-decoration: none;
}

.webVueAntYtRadioStyle-mvhzsxu{
color: #333333;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
}
.webVueAntYtRadioStyle-mvhzsxu .ant-radio-wrapper span{
color: #333333;
font-size: 14px;
font-weight: Normal;
}
.webVueAntYtRadioStyle-mvhzsxu .ant-radio-wrapper:not(:last-child){
margin-right: 14px;
}
.webVueAntYtRadioStyle-mvhzsxu .ant-radio-inner{
border-color: #CBCBCB;
}
.webVueAntYtRadioStyle-mvhzsxu .ant-radio-wrapper-checked span{
color: #333333;
}
.webVueAntYtRadioStyle-mvhzsxu .ant-radio-wrapper-checked .ant-radio-inner{
border-color: #3F82F9;
}
.webVueAntYtRadioStyle-mvhzsxu .ant-radio-wrapper-checked .ant-radio-inner:after{
background-color: #3F82F9;
}
.webVueAntYtRadioFormItem-mv74l9z .ant-form-item-label label{
width: 67px;
padding-right: 10px;
}
.webVueAntYtRadioFormItem-mv74l9z{
opacity: 1;
}

.webVueAntYtRadioStyle-mvvhbc4{
color: #333333;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
}
.webVueAntYtRadioStyle-mvvhbc4 .ant-radio-wrapper span{
color: #333333;
font-size: 14px;
font-weight: Normal;
}
.webVueAntYtRadioStyle-mvvhbc4 .ant-radio-wrapper:not(:last-child){
margin-right: 14px;
}
.webVueAntYtRadioStyle-mvvhbc4 .ant-radio-inner{
border-color: #CBCBCB;
}
.webVueAntYtRadioStyle-mvvhbc4 .ant-radio-wrapper-checked span{
color: #333333;
}
.webVueAntYtRadioStyle-mvvhbc4 .ant-radio-wrapper-checked .ant-radio-inner{
border-color: #3F82F9;
}
.webVueAntYtRadioStyle-mvvhbc4 .ant-radio-wrapper-checked .ant-radio-inner:after{
background-color: #3F82F9;
}
.webVueAntYtRadioFormItem-mvr5dnp .ant-form-item-label label{
width: 67px;
padding-right: 10px;
}
.webVueAntYtRadioFormItem-mvr5dnp{
opacity: 1;
}

.webVueAntYtRectangleStyle-mviud1i{
background: #1890FF;
border-top: 1px solid transparent;
border-right: 1px solid transparent;
border-bottom: 1px solid transparent;
border-left: 1px solid transparent;
}

.webVueAntYtSpanStyle-mvpdf4k{
color: #3D3D3D !important;
font-weight: bold;
}
.webVueAntYtSpanStyle-mvpdf4k span{
text-decoration: none;
}

.webVueAntYtRadioStyle-mvgenhm{
color: #333333;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
}
.webVueAntYtRadioStyle-mvgenhm .ant-radio-wrapper span{
color: #333333;
font-size: 14px;
font-weight: Normal;
}
.webVueAntYtRadioStyle-mvgenhm .ant-radio-wrapper:not(:last-child){
margin-right: 14px;
}
.webVueAntYtRadioStyle-mvgenhm .ant-radio-inner{
border-color: #CBCBCB;
}
.webVueAntYtRadioStyle-mvgenhm .ant-radio-wrapper-checked span{
color: #333333;
}
.webVueAntYtRadioStyle-mvgenhm .ant-radio-wrapper-checked .ant-radio-inner{
border-color: #3F82F9;
}
.webVueAntYtRadioStyle-mvgenhm .ant-radio-wrapper-checked .ant-radio-inner:after{
background-color: #3F82F9;
}
.webVueAntYtRadioFormItem-mv9mbbi .ant-form-item-label label{
width: 80px;
padding-right: 10px;
}
.webVueAntYtRadioFormItem-mv9mbbi{
opacity: 1;
}

.webVueAntYtInputNumberFormItem-mvsi5lc .ant-form-item-explain{
position: absolute;
top: 100%;
z-index: -1;
}
.webVueAntYtInputNumberFormItem-mvsi5lc .ant-form-item-label label{
width: 95px;
padding-right: 10px;
}
.webVueAntYtInputNumberStyle-mv9play{
background: #FFFFFF !important;
}

.webVueAntYtInputNumberFormItem-mv7hvnm .ant-form-item-explain{
position: absolute;
top: 100%;
z-index: -1;
}
.webVueAntYtInputNumberFormItem-mv7hvnm .ant-form-item-label label{
width: 109px;
padding-right: 10px;
}
.webVueAntYtInputNumberStyle-mv54x66{
background: #FFFFFF !important;
}

.webVueAntYtRectangleStyle-mvl95ud{
background: #1890FF;
border-top: 1px solid transparent;
border-right: 1px solid transparent;
border-bottom: 1px solid transparent;
border-left: 1px solid transparent;
}

.webVueAntYtSpanStyle-mvsjttp{
color: #3D3D3D !important;
font-weight: bold;
}
.webVueAntYtSpanStyle-mvsjttp span{
text-decoration: none;
}

.webVueAntYtRadioStyle-mv0d1n5{
color: #333333;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
}
.webVueAntYtRadioStyle-mv0d1n5 .ant-radio-wrapper span{
color: #333333;
font-size: 14px;
font-weight: Normal;
}
.webVueAntYtRadioStyle-mv0d1n5 .ant-radio-wrapper:not(:last-child){
margin-right: 14px;
}
.webVueAntYtRadioStyle-mv0d1n5 .ant-radio-inner{
border-color: #CBCBCB;
}
.webVueAntYtRadioStyle-mv0d1n5 .ant-radio-wrapper-checked span{
color: #333333;
}
.webVueAntYtRadioStyle-mv0d1n5 .ant-radio-wrapper-checked .ant-radio-inner{
border-color: #3F82F9;
}
.webVueAntYtRadioStyle-mv0d1n5 .ant-radio-wrapper-checked .ant-radio-inner:after{
background-color: #3F82F9;
}
.webVueAntYtRadioFormItem-mvqr1gs .ant-form-item-label label{
width: 80px;
padding-right: 10px;
}
.webVueAntYtRadioFormItem-mvqr1gs{
opacity: 1;
}


.webVueAntYtInputFormItem-mv574wn .ant-form-item-explain{
position: absolute;
top: 100%;
z-index: -1;
}
.webVueAntYtInputFormItem-mv574wn .ant-form-item-label label{
width: 80px;
padding-right: 10px;
}
.webVueAntYtInputStyle-mv192xe:not(.ant-input-affix-wrapper){
background: #FFFFFF !important;
}

.webVueAntYtInputFormItem-mv11hh8 .ant-form-item-explain{
position: absolute;
top: 100%;
z-index: -1;
}
.webVueAntYtInputFormItem-mv11hh8 .ant-form-item-label label{
width: 80px;
padding-right: 10px;
}
.webVueAntYtInputFormItem-mv11hh8 .ant-form-item-label label .label-content{
text-align: right;
text-align-last: right;
}
.webVueAntYtInputStyle-mvtnx1d:not(.ant-input-affix-wrapper){
background: #FFFFFF !important;
}

.webVueAntYtInputFormItem-mv1kfro .ant-form-item-explain{
position: absolute;
top: 100%;
z-index: -1;
}
.webVueAntYtInputFormItem-mv1kfro .ant-form-item-label label{
width: 94px;
padding-right: 10px;
}
.webVueAntYtInputStyle-mvkt1uk:not(.ant-input-affix-wrapper){
background: #FFFFFF !important;
}

.webVueAntYtInputFormItem-mvplypw .ant-form-item-explain{
position: absolute;
top: 100%;
z-index: -1;
}
.webVueAntYtInputFormItem-mvplypw .ant-form-item-label label{
width: 80px;
padding-right: 10px;
}
.webVueAntYtInputStyle-mvdm6nr:not(.ant-input-affix-wrapper){
background: #FFFFFF !important;
}

.webVueAntYtRectangleStyle-mvr26q7{
background: #1890FF;
border-top: 1px solid transparent;
border-right: 1px solid transparent;
border-bottom: 1px solid transparent;
border-left: 1px solid transparent;
}

.webVueAntYtSpanStyle-mv3qypt{
color: #3D3D3D !important;
font-weight: bold;
}
.webVueAntYtSpanStyle-mv3qypt span{
text-decoration: none;
}

.webVueAntYtRectangleStyle-mvl19ks{
background: #1890FF;
border-top: 1px solid transparent;
border-right: 1px solid transparent;
border-bottom: 1px solid transparent;
border-left: 1px solid transparent;
}

.webVueAntYtSpanStyle-mvmlfun{
color: #3D3D3D !important;
font-weight: bold;
}
.webVueAntYtSpanStyle-mvmlfun span{
text-decoration: none;
}

.webVueAntYtInputFormItem-mvdsv3q .ant-form-item-explain{
position: absolute;
top: 100%;
z-index: -1;
}
.webVueAntYtInputFormItem-mvdsv3q .ant-form-item-label label{
width: 80px;
padding-right: 10px;
}
.webVueAntYtInputFormItem-mvdsv3q .ant-form-item-label label .label-content{
text-align: right;
text-align-last: right;
}
.webVueAntYtInputStyle-mv5xzoz:not(.ant-input-affix-wrapper){
background: #FFFFFF !important;
}

.webVueAntYtInputFormItem-mvilfao .ant-form-item-explain{
position: absolute;
top: 100%;
z-index: -1;
}
.webVueAntYtInputFormItem-mvilfao .ant-form-item-label label{
width: 80px;
padding-right: 10px;
}
.webVueAntYtInputFormItem-mvilfao .ant-form-item-label label .label-content{
text-align: right;
text-align-last: right;
}
.webVueAntYtInputStyle-mv5zmqp:not(.ant-input-affix-wrapper){
background: #FFFFFF !important;
}

.webVueAntYtInputFormItem-mvy3a0f .ant-form-item-explain{
position: absolute;
top: 100%;
z-index: -1;
}
.webVueAntYtInputFormItem-mvy3a0f .ant-form-item-label label{
width: 80px;
padding-right: 10px;
}
.webVueAntYtInputFormItem-mvy3a0f .ant-form-item-label label .label-content{
text-align: right;
text-align-last: right;
}
.webVueAntYtInputStyle-mvexmn9:not(.ant-input-affix-wrapper){
background: #FFFFFF !important;
}

.webVueAntYtRectangleStyle-mvimola{
background: #1890FF;
border-top: 1px solid transparent;
border-right: 1px solid transparent;
border-bottom: 1px solid transparent;
border-left: 1px solid transparent;
}

.webVueAntYtSpanStyle-mvqpatf{
color: #3D3D3D !important;
font-weight: bold;
}
.webVueAntYtSpanStyle-mvqpatf span{
text-decoration: none;
}

.webVueAntYtTableStyle-mve4v2w{
opacity: 1;
}
.webVueAntYtTableStyle-mve4v2w .ant-table{
box-shadow: 0px 0px 0px 0px transparent;
border-top-left-radius: 4px;
border-top-right-radius: 4px;
border-bottom-left-radius: 4px;
border-bottom-right-radius: 4px;
border-top: 1px solid #D9D9D9;
border-right: 1px solid #D9D9D9;
border-bottom: 1px solid #D9D9D9;
border-left: 1px solid #D9D9D9;
}
.webVueAntYtTableStyle-mve4v2w .ant-table th:first-child{
border-top-left-radius: 4px !important;
}
.webVueAntYtTableStyle-mve4v2w .ant-table th:last-child{
border-top-right-radius: 4px !important;
}
.webVueAntYtTableStyle-mve4v2w .ant-table tr:last-child td:first-child{
border-bottom-left-radius: 4px !important;
}
.webVueAntYtTableStyle-mve4v2w .ant-table tr:last-child td:last-child{
border-bottom-right-radius: 4px !important;
}
.webVueAntYtTableStyle-mve4v2w .ant-table .ant-table-thead tr,.webVueAntYtTableStyle-mve4v2w .ant-table .ant-table-thead tr th div:first-child{
height: 40px;
}
.webVueAntYtTableStyle-mve4v2w .ant-table .ant-table-thead tr th div.ant-table-selection{
line-height: 40px;
}
.webVueAntYtTableStyle-mve4v2w .ant-table .ant-table-thead tr th{
background: #F6F6F6;
}
.webVueAntYtTableStyle-mve4v2w .ant-table .ant-table-thead tr span.th-text{
color: #000000A6;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
line-height: 50px;
letter-spacing: 0px;
font-style: normal;
text-align: center;
text-align-last: center;
text-decoration: none;
padding-top: 0px;
padding-right: 0px;
padding-bottom: 0px;
padding-left: 0px;
}
.webVueAntYtTableStyle-mve4v2w .ant-table tbody tr td{
height: 40px;
}
.webVueAntYtTableStyle-mve4v2w .ant-table tbody tr td .ant-checkbox-wrapper{
line-height: 40px;
}
.webVueAntYtTableStyle-mve4v2w .ant-table tbody tr td{
background: #FFFFFF;
}
.webVueAntYtTableStyle-mve4v2w .ant-table thead tr th,.webVueAntYtTableStyle-mve4v2w .ant-table .ant-table-tbody tr:not(:last-child) td{
border-bottom: 1px solid #dcdcdc;
}
.webVueAntYtTableStyle-mve4v2w .ant-table thead tr th:not(:last-child),.webVueAntYtTableStyle-mve4v2w .ant-table .ant-table-tbody tr td:not(:last-child){
border-right: 1px solid #dcdcdc;
}
.webVueAntYtTableStyle-mve4v2w.ant-table-striped .ant-table tbody tr:nth-child(2n-1) td{
background: #FFFFFF;
}
.webVueAntYtTableStyle-mve4v2w.ant-table-striped .ant-table tbody tr:nth-child(2n) td{
background: #FFFFFF;
}
.webVueAntYtTableStyle-mve4v2w .ant-table tbody tr:not(.ant-table-row-selected):hover td{
background: #E4EFFF !important;
}
.webVueAntYtTableStyle-mve4v2w .ant-table tbody tr:not(.ant-table-row-selected):hover td span.td-text{
color: #000000 !important;
}
.webVueAntYtTableStyle-mve4v2w .ant-table-tbody tr.ant-table-row-selected td{
background: #3C8EFF !important;
}
.webVueAntYtTableStyle-mve4v2w .ant-table-tbody tr.ant-table-row-selected td span.td-text{
color: #FFFFFF !important;
}
.webVueAntYtTableStyle-mve4v2w .ant-pagination li:not(.ant-pagination-options),.webVueAntYtTableStyle-mve4v2w .ant-pagination button,.webVueAntYtTableStyle-mve4v2w .ant-pagination li .ant-select .ant-select-selector,.webVueAntYtTableStyle-mve4v2w .ant-pagination li input{
border-top-left-radius: 4px;
border-top-right-radius: 4px;
border-bottom-left-radius: 4px;
border-bottom-right-radius: 4px;
background: #FFFFFF;
color: #000000A6;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
line-height: 32px;
letter-spacing: 0px;
text-align: center;
text-align-last: center;
font-style: normal;
text-decoration: none;
}
.webVueAntYtTableStyle-mve4v2w .ant-pagination button,.webVueAntYtTableStyle-mve4v2w .ant-pagination li .ant-select .ant-select-selector,.webVueAntYtTableStyle-mve4v2w .ant-pagination li input,.webVueAntYtTableStyle-mve4v2w .ant-pagination li a,.webVueAntYtTableStyle-mve4v2w .ant-pagination li .ant-pagination-options-quick-jumper{
padding-top: 0px;
padding-right: 0px;
padding-bottom: 0px;
padding-left: 0px;
}
.webVueAntYtTableStyle-mve4v2w .ant-pagination li:not(.ant-pagination-options),.webVueAntYtTableStyle-mve4v2w .ant-pagination li.ant-pagination-options .ant-pagination-options-size-changer.ant-select .ant-select-selector,.webVueAntYtTableStyle-mve4v2w .ant-pagination li.ant-pagination-options .ant-pagination-options-quick-jumper input{
border-top: 1px solid #D9D9D9;
border-right: 1px solid #D9D9D9;
border-bottom: 1px solid #D9D9D9;
border-left: 1px solid #D9D9D9;
}
.webVueAntYtTableStyle-mve4v2w .ant-pagination li button{
border: none;
}
.webVueAntYtTableStyle-mve4v2w .ant-pagination li a,.webVueAntYtTableStyle-mve4v2w .ant-pagination li .ant-pagination-options-quick-jumper{
color: #000000A6;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
line-height: 32px;
letter-spacing: 0px;
text-align: center;
text-align-last: center;
font-style: normal;
text-decoration: none;
}
.webVueAntYtTableStyle-mve4v2w .ant-pagination li.ant-pagination-item-active{
background: #FFFFFF;
border-top: 1px solid #1890ff;
border-right: 1px solid #1890ff;
border-bottom: 1px solid #1890ff;
border-left: 1px solid #1890ff;
}
.webVueAntYtTableStyle-mve4v2w .ant-pagination li.ant-pagination-item-active a{
color: #1890ff;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
line-height: 32px;
letter-spacing: 0px;
text-align: center;
text-align-last: center;
font-style: normal;
text-decoration: none;
}
.webVueAntYtTableStyle-mve4v2w tr td:nth-child(1) div:first-child{
text-align: center;
text-align-last: center;
padding-top: 0px;
padding-right: 0px;
padding-bottom: 0px;
padding-left: 0px;
}
.webVueAntYtTableStyle-mve4v2w tr td:nth-child(1) div:first-child span.td-text{
color: #000000A6;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
line-height: 50px;
letter-spacing: 0px;
text-decoration: none;
font-style: normal;
}
.webVueAntYtTableStyle-mve4v2w tr > th:nth-child(1), .webVueAntYtTableStyle-mve4v2w .ant-table-body tr.ant-table-measure-row td:nth-child(1){
width: 40px !important;
min-width: 40px !important;
max-width: 40px !important;
}
.webVueAntYtTableStyle-mve4v2w tr td:nth-child(2) div:first-child{
text-align: center;
text-align-last: center;
padding-top: 0px;
padding-right: 0px;
padding-bottom: 0px;
padding-left: 0px;
}
.webVueAntYtTableStyle-mve4v2w tr td:nth-child(2) div:first-child span.td-text{
color: #000000A6;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
line-height: 50px;
letter-spacing: 0px;
text-decoration: none;
font-style: normal;
}
.webVueAntYtTableStyle-mve4v2w tr > th:nth-child(2), .webVueAntYtTableStyle-mve4v2w .ant-table-body tr.ant-table-measure-row td:nth-child(2){
width: calc((100% - 120px) / 3) !important;
min-width: 1px !important;
max-width: 1px !important;
}
.webVueAntYtTableStyle-mve4v2w tr td:nth-child(3) div:first-child{
text-align: center;
text-align-last: center;
padding-top: 0px;
padding-right: 0px;
padding-bottom: 0px;
padding-left: 0px;
}
.webVueAntYtTableStyle-mve4v2w tr td:nth-child(3) div:first-child span.td-text{
color: #000000A6;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
line-height: 50px;
letter-spacing: 0px;
text-decoration: none;
font-style: normal;
}
.webVueAntYtTableStyle-mve4v2w tr > th:nth-child(3), .webVueAntYtTableStyle-mve4v2w .ant-table-body tr.ant-table-measure-row td:nth-child(3){
width: calc((100% - 120px) / 3) !important;
min-width: 1px !important;
max-width: 1px !important;
}
.webVueAntYtTableStyle-mve4v2w tr td:nth-child(4) div:first-child{
text-align: center;
text-align-last: center;
padding-top: 0px;
padding-right: 0px;
padding-bottom: 0px;
padding-left: 0px;
}
.webVueAntYtTableStyle-mve4v2w tr td:nth-child(4) div:first-child span.td-text{
color: #000000A6;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
line-height: 50px;
letter-spacing: 0px;
text-decoration: none;
font-style: normal;
}
.webVueAntYtTableStyle-mve4v2w tr > th:nth-child(4), .webVueAntYtTableStyle-mve4v2w .ant-table-body tr.ant-table-measure-row td:nth-child(4){
width: calc((100% - 120px) / 3) !important;
min-width: 1px !important;
max-width: 1px !important;
}
.webVueAntYtTableStyle-mve4v2w tr td:nth-child(5) div:first-child{
text-align: center;
text-align-last: center;
padding-top: 0px;
padding-right: 0px;
padding-bottom: 0px;
padding-left: 0px;
}
.webVueAntYtTableStyle-mve4v2w tr td:nth-child(5) div:first-child span.td-text{
color: #000000A6;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
line-height: 50px;
letter-spacing: 0px;
text-decoration: none;
font-style: normal;
}
.webVueAntYtTableStyle-mve4v2w tr > th:nth-child(5), .webVueAntYtTableStyle-mve4v2w .ant-table-body tr.ant-table-measure-row td:nth-child(5){
width: 80px !important;
min-width: 80px !important;
max-width: 80px !important;
}
.webVueAntYtTableStyle-mve4v2w{
width: 100%;
}

.webVueAntYtInputFormItem-mvmifwx .ant-form-item-explain{
position: absolute;
top: 100%;
z-index: -1;
}
.webVueAntYtInputFormItem-mvmifwx .ant-form-item-label label{
width: 80px;
padding-right: 10px;
}
.webVueAntYtInputFormItem-mvmifwx .ant-form-item-label label .label-content{
text-align: right;
text-align-last: right;
}
.webVueAntYtInputStyle-mvimnny:not(.ant-input-affix-wrapper){
background: #FFFFFF !important;
}

.webVueAntYtDatePickerFormItem-mv2kar5 .ant-form-item-explain{
position: absolute;
top: 100%;
z-index: -1;
}
.webVueAntYtDatePickerFormItem-mv2kar5 .ant-form-item-label label{
width: 80px;
padding-right: 10px;
}
.webVueAntYtDatePickerStyle-mvkc68n{
background: #FFFFFF!important;
border-top: 1px solid #CDCDCD !important;
border-right: 1px solid #CDCDCD !important;
border-bottom: 1px solid #CDCDCD !important;
border-left: 1px solid #CDCDCD !important;
}
.webVueAntYtDatePickerStyle-mvkc68n.ant-picker-focused,.webVueAntYtDatePickerStyle-mvkc68n.ant-picker:hover{
border-right: 1px solid #CDCDCD!important;
}

.webVueAntYtRangePickerFormItem-mvhsymb .ant-form-item-explain{
position: absolute;
top: 100%;
z-index: -1;
}
.webVueAntYtRangePickerFormItem-mvhsymb .ant-form-item-label label{
width: 80px;
padding-top: 0px;
padding-right: 10px;
padding-bottom: 0px;
}
.webVueAntYtRangePickerFormItem-mvhsymb .ant-form-item-label label .label-content{
text-align: right;
text-align-last: right;
}
.webVueAntYtRangePickerStyle-mvv4urt.ant-picker-focused,.webVueAntYtRangePickerStyle-mvv4urt.ant-picker:hover{
border-right: 1px solid #CDCDCD!important;
}


.webVueAntYtTableStyle-mvbmd4x{
opacity: 1;
}
.webVueAntYtTableStyle-mvbmd4x .ant-table{
box-shadow: 0px 0px 0px 0px transparent;
border-top-left-radius: 4px;
border-top-right-radius: 4px;
border-bottom-left-radius: 4px;
border-bottom-right-radius: 4px;
border-top: 1px solid #D9D9D9;
border-right: 1px solid #D9D9D9;
border-bottom: 1px solid #D9D9D9;
border-left: 1px solid #D9D9D9;
}
.webVueAntYtTableStyle-mvbmd4x .ant-table th:first-child{
border-top-left-radius: 4px !important;
}
.webVueAntYtTableStyle-mvbmd4x .ant-table th:last-child{
border-top-right-radius: 4px !important;
}
.webVueAntYtTableStyle-mvbmd4x .ant-table tr:last-child td:first-child{
border-bottom-left-radius: 4px !important;
}
.webVueAntYtTableStyle-mvbmd4x .ant-table tr:last-child td:last-child{
border-bottom-right-radius: 4px !important;
}
.webVueAntYtTableStyle-mvbmd4x .ant-table .ant-table-thead tr,.webVueAntYtTableStyle-mvbmd4x .ant-table .ant-table-thead tr th div:first-child{
height: 40px;
}
.webVueAntYtTableStyle-mvbmd4x .ant-table .ant-table-thead tr th div.ant-table-selection{
line-height: 40px;
}
.webVueAntYtTableStyle-mvbmd4x .ant-table .ant-table-thead tr th{
background: #F6F6F6;
}
.webVueAntYtTableStyle-mvbmd4x .ant-table .ant-table-thead tr span.th-text{
color: #000000A6;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
line-height: 50px;
letter-spacing: 0px;
font-style: normal;
text-align: center;
text-align-last: center;
text-decoration: none;
padding-top: 0px;
padding-right: 0px;
padding-bottom: 0px;
padding-left: 0px;
}
.webVueAntYtTableStyle-mvbmd4x .ant-table tbody tr td{
height: 40px;
}
.webVueAntYtTableStyle-mvbmd4x .ant-table tbody tr td .ant-checkbox-wrapper{
line-height: 40px;
}
.webVueAntYtTableStyle-mvbmd4x .ant-table tbody tr td{
background: #FFFFFF;
}
.webVueAntYtTableStyle-mvbmd4x .ant-table thead tr th,.webVueAntYtTableStyle-mvbmd4x .ant-table .ant-table-tbody tr:not(:last-child) td{
border-bottom: 1px solid #dcdcdc;
}
.webVueAntYtTableStyle-mvbmd4x .ant-table thead tr th:not(:last-child),.webVueAntYtTableStyle-mvbmd4x .ant-table .ant-table-tbody tr td:not(:last-child){
border-right: 1px solid #dcdcdc;
}
.webVueAntYtTableStyle-mvbmd4x.ant-table-striped .ant-table tbody tr:nth-child(2n-1) td{
background: #FFFFFF;
}
.webVueAntYtTableStyle-mvbmd4x.ant-table-striped .ant-table tbody tr:nth-child(2n) td{
background: #FFFFFF;
}
.webVueAntYtTableStyle-mvbmd4x .ant-table tbody tr:not(.ant-table-row-selected):hover td{
background: #E4EFFF !important;
}
.webVueAntYtTableStyle-mvbmd4x .ant-table tbody tr:not(.ant-table-row-selected):hover td span.td-text{
color: #000000 !important;
}
.webVueAntYtTableStyle-mvbmd4x .ant-table-tbody tr.ant-table-row-selected td{
background: #3C8EFF !important;
}
.webVueAntYtTableStyle-mvbmd4x .ant-table-tbody tr.ant-table-row-selected td span.td-text{
color: #FFFFFF !important;
}
.webVueAntYtTableStyle-mvbmd4x .ant-pagination li:not(.ant-pagination-options),.webVueAntYtTableStyle-mvbmd4x .ant-pagination button,.webVueAntYtTableStyle-mvbmd4x .ant-pagination li .ant-select .ant-select-selector,.webVueAntYtTableStyle-mvbmd4x .ant-pagination li input{
border-top-left-radius: 4px;
border-top-right-radius: 4px;
border-bottom-left-radius: 4px;
border-bottom-right-radius: 4px;
background: #FFFFFF;
color: #000000A6;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
line-height: 32px;
letter-spacing: 0px;
text-align: center;
text-align-last: center;
font-style: normal;
text-decoration: none;
}
.webVueAntYtTableStyle-mvbmd4x .ant-pagination button,.webVueAntYtTableStyle-mvbmd4x .ant-pagination li .ant-select .ant-select-selector,.webVueAntYtTableStyle-mvbmd4x .ant-pagination li input,.webVueAntYtTableStyle-mvbmd4x .ant-pagination li a,.webVueAntYtTableStyle-mvbmd4x .ant-pagination li .ant-pagination-options-quick-jumper{
padding-top: 0px;
padding-right: 0px;
padding-bottom: 0px;
padding-left: 0px;
}
.webVueAntYtTableStyle-mvbmd4x .ant-pagination li:not(.ant-pagination-options),.webVueAntYtTableStyle-mvbmd4x .ant-pagination li.ant-pagination-options .ant-pagination-options-size-changer.ant-select .ant-select-selector,.webVueAntYtTableStyle-mvbmd4x .ant-pagination li.ant-pagination-options .ant-pagination-options-quick-jumper input{
border-top: 1px solid #D9D9D9;
border-right: 1px solid #D9D9D9;
border-bottom: 1px solid #D9D9D9;
border-left: 1px solid #D9D9D9;
}
.webVueAntYtTableStyle-mvbmd4x .ant-pagination li button{
border: none;
}
.webVueAntYtTableStyle-mvbmd4x .ant-pagination li a,.webVueAntYtTableStyle-mvbmd4x .ant-pagination li .ant-pagination-options-quick-jumper{
color: #000000A6;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
line-height: 32px;
letter-spacing: 0px;
text-align: center;
text-align-last: center;
font-style: normal;
text-decoration: none;
}
.webVueAntYtTableStyle-mvbmd4x .ant-pagination li.ant-pagination-item-active{
background: #FFFFFF;
border-top: 1px solid #1890ff;
border-right: 1px solid #1890ff;
border-bottom: 1px solid #1890ff;
border-left: 1px solid #1890ff;
}
.webVueAntYtTableStyle-mvbmd4x .ant-pagination li.ant-pagination-item-active a{
color: #1890ff;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
line-height: 32px;
letter-spacing: 0px;
text-align: center;
text-align-last: center;
font-style: normal;
text-decoration: none;
}
.webVueAntYtTableStyle-mvbmd4x tr td:nth-child(1) div:first-child{
text-align: center;
text-align-last: center;
padding-top: 0px;
padding-right: 0px;
padding-bottom: 0px;
padding-left: 0px;
}
.webVueAntYtTableStyle-mvbmd4x tr td:nth-child(1) div:first-child span.td-text{
color: #000000A6;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
line-height: 50px;
letter-spacing: 0px;
text-decoration: none;
font-style: normal;
}
.webVueAntYtTableStyle-mvbmd4x tr > th:nth-child(1), .webVueAntYtTableStyle-mvbmd4x .ant-table-body tr.ant-table-measure-row td:nth-child(1){
width: 40px !important;
min-width: 40px !important;
max-width: 40px !important;
}
.webVueAntYtTableStyle-mvbmd4x tr td:nth-child(2) div:first-child{
text-align: center;
text-align-last: center;
padding-top: 0px;
padding-right: 0px;
padding-bottom: 0px;
padding-left: 0px;
}
.webVueAntYtTableStyle-mvbmd4x tr td:nth-child(2) div:first-child span.td-text{
color: #000000A6;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
line-height: 50px;
letter-spacing: 0px;
text-decoration: none;
font-style: normal;
}
.webVueAntYtTableStyle-mvbmd4x tr > th:nth-child(2), .webVueAntYtTableStyle-mvbmd4x .ant-table-body tr.ant-table-measure-row td:nth-child(2){
width: calc((100% - 120px) / 6) !important;
min-width: 1px !important;
max-width: 1px !important;
}
.webVueAntYtTableStyle-mvbmd4x tr td:nth-child(3) div:first-child{
text-align: center;
text-align-last: center;
padding-top: 0px;
padding-right: 0px;
padding-bottom: 0px;
padding-left: 0px;
}
.webVueAntYtTableStyle-mvbmd4x tr td:nth-child(3) div:first-child span.td-text{
color: #000000A6;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
line-height: 50px;
letter-spacing: 0px;
text-decoration: none;
font-style: normal;
}
.webVueAntYtTableStyle-mvbmd4x tr > th:nth-child(3), .webVueAntYtTableStyle-mvbmd4x .ant-table-body tr.ant-table-measure-row td:nth-child(3){
width: calc((100% - 120px) / 6) !important;
min-width: 1px !important;
max-width: 1px !important;
}
.webVueAntYtTableStyle-mvbmd4x tr td:nth-child(4) div:first-child{
text-align: center;
text-align-last: center;
padding-top: 0px;
padding-right: 0px;
padding-bottom: 0px;
padding-left: 0px;
}
.webVueAntYtTableStyle-mvbmd4x tr td:nth-child(4) div:first-child span.td-text{
color: #000000A6;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
line-height: 50px;
letter-spacing: 0px;
text-decoration: none;
font-style: normal;
}
.webVueAntYtTableStyle-mvbmd4x tr > th:nth-child(4), .webVueAntYtTableStyle-mvbmd4x .ant-table-body tr.ant-table-measure-row td:nth-child(4){
width: calc((100% - 120px) / 6) !important;
min-width: 1px !important;
max-width: 1px !important;
}
.webVueAntYtTableStyle-mvbmd4x tr td:nth-child(5) div:first-child{
text-align: center;
text-align-last: center;
padding-top: 0px;
padding-right: 0px;
padding-bottom: 0px;
padding-left: 0px;
}
.webVueAntYtTableStyle-mvbmd4x tr td:nth-child(5) div:first-child span.td-text{
color: #000000A6;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
line-height: 50px;
letter-spacing: 0px;
text-decoration: none;
font-style: normal;
}
.webVueAntYtTableStyle-mvbmd4x tr > th:nth-child(5), .webVueAntYtTableStyle-mvbmd4x .ant-table-body tr.ant-table-measure-row td:nth-child(5){
width: calc((100% - 120px) / 6) !important;
min-width: 1px !important;
max-width: 1px !important;
}
.webVueAntYtTableStyle-mvbmd4x tr td:nth-child(6) div:first-child{
text-align: center;
text-align-last: center;
padding-top: 0px;
padding-right: 0px;
padding-bottom: 0px;
padding-left: 0px;
}
.webVueAntYtTableStyle-mvbmd4x tr td:nth-child(6) div:first-child span.td-text{
color: #000000A6;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
line-height: 50px;
letter-spacing: 0px;
text-decoration: none;
font-style: normal;
}
.webVueAntYtTableStyle-mvbmd4x tr > th:nth-child(6), .webVueAntYtTableStyle-mvbmd4x .ant-table-body tr.ant-table-measure-row td:nth-child(6){
width: calc((100% - 120px) / 6) !important;
min-width: 1px !important;
max-width: 1px !important;
}
.webVueAntYtTableStyle-mvbmd4x tr td:nth-child(7) div:first-child{
text-align: center;
text-align-last: center;
padding-top: 0px;
padding-right: 0px;
padding-bottom: 0px;
padding-left: 0px;
}
.webVueAntYtTableStyle-mvbmd4x tr td:nth-child(7) div:first-child span.td-text{
color: #000000A6;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
line-height: 50px;
letter-spacing: 0px;
text-decoration: none;
font-style: normal;
}
.webVueAntYtTableStyle-mvbmd4x tr > th:nth-child(7), .webVueAntYtTableStyle-mvbmd4x .ant-table-body tr.ant-table-measure-row td:nth-child(7){
width: calc((100% - 120px) / 6) !important;
min-width: 1px !important;
max-width: 1px !important;
}
.webVueAntYtTableStyle-mvbmd4x tr td:nth-child(8) div:first-child{
text-align: center;
text-align-last: center;
padding-top: 0px;
padding-right: 0px;
padding-bottom: 0px;
padding-left: 0px;
}
.webVueAntYtTableStyle-mvbmd4x tr td:nth-child(8) div:first-child span.td-text{
color: #000000A6;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
line-height: 50px;
letter-spacing: 0px;
text-decoration: none;
font-style: normal;
}
.webVueAntYtTableStyle-mvbmd4x tr > th:nth-child(8), .webVueAntYtTableStyle-mvbmd4x .ant-table-body tr.ant-table-measure-row td:nth-child(8){
width: 80px !important;
min-width: 80px !important;
max-width: 80px !important;
}
.webVueAntYtTableStyle-mvbmd4x{
width: 100%;
}

.webVueAntYtRectangleStyle-mv4t6e2{
background: #1890FF;
border-top: 1px solid transparent;
border-right: 1px solid transparent;
border-bottom: 1px solid transparent;
border-left: 1px solid transparent;
}

.webVueAntYtSpanStyle-mvi5pwc{
color: #3D3D3D !important;
font-weight: bold;
}
.webVueAntYtSpanStyle-mvi5pwc span{
text-decoration: none;
}


.webVueAntYtTableStyle-mv2forp{
opacity: 1;
}
.webVueAntYtTableStyle-mv2forp .ant-table{
box-shadow: 0px 0px 0px 0px transparent;
border-top-left-radius: 4px;
border-top-right-radius: 4px;
border-bottom-left-radius: 4px;
border-bottom-right-radius: 4px;
border-top: 1px solid #D9D9D9;
border-right: 1px solid #D9D9D9;
border-bottom: 1px solid #D9D9D9;
border-left: 1px solid #D9D9D9;
}
.webVueAntYtTableStyle-mv2forp .ant-table th:first-child{
border-top-left-radius: 4px !important;
}
.webVueAntYtTableStyle-mv2forp .ant-table th:last-child{
border-top-right-radius: 4px !important;
}
.webVueAntYtTableStyle-mv2forp .ant-table tr:last-child td:first-child{
border-bottom-left-radius: 4px !important;
}
.webVueAntYtTableStyle-mv2forp .ant-table tr:last-child td:last-child{
border-bottom-right-radius: 4px !important;
}
.webVueAntYtTableStyle-mv2forp .ant-table .ant-table-thead tr,.webVueAntYtTableStyle-mv2forp .ant-table .ant-table-thead tr th div:first-child{
height: 40px;
}
.webVueAntYtTableStyle-mv2forp .ant-table .ant-table-thead tr th div.ant-table-selection{
line-height: 40px;
}
.webVueAntYtTableStyle-mv2forp .ant-table .ant-table-thead tr th{
background: #F6F6F6;
}
.webVueAntYtTableStyle-mv2forp .ant-table .ant-table-thead tr span.th-text{
color: #000000A6;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
line-height: 50px;
letter-spacing: 0px;
font-style: normal;
text-align: center;
text-align-last: center;
text-decoration: none;
padding-top: 0px;
padding-right: 0px;
padding-bottom: 0px;
padding-left: 0px;
}
.webVueAntYtTableStyle-mv2forp .ant-table tbody tr td{
height: 40px;
}
.webVueAntYtTableStyle-mv2forp .ant-table tbody tr td .ant-checkbox-wrapper{
line-height: 40px;
}
.webVueAntYtTableStyle-mv2forp .ant-table tbody tr td{
background: #FFFFFF;
}
.webVueAntYtTableStyle-mv2forp .ant-table thead tr th,.webVueAntYtTableStyle-mv2forp .ant-table .ant-table-tbody tr:not(:last-child) td{
border-bottom: 1px solid #dcdcdc;
}
.webVueAntYtTableStyle-mv2forp .ant-table thead tr th:not(:last-child),.webVueAntYtTableStyle-mv2forp .ant-table .ant-table-tbody tr td:not(:last-child){
border-right: 1px solid #dcdcdc;
}
.webVueAntYtTableStyle-mv2forp.ant-table-striped .ant-table tbody tr:nth-child(2n-1) td{
background: #FFFFFF;
}
.webVueAntYtTableStyle-mv2forp.ant-table-striped .ant-table tbody tr:nth-child(2n) td{
background: #FFFFFF;
}
.webVueAntYtTableStyle-mv2forp .ant-table tbody tr:not(.ant-table-row-selected):hover td{
background: #E4EFFF !important;
}
.webVueAntYtTableStyle-mv2forp .ant-table tbody tr:not(.ant-table-row-selected):hover td span.td-text{
color: #000000 !important;
}
.webVueAntYtTableStyle-mv2forp .ant-table-tbody tr.ant-table-row-selected td{
background: #3C8EFF !important;
}
.webVueAntYtTableStyle-mv2forp .ant-table-tbody tr.ant-table-row-selected td span.td-text{
color: #FFFFFF !important;
}
.webVueAntYtTableStyle-mv2forp .ant-pagination li:not(.ant-pagination-options),.webVueAntYtTableStyle-mv2forp .ant-pagination button,.webVueAntYtTableStyle-mv2forp .ant-pagination li .ant-select .ant-select-selector,.webVueAntYtTableStyle-mv2forp .ant-pagination li input{
border-top-left-radius: 4px;
border-top-right-radius: 4px;
border-bottom-left-radius: 4px;
border-bottom-right-radius: 4px;
background: #FFFFFF;
color: #000000A6;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
line-height: 32px;
letter-spacing: 0px;
text-align: center;
text-align-last: center;
font-style: normal;
text-decoration: none;
}
.webVueAntYtTableStyle-mv2forp .ant-pagination button,.webVueAntYtTableStyle-mv2forp .ant-pagination li .ant-select .ant-select-selector,.webVueAntYtTableStyle-mv2forp .ant-pagination li input,.webVueAntYtTableStyle-mv2forp .ant-pagination li a,.webVueAntYtTableStyle-mv2forp .ant-pagination li .ant-pagination-options-quick-jumper{
padding-top: 0px;
padding-right: 0px;
padding-bottom: 0px;
padding-left: 0px;
}
.webVueAntYtTableStyle-mv2forp .ant-pagination li:not(.ant-pagination-options),.webVueAntYtTableStyle-mv2forp .ant-pagination li.ant-pagination-options .ant-pagination-options-size-changer.ant-select .ant-select-selector,.webVueAntYtTableStyle-mv2forp .ant-pagination li.ant-pagination-options .ant-pagination-options-quick-jumper input{
border-top: 1px solid #D9D9D9;
border-right: 1px solid #D9D9D9;
border-bottom: 1px solid #D9D9D9;
border-left: 1px solid #D9D9D9;
}
.webVueAntYtTableStyle-mv2forp .ant-pagination li button{
border: none;
}
.webVueAntYtTableStyle-mv2forp .ant-pagination li a,.webVueAntYtTableStyle-mv2forp .ant-pagination li .ant-pagination-options-quick-jumper{
color: #000000A6;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
line-height: 32px;
letter-spacing: 0px;
text-align: center;
text-align-last: center;
font-style: normal;
text-decoration: none;
}
.webVueAntYtTableStyle-mv2forp .ant-pagination li.ant-pagination-item-active{
background: #FFFFFF;
border-top: 1px solid #1890ff;
border-right: 1px solid #1890ff;
border-bottom: 1px solid #1890ff;
border-left: 1px solid #1890ff;
}
.webVueAntYtTableStyle-mv2forp .ant-pagination li.ant-pagination-item-active a{
color: #1890ff;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
line-height: 32px;
letter-spacing: 0px;
text-align: center;
text-align-last: center;
font-style: normal;
text-decoration: none;
}
.webVueAntYtTableStyle-mv2forp tr td:nth-child(1) div:first-child{
text-align: center;
text-align-last: center;
padding-top: 0px;
padding-right: 0px;
padding-bottom: 0px;
padding-left: 0px;
}
.webVueAntYtTableStyle-mv2forp tr td:nth-child(1) div:first-child span.td-text{
color: #000000A6;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
line-height: 50px;
letter-spacing: 0px;
text-decoration: none;
font-style: normal;
}
.webVueAntYtTableStyle-mv2forp tr > th:nth-child(1), .webVueAntYtTableStyle-mv2forp .ant-table-body tr.ant-table-measure-row td:nth-child(1){
width: 40px !important;
min-width: 40px !important;
max-width: 40px !important;
}
.webVueAntYtTableStyle-mv2forp tr td:nth-child(2) div:first-child{
text-align: center;
text-align-last: center;
padding-top: 0px;
padding-right: 0px;
padding-bottom: 0px;
padding-left: 0px;
}
.webVueAntYtTableStyle-mv2forp tr td:nth-child(2) div:first-child span.td-text{
color: #000000A6;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
line-height: 50px;
letter-spacing: 0px;
text-decoration: none;
font-style: normal;
}
.webVueAntYtTableStyle-mv2forp tr > th:nth-child(2), .webVueAntYtTableStyle-mv2forp .ant-table-body tr.ant-table-measure-row td:nth-child(2){
width: calc((100% - 130px) / 6) !important;
min-width: 1px !important;
max-width: 1px !important;
}
.webVueAntYtTableStyle-mv2forp tr td:nth-child(3) div:first-child{
text-align: center;
text-align-last: center;
padding-top: 0px;
padding-right: 0px;
padding-bottom: 0px;
padding-left: 0px;
}
.webVueAntYtTableStyle-mv2forp tr td:nth-child(3) div:first-child span.td-text{
color: #000000A6;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
line-height: 50px;
letter-spacing: 0px;
text-decoration: none;
font-style: normal;
}
.webVueAntYtTableStyle-mv2forp tr > th:nth-child(3), .webVueAntYtTableStyle-mv2forp .ant-table-body tr.ant-table-measure-row td:nth-child(3){
width: calc((100% - 130px) / 6) !important;
min-width: 1px !important;
max-width: 1px !important;
}
.webVueAntYtTableStyle-mv2forp tr td:nth-child(4) div:first-child{
text-align: center;
text-align-last: center;
padding-top: 0px;
padding-right: 0px;
padding-bottom: 0px;
padding-left: 0px;
}
.webVueAntYtTableStyle-mv2forp tr td:nth-child(4) div:first-child span.td-text{
color: #000000A6;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
line-height: 50px;
letter-spacing: 0px;
text-decoration: none;
font-style: normal;
}
.webVueAntYtTableStyle-mv2forp tr > th:nth-child(4), .webVueAntYtTableStyle-mv2forp .ant-table-body tr.ant-table-measure-row td:nth-child(4){
width: calc((100% - 130px) / 6) !important;
min-width: 1px !important;
max-width: 1px !important;
}
.webVueAntYtTableStyle-mv2forp tr td:nth-child(5) div:first-child{
text-align: center;
text-align-last: center;
padding-top: 0px;
padding-right: 0px;
padding-bottom: 0px;
padding-left: 0px;
}
.webVueAntYtTableStyle-mv2forp tr td:nth-child(5) div:first-child span.td-text{
color: #000000A6;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
line-height: 50px;
letter-spacing: 0px;
text-decoration: none;
font-style: normal;
}
.webVueAntYtTableStyle-mv2forp tr > th:nth-child(5), .webVueAntYtTableStyle-mv2forp .ant-table-body tr.ant-table-measure-row td:nth-child(5){
width: calc((100% - 130px) / 6) !important;
min-width: 1px !important;
max-width: 1px !important;
}
.webVueAntYtTableStyle-mv2forp tr td:nth-child(6) div:first-child{
text-align: center;
text-align-last: center;
padding-top: 0px;
padding-right: 0px;
padding-bottom: 0px;
padding-left: 0px;
}
.webVueAntYtTableStyle-mv2forp tr td:nth-child(6) div:first-child span.td-text{
color: #000000A6;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
line-height: 50px;
letter-spacing: 0px;
text-decoration: none;
font-style: normal;
}
.webVueAntYtTableStyle-mv2forp tr > th:nth-child(6), .webVueAntYtTableStyle-mv2forp .ant-table-body tr.ant-table-measure-row td:nth-child(6){
width: calc((100% - 130px) / 6) !important;
min-width: 1px !important;
max-width: 1px !important;
}
.webVueAntYtTableStyle-mv2forp tr td:nth-child(7) div:first-child{
text-align: center;
text-align-last: center;
padding-top: 0px;
padding-right: 0px;
padding-bottom: 0px;
padding-left: 0px;
}
.webVueAntYtTableStyle-mv2forp tr td:nth-child(7) div:first-child span.td-text{
color: #000000A6;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
line-height: 50px;
letter-spacing: 0px;
text-decoration: none;
font-style: normal;
}
.webVueAntYtTableStyle-mv2forp tr > th:nth-child(7), .webVueAntYtTableStyle-mv2forp .ant-table-body tr.ant-table-measure-row td:nth-child(7){
width: calc((100% - 130px) / 6) !important;
min-width: 1px !important;
max-width: 1px !important;
}
.webVueAntYtTableStyle-mv2forp tr td:nth-child(8) div:first-child{
text-align: center;
text-align-last: center;
padding-top: 0px;
padding-right: 0px;
padding-bottom: 0px;
padding-left: 0px;
}
.webVueAntYtTableStyle-mv2forp tr td:nth-child(8) div:first-child span.td-text{
color: #000000A6;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
line-height: 50px;
letter-spacing: 0px;
text-decoration: none;
font-style: normal;
}
.webVueAntYtTableStyle-mv2forp tr > th:nth-child(8), .webVueAntYtTableStyle-mv2forp .ant-table-body tr.ant-table-measure-row td:nth-child(8){
width: 90px !important;
min-width: 90px !important;
max-width: 90px !important;
}
.webVueAntYtTableStyle-mv2forp{
width: 100%;
}

.webVueAntYtRectangleStyle-mv232q2{
background: #1890FF;
border-top: 1px solid transparent;
border-right: 1px solid transparent;
border-bottom: 1px solid transparent;
border-left: 1px solid transparent;
}

.webVueAntYtSpanStyle-mvpaslo{
color: #3D3D3D !important;
font-weight: bold;
}
.webVueAntYtSpanStyle-mvpaslo span{
text-decoration: none;
}

.webVueAntYtSelectFormItem-mvvoo80 .ant-form-item-explain{
position: absolute;
top: 100%;
z-index: -1;
}
.webVueAntYtSelectFormItem-mvvoo80 .ant-form-item-label label{
width: 80px;
padding-right: 10px;
}

.webVueAntYtInputFormItem-mv8lagz .ant-form-item-explain{
position: absolute;
top: 100%;
z-index: -1;
}
.webVueAntYtInputFormItem-mv8lagz .ant-form-item-label label{
padding-right: 10px;
}
.webVueAntYtInputFormItem-mv8lagz .ant-form-item-label label .label-content{
text-align: right;
text-align-last: right;
}
.webVueAntYtInputStyle-mve95nu:not(.ant-input-affix-wrapper){
background: #FFFFFF !important;
}

.webVueAntYtInputFormItem-mve38v3 .ant-form-item-explain{
position: absolute;
top: 100%;
z-index: -1;
}
.webVueAntYtInputFormItem-mve38v3 .ant-form-item-label label{
width: 66px;
padding-right: 10px;
}
.webVueAntYtInputFormItem-mve38v3 .ant-form-item-label label .label-content{
text-align: right;
text-align-last: right;
}
.webVueAntYtInputStyle-mv7r26c:not(.ant-input-affix-wrapper){
background: #FFFFFF !important;
}

.webVueAntYtInputFormItem-mve57mk .ant-form-item-explain{
position: absolute;
top: 100%;
z-index: -1;
}
.webVueAntYtInputFormItem-mve57mk .ant-form-item-label label{
width: 66px;
padding-right: 10px;
}
.webVueAntYtInputFormItem-mve57mk .ant-form-item-label label .label-content{
text-align: right;
text-align-last: right;
}
.webVueAntYtInputStyle-mv8thsr:not(.ant-input-affix-wrapper){
background: #FFFFFF !important;
}

.webVueAntYtButtonStyle-mvwz8h5{
color: #1890FF !important;
background: transparent !important;
border-top: 0px solid transparent;
border-right: 0px solid transparent;
border-bottom: 0px solid transparent;
border-left: 0px solid transparent;
align-items: center;
justify-content: center;
}
.webVueAntYtButtonStyle-mvwz8h5>span{
letter-spacing: 0px !important;
}

.webVueAntYtButtonStyle-mvxexez{
color: #F84C55 !important;
background: transparent !important;
border-top: 0px solid transparent;
border-right: 0px solid transparent;
border-bottom: 0px solid transparent;
border-left: 0px solid transparent;
align-items: center;
justify-content: center;
}
.webVueAntYtButtonStyle-mvxexez>span{
letter-spacing: 0px !important;
}

.webVueAntYtSelectFormItem-mvktwxa .ant-form-item-explain{
position: absolute;
top: 100%;
z-index: -1;
}
.webVueAntYtSelectFormItem-mvktwxa .ant-form-item-label label{
width: 80px;
padding-right: 10px;
}

.webVueAntYtButtonStyle-mvxkhfs{
color: #FFFFFF !important;
background: #3C8EFF !important;
align-items: center;
justify-content: center;
}
.webVueAntYtButtonStyle-mvxkhfs>span{
letter-spacing: 0px !important;
}

.webVueAntYtButtonStyle-mv4ai8x{
color: #F84C55 !important;
background: transparent !important;
border-top: 0px solid transparent;
border-right: 0px solid transparent;
border-bottom: 0px solid transparent;
border-left: 0px solid transparent;
align-items: center;
justify-content: center;
}
.webVueAntYtButtonStyle-mv4ai8x>span{
letter-spacing: 0px !important;
}

.webVueAntYtInputFormItem-mvybuua .ant-form-item-explain{
position: absolute;
top: 100%;
z-index: -1;
}
.webVueAntYtInputFormItem-mvybuua .ant-form-item-label label{
padding-right: 10px;
}
.webVueAntYtInputFormItem-mvybuua .ant-form-item-label label .label-content{
text-align: right;
text-align-last: right;
}
.webVueAntYtInputStyle-mvvpncd:not(.ant-input-affix-wrapper){
background: #FFFFFF !important;
}

.webVueAntYtInputFormItem-mv1ry0h .ant-form-item-explain{
position: absolute;
top: 100%;
z-index: -1;
}
.webVueAntYtInputFormItem-mv1ry0h .ant-form-item-label label{
width: 66px;
padding-right: 10px;
}
.webVueAntYtInputFormItem-mv1ry0h .ant-form-item-label label .label-content{
text-align: right;
text-align-last: right;
}
.webVueAntYtInputStyle-mv7g1ns:not(.ant-input-affix-wrapper){
background: #FFFFFF !important;
}

.webVueAntYtInputFormItem-mvtqxos .ant-form-item-explain{
position: absolute;
top: 100%;
z-index: -1;
}
.webVueAntYtInputFormItem-mvtqxos .ant-form-item-label label{
width: 66px;
padding-right: 10px;
}
.webVueAntYtInputFormItem-mvtqxos .ant-form-item-label label .label-content{
text-align: right;
text-align-last: right;
}
.webVueAntYtInputStyle-mvnsaxy:not(.ant-input-affix-wrapper){
background: #FFFFFF !important;
}

.webVueAntYtButtonStyle-mvurnxf{
color: #FFFFFF !important;
background: #3C8EFF !important;
align-items: center;
justify-content: center;
}
.webVueAntYtButtonStyle-mvurnxf>span{
letter-spacing: 0px !important;
}

.webVueAntYtButtonStyle-mvraadk{
color: #F84C55 !important;
background: transparent !important;
border-top: 0px solid transparent;
border-right: 0px solid transparent;
border-bottom: 0px solid transparent;
border-left: 0px solid transparent;
align-items: center;
justify-content: center;
}
.webVueAntYtButtonStyle-mvraadk>span{
letter-spacing: 0px !important;
}

.webVueAntYtButtonStyle-mv0i720{
color: #FFFFFF !important;
background: #3C8EFF !important;
align-items: center;
justify-content: center;
}
.webVueAntYtButtonStyle-mv0i720>span{
letter-spacing: 0px !important;
}

.webVueAntYtSpanStyle-mv0e6ah{
color: #3D3D3D !important;
}
.webVueAntYtSpanStyle-mv0e6ah span{
text-decoration: none;
}

.webVueAntUploadButton  {
    flex-wrap: nowrap;
}
.webVueAntUploadButton ,
.webVueAntUploadButton .ant-form-item-control-input,
.webVueAntUploadButton .ant-form-item-control-input .ant-form-item-control-input-content {
    width: 100%;
    height: 100%;
}
.webVueAntUploadButton .ant-form-item-control-input {
    min-height: unset;
}
.webVueAntUploadButton .ant-form-item-label {
    flex-shrink: 0;
    padding: 0;
    text-align: left;
}
.webVueAntUploadButton .ant-form-item-label label {
    width: 100%;
    height: 100%;
}
.webVueAntUploadButton .ant-form-item-label>label.ant-form-item-required:not(.ant-form-item-required-mark-optional):before {
  margin-top: 4px;
}
.webVueAntUploadButton .ant-form-item-label label .label-content{
    flex: 1;
    display: inline-block;
    overflow: hidden;
    text-overflow: ellipsis;
}
.webVueAntUploadButton .ant-form-item-label>label.ant-form-item-no-colon:after {
    display: none;
}
.webVueAntUploadButton .ant-form-item-label label .ant-form-item-content {
    white-space: nowrap;
}
.webVueAntUploadButton.hide-label .ant-form-item-label {
    display: none;
}
.webVueAntUploadButton .ant-form-item-content:focus{
    outline: none;
}
.webVueAntUploadButton .ant-btn, .webVueAntUploadButton .ant-upload {
    width: 100%;
    height: 100%;
}

.webVueAntUploadButtonFormItem-mvdvuxq{
opacity: 1;
flex-direction: row;

}
.webVueAntUploadButtonFormItem-mvdvuxq .ant-form-item-explain{
position: absolute;
top: 100%;
z-index: -1;
}
.webVueAntUploadButtonFormItem-mvdvuxq .ant-form-item-label label{
text-decoration: none;
font-style: normal;
color: #333333;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
width: 80px;
padding-top: 0px;
padding-right: 10px;
padding-bottom: 0px;
padding-left: 0px;
}
.webVueAntUploadButtonFormItem-mvdvuxq .ant-form-item-label label .label-content{
text-align: left;
text-align-last: left;
}
.webVueAntUploadButtonFormItem-mvdvuxq .ant-upload-list{
max-width: 208px;
max-height: 88px;
}
.webVueAntUploadButtonStyle-mvebg41 .ant-btn{
color: #000000A6;
font-family: Microsoft YaHei;
font-weight: Normal;
font-size: 14px;
text-align: center;
font-style: normal;
// border-top-left-radius: 4px;
// border-top-right-radius: 4px;
// border-bottom-left-radius: 4px;
// border-bottom-right-radius: 4px;
// background-color: #FFFFFF;
// border-top: 1px solid #D9D9D9;
// border-right: 1px solid #D9D9D9;
// border-bottom: 1px solid #D9D9D9;
// border-left: 1px solid #D9D9D9;
// box-shadow: 0px 0px 0px 0px transparent;
border:0 !important;
}
.webVueAntUploadButtonStyle-mvebg41 .ant-btn span{
text-decoration: none;
}

.webVueAntUploadButtonFormItem-mv6f4ua{
opacity: 1;
flex-direction: row;
}
.webVueAntUploadButtonFormItem-mv6f4ua .ant-form-item-explain{
position: absolute;
top: 100%;
z-index: -1;
}
.webVueAntUploadButtonFormItem-mv6f4ua .ant-form-item-label label{
text-decoration: none;
font-style: normal;
color: #333333;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
width: 80px;
padding-top: 0px;
padding-right: 10px;
padding-bottom: 0px;
padding-left: 0px;
}
.webVueAntUploadButtonFormItem-mv6f4ua .ant-form-item-label label .label-content{
text-align: right;
text-align-last: right;
}
.webVueAntUploadButtonFormItem-mv6f4ua .ant-upload-list{
max-width: 208px;
max-height: 88px;
}
.webVueAntUploadButtonStyle-mvb706o .ant-btn{
color: #000000A6;
font-family: Microsoft YaHei;
font-weight: Normal;
font-size: 14px;
text-align: center;
font-style: normal;
border-top-left-radius: 4px;
border-top-right-radius: 4px;
border-bottom-left-radius: 4px;
border-bottom-right-radius: 4px;
background-color: #FFFFFF;
border-top: 1px solid #D9D9D9;
border-right: 1px solid #D9D9D9;
border-bottom: 1px solid #D9D9D9;
border-left: 1px solid #D9D9D9;
box-shadow: 0px 0px 0px 0px transparent;
}
.webVueAntUploadButtonStyle-mvb706o .ant-btn span{
text-decoration: none;
}

.webVueAntUploadButtonFormItem-mvlj66h{
opacity: 1;
flex-direction: row;
}
.webVueAntUploadButtonFormItem-mvlj66h .ant-form-item-explain{
position: absolute;
top: 100%;
z-index: -1;
}
.webVueAntUploadButtonFormItem-mvlj66h .ant-form-item-label label{
text-decoration: none;
font-style: normal;
color: #333333;
font-family: Microsoft YaHei;
font-size: 14px;
font-weight: Normal;
width: 80px;
padding-top: 0px;
padding-right: 10px;
padding-bottom: 0px;
padding-left: 0px;
}
.webVueAntUploadButtonFormItem-mvlj66h .ant-form-item-label label .label-content{
text-align: right;
text-align-last: right;
}
.webVueAntUploadButtonFormItem-mvlj66h .ant-upload-list{
max-width: 208px;
max-height: 88px;
}
.webVueAntUploadButtonStyle-mvilr9o .ant-btn{
color: #000000A6;
font-family: Microsoft YaHei;
font-weight: Normal;
font-size: 14px;
text-align: center;
font-style: normal;
border-top-left-radius: 4px;
border-top-right-radius: 4px;
border-bottom-left-radius: 4px;
border-bottom-right-radius: 4px;
background-color: #FFFFFF;
border-top: 1px solid #D9D9D9;
border-right: 1px solid #D9D9D9;
border-bottom: 1px solid #D9D9D9;
border-left: 1px solid #D9D9D9;
box-shadow: 0px 0px 0px 0px transparent;
}
.webVueAntUploadButtonStyle-mvilr9o .ant-btn span{
text-decoration: none;
}

// 运营规则 弹窗 form
.spanLable {
  display: block;
  border-left: solid 3px #1890ff;
  line-height: 1;
  text-indent: 10px;
  font-size: 14px;
  color: #3d3d3d;
  font-weight: bold;
  margin-bottom: 20px;
}

// 运营规则 新增弹窗 || 编辑弹窗 || 详情弹窗 form
.webVueAntForm-yy {
  padding: 20px 24px;

  .ant-form-item-label {
    margin-right: 12px;
  }

  .ant-input-number {
    width: 100%;
  }

  :deep(.ant-row) {
    margin: 0 !important;
  }

  :deep(.ant-col-12-row) {
    padding-right: 48px !important;
  }

}

// 运营规则 详情弹窗 form
.webVueAntForm-un {
  :deep(.ant-input-disabled) {
    background: #FFFFFF !important;
  }
  .ant-input-disabled {
    background: #FFFFFF !important;
  }
}

.codeModal {
  .ant-table-tbody > tr > td {
    word-break: break-all;
  }
}

</style>