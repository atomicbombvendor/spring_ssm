/**
 * @license Copyright (c) 2003-2017, CKSource - Frederico Knabben. All rights reserved.
 * For licensing, see LICENSE.md or http://ckeditor.com/license
 */

CKEDITOR.editorConfig = function( config ) {
	//Define changes to default configuration here. For example:
	config.language = 'zh-cn';
	config.disableNativeSpellChecker=false; //本地拼写检查
    config.toolbarCanCollapse = true;//是否可收缩
    config.resize_enabled = true;
    // 设置宽高
    // config.resize_minHeight = 750;
    // config.resize_minWidth = 750;
    config.editingBlock = true;
    config.find_highlight = {
        element : 'span',
        styles : { 'background-color' : '#ff0', 'color' : '#00f' }
    };
};
