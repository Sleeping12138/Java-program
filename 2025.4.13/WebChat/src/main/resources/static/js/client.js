// 左侧导航栏的js

function initSwithTab() {
    let tabSession = document.querySelector('.tab .tab-session');
    let tabFriend = document.querySelector('.tab .tab-friend');
    let lists = document.querySelectorAll('.list');

    tabSession.onclick = function () {
        tabSession.style.backgroundImage = 'url(image/对话.png)';
        tabFriend.style.backgroundImage = 'url(image/用户2.png)';
        lists[0].classList = 'list';
        lists[1].classList = 'list hide';
    }
    tabFriend.onclick = function () {
        tabSession.style.backgroundImage = 'url(image/对话2.png)';
        tabFriend.style.backgroundImage = 'url(image/用户.png)'
        lists[0].classList = 'list hide';
        lists[1].classList = 'list';
    }
}
initSwithTab();