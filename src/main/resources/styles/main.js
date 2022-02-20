/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/ClientSide/javascript.js to edit this template
 */


function doTheMagic(){
console.log('hola mundo');

let btnNext = document.querySelector('.next');
let btnPrevious = document.querySelector('.previous');
let overflow = document.querySelector('.overflow');
let block = document.querySelector('.bloco');
let allBlocks = document.querySelectorAll('.bloco');
let blockWidth = block.offsetWidth;

let position = 0;
let maxWidth = overflow.offsetWidth;
let allBlocksWidth = allBlocks.length*blockWidth;
  
  if(allBlocksWidth < maxWidth){
    btnPrevious.style.opacity = "0";
    btnNext.style.opacity = "0";
  }

function togglePrev(position){
  if(position >= blockWidth){
    btnPrevious.style.opacity = "1";
  } else {
    btnPrevious.style.opacity = "0";
  }
}

function toggleNext(position){
  if((allBlocksWidth-position) > maxWidth){
    btnNext.style.opacity = "1";
  } else {
    btnNext.style.opacity = "0";
  }
}

btnNext.onclick = function(){
  if((allBlocksWidth-position) > maxWidth){
    position = position+blockWidth;
    overflow.style.transform = `translateX(-${position}px)`;
  }
  togglePrev(position);
    toggleNext(position);
}

btnPrevious.onclick = function(){
  if(position >= blockWidth){
    position = position-blockWidth;
    overflow.style.transform = `translateX(-${position}px)`;
  }
    togglePrev(position);
  toggleNext(position);
}

}



function resize() {
  if(window.innerWidth < 768){
    let overflow = document.querySelector('.overflow');
    overflow.style.transform = `translateX(0px)`;
    doTheMagic();
  } else {
    doTheMagic();
  }
}

window.onresize = resize;
doTheMagic();
