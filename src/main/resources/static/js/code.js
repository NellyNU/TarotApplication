const predictions = [
    "The future is looking great! Your long-awaited dreams will be coming together!",
    "New opportunities shine through! Soon you will become a very important person at your workplace!",
    "Your projects are almost finished - you will experience a huge productivity boost very soon!",
    "The perfect time to go out is now! Interesting people are just waiting for you to show up!",
    "The seeds of love will soon give fruit - perhaps be a bit more persistant with him/her?",
    "It seems someone who you have known for awhile now has feelings for you… Take a closer look!",
    "A wonderful time - both work and pleasure will be fused into one for your convenience!",
    "Slow and steady wins the race - keep grinding and benefits shall be returned tenfold!",
    "Inner peace is a great treasure and you will soon find it very palpable!",
    "If you want to achieve success - better start laying the groundwork now!",
    "A new level of maturity will soon rise in your relationship - don't back down!",
    "This is a wonderful time to be yourself - stay natural and people will love you for it!",
    "Your management will finally reward you for your work - a promotion is right around the corner!",
    "Your future will be different from what you expect now. Don't worry - it's all for the better.",
    "A great opportunity to change your social circle.",
    "Perhaps it is time to abandon that hobby - you can spend your time better elsewhere.",
    "Patience and honesty will reward you at the workplace - keep grinding.",
    "Appreciate your partner more often - he/she will be very pleased!",
    "You might need more rest than usual in the coming days, don't deny yourself that.",
    "Do not change your workplace just yet - your loyalty will be rewarded.",
    "You should get more of genuine alone time for now.",
    "Your knowledge on an important topic will be put to a test soon.",
    "You might discover a dirty secret from your partner's past soon.",
    "Nostalgia will be visiting you often soon.",
    "Don't waste your time talking to unpleasant people - they're not worth it.",
    "The next few choices will heavily determine your future.",
    "The path to success will be painful and tedious. Be prepared.",
    "He/She is not into you - stop before you waste even more time.",
    "You will experience a burnout in one of your hobbies - don't push yourself too hard.",
    "Someone among your colleagues will prove to be extremely unreliable.",
    "He/She is simply using you, there is no real affection.",
    "You will soon encounter an impossible task. Don't hesitate to ask for help.",
    "An enterprise that provides you with work or some services will soon suffer significant downturn.",
    "Gossips and enviers could destroy your love life - don't let them influence those who are close to you.",
    "Your health is likely to suffer soon, stay vigilant.",
    "Involuntary celibacy awaits you in the near future."
];
const voice = [new Audio("voice/1.mp3"), new Audio("voice/2.mp3"), new Audio("voice/3.mp3"), new Audio("voice/4.mp3"),
    new Audio("voice/5.mp3"), new Audio("voice/6.mp3"), new Audio("voice/7.mp3"), new Audio("voice/8.mp3")];
// функция для того чтобы генерировать уникальные и не повторяющиеся
//цифры для карт таро, мб оно потом не нужно будет
function getUniqueRandomNumbers(max, count) {
    const numbers = [];
    while (numbers.length < count) {
        const num = Math.ceil(Math.random() * max);
        if (!numbers.includes(num)) {
            numbers.push(num);
        }
    }
    return numbers;
}
//переворачивает карту
function flipCard(card) {
    console.log("flipCard called");
    if (!card.classList.contains('flipped')) {
        card.classList.add('flipped'); 
        const randomIndices = getUniqueRandomNumbers(36, 5);
        randomIndices.forEach((index,i)=>{//вставляет картинку карты таро в блок
            const cardBack = card.querySelectorAll('.card-back')[i];
            cardBack.style.backgroundImage=`url('img/${index}.JPG')`;
            document.getElementById('prediction-text').textContent = predictions[index];
            voice[Math.floor(index/8)].play();
        });
    }
   }


//временная функция, которая сбрасывает все карты, нужна для проверок
function resetCards() {
    const cards = document.querySelectorAll('.card');
    cards.forEach(card => {
        card.classList.remove('flipped'); 
        const cardBack = card.querySelector('.card-back');
    });
    document.getElementById('prediction-text').textContent='turn the cards';
    
}

document.getElementById("music").play();
