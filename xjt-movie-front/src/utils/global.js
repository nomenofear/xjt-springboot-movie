/*export let bindToGlobal = (obj, key='var') => {
    window[key] = {};
    for (let i in obj) {
        window[key][i] = obj[i]
    }
};*/
const navHeaderArr = [
    {}
]


const categoryArr = [
    "全部",
    "爱情",
    "喜剧",
    "动画",
    "剧情",
    "恐怖",
    "科幻",
    "动作",
    "战争",
    "犯罪",
    "武侠",
    "灾难",
    "纪录片",
    "其他"
];

const countryArr = [
    "全部",
    "中国",
    "日本",
    "韩国",
    "美国",
    "欧洲",
    "印度",
    "东南亚",
    "俄罗斯",
    "其他"
];

const releaseDataArr = [
    "全部",
    "2021",
    "2020",
    "2019",
    "2018",
    "2017",
    "2016",
    "2015",
    "2014",
    "2013",
    "2012",
    "2012",
    "2011",
    "2010",
    "90年代",
];

export default {
    categoryArr,
    countryArr,
    releaseDataArr,
}


