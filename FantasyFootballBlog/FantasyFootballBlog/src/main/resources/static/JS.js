/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
const input = document.getElementById("search-input");
const searchBtn = document.getElementById("search-btn");

const expand = () => {
  searchBtn.classList.toggle("close");
  input.classList.toggle("square");
};

searchBtn.addEventListener("click", expand);

var vid = document.getElementById("theVid");
var vid2 = document.getElementById("theVid2");

function playVid() {
    vid.play();
}

function playVid2() {
    vid2.play();
}