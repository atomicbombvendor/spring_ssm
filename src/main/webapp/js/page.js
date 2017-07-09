//获取对应控件
var totalPage = document.getElementById("spanTotalPage");//总页数
var pageNum = document.getElementById("spanPageNum");//当前页
var totalInfo = document.getElementById("spanTotalInfo");//记录总数
var pageNum2 = document.getElementById("spanPageNum");//当前页文本框
var blogTable = document.getElementById("blogTable");
var perviousLink = document.getElementsByClassName("previous");
var nextLink = document.getElementsByClassName("next");
<!-- 这些js var的加载顺序要在html渲染了之后才能加载-->
var pageSize = 5;

var numberRowsInTable = document.getElementById('blogTable').rows.length-1;

var page = 1;

//next
function nextPage() {
    if (pageCount() <= 1) {

    } else {
        hideTable();
        var currentRow = pageSize * page + 1;//下一页的第一行
        var maxRow = currentRow + pageSize; //下一页的一行
        if (maxRow > numberRowsInTable)
            maxRow = numberRowsInTable + 1;//如果计算中下一页最后一行大于实际最后一行行号
        for (var i = currentRow; i < maxRow; i++) {
            blogTable.rows[i].style.display = '';
        }
        page++;
        pageNum2.value = page;
        if (maxRow == numberRowsInTable) { //如果下一页的最后一行是表格的最后一行
            nextNoLink(); //下一页 和尾页 不点击
            lastNoLink();
        }
        showPage();//更新page显示
        if (page == pageCount()) {//如果当前页是尾页
            nextNoLink();
            lastNoLink();
        }

        preLink();
        firstLink();
    }
}

//上一页
function prePage() {
    if (pageCount() <= 1) {
    }
    else {
        hideTable();
        page--;
        pageNum2.value = page;
        var currentRow = pageSize * page + 1;//下一页的第一行
        var maxRow = currentRow - pageSize;//本页的第一行
        if (currentRow > numberRowsInTable) currentRow = numberRowsInTable;//如果计算中本页的第一行小于实际首页的第一行行号，则更正
        for (var i = maxRow; i < currentRow; i++) {
            blogTable.rows[i].style.display = '';
        }
        if (maxRow == 0) {
            preNoLink();
            firstNoLink();
        }
        showPage();//更新page显示
        if (page == 1) {
            firstNoLink();
            preNoLink();
        }
        nextLink();
        lastLink();
    }
}

function pageCount() {//总共的页数
    var count = 0;
    if (numberRowsInTable % pageSize != 0) count = 1;
    return parseInt(numberRowsInTable / pageSize) + count;
}

//显示链接 link方法将相应的文字变成可点击翻页的  nolink方法将对应的文字变成不可点击的
function preLink() {
    perviousLink.innerHTML = "<a href='javascript:pre();'>上一页</a>";
}

function preNoLink() {
    perviousLink.innerHTML = "上一页";
}

function nextLink() {
    spanNext.innerHTML = "<a href='javascript:next();'>下一页</a>";
}

function nextNoLink() {
    spanNext.innerHTML = "下一页";
}

function firstLink() {
    spanFirst.innerHTML = "<a href='javascript:first();'>首页</a>";
}

function firstNoLink() {
    spanFirst.innerHTML = "首页";
}

function lastLink() {
    spanLast.innerHTML = "<a href='javascript:last();'>尾页</a>";
}

function lastNoLink() {
    spanLast.innerHTML = "尾页";
}

function hide() {
    for (var i = pageSize + 1; i < numberRowsInTable + 1; i++) {
        blogTable.rows[i].style.display = 'none';
    }
    blogTable.rows[0].style.display='none';

    inforCount();

    totalPage.innerHTML = pageCount();

    showPage();

    pageNum2.value = page;

    if (pageCount() > 1) {
        nextLink();
        lastLink();
    }
}

function hide2() {
    for (var i = 5 + 1; i < 13 + 1; i++) {
        blogTable.rows[i].style.display = 'none';
    }
    blogTable.rows[0].style.display='none';

    inforCount();

    totalPage.innerHTML = pageCount();

    showPage();

    pageNum2.value = page;

    if (pageCount() > 1) {
        nextLink();
        lastLink();
    }
}

function showPage() {//设置当前页数
    pageNum.innerHTML = page;
}

function inforCount() {//设置总记录数
    totalInfo.innerHTML = numberRowsInTable;
}

function hideTable() {//隐藏表格内容
    for (var i = 0; i < numberRowsInTable + 1; i++) {
        blogTable.rows[i].style.display = 'none';
    }
}

hide2();