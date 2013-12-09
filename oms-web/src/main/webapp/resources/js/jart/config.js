/*
* jart全局配置
*/
//默认皮肤，不设置默认为default
//window.jart_theme = "default";

//此配置项为一个对象，对象属性名对应控件名称，对象属性值对应控件默认属性集
window.jart_defaults = {
    confirm: {
        btnOk: "确定",
        btnCancel: "取消"
    },
    alert: {
        btnOk: "确定"
    }
};

//是否处理frameset在IE6下竖起滚动条带出横向滚动条的BUG
window.jart_ie6_frameset_scroll_bug = true;

//调试模式的开关，在调试模式下，可以通过Debug.info(msg)来打印消息，或通过Debug.start(title)和Debug.end()匹配来测试代码执行性能
window.jart_debug = true;