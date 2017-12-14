<template>
  <div>
    s<nav-bar></nav-bar>
    <div class="container">
      <small-search></small-search>
      <div class="columns" id="results">
        <album-column :albums="albums"></album-column>
        <artist-column :artists="artists"></artist-column>
        <song-column :songs="songs"></song-column>
      </div>
    </div>
    <footer class="footer">
      <div class="container">
        <div class="content has-text-centered">
          <song-player></song-player>
        </div>
      </div>
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
      var albumsList = [
        { title: 'Album1', description: 'Description1' },
        { title: 'Album2', description: 'Description2' },
        { title: 'Album3', description: 'Description3' },
        { title: 'Album4', description: 'Description4' },
        { title: 'Album5', description: 'Description5' }
      ]

      var artistList = [
        { name: 'Name1' },
        { name: 'Name2' },
        { name: 'Name3' },
        { name: 'Name4' },
        { name: 'Name5' }
      ]

      var songList = [
        { title: 'Song1' },
        { title: 'Song2' },
        { title: 'Song3' },
        { title: 'Song4' },
        { title: 'Song5' }
      ]

      return {
        albums: albumsList,
        artists: artistList,
        songs: songList
      }
    }
  }
</script>

