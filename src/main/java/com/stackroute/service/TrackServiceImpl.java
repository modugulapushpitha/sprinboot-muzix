package com.stackroute.service;
import com.stackroute.domain.Track;
import com.stackroute.exception.TrackAlreadyExistException;
import com.stackroute.exception.TrackNotFoundException;
import com.stackroute.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class TrackServiceImpl implements TrackService{
    TrackRepository trackRepository;
    @Autowired
    public TrackServiceImpl(TrackRepository trackRepository){

        this.trackRepository=trackRepository;
    }
    @Override
    public Track saveTrack(Track track) throws TrackAlreadyExistException {
        if(trackRepository.existsById(track.getId())) {
            throw new TrackAlreadyExistException("track already exists");
        }
        Track saveTrack= trackRepository.save(track);
        if(saveTrack==null)
            throw new TrackAlreadyExistException(" track already exists");
        return saveTrack;
    }
    @Override
    public List<Track> deleteTrackById(int id) throws TrackNotFoundException {
        if(!trackRepository.existsById(id))
        {
            throw new TrackNotFoundException("Track not found");
        }
        trackRepository.delete(getTrackById(id));
        return trackRepository.findAll();

    }

    @Override
    public Track updateTrack(Track track) throws TrackNotFoundException {

        if(trackRepository.existsById(track.getId()))
        {

            Track updateTrack=trackRepository.save(track);
            return updateTrack;


        }

        else {

            throw new TrackNotFoundException("ID doesnt exist");
        }
    }
    @Override
    public Track getTrackById(int id) {
        Optional<Track> trackbyid=trackRepository.findById(id);
        if(trackbyid.isPresent()){
            return trackbyid.get();

        }
        else {
            return null;
        }
    }
    @Override
    public List<Track> getAllTracks() {
        return trackRepository.findAll();
    }
}
