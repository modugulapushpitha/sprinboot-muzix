package com.stackroute.service;

import com.stackroute.domain.Track;

import java.util.List;

public interface TrackService {

    Track saveTrack(Track track);
    Track deleteTrackById(int id);
    Track updateTrack(Track track);
    Track getTrackById(int id);
    List<Track> getAllTracks();
    List<Track> queryTrackByName(String name);
}
