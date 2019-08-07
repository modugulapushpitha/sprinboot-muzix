package com.stackroute.service;

import com.stackroute.domain.Track;
import com.stackroute.exceptions.TrackAlreadyExistsException;
import com.stackroute.exceptions.TrackNotFoundException;

import java.util.List;

public interface TrackService {

    Track saveTrack(Track track) throws TrackAlreadyExistsException;
    Track deleteTrackById(int id) throws TrackNotFoundException;
    Track updateTrack(Track track) throws TrackNotFoundException;
    Track getTrackById(int id) throws TrackNotFoundException;
    List<Track> getAllTracks() throws TrackNotFoundException;
    List<Track> queryTrackByName(String name);
}
