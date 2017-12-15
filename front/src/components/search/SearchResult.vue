<template>
  <div>
    <!--
      <nav-bar></nav-bar>
    -->
    <section class="section">
      <div class="container">
        <small-search></small-search>
        <div class="columns" id="results">
          <artist-column :artists="artists" v-on:selected="selectArtist"></artist-column>
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
      },
      selectArtist (artist) {
        this.albums = artist.albums
      }
    }
  }
</script>

