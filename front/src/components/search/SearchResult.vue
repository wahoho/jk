<template>
  <div>
    <!--
      <nav-bar></nav-bar>
    -->
    <section class="section">
      <div class="container">
        <small-search></small-search>
        <div class="columns" id="results">
          <artist-column :artists="artists"></artist-column>
          <album-column :albums="albums"></album-column>
          <song-column :songs="songs"></song-column>
        </div>
      </div>
    </section>
    <footer class="footer">
      <song-player></song-player>
    </footer>
  </div>
</template>

<script>
  import NavBar from '../navigation/Navbar'
  import SmallSearch from './SmallSearch'
  import AlbumColumn from '../album/AlbumColumn'
  import ArtistColumn from '../artist/ArtistColumn'
  import SongColumn from '../song/SongColumn'
  import SongPlayer from '../player/SongPlayer'

  export default {
    components: {
      SmallSearch,
      NavBar,
      AlbumColumn,
      ArtistColumn,
      SongColumn,
      SongPlayer
    },
    props: ['keyword'],
    data () {
      var artistList = []
      var albumsList = []
      var songList = []

      /*
      var albumsList = [
        { title: 'Album1', description: 'Description1', cover: 'https://upload.wikimedia.org/wikipedia/en/5/5e/Koko_ni_Ita_Koto_Album_Cover.jpg' },
        { title: 'Album2', description: 'Description2', cover: 'https://upload.wikimedia.org/wikipedia/en/5/5e/Koko_ni_Ita_Koto_Album_Cover.jpg' },
        { title: 'Album3', description: 'Description3', cover: 'https://upload.wikimedia.org/wikipedia/en/5/5e/Koko_ni_Ita_Koto_Album_Cover.jpg' },
        { title: 'Album4', description: 'Description4', cover: 'https://upload.wikimedia.org/wikipedia/en/5/5e/Koko_ni_Ita_Koto_Album_Cover.jpg' },
        { title: 'Album5', description: 'Description5', cover: 'https://upload.wikimedia.org/wikipedia/en/5/5e/Koko_ni_Ita_Koto_Album_Cover.jpg' }
      ]

      var songList = [
        { title: 'Song1' },
        { title: 'Song2' },
        { title: 'Song3' },
        { title: 'Song4' },
        { title: 'Song5' },
        { title: 'Song1' },
        { title: 'Song2' },
        { title: 'Song3' },
        { title: 'Song4' },
        { title: 'Song5' },
        { title: 'Song1' },
        { title: 'Song2' },
        { title: 'Song3' },
        { title: 'Song4' },
        { title: 'Song5' }
      ]
      */

      return {
        albums: albumsList,
        artists: artistList,
        songs: songList
      }
    },
    created () {
      this.searchMusic()
    },
    methods: {
      searchMusic () {
        // const SEARCH_URL = '/v1/spotify/albums?q='
        const SEARCH_URL = 'http://10.10.14.88:3000/v1/spotify/albums?q='
        var url = SEARCH_URL + this.keyword
        var vm = this
        this.$http.get(url)
          .then(response => {
            var data = response.data
            data.map(a => {
              var albums = a.albums.map(al => {
                var image = al.images.find(e => e.height === 64).url
                var album = { id: al.id, name: al.name, cover: image }
                return album
              })
              var artist = { id: a.id, name: a.name, albums: albums }
              vm.artists.push(artist)
              if (vm.albums.length === 0) {
                console.log(albums)
                vm.albums = albums
              }
            })
          })
          .catch(exception => console.log(exception))
      }
    }
  }
</script>

