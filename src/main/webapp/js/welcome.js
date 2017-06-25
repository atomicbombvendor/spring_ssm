/**
 * Created by ZZ on 2017/6/25.
 */
/*Javascript代码片段*/

$('#nav').affix({
    offset: {
        top: $('header').height()
    }
});

$('#sidebar').affix({
    offset: {
        top: 500
    }
});