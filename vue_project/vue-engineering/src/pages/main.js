import { createRouter, createWebHashHistory } from 'vue-router';
import axios from "axios";

const router = createRouter({
    history: createWebHashHistory(),
    routes: [

        {
            path: '/',
            redirect: '/daohangye/yunyingkanban'
        },

        {
            path: "/dengluye",
            name: "登录页",
            component: () => import("./登录页.vue")
        },
        {
            path: "/daohangye",
            name: "导航页面",
            component: () => import("./导航页面.vue"),
            children: [
                {
                    path: "dengluye",
                    name: "登录页_child",
                    components: {
                        second_route: () => import("./登录页.vue")
                    }
                },
                {
                    path: "app_yonghu_guanli",
                    name: "APP用户管理_child",
                    components: {
                        second_route: () => import("./APP用户管理.vue")
                    }
                },
                {
                    path: "tingche_dingdan",
                    name: "停车订单_child",
                    components: {
                        second_route: () => import("./停车订单.vue")
                    }
                },
                {
                    path: "chechang_peizhi",
                    name: "车场配置_child",
                    components: {
                        second_route: () => import("./车场配置.vue")
                    }
                },
                {
                    path: "cheliang_guanli",
                    name: "车辆管理_child",
                    components: {
                        second_route: () => import("./车辆管理.vue")
                    }
                },
                {
                    path: "juese_guanli",
                    name: "角色管理_child",
                    components: {
                        second_route: () => import("./角色管理.vue")
                    }
                },
                {
                    path: "yonghu_guanli",
                    name: "用户管理_child",
                    components: {
                        second_route: () => import("./用户管理.vue")
                    }
                },
                {
                    path: "zuzhi_jigou_guanli",
                    name: "组织机构管理_child",
                    components: {
                        second_route: () => import("./组织机构管理.vue")
                    }
                },
                {
                    path: "caidan_guanli",
                    name: "菜单管理_child",
                    components: {
                        second_route: () => import("./菜单管理.vue")
                    }
                },
                {
                    path: "yewu_luoji",
                    name: "业务逻辑_child",
                    components: {
                        second_route: () => import("./业务逻辑.vue")
                    }
                },
                {
                    path: "jifei_guanli",
                    name: "计费管理_child",
                    components: {
                        second_route: () => import("./计费管理.vue")
                    }
                },
                {
                    path: "shujuzidian",
                    name: "数据字典_child",
                    components: {
                        second_route: () => import("./数据字典.vue")
                    }
                },
                {
                    path: "gerenzhongxin",
                    name: "个人中心_child",
                    components: {
                        second_route: () => import("./个人中心.vue")
                    }
                },
                {
                    path: "yunyingkanban",
                    name: "运营看板_child",
                    components: {
                        second_route: () => import("./运营看板.vue")
                    }
                },
                {
                    path: "chechangkanban",
                    name: "车场看板_child",
                    components: {
                        second_route: () => import("./车场看板.vue")
                    }
                },
                {
                    path: "black_white",
                    name: "黑白名单_child",
                    components: {
                        second_route: () => import("./黑白名单.vue")
                    }
                },
                {
                    path: "abnormal",
                    name: "异常数据_child",
                    components: {
                        second_route: () => import("./异常数据.vue")
                    }
                },
                {
                    path: "arrearage",
                    name: "车辆欠费_child",
                    components: {
                        second_route: () => import("./车辆欠费.vue")
                    }
                },
                {
                    path: "zijin-guanli",
                    name: "资金管理_child",
                    components: {
                        second_route: () => import("./资金管理.vue")
                    }
                },
                {
                    path: "xianshang-kaipiao",
                    name: "线上开票_child",
                    components: {
                        second_route: () => import("./线上开票.vue")
                    }
                },
                {
                    path: "chechang-xunjian",
                    name: "车场巡检_child",
                    components: {
                        second_route: () => import("./车场巡检.vue")
                    }
                }
            ]
        },
        {
            path: "/app_yonghu_guanli",
            name: "APP用户管理",
            component: () => import("./APP用户管理.vue")
        },
        {
            path: "/tingche_dingdan",
            name: "停车订单",
            component: () => import("./停车订单.vue")
        },
        {
            path: "/chechang_peizhi",
            name: "车场配置",
            component: () => import("./车场配置.vue")
        },
        {
            path: "/cheliang_guanli",
            name: "车辆管理",
            component: () => import("./车辆管理.vue")
        },
        {
            path: "/juese_guanli",
            name: "角色管理",
            component: () => import("./角色管理.vue")
        },
        {
            path: "/yonghu_guanli",
            name: "用户管理",
            component: () => import("./用户管理.vue")
        },
        {
            path: "/zuzhi_jigou_guanli",
            name: "组织机构管理",
            component: () => import("./组织机构管理.vue")
        },
        {
            path: "/caidan_guanli",
            name: "菜单管理",
            component: () => import("./菜单管理.vue")
        },
        {
            path: "/yewu_luoji",
            name: "业务逻辑",
            component: () => import("./业务逻辑.vue")
        },
        {
            path: "/jifei_guanli",
            name: "计费管理",
            component: () => import("./计费管理.vue")
        },
        {
            path: "/yunyingkanban",
            name: "运营看板",
            component: () => import("./运营看板.vue")
        },
        {
            path: "/black_white",
            name: "黑白名单",
            component: () => import("./黑白名单.vue")
        },
        {
            path: "/abnormal",
            name: "异常数据",
            component: () => import("./异常数据.vue")
        },
        {
            path: "/arrearage",
            name: "车辆欠费",
            component: () => import("./车辆欠费.vue")
        },
        {
            path: "/zijin-guanli",
            name: "资金管理",
            component: () => import("./资金管理.vue")
        },
        {
            path: "/xianshang-kaipiao",
            name: "线上开票",
            component: () => import("./线上开票.vue")
        },
        {
            path: "/chechang-xunjian",
            name: "车场巡检",
            component: () => import("./车场巡检.vue")
        }
    ]
});


async function isLoggedIn() {
    try {
        // 假设后端提供了一个名为 `./system/logincheck` 的接口
        const response = await axios.get('./system/logincheck');

        // 假设后端返回的是一个对象，表示用户是否登录
        return response.data.data;
    } catch (error) {
        console.error('Error checking login status:', error);
        return false; // 在出错时默认返回未登录状态
    }
}

// 添加全局前置守卫
router.beforeEach(async (to, from, next) => {
    const isLoggedInAsync = await isLoggedIn();
    // const isLoggedInAsync = true 
    console.log('isLoggedInAsync', isLoggedInAsync);
    if (!isLoggedInAsync && to.path !== '/dengluye') {
        // 如果用户未登录且目标路由不是登录页，重定向到登录页
        next('/dengluye');
    } else {
        // 否则正常导航
        next();
    }
});

export default router;
