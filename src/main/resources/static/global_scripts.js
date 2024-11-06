

function getInitialNavItem() {
    const path = window.location.pathname;
    if (path.includes('Shorts')) return 'Shorts';
    if (path.includes('Subscriptions')) return 'Subscriptions';
    if (path.includes('You')) return 'You';
    return 'Home'; // default
}
document.addEventListener('alpine:init', () => {
    Alpine.store('searchBar', {
        focused: false,
        search: true,
        inputValue: '',
        setFocused(value) {
            this.focused = value;
        },
        setSearch(value) {
            this.search = value;
        },
        setInputValue(value) {
            this.inputValue = value;
        }
    });
});
document.addEventListener('alpine:init', () => {
    Alpine.store('nav', {
        chosen: getInitialNavItem(),
        setChosen(item) {
            if(this.chosen === item){
                return
            }
            this.chosen = item;
        }
    });
});

document.addEventListener('alpine:init', () => {
    Alpine.store('tag', {
        chosen: 'Everything',
        setChosen(item) {
            if(this.chosen === item){
                return
            }
            this.chosen = item;
        }
    });
});
document.addEventListener('alpine:init', () => {
    Alpine.data('videoPlayer', () => ({
        isPlaying: false,
        volume: 1,
        progress: 0,
        duration: 0,
        isFullscreen: false,  // Add this line
        initializeVideo() {
            this.$refs.video.volume = this.volume;
            this.duration = this.$refs.video.duration;
        },
        togglePlay() {
            if (this.isPlaying) {
                this.$refs.video.pause();
            } else {
                this.$refs.video.play();
            }
            this.isPlaying = !this.isPlaying;

            console.log(this.isPlaying);
        },
        changeVolume() {
            this.$refs.video.volume = this.volume;
        },
        updateProgress() {
            let currentTime = this.$refs.video.currentTime;
            let duration = this.duration;
            this.progress = (currentTime / duration) * 100;
            console.log("Progress at: "+ this.progress);
            console.log("Current time is : " + currentTime);
            console.log("Duration is : " + duration);
        },
        skip(seconds) {
            this.$refs.video.currentTime += seconds;
        },
        seekTo(event) {
            const rect = event.target.getBoundingClientRect();
            const x = event.clientX - rect.left;
            const clickedValue = (x / rect.width) * this.duration;
            this.$refs.video.currentTime = clickedValue;
        },
        toggleFullscreen() {
            if (!document.fullscreenElement) {
                this.$refs.video.parentElement.requestFullscreen();
            } else {
                document.exitFullscreen();
            }
            this.isFullscreen = !this.isFullscreen;
        }
    }));
});

