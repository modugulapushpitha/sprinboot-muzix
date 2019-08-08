package com.stackroute.service;

import com.stackroute.domain.Track;
import com.stackroute.exception.TrackAlreadyExistException;
import com.stackroute.exception.TrackNotFoundException;

import java.util.List;

public interface TrackService {

    Track saveTrack(Track track) throws TrackAlreadyExistException;
    public List<Track> deleteTrackById(int id) throws TrackNotFoundException;
    public Track updateTrack(Track track) throws TrackNotFoundException;
    public Track getTrackById(int id) throws TrackNotFoundException;
    public List<Track> getAllTracks();
}
