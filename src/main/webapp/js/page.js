//获取对应控件
var totalPage = document.getElementById("spanTotalPage");//总页数
var currentPageNum = document.getElementById("spanPageNum");//当前页
var totalInfo = document.getElementById("spanTotalInfo");//记录总数
var currentPageText = document.getElementById("spanPageNum");//当前页文本框
var blogTable = document.getElementById("blogTable");

var pageSize = 5;

var numberRowsInTable = document.getElementById('blogTable').rows.length-1;//表格的最大行数，总行数的

var totalPageNum=pageCount();

var page = 1;

function setCurrentPageNum() {//设置当前页数
    currentPageNum.innerHTML = page;
}

function setAllPageNum() {//设置总记录数
    totalInfo.innerHTML = numberRowsInTable;
}

function hideTable() {//隐藏表格内容
    for (var i = 0; i < numberRowsInTable + 1; i++) {
        blogTable.rows[i].style.display = 'none';
    }
}

//显示链接 link方法将相应的文字变成可点击翻页的  noLink方法将对应的文字变成不可点击的
function preLink() {
    $('#previousLink').attr("onclick","prePage();");
}

function preNoLink() {
    $('#previousLink').removeAttr('onclick');
}

function neLink() {
    $('#nextLink').attr("onclick","nextPage();");
}

function nextNoLink() {
    $('#nextLink').removeAttr('onclick');
}

//next
function nextPage() {
    if (pageCount() <= 1) {

    } else {
        hideTable();
        var currentRow = pageSize * page + 1;//下一页的第一行
        var currentPageLastNum = currentRow + pageSize -1; //计算得到的下一页的最后一行
        if (currentPageLastNum >= numberRowsInTable)
            currentPageLastNum = numberRowsInTable;//如果计算中下一页最后一行大于实际最后一行行号
        for (var i = currentRow; i <= currentPageLastNum; i++) {
            blogTable.rows[i].style.display = '';//显示 关键利用了表格的 rows 属性，可以控制具体的行数的显示和消失
        }
        page++;
        if(page >= totalPageNum) {//当前页数超过或者等于最大的页数
            page = totalPageNum;
            currentPageText.value = page;//设置当前页面页数
            setCurrentPageNum();//更新page显示
            nextNoLink();
        }else{
            currentPageText.value = page;
            setCurrentPageNum();//更新page显示
            preLink();
        }

    }
}

//上一页
function prePage() {
    if (pageCount() <= 1) {
    }
    else {
        hideTable();
        page--;
        if(page <= 0) {//如果page被多减了一次，小于了0
            page = 1;
        }
        currentPageText.value = page;
        var currentRow = pageSize * page + 1;//currentRow = pageSize * page + 1;//下一页的第一行
        var currentPageFirstRow = currentRow - pageSize;////本页的第一行
        if (currentRow > numberRowsInTable) currentRow = numberRowsInTable;//下一页的第一行 大于总行数
        for (var i = currentPageFirstRow; i < currentRow; i++) {
            blogTable.rows[i].style.display = '';//显示
        }
        if (currentPageFirstRow == 1) {
            //设置上一页不可见
            preNoLink();
        }
        setCurrentPageNum();//更新page显示
        if (page == 1) {
            //同时设置为不可见
            preNoLink();
        }
        neLink();//下一页可用
    }
}

function pageCount() {//总共的页数
    var count = 0;
    if (numberRowsInTable % pageSize != 0) count = 1;
    return parseInt(numberRowsInTable / pageSize) + count;
}

function hide() {
    for (var i = pageSize + 1; i < numberRowsInTable + 1; i++) {
        blogTable.rows[i].style.display = 'none';
    }
    blogTable.rows[0].style.display='none';

    setAllPageNum();

    totalPage.innerHTML = pageCount();

    setCurrentPageNum();

    currentPageText.value = page;

    if (pageCount() > 1) {
        neLink();
    }
    preNoLink();
}
//加载隐藏function
$(document).ready(function(){
    hide();
});
