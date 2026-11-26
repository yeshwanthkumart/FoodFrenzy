const filterButtons = document.querySelectorAll('[data-filter]');
const menuSections = document.querySelectorAll('.menu-section');

filterButtons.forEach((button) => {
    button.addEventListener('click', () => {
        const selectedFilter = button.dataset.filter;

        filterButtons.forEach((item) => item.classList.toggle('is-active', item === button));
        menuSections.forEach((section) => {
            const matches = selectedFilter === 'all' || section.dataset.category === selectedFilter;
            section.hidden = !matches;
        });
    });
});
