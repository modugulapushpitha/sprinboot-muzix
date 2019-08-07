package com.stackroute.service;
import com.stackroute.domain.Track;
import com.stackroute.exceptions.TrackAlreadyExistsException;
import com.stackroute.exceptions.TrackNotFoundException;
import com.stackroute.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class TrackServiceImpl implements TrackService{
    private TrackRepository trackRepository;
    @Autowired
    public TrackServiceImpl(TrackRepository trackRepository){
        this.trackRepository=trackRepository;
    }
    @Override
    public Track saveTrack(Track track) throws TrackAlreadyExistsException {
        try {

            if (trackRepository.existsById(track.getId())) {
            }
        }catch (Exception e){
            throw new TrackAlreadyExistsException("track already exists");
        }
        Track saveTrack= trackRepository.save(track);
       try {
           if (saveTrack == null)
               throw new TrackAlreadyExistsException(" track already exists");
       }catch (Exception e) {
           throw new TrackAlreadyExistsException(" track already exists");
       }
        return saveTrack;
    }
    @Override
    public Track deleteTrackById(int id) throws TrackNotFoundException {
        Track track=null;
        try {
            if (getTrackById(id) == null) {
                throw new TrackNotFoundException("track not found");
            } else {
                trackRepository.delete(getTrackById(id));
                TrackService trackService = null;
                track=trackService.getTrackById(id);
            }
        }catch (Exception e){

        }
        return track;
    }
    @Override
    public Track updateTrack(Track track) throws TrackNotFoundException{
        Track updatetrack = trackRepository.findById(track.getId()).get();
            if (updatetrack != null) {
                updatetrack.setId(track.getId());
                updatetrack.setName(track.getName());
                updatetrack.setComment(track.getComment());
                return trackRepository.save(updatetrack);
            }
        else {
                return track;
            }
    }
    @Override
    public Track getTrackById(int id) throws TrackNotFoundException{
        Optional<Track> trackbyid=trackRepository.findById(id);
        try {
            if (trackbyid.isPresent()) {
                return trackbyid.get();

            }
        }catch (Exception e){
            throw new TrackNotFoundException("track not found");
        }
        return trackbyid.get();
    }
    @Override
    public List<Track> getAllTracks() throws TrackNotFoundException{
        try {
        if(trackRepository==null)
            throw new TrackNotFoundException("No tracks available");
        }catch (Exception e){
            throw new TrackNotFoundException("no tracks available");
        }
        return trackRepository.findAll();
    }
    @Override
    public List<Track> queryTrackByName(String name){
        List<Track> trackList=trackRepository.queryTrackByName(name);
        return trackList;
    }
}
