package com.stackroute.service;

import com.stackroute.domain.Track;
import com.stackroute.exception.TrackAlreadyExistsException;
import com.stackroute.exception.TrackNotFoundException;

import java.util.List;

public interface TrackService {

    public Track saveTrack(Track track) throws TrackAlreadyExistsException;
    public boolean deleteTrackById(int id) throws TrackNotFoundException;
    public boolean updateTrack(Track track);
    public Track getTrackById(int id) throws TrackNotFoundException;
    public List<Track> getAllTracks();
    public List<Track> queryTrackByName(String name)throws TrackNotFoundException;
}
