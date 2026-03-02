document.addEventListener('DOMContentLoaded', () => {
    const themeToggle = document.getElementById('theme-toggle');
    const body = document.body;

    const applyTheme = (theme) => {
        body.setAttribute('data-theme', theme);
        localStorage.setItem('theme', theme);
    };

    themeToggle.addEventListener('click', () => {
        const currentTheme = body.getAttribute('data-theme');
        const newTheme = currentTheme === 'dark' ? 'light' : 'dark';
        applyTheme(newTheme);
    });

    // Use the stored theme, if there is. Otherwise, use the light one
    const savedTheme = localStorage.getItem('theme') || 'light';
    applyTheme(savedTheme);

});

/**
 * Creates the HTML for a vinyl card from the provided data.
 * @param {object} vinylData - An object with the vinyl's information.
 * @param {string} vinylData.title - The album's title.
 * @param {string} vinylData.artist - The artist or band.
 * @param {string} vinylData.genre - The music genre.
 * @param {number} vinylData.price - The vinyl's price.
 * @param {string} vinylData.owner - The seller's username.
 * @returns {string} - A string containing the HTML for the .vinyl-card div.
 */
function createVinylCard(vinylData) {
  // Generates a random string to make each image unique
  const randomSeed = Math.random().toString(16).substring(2, 8);
  const imageUrl = `https://picsum.photos/seed/${randomSeed}/400/400`;

  // Formats the price to always have 2 decimal places and the Euro symbol
  const formattedPrice = `${vinylData.price.toFixed(2).replace('.', ',')} €`;

  // Uses template literals to build the HTML
  return `
    <div class="vinyl-card">
      <img src="${imageUrl}" alt="Cover of ${vinylData.title}">
      <div class="card-content">
        <h3 class="vinyl-title">${vinylData.title}</h3>
        <div class="card-body">
          <span class="vinyl-artist">
            <span class="material-icons">album</span>
            <strong>${vinylData.artist}</strong>
          </span>
          <span class="vinyl-genre">${vinylData.genre}</span>
        </div>
        <div class="card-footer">
          <span class="vinyl-owner">
            <span class="material-icons">person</span>
            <strong>${vinylData.owner}</strong>
          </span>
          <span class="vinyl-price">${formattedPrice}</span>
        </div>
      </div>
    </div>
  `;
}

// --- DATA FOR RANDOM VINYLS ---

// Pool of artists and their albums to ensure realistic pairings
const albums = [
  { artist: "Pink Floyd", title: "The Dark Side of the Moon", genre: "Progressive Rock" },
  { artist: "The Beatles", title: "Abbey Road", genre: "Rock" },
  { artist: "Michael Jackson", title: "Thriller", genre: "Pop" },
  { artist: "Nirvana", title: "Nevermind", genre: "Grunge" },
  { artist: "Fleetwood Mac", title: "Rumours", genre: "Soft Rock" },
  { artist: "Led Zeppelin", title: "IV", genre: "Hard Rock" },
  { artist: "Miles Davis", title: "Kind of Blue", genre: "Jazz" },
  { artist: "Daft Punk", title: "Random Access Memories", genre: "Electronic" },
  { artist: "Queen", title: "A Night at the Opera", genre: "Rock" },
  { artist: "Bob Marley", title: "Exodus", genre: "Reggae" },
  { artist: "The Clash", title: "London Calling", genre: "Punk" },
  { artist: "Kendrick Lamar", title: "To Pimp a Butterfly", genre: "Hip Hop" },
  { artist: "Radiohead", title: "OK Computer", genre: "Alternative" },
  { artist: "Amy Winehouse", title: "Back to Black", genre: "Soul" },
  { artist: "Arctic Monkeys", title: "AM", genre: "Indie Rock" },
  { artist: "The Strokes", title: "Is This It", genre: "Indie Rock" },
  { artist: "David Bowie", title: "Ziggy Stardust", genre: "Glam Rock" },
  { artist: "Stevie Wonder", title: "Songs in the Key of Life", genre: "Soul" },
  { artist: "Tame Impala", title: "Currents", genre: "Psychedelic Pop" },
  { artist: "Frank Ocean", title: "Blonde", genre: "R&B" }
];

// Pool of random usernames
const owners = ['VinylVortex', 'GrooveGuardian', 'WaxWizard', 'SpinMaster', 'RecordRebel', 'AudioPhile101', 'ClassicCuts', 'TurntableTamer', 'DJ_Dusty', 'a.morales.2019'];

const vinylsData = [];

for (let i = 0; i < 20; i++) {

  const albumInfo = albums[i];
  const randomOwner = owners[Math.floor(Math.random() * owners.length)];
  const randomPrice = Math.random() * (50 - 15) + 15;

  const newVinyl = {
    title: albumInfo.title,
    artist: albumInfo.artist,
    genre: albumInfo.genre,
    price: randomPrice,
    owner: randomOwner
  };

  vinylsData.push(newVinyl);
}

document.addEventListener('DOMContentLoaded', () => {

  const gallery = document.querySelector('.vinyl-grid');
  
  if (gallery) {
    let allCardsHTML = '';
    vinylsData.forEach(vinyl => {
      allCardsHTML += createVinylCard(vinyl);
    });
    gallery.innerHTML = allCardsHTML;
  }

  // --- Tab System Logic for profile---
    const tabButtons = document.querySelectorAll('.tab-button');
    const tabContents = document.querySelectorAll('.tab-content');

    tabButtons.forEach(button => {
        button.addEventListener('click', () => {
            const targetId = button.getAttribute('data-target');
            const targetContent = document.getElementById(targetId);

            // Deactivate all buttons and hide all content
            tabButtons.forEach(btn => btn.classList.remove('active'));
            tabContents.forEach(content => content.classList.remove('active'));

            // Activate the clicked button and show its corresponding content
            button.classList.add('active');
            if (targetContent) {
                targetContent.classList.add('active');
            }
        });
    });

    // --- Avatar Preview Logic for Edit Profile Page ---
    const avatarUpload = document.getElementById('avatar-upload');
    const avatarPreview = document.getElementById('avatar-preview');

    // Check if these elements exist on the current page
    if (avatarUpload && avatarPreview) {
        avatarUpload.addEventListener('change', function() {
            const file = this.files[0];
            if (file) {
                // Create a temporary URL for the selected file and set it as the image source
                const reader = new FileReader();
                reader.onload = function(e) {
                    avatarPreview.setAttribute('src', e.target.result);
                }
                reader.readAsDataURL(file);
            }
        });
    }
});