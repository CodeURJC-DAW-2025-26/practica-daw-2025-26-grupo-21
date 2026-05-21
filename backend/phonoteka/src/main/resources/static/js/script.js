const renderCheckoutSummary = () => {
    const summaryContainer = document.getElementById('checkout-items');
    const subtotalElement = document.getElementById('subtotal');
    const finalTotalElement = document.getElementById('final-total');

    // Only proceed if we are currently on the checkout page
    if (!summaryContainer) return; 

    // Mock data for the checkout summary
    const cartItems = [
        { title: "The Dark Side of the Moon", price: 35.00 },
        { title: "Abbey Road", price: 28.50 }
    ];

    let itemsHtml = '';
    let subtotal = 0;

    cartItems.forEach(item => {
        subtotal += item.price;
        itemsHtml += `
            <div class="summary-item">
                <span class="item-name">${item.title}</span>
                <span>${item.price.toFixed(2).replace('.', ',')} €</span>
            </div>
        `;
    });

    const shipping = 4.50;
    summaryContainer.innerHTML = itemsHtml;
    subtotalElement.textContent = `${subtotal.toFixed(2).replace('.', ',')} €`;
    finalTotalElement.textContent = `${(subtotal + shipping).toFixed(2).replace('.', ',')} €`;
};

function createVinylCard(vinylData, detailPage = 'vinyl.html') {
    // Generates a random seed for unique placeholder images
    const randomSeed = Math.random().toString(16).substring(2, 8);
    const imageUrl = `https://picsum.photos/seed/${randomSeed}/400/400`;
    const formattedPrice = `${vinylData.price.toFixed(2).replace('.', ',')} €`;

    // Wrap the card in an <a> tag to link to the detail page
    return `
        <a href="${detailPage}" class="vinyl-card-link">
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
        </a>
    `;
}

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

const owners = ['VinylVortex', 'GrooveGuardian', 'WaxWizard', 'SpinMaster', 'RecordRebel', 'AudioPhile101', 'ClassicCuts', 'TurntableTamer', 'DJ_Dusty', 'a.morales.2019'];

const vinylsData = [];
for (let i = 0; i < 20; i++) {
    const albumInfo = albums[i];
    const randomOwner = owners[Math.floor(Math.random() * owners.length)];
    const randomPrice = Math.random() * (50 - 15) + 15;

    vinylsData.push({
        title: albumInfo.title,
        artist: albumInfo.artist,
        genre: albumInfo.genre,
        price: randomPrice,
        owner: randomOwner
    });
}

document.addEventListener('DOMContentLoaded', () => {

    // 1. Render Gallery (if on homepage)
    const gallery = document.querySelector('.vinyl-grid');
    if (gallery) {
        const isLoggedHomepage = window.location.pathname.includes('index-logged.html');
        const detailPage = isLoggedHomepage ? 'vinyl-logged.html' : 'vinyl.html';
        gallery.innerHTML = vinylsData.map(vinyl => createVinylCard(vinyl, detailPage)).join('');
    }

    // 2. Render Checkout (if on checkout page)
    renderCheckoutSummary();

    // 3. Tab System Logic (for Profile page)
    const tabButtons = document.querySelectorAll('.tab-button');
    const tabContents = document.querySelectorAll('.tab-content');

    const activateTab = (targetId) => {
        const nextButton = document.querySelector(`.tab-button[data-target="${targetId}"]`);
        const nextContent = document.getElementById(targetId);

        if (!nextButton || !nextContent) return;

        tabButtons.forEach(btn => btn.classList.remove('active'));
        tabContents.forEach(content => content.classList.remove('active'));
        nextButton.classList.add('active');
        nextContent.classList.add('active');
    };

    tabButtons.forEach(button => {
        button.addEventListener('click', () => {
            const targetId = button.getAttribute('data-target');
            activateTab(targetId);
        });
    });

    const requestedTab = new URLSearchParams(window.location.search).get('tab');
    const tabAliasMap = {
        orders: 'tab-history',
        purchases: 'tab-history',
        history: 'tab-history',
        reviews: 'tab-reviews',
        selling: 'tab-selling'
    };
    const tabFromHash = window.location.hash?.replace('#', '');

    if (requestedTab && tabAliasMap[requestedTab]) {
        activateTab(tabAliasMap[requestedTab]);
    } else if (tabFromHash && document.getElementById(tabFromHash)) {
        activateTab(tabFromHash);
    }

    // 4. Avatar Preview Logic (for Edit Profile page)
    const avatarUpload = document.getElementById('avatar-upload');
    const avatarPreview = document.getElementById('avatar-preview');

    if (avatarUpload && avatarPreview) {
        avatarUpload.addEventListener('change', function() {
            const file = this.files[0];
            if (file) {
                const reader = new FileReader();
                reader.onload = (e) => avatarPreview.setAttribute('src', e.target.result);
                reader.readAsDataURL(file);
            }
        });
    }

    // 5. Theme Toggle Logic (Light/Dark mode)
    const themeToggle = document.getElementById('theme-toggle');
    const body = document.body;

    const applyTheme = (theme) => {
        body.setAttribute('data-theme', theme);
        localStorage.setItem('theme', theme);
    };

    if (themeToggle) {
        themeToggle.addEventListener('click', () => {
            const newTheme = body.getAttribute('data-theme') === 'dark' ? 'light' : 'dark';
            applyTheme(newTheme);
        });
    }

    // Load saved theme preference
    applyTheme(localStorage.getItem('theme') || 'light');

    // 6. Shopping Cart Drawer Logic
    const cartBtn = document.getElementById('cart-btn');
    const closeCartBtn = document.getElementById('close-cart');
    const cartDrawer = document.getElementById('cart-drawer');
    const cartOverlay = document.getElementById('cart-overlay');
    
    const toggleCart = () => {
        cartDrawer?.classList.toggle('open');
        cartOverlay?.classList.toggle('active');
    };

    if (cartBtn) cartBtn.addEventListener('click', toggleCart);
    if (closeCartBtn) closeCartBtn.addEventListener('click', toggleCart);
    if (cartOverlay) cartOverlay.addEventListener('click', toggleCart);

    // Initial Cart Items
    let cartItemsList = [
        { id: 1, title: "The Dark Side of the Moon", artist: "Pink Floyd", price: 35.00, img: "https://picsum.photos/seed/vinyl1/100/100" },
        { id: 2, title: "Abbey Road", artist: "The Beatles", price: 28.50, img: "https://picsum.photos/seed/vinyl2/100/100" }
    ];

    const renderCart = () => {
        const container = document.getElementById('cart-items-container');
        const totalElement = document.getElementById('cart-total-amount');
        const badge = document.getElementById('cart-count');
        
        if (!container) return;

        if (cartItemsList.length === 0) {
            container.innerHTML = '<div class="empty-cart-msg">Your cart is empty</div>';
            if (totalElement) totalElement.textContent = '0,00 €';
            if (badge) badge.style.display = 'none';
            return;
        }

        let total = 0;
        container.innerHTML = cartItemsList.map((item, index) => {
            total += item.price;
            return `
                <div class="cart-item">
                    <img src="${item.img}" alt="${item.title}">
                    <div class="cart-item-info">
                        <p class="cart-item-title">${item.title}</p>
                        <span class="cart-item-price">${item.price.toFixed(2).replace('.', ',')} €</span>
                    </div>
                    <button class="remove-item-btn" onclick="removeFromCart(${index})">
                        <span class="material-icons">delete</span>
                    </button>
                </div>
            `;
        }).join('');

        if (totalElement) totalElement.textContent = `${total.toFixed(2).replace('.', ',')} €`;
        if (badge) {
            badge.textContent = cartItemsList.length;
            badge.style.display = 'flex';
        }
    };

    // Global function to remove items from cart
    window.removeFromCart = (index) => {
        cartItemsList.splice(index, 1);
        renderCart();
    };

    renderCart();
});