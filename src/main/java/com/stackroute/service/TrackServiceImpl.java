package com.stackroute.service;

import com.stackroute.domain.Track;
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
    public Track saveTrack(Track track) {
        Track savedTrack=trackRepository.save(track);
        return savedTrack;
    }

    @Override
    public Track deleteTrackById(int id) {

        trackRepository.delete(getTrackById(id));
        TrackService trackService= null;
        return  trackService.getTrackById(id);
    }

    @Override
    public Track updateTrack(Track track) {
        Track updatetrack = trackRepository.findById(track.getId()).get();
        if (updatetrack != null) {
            updatetrack.setId(track.getId());
            updatetrack.setName(track.getName());
            updatetrack.setComment(track.getComment());
            return trackRepository.save(updatetrack);
        } else {
            return track;
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
    @Override
    public List<Track> queryTrackByName(String name) {
        List<Track> trackList=trackRepository.queryTrackByName(name);
        return trackList;
    }
}
